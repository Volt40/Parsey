package org.volt4.parsey.main;

import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;
import javafx.geometry.Rectangle2D;
import org.volt4.parsey.node.*;
import org.volt4.parsey.node.implementation.MathNode;

public class Test {

    public static void main(String[] args) {

        NodeNetwork nn = new NodeNetwork();
        MathNode n1 = new MathNode(MathNode.Type.ADD);
        NodeConnection<Double, Double> c1 = new NodeConnection<>();
        NodeInput<Double> in1 = (NodeInput<Double>) n1.inputs().get(0);
        NodeOutput<Double> out1 = (NodeOutput<Double>) n1.outputs().get(0);
        out1.addConnection(c1);
        in1.setConnection(c1);
        nn.addNode(n1);
        nn.addConnection(c1);
        try {
            nn.evaluate(100);
        } catch (NodeException e) {
            e.printStackTrace();
        }

    }

}
