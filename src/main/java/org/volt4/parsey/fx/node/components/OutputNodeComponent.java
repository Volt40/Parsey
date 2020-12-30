package org.volt4.parsey.fx.node.components;

import org.volt4.parsey.node.NodeOutput;

import java.util.ArrayList;
import java.util.List;

/**
 * This type of component represents an output of a node.
 * This is a sub-class of NodeComponent.
 *
 * @version 1.1
 * @param <T> The data type that this OutputNodeComponent works with.
 *
 */
public abstract class OutputNodeComponent<T> extends NodeComponent {

    // This component's output connections.
    protected List<NodeConnectionComponent<?, ?>> outputConnections;

    // NodeOutput this component controls.
    protected NodeOutput<T> nodeOutput;

    // This output node's handle.
    private OutputConnectionHandle<T> handle;

    /**
     * Constructs a NodeComponent.
     * @param fxml The fxml resource location.
     * @param height The height of this component.
     * @param buffer The buffer <I>above</I> this component.
     * @param nodeOutput NodeOutput this component controls.
     */
    public OutputNodeComponent(String fxml, double height, double buffer, NodeOutput<T> nodeOutput, ConnectionHandle.HandleColor handleColor) {
        super(fxml, height, buffer);
        this.nodeOutput = nodeOutput;
        outputConnections = new ArrayList<>();
        handle = new OutputConnectionHandle<T>(this, handleColor);
    }

    /**
     * Returns the NodeOutput object that this component controls.
     * @return the NodeOutput object that this component controls.
     */
    public NodeOutput<T> getNodeOutput() {
        return nodeOutput;
    }

    /**
     * Adds the output to the node network.
     * @param connection Output to be added.
     */
    public void addOutput(NodeConnectionComponent<?, ?> connection) {
        outputConnections.add(connection);
        nodeOutput.addConnection(connection.getNodeConnection());
    }

    /**
     * Removes the output from the node network.
     * @param connection Output to be removed.
     */
    public void removeOutput(NodeConnectionComponent<?, ?> connection) {
        outputConnections.remove(connection);
        nodeOutput.removeConnection(connection.getNodeConnection());
    }

}
