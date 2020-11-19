package org.kiosco.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.StageStyle;
import org.kiosco.utils.FlowController;

import java.net.URL;
import java.util.ResourceBundle;

public class InicioController extends Controller implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void initialize() {

    }

    @FXML
    public void actMinimizar(ActionEvent actionEvent) {
        this.minimizeWindow();
    }

    @FXML
    public void actCerrar(ActionEvent actionEvent) {
        this.closeWindow();
    }



    @FXML
    public void actIniciarConfiguracion(ActionEvent actionEvent) {
        FlowController.getInstance().goViewInResizableWindow("Configuracion", 1050, 700, true, StageStyle.UNDECORATED);
        this.closeWindow();
    }


}
