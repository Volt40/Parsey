package org.volt4.parsey.fx.node.components;

import javafx.scene.input.MouseEvent;

/**
 * Input connection handle.
 *
 * @version 1.0
 *
 */
public class InputConnectionHandle extends ConnectionHandle {

    // This input's connection.
    private NodeConnectionComponent<?, ?> referencedConnection;

    /**
     * Constructs a InputConnectionHandle with the given color.
     * @param color Color of the InputConnectionHandle.
     */
    public InputConnectionHandle(HandleColor color) {
        super(color);
    }

    /**
     * Called when the mouse drags on this handle.
     * @param event Event object.
     */
    @Override
    public void onDrag(MouseEvent event) {

    }

    /**
     * Called when the mouse releases from this handle (when the drag is finished).
     * @param event Event object.
     */
    @Override
    public void onRelease(MouseEvent event) {

    }

}
