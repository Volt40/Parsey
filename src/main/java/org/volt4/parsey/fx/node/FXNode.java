package org.volt4.parsey.fx.node;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.volt4.parsey.fx.node.components.Component;
import org.volt4.parsey.fx.node.components.IOComponent;
import org.volt4.parsey.node.Node;
import org.volt4.parsey.node.NodeInput;
import org.volt4.parsey.node.NodeOutput;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class FXNode extends AnchorPane {

    // Location of this object's FXML resource.
    private static final String FXML_RESOURCE_LOCATION = "/fxml/nodes/NodeBase.fxml";

    @FXML
    private AnchorPane body;

    @FXML
    private AnchorPane header;

    @FXML
    private Text label;

    // List of components.
    private List<Component> components;

    // Linked node.
    private Node linkedNode;

    /**
     * Constructs an FXNode.
     */
    public FXNode() {
        components = new ArrayList<Component>();
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
    }

    /**
     * Sets the linked node.
     * @param node Node to be linked.
     */
    public void setLinkedNode(Node node) {
        linkedNode = node;
    }

    /**
     * Adds the component to the node.
     * @param component Component to be added.
     * @param buffer Distance from last component.
     */
    public void addComponent(Component component, double buffer) {
        components.add(component);
        components.add(Component.getBuffer(buffer));
        getChildren().add(component.getRoot());
        AnchorPane.setRightAnchor(component.getRoot(), 10d);
        AnchorPane.setLeftAnchor(component.getRoot(), 10d);
    }

    public void addInputIOComponent(IOComponent component, String mapName, double buffer) {
        addComponent(component, buffer);
        if (component.canSupply())
            for (NodeInput input : linkedNode.inputs())
                if (input.getLabel().equals(mapName))
                    input.useStaticInput(() -> component.supplyValue());
    }

    public void addOutputIOComponent(IOComponent component, String mapName, double buffer) {
        addComponent(component, buffer);
        if (component.canSupply())
            for (NodeOutput output : linkedNode.outputs())
                if (output.getLabel().equals(mapName));
                    //TODO
    }

    /**
     * Recalculates the size and placement of the node.
     */
    public void recalculateSize() {
        double currentPlace = 30;
        for (Component component : components)
            if (!component.isComponentDisabled())
                if (component.getRoot() == null)
                    currentPlace += component.getComponentHeight();
                else {
                    AnchorPane.setTopAnchor(component.getRoot(), currentPlace);
                    currentPlace += component.getComponentHeight();
                }
        setPrefHeight(currentPlace + 10d);
    }

    /**
     * Sets the label (title) of this node.
     * @param label Label to be set.
     */
    public void setLabel(String label) {
        this.label.setText(label);
    }


}
