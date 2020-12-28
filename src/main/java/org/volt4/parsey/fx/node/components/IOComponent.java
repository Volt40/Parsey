package org.volt4.parsey.fx.node.components;

import org.volt4.parsey.node.NodeInput;
import org.volt4.parsey.node.NodeOutput;

/**
 * A component that is an input/output of a node.
 *
 * @version 1.0
 *
 */
public interface IOComponent<T> extends Component {

    /**
     * Returns true if this input/output component can supply a value on its own.
     * @return true if this input/output component can supply a value on its own.
     */
    boolean canSupply();

    /**
     * Returns the supplied value.
     * @return the supplied value.
     */
    T supplyValue();

    /**
     * Returns this IOComponent's type.
     * @return this IOComponent's type.
     */
    Type getType();

    /**
     * Returns the linked output (if this node has one).
     * @return the linked output (if this node has one), null otherwise.
     */
    NodeOutput<T> getLinkedOutput();

    /**
     * Returns the linked input (if this node has one).
     * @return the linked input (if this node has one), null otherwise.
     */
    NodeInput<T> getLinkedInput();

    /**
     * True if the value is receiving an input from another node.
     * @param inputted if the value is receiving an input from another node.
     */
    void setInputted(boolean inputted);

    /**
     * The type if this IO.
     */
    enum Type {
        INPUT, OUTPUT;
    }

}
