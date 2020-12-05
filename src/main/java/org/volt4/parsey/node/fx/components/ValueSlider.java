package org.volt4.parsey.node.fx.components;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

import java.io.IOException;

/**
 * This component is a used to set a numerical value.
 */
public class ValueSlider extends AnchorPane {

    // Location of this component's FXML.
    private static final String FXML_RESOURCE_LOCATION = "/fxml/nodes/components/ValueSlider.fxml";

    // The label for this value slider.
    private String label;

    @FXML
    private Text valueText;

    @FXML
    private AnchorPane rightPane;

    @FXML
    private AnchorPane leftPane;

    @FXML
    private AnchorPane centerPane;

    /**
     * Constructs a value slider and imports the fxml resource.
     * @param label Label for the value on this slider.
     */
    public ValueSlider(String label) {
        this.label = label;
        // Set up the loader.
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(FXML_RESOURCE_LOCATION));
        loader.setRoot(this);
        loader.setController(this);
        // Load.
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Set up.
    }

    /*
     * Below are all the handlers for the value slider.
     */

    @FXML
    void centerDragDetected(MouseEvent event) {

    }

    @FXML
    void centerMouseDragged(MouseEvent event) {

    }

    @FXML
    void centerMouseEntered(MouseEvent event) {

    }

    @FXML
    void centerMouseExit(MouseEvent event) {

    }

    @FXML
    void centerMouseRelease(MouseEvent event) {

    }

    @FXML
    void dragDetected(MouseEvent event) {

    }

    @FXML
    void leftArrowMouseEnter(MouseEvent event) {

    }

    @FXML
    void leftArrowMouseExit(MouseEvent event) {

    }

    @FXML
    void leftArrowMousePress(MouseEvent event) {

    }

    @FXML
    void leftArrowMouseRelease(MouseEvent event) {

    }

    @FXML
    void mouseEnter(MouseEvent event) {

    }

    @FXML
    void mouseExit(MouseEvent event) {

    }

    @FXML
    void rightArrowMouseEnter(MouseEvent event) {

    }

    @FXML
    void rightArrowMouseExit(MouseEvent event) {

    }

    @FXML
    void rightArrowMousePress(MouseEvent event) {

    }

    @FXML
    void rightArrowMouseRelease(MouseEvent event) {

    }

}
