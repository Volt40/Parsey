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

    // Cubic curve object used to display the connection.
    private CubicCurve curve;

    // Node Connection
    private NodeConnection<I, O> connection;

    public enum Type {
        LINE, CURVE;
    }

}
