package org.volt4.parsey.fx.node.components;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * A dropdown component. Does what dropdowns do.
 *
 * @version 1.0
 *
 */
public class DropDown extends AnchorPane implements Component {

    // Location of this component's FXML.
    private static final String FXML_RESOURCE_LOCATION = "/fxml/nodes/components/DropDown.fxml";

    // True if this component is disabled.
    boolean disabled;

    @FXML
    private ComboBox<String> comboBox;

    public DropDown(String... items) {
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
        // Setup
        ObservableList<String> options = FXCollections.observableArrayList(items);
        comboBox.setItems(options);
    }

    public String getSelected() {
        return comboBox.getValue();
    }

    public void setSelected(int i) {
        comboBox.getSelectionModel().select(i);
    }

    public ComboBox<String> getEmbedded() {
        return comboBox;
    }

    @Override
    public double getComponentHeight() {
        return getPrefHeight();
    }

    @Override
    public Pane getRoot() {
        return this;
    }

    @Override
    public boolean isComponentDisabled() {
        return disabled;
    }

    @Override
    public void setComponentDisabled(boolean disabled) {
        this.disabled = disabled;
    }
}
