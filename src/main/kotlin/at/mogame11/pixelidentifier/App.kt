package at.mogame11.pixelidentifier

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import java.io.IOException

class App : Application() {
    /**
     * The companion object for the PixelIdentifier application.
     */
    companion object {
        /**
         * The name of the application.
         */
        const val appName = "PixelIdentifier"
        /**
         * The current scene of the application.
         */
        var scene: Scene? = null

        /**
         * Returns a FXMLLoader for the specified FXML file name.
         * @param fileName the file name of the FXML file
         * @return a FXMLLoader for the specified FXML file
         * @throws IOException if the FXML file cannot be loaded
         */
        @Throws(IOException::class)
        fun findFXMLLoader(fileName: String): FXMLLoader {
            return FXMLLoader(App::class.java.getResource("$fileName.fxml"))
        }
    }

    /**
     * This method is responsible for starting the JavaFX application by loading the main menu FXML file,
     * creating a new Scene with the loaded FXML, setting the title of the Stage, and displaying it to the user.
     * @param stage the primary Stage of the application
     */
    override fun start(stage: Stage) {
        val fxmlLoader: FXMLLoader = App.findFXMLLoader("menu")
        scene?.root
        App.scene = Scene(fxmlLoader.load(), 720.0, 480.0)
        stage.title = App.appName
        stage.scene = App.scene
        stage.isResizable = false
        stage.show()
    }

}

fun main() {
    Application.launch(App::class.java)
}