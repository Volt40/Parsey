package org.volt4.parsey.fx.node.components;

import javafx.scene.shape.CubicCurve;
import org.volt4.parsey.node.NodeConnection;

/**
 * Represents a visual connection between two nodes.
 *
 * @param <I> Input data type.
 * @param <O> Output data type.
 * @version 1.0
 *
 */
public class NodeConnectionComponent<I, O> {

    // The global interpolation type for all connection curves.
    private static InterpolationType globalType;

    // Cubic curve object used to display the connection.
    private CubicCurve curve;

    // Node Connection
    private NodeConnection<I, O> connection;

    /**
     * Returns the NodeConnection of this object.
     * @return the NodeConnection of this object.
     */
    public NodeConnection<I, O> getNodeConnection() {
        return connection;
    }

    /**
     * The interpolation type of the curve.
     */
    public enum InterpolationType {
        LINE, CURVE;
    }

}
