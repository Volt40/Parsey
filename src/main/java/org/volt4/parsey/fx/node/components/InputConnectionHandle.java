package org.volt4.parsey.fx.node.components;

import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Input connection handle.
 *
 * @version 1.0
 *
 */
public class InputConnectionHandle extends ConnectionHandle {

    // Keeps track of all InputConnectionHandles.
    private static List<InputConnectionHandle> allInputConnectionHandles;

    // This input's connection.
    private NodeConnectionComponent<?, ?> referencedConnection;

    /**
     * Constructs a InputConnectionHandle with the given color.
     * @param color Color of the InputConnectionHandle.
     */
    public InputConnectionHandle(HandleColor color) {
        super(color);
        if (allInputConnectionHandles == null)
            allInputConnectionHandles = new ArrayList<>();
        allInputConnectionHandles.add(this);
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
