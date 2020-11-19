package org.kiosco.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import org.kiosco.utils.FlowController;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController extends Controller implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @Override
    public void initialize() {

    }

    public void actTextos(ActionEvent actionEvent) {
    }

    public void actImagenes(ActionEvent actionEvent) {
    }

    public void actVideos(ActionEvent actionEvent) {
    }

    public void actEnlaces(ActionEvent actionEvent) {
    }

    public void actPresentar(ActionEvent actionEvent) {
    }

    public void actSalir(ActionEvent actionEvent) {
        FlowController.getInstance().closeMain();
    }
}
