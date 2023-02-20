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
    val pixels: ArrayList<Pixel> = ArrayList()
    lateinit var currentImage: BufferedImage

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
     * Returns a string with all the unique pixels in the image and their hexadecimal codes.
     * @return A string with all the unique pixels and their hexadecimal codes.
     */
    fun getAllPixels(): String {
        val stringBuilder = StringBuilder()
        for (currentBit in pixels) {
            stringBuilder.append(currentBit.getHexCode()).append("\n")
        }
        return stringBuilder.toString()
    }


    fun readPixels() {
        val width = currentImage.width
        val height = currentImage.height
        for (y in 0 until height) {
            for (x in 0 until width) {
                val argb = currentImage.getRGB(x, y)
                val alpha = (argb shr 24) and 0xff
                val red = (argb shr 16) and 0xff
                val green = (argb shr 8) and 0xff
                val blue = argb and 0xff
            }
        }
    }
}
