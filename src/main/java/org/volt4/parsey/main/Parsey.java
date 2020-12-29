package org.volt4.parsey.main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.CubicCurve;
import javafx.stage.Stage;
import org.volt4.parsey.fx.Editor;
import org.volt4.parsey.fx.node.FXMathNode;
import org.volt4.parsey.fx.node.FXNode;
import org.volt4.parsey.fx.node.components.implementation.DropDown;
import org.volt4.parsey.fx.node.components.IOComponent;
import org.volt4.parsey.fx.node.components.implementation.IOLabel;
import org.volt4.parsey.fx.node.components.implementation.ValueSlider;
import org.volt4.parsey.node.implementation.MathNode;

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
        Editor root = new Editor();
        ValueSlider slider = new ValueSlider(IOComponent.Type.INPUT, "Value");
        DropDown dropDown = new DropDown("Choice 1", "Choice 2", "Choice 3");
        IOLabel ioLabel = new IOLabel("Value", IOLabel.Type.OUTPUT, 30);
        FXNode fxNode = new FXMathNode(MathNode.Type.LOGARITHM);

        AnchorPane nc = new AnchorPane();
        nc.setPrefSize(10, 10);
        nc.getStyleClass().add("nc-purple");
        final double px = 50, py = 50;
        nc.setLayoutX(px);
        nc.setLayoutY(py);
        final CubicCurve curve = new CubicCurve();
//        PseudoClass cc = PseudoClass.getPseudoClass("curve-normal");
        curve.getStyleClass().add("curve-left");
        nc.setOnMouseDragged(e -> {
            double x = nc.getLayoutX() + e.getX();
            double y = nc.getLayoutY() + e.getY();
            curve.setStartX(px + 5);
            curve.setStartY(py + 5);
            curve.setEndX(x);
            curve.setEndY(y);
            curve.setControlX1(px + ((x - px) / 2d));
            curve.setControlX2(px + ((x - px) / 2d));
            curve.setControlY1(py);
            curve.setControlY2(y);
            curve.setVisible(true);
        });
        nc.setOnMouseReleased(e -> {
            curve.setVisible(false);
        });

        root.getChildren().add(curve);
        root.getChildren().add(nc);

        scene = new Scene(root);
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
