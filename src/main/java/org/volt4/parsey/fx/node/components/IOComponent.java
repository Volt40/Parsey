package org.volt4.parsey.fx.node.components;

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
     * True if the value is reciving an input from another node.
     * @param inputed if the value is reciving an input from another node.
     */
    void setInputed(boolean inputed);

    /**
     * The type if this IO.
     */
    enum Type {
        INPUT, OUTPUT;
    }

}
