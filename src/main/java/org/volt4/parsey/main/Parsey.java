package org.volt4.parsey.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.volt4.parsey.fx.node.FXMathNode;
import org.volt4.parsey.fx.node.FXNode;
import org.volt4.parsey.fx.node.components.DropDown;
import org.volt4.parsey.fx.node.components.IOComponent;
import org.volt4.parsey.fx.node.components.IOLabel;
import org.volt4.parsey.fx.node.components.ValueSlider;

/**
 * JFX Application class for Parsey.
 *
 * @version 1.0
 *
 */
public class Parsey extends Application {

    // Resource location for the icon.
    private static final String LOGO_RESOURCE_LOCATION = "/icons/logo.png";

    // The scene.
    private static Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();
        ValueSlider slider = new ValueSlider(IOComponent.Type.INPUT, "Value");
        DropDown dropDown = new DropDown("Choice 1", "Choice 2", "Choice 3");
        IOLabel ioLabel = new IOLabel("Value", IOLabel.Type.OUTPUT, 30);
        FXNode fxNode = new FXMathNode();
        root.getChildren().add(fxNode);
        scene = new Scene(root, 500, 500);
        //scene.getStylesheets().add("/stylesheets/workspace.css");
        scene.getStylesheets().add("/stylesheets/parseydark.css");
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(LOGO_RESOURCE_LOCATION));
        primaryStage.show();
    }

    /**
     * Returns the scene.
     * @return the scene.
     */
    public static Scene getScene() {
        return scene;
    }

    /**
     * Launch Parsey.
     * @param args Java arguments.
     */
    public static void launchParsey(String[] args) {
        launch(args);
    }

}
