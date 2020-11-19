package org.kiosco;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.kiosco.utils.FlowController;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FlowController.getInstance().goViewInNoResizableWindow("Configuracion", Boolean.FALSE, StageStyle.UNDECORATED);
    }

    public static void main(String[] args) {
        launch();
    }

}