package at.mogame11.pixelidentifier

import java.util.*

/**
 * The Pixel class represents a color as a combination of red, green, blue, and alpha values. It provides methods for setting
 * and getting the values and for generating the color's hexadecimal code.
 */
class Pixel(alpha: Int, red: Int, green: Int, blue: Int) {
    private var alpha: Int = 0
    private var red: Int = 0
    private var green: Int = 0
    private var blue: Int = 0

    /**
     * Initializes the color with the given alpha, red, green, and blue values.
     * @param alpha the alpha value of the color (between 0 and 255)
     * @param red the red value of the color (between 0 and 255)
     * @param green the green value of the color (between 0 and 255)
     * @param blue the blue value of the color (between 0 and 255)
     */
    init {
        try {
            // Check if the color values are in range
            if (areValuesInRange(alpha, red, green, blue)) {
                this.alpha = alpha
                this.red = red
                this.green = green
                this.blue = blue
            } else {
                // If the values are not in range, an InputMismatchException is thrown
                throw InputMismatchException()
            }
        } catch (ime: InputMismatchException) {
            // The catch block prints the stack trace of the InputMismatchException if it is thrown.
            ime.printStackTrace()
        }
    }

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

        // Check if the color values are in range
        if (areValuesInRange(alpha, red, green, blue)) {
            if (alpha != 0) {
                redStr = Integer.toHexString(this.red)
                greenStr = Integer.toHexString(this.green)
                blueStr = Integer.toHexString(this.blue)

                // Add leading zeros to ensure a two-digit hexadecimal value
                if (redStr.length == 1) redStr = "0$redStr"
                if (greenStr.length == 1) greenStr = "0$greenStr"
                if (blueStr.length == 1) blueStr = "0$blueStr"

                // If alpha is not 255, add the alpha value to the hexadecimal code
                if (alpha != 255) alphaStr = String.format(" - Alpha: %02x", alpha)

                // Append the hexadecimal code to the StringBuilder
                hex.append('#').append(redStr).append(greenStr).append(blueStr).append(alphaStr)
            } else {
                // If alpha is 0, the color is transparent
                hex.append("Transparent")
            }
        }

        // Return the hexadecimal code as a string
        return hex.toString()
    }

    /**
     * Checks whether the alpha, red, green, and blue values of the pixel are within the range of 0 to 255.
     *
     * @return true if the values are within range, false otherwise.
     */
    private fun areValuesInRange(alpha: Int, red: Int, green: Int, blue: Int): Boolean {
        return (alpha in 0..255) && (red in 0..255) && (green in 0..255) && (blue in 0..255)
    }
}
