package org.volt4.parsey.fx.node.components;

import javafx.scene.shape.CubicCurve;
import org.volt4.parsey.node.NodeConnection;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a visual connection between two nodes.
 *
 * @param <I> Input data type.
 * @param <O> Output data type.
 * @version 1.0
 *
 */
public class NodeConnectionComponent<I, O> {

    // Keeps track of all NodeConnectionComponents.
    private static List<NodeConnectionComponent<?, ?>> allNodeConnectionComponents;

    // The global interpolation type for all connection curves.
    private static InterpolationType globalType = InterpolationType.CURVE;

    /**
     * Sets the global interpolation type. The type is curve by default.
     * @param globalType The type to be set.
     */
    public void setGlobalInterpolationType(InterpolationType globalType) {
        NodeConnectionComponent.globalType = globalType;
        for (NodeConnectionComponent<?, ?> connection : allNodeConnectionComponents)
            connection.recalculateControls();
    }

    // Cubic curve object used to display the connection.
    private CubicCurve curve;

    // Node Connection
    private NodeConnection<I, O> connection;

    /**
     * Constructs a node connection component.
     */
    public NodeConnectionComponent() {
        // Track this object.
        if (allNodeConnectionComponents == null)
            allNodeConnectionComponents = new ArrayList<>();
        allNodeConnectionComponents.add(this);
    }

    /**
     * Returns the NodeConnection of this object.
     * @return the NodeConnection of this object.
     */
    public NodeConnection<I, O> getNodeConnection() {
        return connection;
    }

    /**
     * Sets the left point of the curve.
     * @param x X coordinate of the point to be set.
     * @param y Y coordinate of the point to be set.
     */
    public void setCurveStartPoint(double x, double y) {
        curve.setStartX(x);
        curve.setStartY(y);
        recalculateControls();
    }

    /**
     * Sets the right point of the curve.
     * @param x X coordinate of the point to be set.
     * @param y Y coordinate of the point to be set.
     */
    public void setCurveEndPoint(double x, double y) {
        curve.setEndX(x);
        curve.setEndY(y);
        recalculateControls();
    }

    /**
     * Recalculates the control points of the curve (based
     * on the interpolation type);
     */
    private void recalculateControls() {
        if (globalType == InterpolationType.LINE) {
            // Line interpolation.
            curve.setControlX1(curve.getStartX());
            curve.setControlY1(curve.getStartY());
            curve.setControlX2(curve.getEndX());
            curve.setControlY2(curve.getEndY());
        } else {
            // Curve interpolation.
            curve.setControlX1(curve.getStartX() + ((curve.getEndX() - curve.getStartX()) / 2));
            curve.setControlY1(curve.getStartY());
            curve.setControlX2(curve.getStartX() + ((curve.getEndX() - curve.getStartX()) / 2));
            curve.setControlY2(curve.getEndY());
        }
    }

    /**
     * The interpolation type of the curve.
     */
    public enum InterpolationType {
        LINE, CURVE;
    }

}
