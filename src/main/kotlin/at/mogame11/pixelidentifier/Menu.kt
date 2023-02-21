package at.mogame11.pixelidentifier

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.stage.FileChooser
import java.util.*

/**
 * This class represents the menu controller of the pixel identifier application.
 * It provides functionality to choose an image file and display its pixels.
 */
class Menu{

    private var resourceBundle: ResourceBundle? = null

    init {
        resourceBundle = ResourceBundle.getBundle("at.mogame11.pixelidentifier.Menu")
    }

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
        fileChooser.title = resourceBundle?.getString("fileChooser.title")

        // Add filters to only allow specific image file types
        fileChooser.extensionFilters.add(
            FileChooser.ExtensionFilter(
                resourceBundle?.getString("fileChooser.extensionFilterTitle"),
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
        try {
            selectedFile.absolutePath
        }catch (npe: NullPointerException){
            //npe.printStackTrace()
            return
        }
        // If a file was selected, do something with it
        if (selectedFile != null) {
            // TODO: Implement it with JavaFX

            // Create a new Image object using the selected file path
            val image = Image(selectedFile.absolutePath)

            // Print all the pixels in the image
            print(image.getAllPixels())
        }
    }
}
