package org.volt4.parsey.fx.node;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import org.volt4.parsey.fx.node.components.InputNodeComponent;
import org.volt4.parsey.fx.node.components.NodeComponent;
import org.volt4.parsey.fx.node.components.OutputNodeComponent;
import org.volt4.parsey.node.Node;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Base of all nodes. All nodes are subclasses of this.
 *
 * @version 1.0
 *
 */
public abstract class FXNodeBase extends AnchorPane {

    // Location of this object's FXML resource.
    private static final String FXML_RESOURCE_LOCATION = "/fxml/nodes/NodeBase.fxml";

    @FXML
    private AnchorPane body;

    @FXML
    private AnchorPane header;

    @FXML
    private Text label;

    // List of components & handles.
    private List<NodeComponent> components;

    // Linked node.
    private Node linkedNode;

    /**
     * Constructs an FXNodeBase.
     */
    public FXNodeBase() {
        components = new ArrayList<NodeComponent>();
        // Set up the loader.
        FXMLLoader loader = new FXMLLoader(getClass().getResource(FXML_RESOURCE_LOCATION));
        loader.setRoot(this);
        loader.setController(this);
        // Load.
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Set up
        enableDrag(this);
    }

    protected void addComponent(NodeComponent component) {

    }

    protected void addInputComponent(InputNodeComponent<?> component) {

    }

    protected void addOutputComponent(OutputNodeComponent<?> component) {

    }

    /**
     * Makes a node draggable.
     * @param pane Pane to enable the drag.
     */
    public static void enableDrag(Pane pane) {
        final double[] delta = new double[2];
        pane.setOnMousePressed(mouseEvent -> {
            // Record a delta distance for the drag operation.
            delta[0] = mouseEvent.getX();
            delta[1] = mouseEvent.getY();
        });
        pane.setOnMouseDragged(mouseEvent -> {
            // Update the position.
            pane.setLayoutX(pane.getLayoutX() + mouseEvent.getX() - delta[0]);
            pane.setLayoutY(pane.getLayoutY() + mouseEvent.getY() - delta[1]);
        });
    }

    /**
     * Prevents dragging on-top of the given pane.
     * @param pane Pane to disable dragging.
     */
    public static void consumeDrag(Pane pane) {
        pane.setOnMouseDragged(mouseEvent -> mouseEvent.consume());
    }

}
