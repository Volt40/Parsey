package org.volt4.parsey.fx.node.components;

import javafx.scene.layout.Pane;

/**
 * UI Components that are used in nodes all must implement this. This takes care of
 * the information needed to layout the component on the node. Components that are
 * not used in nodes do not need to implement this. Components that have inputs/
 * outputs should implement the Input/OutputNodeComponent interface. (Input/OutputNodeComponent
 * is a sub-interface of NodeComponent).
 *
 * @version 1.0
 *
 */
public interface NodeComponent {

    /**
     * Returns the height of this component.
     * @return the height of this component.
     */
    double getComponentHeight();

    /**
     * Returns the buffer of this component. The buffer
     * is the distance <I>above</I> the component.
     * @return
     */
    double getBuffer();

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
     * Sets the component to be disabled. Disabled components should be invisible.
     * @param disabled true if this component is disabled, false otherwise.
     */
    void setComponentDisabled(boolean disabled);

}
