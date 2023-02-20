package at.mogame11.pixelidentifier

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import java.io.IOException

class App : Application() {
    companion object {
        val appName = "PixelIdentifier"
        var scene: Scene? = null

        @Throws(IOException::class)
        fun findFXMLLoader(s: String): FXMLLoader {
            return FXMLLoader(App::class.java.getResource("$s.fxml"))
        }
    }

    override fun start(stage: Stage) {
        val fxmlLoader: FXMLLoader = App.findFXMLLoader("menu")
        scene?.root
        App.scene = Scene(fxmlLoader.load(), 816.0, 544.0)
        stage.title = App.appName
        stage.scene = App.scene
        stage.isResizable = false
        stage.show()
    }


}

fun main() {
    Application.launch(App::class.java)
}