package org.volt4.parsey.fx.node.components;

import org.volt4.parsey.node.NodeInput;

/**
 * This type of component represents an input to a node. It often
 * (but not necessarily) is able to supply an input itself (users
 * are able to manually input a value). This is a sub-interface of
 * NodeComponent.
 *
 * @version 1.0
 * @param <T> The data type that this InputNodeComponent works with.
 *
 */
public interface InputNodeComponent<T> extends NodeComponent {

    /**
     * Returns the NodeInput object that this component controls.
     * @return the NodeInput object that this component controls.
     */
    NodeInput<T> getNodeInput();

    /**
     * Returns true if this component is able to supply an input.
     * @return True if this component can supply a value, false
     * otherwise.
     */
    boolean canSupply();

    /**
     * Supplies the value, or null if it can't (use canSupply() to
     * see if this can supply a value).
     * @return The supplied value.
     */
    T supply();

    /**
     * Sets the input connection of this component. Used for reference.
     * @param input Input connection to be set.
     */
    void setInput(NodeConnectionComponent<?, ?> input);

}
