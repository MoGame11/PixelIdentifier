package at.mogame11.pixelidentifier

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.stage.FileChooser


class Menu {

    @FXML
    private val chooseFileButton: Button? = null

    @FXML
    private fun onChooseFileAction() {
        val fileChooser = FileChooser()
        fileChooser.title = "Open File"
        fileChooser.extensionFilters.add(
            FileChooser.ExtensionFilter(
                "Image Files",
                "*.png",
                "*.jpg",
                "*.jpeg",
                "*.gif",
                "*.bmp",
                "*.tif",
                "*.tiff"
            )
        )
        val selectedFile = fileChooser.showOpenDialog(chooseFileButton?.scene?.window)
        val filePath = selectedFile.absolutePath
        if (selectedFile != null) {
            // TODO: do something with the selected file
            val image = Image(filePath)
        }
    }
}