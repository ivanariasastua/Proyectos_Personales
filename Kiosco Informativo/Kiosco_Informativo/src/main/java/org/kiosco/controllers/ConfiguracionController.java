package org.kiosco.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import org.kiosco.utils.FlowController;

import java.net.URL;
import java.util.ResourceBundle;

public class ConfiguracionController extends Controller implements Initializable {

    @FXML public Pane paneMenu;
    @FXML public Pane paneContenedor;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FlowController.getInstance().goViewPanel(paneMenu, "Menu");
    }

    @Override
    public void initialize() {
        FlowController.getInstance().setMainStage(this.getStage());
    }

    @FXML
    public void actMinimizar(ActionEvent actionEvent) {
        this.minimizeWindow();
    }

    @FXML
    public void actAjustar(ActionEvent actionEvent) {
        this.adjustWindow();
    }

    @FXML
    public void actCerrar(ActionEvent actionEvent) {
        this.closeWindow();
    }
}
