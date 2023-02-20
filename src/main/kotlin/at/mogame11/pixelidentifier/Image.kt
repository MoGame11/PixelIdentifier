package at.mogame11.pixelidentifier

import java.awt.image.BufferedImage
import java.io.File
import java.io.IOException
import javax.imageio.ImageIO

/**
 * The Image class represents an image and contains methods for adding pixels to it and getting all the unique pixels.
 */
class Image(filePath: String) {
    // List of unique pixels in the image
    private val pixels: ArrayList<Pixel> = ArrayList()
    private lateinit var currentImage: BufferedImage

    /**
     * Initializes the object by reading the image file from the specified file path and setting the currentImage variable.
     * If an IOException occurs, it will print the stack trace.
     * @param filePath the path of the image file to read
     */
    init {
        try {
            val file = File(filePath)
            currentImage = ImageIO.read(file)
        } catch (ioe: IOException) {
            ioe.printStackTrace()
        }
    }

    /**
     * Adds a pixel to the list of unique pixels if it does not already exist.
     * @param pixel The pixel to add.
     */
    fun addPixel(pixel: Pixel) {
        for (currentBit in pixels) {
            if (currentBit.getHexCode() == pixel.getHexCode()) {
                // Pixel already exists in the list
                return
            }
        }
        this.pixels.add(pixel)
    }

    /**
     * Returns a string containing the hexadecimal codes for all pixels in the image.
     * The pixels are read using the readPixels() method.
     * @return a string of hexadecimal codes separated by newlines
     */
    fun getAllPixels(): String {
        readPixels()
        val stringBuilder = StringBuilder()
        for (currentBit in pixels) {
            stringBuilder.append(currentBit.getHexCode()).append("\n")
        }
        return stringBuilder.toString()
    }

    /**
     * Reads the pixel data from the current image and creates a new Pixel object for each pixel,
     * which is then added to the collection of pixels.
     */
    private fun readPixels() {
        val width = currentImage.width
        val height = currentImage.height
        for (y in 0 until height) {
            for (x in 0 until width) {
                val argb = currentImage.getRGB(x, y)
                // Extract the alpha, red, green, and blue components of the pixel
                val alpha = (argb shr 24) and 0xff
                val red = (argb shr 16) and 0xff
                val green = (argb shr 8) and 0xff
                val blue = argb and 0xff

                // Create a new Pixel object with the extracted components
                val onePixel = Pixel(alpha, red, green, blue)

                // Add the new pixel to the
                addPixel(onePixel)
            }
        }
    }

}
