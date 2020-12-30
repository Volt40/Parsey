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
public class InputConnectionHandle<T> extends ConnectionHandle {

    // Keeps track of all InputConnectionHandles.
    private static List<InputConnectionHandle> allInputConnectionHandles;

    /**
     * Returns a list of all InputConnectionHandle.
     * @return a list of all InputConnectionHandle.
     */
    public static List<InputConnectionHandle> getAllInputConnectionHandles() {
        return allInputConnectionHandles;
    }

    // This input's connection.
    private NodeConnectionComponent<?, ?> referencedConnection;

    // Input component this is linked to.
    private InputNodeComponent<T> linkedNodeComponent;

    // Active connection, null if inactive.
    private NodeConnectionComponent<?, ?> activeConnection;

    /**
     * Constructs a InputConnectionHandle with the given color.
     * @param color Color of the InputConnectionHandle.
     */
    public InputConnectionHandle(InputNodeComponent<T> linkedNodeComponent, HandleColor color) {
        super(color);
        this.linkedNodeComponent = linkedNodeComponent;
        if (allInputConnectionHandles == null)
            allInputConnectionHandles = new ArrayList<>();
        allInputConnectionHandles.add(this);
    }

    /**
     * Returns the referenced connection.
     * @return the referenced connection.
     */
    public NodeConnectionComponent<?, ?> getReferencedConnection() {
        return referencedConnection;
    }

    /**
     * Called when the mouse drags on this handle.
     * @param event Event object.
     */
    @Override
    public void onDrag(MouseEvent event) {
        if (activeConnection == null) {
            activeConnection = new NodeConnectionComponent<>();
            activeConnection.setCurveEndPoint(getLayoutX() + getPrefWidth() / 2, getLayoutY() + getPrefHeight() / 2);
        } else {
            activeConnection.setCurveStartPoint(event.getX(), event.getY());
        }
    }

    /**
     * Called when the mouse releases from this handle (when the drag is finished).
     * @param event Event object.
     */
    @Override
    public void onRelease(MouseEvent event) {
        double dropX = event.getX();
        double dropY = event.getY();
        for (OutputConnectionHandle och : OutputConnectionHandle.getAllOutputConnectionHandles()) {
            double tX = och.getLayoutX();
            double tY = och.getLayoutY();
            if (dropX < tX + och.getPrefWidth() && dropX > tX) // Check X
                if (dropY < tY + och.getPrefHeight() && dropY > tY) { // Check Y
                    activeConnection.setCurveStartPoint(tX + och.getPrefWidth() / 2, tY + och.getPrefHeight() / 2);
                    linkedNodeComponent.setInput(activeConnection);
                    referencedConnection = activeConnection;
                }
        }
        activeConnection = null;
    }

}
