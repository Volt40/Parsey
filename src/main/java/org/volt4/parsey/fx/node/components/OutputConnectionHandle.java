package org.volt4.parsey.fx.node.components;

import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Output connection handle.
 *
 * @version 1.0
 *
 */
public class OutputConnectionHandle extends ConnectionHandle {

    // This output's connections.
    private List<NodeConnectionComponent<?, ?>> referencedConnections;

    /**
     * Constructs a OutputConnectionHandle with the given color.
     * @param color Color of the OutputConnectionHandle.
     */
    public OutputConnectionHandle(HandleColor color) {
        super(color);
        referencedConnections = new ArrayList<>();
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
