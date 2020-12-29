package org.volt4.parsey.fx.node.components;

import javafx.scene.input.MouseEvent;

/**
 * Output connection handle.
 *
 * @version 1.0
 *
 */
public class OutputConnectionHandle extends ConnectionHandle {

    /**
     * Constructs a OutputConnectionHandle with the given color.
     * @param color Color of the OutputConnectionHandle.
     */
    public OutputConnectionHandle(HandleColor color) {
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
