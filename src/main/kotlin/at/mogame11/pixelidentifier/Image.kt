package at.mogame11.pixelidentifier

import java.awt.image.BufferedImage
import java.io.File
import java.io.IOException
import javax.imageio.ImageIO

/**
 * The Image class represents an image and contains methods for adding pixels to it and getting all the unique pixels.
 */
class Image {
    // List of unique pixels in the image
    val pixels: ArrayList<Pixel> = ArrayList()
    val currentImage: BufferedImage
        get() {
            return currentImage
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

    /**
     * Loads an image from a file.
     * @param filePath The path to the image file.
     * @return The loaded image as a BufferedImage object.
     */
    fun load(filePath: String): BufferedImage? {
        try {
            val file = File(filePath)
            return ImageIO.read(file)
        } catch (ioe: IOException) {
            ioe.printStackTrace()
        }
        return null
    }

    fun readPixels(){
        currentImage.colorModel
    }
}
