package org.volt4.parsey.fx.node.components;

import javafx.scene.layout.Pane;

/**
 * Represents a component of a node.
 *
 * @version 1.0
 *
 */
public interface Component {

    /**
     * Makes a buffer Component.
     * @param buffer
     * @return
     */
    static Component getBuffer(double buffer) {
        return new Component() {
            @Override
            public double getComponentHeight() {
                return buffer;
            }
            @Override
            public Pane getRoot() {
                return null;
            }
            @Override
            public boolean isComponentDisabled() {
                return false;
            }
            @Override
            public void setComponentDisabled(boolean disabled) {

            }
        };
    }

    /**
     * Returns the height of this component.
     * @return the height of this component.
     */
    double getComponentHeight();

    /**
     * Returns the root of this component.
     * @return the root of this component.
     */
    Pane getRoot();

    /**
     * Sets whether or not this component is disabled.
     * @return whether or not this component is disabled.
     */
    boolean isComponentDisabled();

    /**
     * Returns true if this component is disabled.
     * @param disabled true if this component is disabled, false otherwise.
     */
    void setComponentDisabled(boolean disabled);

}
