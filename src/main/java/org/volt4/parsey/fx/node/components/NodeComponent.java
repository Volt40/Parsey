package org.volt4.parsey.fx.node.components;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * UI Components that are used in nodes all must extend this. This takes care of
 * the information needed to layout the component on the node. Components that are
 * not used in nodes do not need to extend this. Components that have inputs/
 * outputs should extend the Input/OutputNodeComponent classes. (Input/OutputNodeComponent
 * is a sub-class of NodeComponent).
 *
 * @version 1.1
 *
 */
public abstract class NodeComponent extends AnchorPane {

    // The height of this component.
    protected double height;

    // This component's buffer.
    protected double buffer;

    // Whether or not this component is disabled.
    protected boolean disabled;

    /**
     * Constructs a NodeComponent.
     * @param fxml The fxml resource location.
     * @param height The height of this component.
     * @param buffer The buffer <I>above</I> this component.
     */
    public NodeComponent(String fxml, double height, double buffer) {
        this.height = height;
        this.buffer = buffer;
        // Set up the loader.
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        loader.setRoot(this);
        loader.setController(this);
        // Load.
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the height of this component.
     * @return the height of this component.
     */
    public double getComponentHeight() {
        return height;
    }

    /**
     * Returns the buffer of this component. The buffer
     * is the distance <I>above</I> the component.
     * @return
     */
    public double getBuffer() {
        return buffer;
    }

    /**
     * Sets whether or not this component is disabled.
     * @return whether or not this component is disabled.
     */
    public boolean isComponentDisabled() {
        return disabled;
    }

    /**
     * Sets the component to be disabled. Disabled components should be invisible.
     * @param disabled true if this component is disabled, false otherwise.
     */
    public void setComponentDisabled(boolean disabled) {
        if (disabled)
            setVisible(false);
        else
            setVisible(true);
        this.disabled = disabled;
    }


}
