package org.volt4.parsey.fx.node.components;

import org.volt4.parsey.node.NodeOutput;

/**
 * This type of component represents an output of a node.
 * This is a sub-interface of NodeComponent.
 *
 * @version 1.0
 * @param <T> The data type that this OutputNodeComponent works with.
 *
 */
public interface OutputNodeComponent<T> extends NodeComponent {

    /**
     * Returns the NodeOutput object that this component controls.
     * @return the NodeOutput object that this component controls.
     */
    NodeOutput<T> getNodeOutput();

    /**
     * Adds the output to the node network.
     * @param connection Output to be added.
     */
    void addOutput(NodeConnectionComponent<?, T> connection);

    /**
     * Removes the output from the node network.
     * @param connection Output to be removed.
     */
    void removeOutput(NodeConnectionComponent<?, T> connection);

}
