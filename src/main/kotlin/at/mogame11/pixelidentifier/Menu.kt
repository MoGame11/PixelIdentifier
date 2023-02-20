package at.mogame11.pixelidentifier

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.stage.FileChooser

/**
 * This class represents the menu controller of the pixel identifier application.
 * It provides functionality to choose an image file and display its pixels.
 */
class Menu {

    @FXML
    private val chooseFileButton: Button? = null

    /**
     * The action to perform when the choose file button is clicked.
     * Opens a file chooser dialog and displays the pixels of the selected image file.
     */
    @FXML
    private fun onChooseFileAction() {
        // Create a new file chooser
        val fileChooser = FileChooser()

        // Set the title of the file chooser
        fileChooser.title = "Open File"

        // Add filters to only allow specific image file types
        fileChooser.extensionFilters.add(
            FileChooser.ExtensionFilter(
                "Image Files",
                "*.bmp",
                "*.wbmp",
                "*.gif",
                "*.jpeg",
                "*.jpg",
                "*.png",
                "*.webp",
                "*.raw",
            )
        )

        // Show the file chooser and wait for a file to be selected
        val selectedFile = fileChooser.showOpenDialog(chooseFileButton?.scene?.window)

        // Get the absolute path of the selected file
        val filePath = selectedFile.absolutePath

        // If a file was selected, do something with it
        if (selectedFile != null) {
            // TODO: Implement it with JavaFX

            // Create a new Image object using the selected file path
            val image = Image(filePath)

            // Print all the pixels in the image
            print(image.getAllPixels())
        }
    }
}