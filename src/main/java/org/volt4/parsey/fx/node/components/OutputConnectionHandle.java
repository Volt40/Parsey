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
public class OutputConnectionHandle<T> extends ConnectionHandle {

    // Keeps track of all OutputConnectionHandles.
    private static List<OutputConnectionHandle> allOutputConnectionHandles;

    /**
     * Returns a list of all OutputConnectionHandles.
     * @return a list of all OutputConnectionHandles.
     */
    public static List<OutputConnectionHandle> getAllOutputConnectionHandles() {
        return allOutputConnectionHandles;
    }

    // This output's connections.
    private List<NodeConnectionComponent<?, ?>> referencedConnections;

    // Output component this is linked to.
    private OutputNodeComponent<T> linkedNodeComponent;

    // Active connection, null if inactive.
    private NodeConnectionComponent<?, ?> activeConnection;

    /**
     * Constructs a OutputConnectionHandle with the given color.
     * @param color Color of the OutputConnectionHandle.
     */
    public OutputConnectionHandle(OutputNodeComponent<T> linkedNodeComponent, HandleColor color) {
        super(color);
        this.linkedNodeComponent = linkedNodeComponent;
        if (allOutputConnectionHandles == null)
            allOutputConnectionHandles = new ArrayList<>();
        allOutputConnectionHandles.add(this);
        referencedConnections = new ArrayList<>();
    }

    /**
     * Called when the mouse drags on this handle.
     * @param event Event object.
     */
    @Override
    public void onDrag(MouseEvent event) {
        if (activeConnection == null) {
            activeConnection = new NodeConnectionComponent<>();
            activeConnection.setCurveStartPoint(getLayoutX() + getPrefWidth() / 2, getLayoutY() + getPrefHeight() / 2);
        } else {
            activeConnection.setCurveEndPoint(event.getX(), event.getY());
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
        for (InputConnectionHandle och : InputConnectionHandle.getAllInputConnectionHandles()) {
            double tX = och.getLayoutX();
            double tY = och.getLayoutY();
            if (dropX < tX + och.getPrefWidth() && dropX > tX)
                if (dropY < tY + och.getPrefHeight() && dropY > tY) {
                    activeConnection.setCurveEndPoint(tX + och.getPrefWidth() / 2, tY + och.getPrefHeight() / 2);
                    linkedNodeComponent.addOutput(activeConnection);
                }
        }
    }

}
