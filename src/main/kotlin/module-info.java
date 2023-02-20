module at.mogame11.pixelidentifier {
    requires javafx.controls;
    requires javafx.fxml;
    requires kotlin.stdlib;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.desktop;

    opens at.mogame11.pixelidentifier to javafx.fxml;
    exports at.mogame11.pixelidentifier;
}