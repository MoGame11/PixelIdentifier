package at.mogame11.pixelidentifier

import java.util.*

/**
 * The Pixel class represents a color as a combination of red, green, blue, and alpha values. It provides methods for setting
 * and getting the values and for generating the color's hexadecimal code.
 */
class Pixel {
    private var alpha: Int = 0
    private var red: Int = 0
    private var green: Int = 0
    private var blue: Int = 0

    /**
     * Constructor that sets the alpha, red, green, and blue values of the pixel.
     *
     * @param alpha The alpha value of the pixel.
     * @param red   The red value of the pixel.
     * @param green The green value of the pixel.
     * @param blue  The blue value of the pixel.
     * @throws InputMismatchException if any of the input values are outside the range of 0 to 255.
     */
    constructor(alpha: Int, red: Int, green: Int, blue: Int) {
        try {
            if (areValuesInRange(alpha, red, green, blue)) {
                this.alpha = alpha
                this.red = red
                this.green = green
                this.blue = blue
            } else {
                throw InputMismatchException()
            }
        } catch (ime: InputMismatchException) {
            ime.printStackTrace()
        }
    }

    /**
     * Constructor that sets the red, green, and blue values of the pixel and sets the alpha value to 255.
     *
     * @param red   The red value of the pixel.
     * @param green The green value of the pixel.
     * @param blue  The blue value of the pixel.
     */
    constructor(red: Int, green: Int, blue: Int) : this(255,red, green, blue)

    /**
     * Generates the hexadecimal code for the pixel based on its alpha, red, green, and blue values.
     *
     * @return The hexadecimal code as a String.
     */
    fun getHexCode(): String {
        var alphaStr = ""
        var redStr = "00"
        var greenStr = "00"
        var blueStr = "00"
        val hex = StringBuilder()

        if (areValuesInRange(alpha, red, green, blue)) {
            redStr = Integer.toHexString(this.red)
            greenStr = Integer.toHexString(this.green)
            blueStr = Integer.toHexString(this.blue)

            if (redStr.length == 1) redStr = "0$redStr"
            if (greenStr.length == 1) greenStr = "0$greenStr"
            if (blueStr.length == 1) blueStr = "0$blueStr"
            if (alpha != 255) alphaStr = String.format(" - Alpha: %02x", alpha)
        }

        hex.append('#').append(redStr).append(greenStr).append(blueStr).append(alphaStr)
        return hex.toString()
    }

    /**
     * Checks whether the alpha, red, green, and blue values of the pixel are within the range of 0 to 255.
     *
     * @return true if the values are within range, false otherwise.
     */
    private fun areValuesInRange(alpha: Int, red: Int,green: Int,blue: Int): Boolean {
        return (this.alpha in 0..255) && (this.red in 0..255) && (this.green in 0..255) && (this.blue in 0..255)
    }
}
