package org.kiosco.utils;

import java.io.IOException;
import java.util.HashMap;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import org.kiosco.App;
import org.kiosco.controllers.Controller;

public class FlowController {

    private static FlowController INSTANCE = null;
    private Stage mainStage;

    private static HashMap<String, FXMLLoader> loaders = new HashMap<>();

    private FlowController() {
    }

    private static void createInstance() {
        if (INSTANCE == null) {
            synchronized (FlowController.class) {
                if (INSTANCE == null) {
                    INSTANCE = new FlowController();
                }
            }
        }
    }

    public static FlowController getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    private FXMLLoader getLoader(String name) {
        FXMLLoader loader = loaders.get(name);
        if (loader == null) {
            synchronized (FlowController.class) {
                loader = getFXMLLoader(name);
            }
        }
        return loader;
    }

    private FXMLLoader getFXMLLoader(String name){
        FXMLLoader loader;
        try {
            loader = new FXMLLoader(App.class.getResource(name + ".fxml"));
            loader.load();
            loaders.put(name, loader);
        } catch (IOException ex) {
            loader = null;
            System.out.println("Error al obtener FXML: "+ex);
        }
        return loader;
    }

    public void cargarFXMLLoader(String name){
        FXMLLoader loader;
        try {
            loader = new FXMLLoader(App.class.getResource(name + ".fxml"));
            loader.load();
            loaders.put(name, loader);
        } catch (IOException ex) {
            loader = null;
            System.out.println("Error al cargar FXML: "+ex);
        }
    }

    public void goViewPanel(Pane panel, String viewName){
        FXMLLoader loader = getLoader(viewName);
        Controller controller = loader.getController();
        controller.setAccion(null);
        controller.initialize();
        Stage stage = controller.getStage();
        panel.getChildren().clear();
        panel.getChildren().add(loader.getRoot());
    }

    public void goViewInStage(String viewName, Stage stage) {
        FXMLLoader loader = getLoader(viewName);
        Controller controller = loader.getController();
        controller.setStage(stage);
        stage.getScene().setRoot(loader.getRoot());
    }

    public void goViewInNoResizableWindow(String viewName, Boolean show, StageStyle style){
        FXMLLoader loader = getLoader(viewName);
        Controller controller = loader.getController();
        Stage stage = new Stage();
        stage.setTitle("Sistema Aeropuerto");
        /* stage.getIcons().add(new Image(""));
         */
        stage.setOnHidden((WindowEvent event) -> {
            controller.getStage().getScene().setRoot(new Pane());
            controller.setStage(null);
        });
        Parent root = loader.getRoot();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(Boolean.FALSE);
        stage.initStyle(style);
        stage.sizeToScene();
        controller.setStage(stage);
        controller.initialize();
        controller.initEvents();
        if(show)
            stage.show();
        else
            stage.showAndWait();
    }

    public void goViewInResizableWindow(String viewName, double minWidth, double minHeight, Boolean show, StageStyle style){
        FXMLLoader loader = getLoader(viewName);
        Controller controller = loader.getController();
        Stage stage = new Stage();
        /*
        stage.getIcons().add(new Image(""));*/
        stage.setTitle("Kiosco Informativo");
        stage.setMinHeight(minHeight+40);
        stage.setMinWidth(minWidth);
        stage.setOnHidden((WindowEvent event) -> {
            controller.getStage().getScene().setRoot(new Pane());
            controller.setStage(null);
        });
        Parent root = loader.getRoot();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setResizable(true);
        stage.sizeToScene();
        stage.initStyle(style);
        controller.setStage(stage);
        controller.initialize();
        controller.initEvents();
        if(show)
            stage.show();
        else
            stage.showAndWait();
    }

    public Controller getController(String viewName) {
        return getLoader(viewName).getController();
    }

    public void initialize() {
        loaders.clear();
    }

    public void salir() {
        mainStage.close();
    }

    public FXMLLoader getNewLoader(String name){
        return getFXMLLoader(name);
    }

    public Stage getMainStage(){
        return mainStage;
    }

    public Boolean hayLoader(String nombre){
        FXMLLoader load = loaders.get(nombre);
        return load != null;
    }

    public void eliminarLoader(String name){
        if(hayLoader(name)){
            loaders.remove(name);
        }
    }

    public void clear(){
        loaders.clear();
    }

    public void setMainStage(Stage stage){
        this.mainStage = stage;

    }

    public void closeMain(){
        this.mainStage.close();;
    }
}
