package org.volt4.parsey.fx.node.components;

import javafx.scene.input.MouseEvent;
import org.volt4.parsey.node.NodeInput;

import java.util.function.Supplier;

/**
 * This type of component represents an input to a node. It often
 * (but not necessarily) is able to supply an input itself (users
 * are able to manually input a value). This is a sub-class of
 * NodeComponent.
 *
 * @version 1.1
 * @param <T> The data type that this InputNodeComponent works with.
 *
 */
public abstract class InputNodeComponent<T> extends NodeComponent implements Supplier<T> {

    // True if this InputNodeComponent can supply its own value.
    protected boolean canSupply;

    // This component's input connection.
    protected NodeConnectionComponent<?, ?> inputConnection;

    // Input this component controls.
    private NodeInput<T> input;

    // This input node's handle.
    private InputConnectionHandle<T> handle;

    /**
     * Constructs an InputNodeComponent.
     * @param canSupply True if this InputNodeComponent can supply its own value.
     */
    public InputNodeComponent(String fxml, double height, double buffer, NodeInput<T> input, boolean canSupply, ConnectionHandle.HandleColor handleColor) {
        super(fxml, height, buffer);
        this.input = input;
        this.canSupply = canSupply;
        handle = new InputConnectionHandle<T>(this, handleColor);
    }

    /**
     * Returns the NodeInput object that this component controls.
     * @return the NodeInput object that this component controls.
     */
    public NodeInput<T> getNodeInput() {
        return input;
    }

    /**
     * Returns true if this component is able to supply an input.
     * @return True if this component can supply a value, false otherwise.
     */
    public boolean canSupply() {
        return canSupply;
    }

    /**
     * Sets the input connection of this component. Used for reference.
     * @param inputConnection Input connection to be set.
     */
    public void setInput(NodeConnectionComponent<?, ?> inputConnection) {
        this.inputConnection = inputConnection;
        input.setConnection(inputConnection.getNodeConnection());
    }

}
