package org.volt4.parsey.fx.node.components.implementation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import org.volt4.parsey.fx.node.components.Component;

import java.io.IOException;

/**
 * Basic label for the inputs and outputs of a node.
 */
@Deprecated
public class IOLabel extends AnchorPane implements Component {

    // Location of this component's FXML.
    private static final String FXML_RESOURCE_LOCATION = "/fxml/nodes/components/IOLabel.fxml";

    // True if this component is disabled.
    boolean disabled;

    @FXML
    private AnchorPane root;

    @FXML
    private Text text;

    // The height of this label.
    private double height;

    /**
     * Constructs and builds an IOLabel with the given arguments.
     * @param label The text of this label.
     * @param type The type of this label.
     * @param height The height of this label.
     */
    public IOLabel(String label, Type type, double height) {
        this.height = height;
        // Set up the loader.
        FXMLLoader loader = new FXMLLoader(getClass().getResource(FXML_RESOURCE_LOCATION));
        loader.setRoot(this);
        loader.setController(this);
        // Load.
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Setup
        text.setText(label);
        root.setPrefHeight(height);
        AnchorPane.setTopAnchor(text, height / 2d - text.getLayoutBounds().getHeight() / 2d);
        switch(type){
            case INPUT:
                AnchorPane.setLeftAnchor(text, 20d);
                break;
            case OUTPUT:
                AnchorPane.setRightAnchor(text, 20d);
                break;
        }
    }

    /**
     * Sets the text of this value label.
     * @param newText Text of this value label.
     */
    public void setText(String newText) {
        text.setText(newText);
    }

    /**
     * The type if the IOLabel.
     */
    public enum Type {
        INPUT, OUTPUT;
    }

    @Override
    public double getComponentHeight() {
        return height;
    }

    @Override
    public Pane getRoot() {
        return this;
    }

    @Override
    public boolean isComponentDisabled() {
        return disabled;
    }

    @Override
    public void setComponentDisabled(boolean disabled) {
        if (disabled)
            setVisible(false);
        else
            setVisible(true);
        this.disabled = disabled;
    }

}
