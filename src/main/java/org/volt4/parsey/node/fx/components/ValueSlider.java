package org.volt4.parsey.node.fx.components;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.volt4.parsey.main.Parsey;
import org.volt4.parsey.main.Settings;

import java.io.IOException;

/**
 * This component is a used to set a numerical value.
 */
public class ValueSlider extends AnchorPane implements Component {

    // Location of this component's FXML.
    private static final String FXML_RESOURCE_LOCATION = "/fxml/nodes/components/ValueSlider.fxml";

    // Default value.
    private static final double DEFAULT_VALUE = 0.5;

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

    @FXML
    private AnchorPane raft;

    // Fields for handling dragging.
    private boolean dragging;
    private double lastDragX;

    /**
     * The value of this slider.
     */
    private double value;

    /**
     * Constructs a value slider and imports the fxml resource.
     * @param label Label for the value on this slider.
     */
    public ValueSlider(String label) {
        this.label = label;
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
        // Set up.
        rightPane.setVisible(false);
        leftPane.setVisible(false);
        setValue(DEFAULT_VALUE);
    }

    /**
     * Sets the value of this ValueSlider
     * @param value Value to be set.
     */
    public void setValue(double value) {
        if (value < 1e-6 && value > -1e-6)
            // Prevents visual glitches.
            value = 0;
        this.value = value;
        valueText.setText(condenseValue());
    }

    /**
     * Gets the value of this slider.
     * @return the value of this slider.
     */
    public double getValue() {
        return value;
    }

    /**
     * Condenses the value so it is displayed to three decimal places.
     * @return the value so it is displayed to three decimal places.
     */
    private String condenseValue() {
        String cv = ("" + value).substring(0, ("" + value).indexOf('.'));
        String cvEnd = ("" + value).substring(("" + value).indexOf('.'));
        for (int i = cvEnd.length() - 1; i < 3; i++)
            cvEnd += "0";
        if (cvEnd.length() > 4)
            cvEnd = cvEnd.substring(0, 4);
        return cv + cvEnd;
    }

    /*
     * Below are all the handlers for the value slider.
     */

    @FXML
    void centerDragDetected(MouseEvent event) {
        dragging = true;
        lastDragX = event.getX();
    }

    @FXML
    void centerMouseDragged(MouseEvent event) {
        if (!dragging)
            return;
        double dX = event.getX() - lastDragX;
        lastDragX = event.getX();
        setValue(value + dX / 100);
    }

    @FXML
    void centerMouseEntered(MouseEvent event) {
        centerPane.setStyle("-fx-background-radius: 6; -fx-border-radius: 6; -fx-background-color: " + Settings.CSL3);
        raft.setStyle("-fx-background-radius: 6; -fx-border-radius: 6; -fx-background-color: " + Settings.CSL3);
        leftPane.setStyle("-fx-background-radius: 6 0 0 6; -fx-border-radius: 6 0 0 6; -fx-background-color: " + Settings.CSL2);
        rightPane.setStyle("-fx-background-radius: 0 6 6 0; -fx-border-radius: 0 6 6 0; -fx-background-color: " + Settings.CSL2);
        Parsey.getScene().setCursor(Cursor.E_RESIZE);
    }

    @FXML
    void centerMouseExit(MouseEvent event) {
        centerPane.setStyle("-fx-background-radius: 6; -fx-border-radius: 6; -fx-background-color: " + Settings.CSL2);
        raft.setStyle("-fx-background-radius: 6; -fx-border-radius: 6; -fx-background-color: " + Settings.CSL2);
        Parsey.getScene().setCursor(Cursor.DEFAULT);
    }

    @FXML
    void centerMouseRelease(MouseEvent event) {
        dragging = false;
    }

    @FXML
    void leftArrowMouseEnter(MouseEvent event) {
        centerPane.setStyle("-fx-background-radius: 6; -fx-border-radius: 6; -fx-background-color: " + Settings.CSL2);
        raft.setStyle("-fx-background-radius: 6; -fx-border-radius: 6; -fx-background-color: " + Settings.CSL2);
        leftPane.setStyle("-fx-background-radius: 6 0 0 6; -fx-border-radius: 6 0 0 6; -fx-background-color: " + Settings.CSL3);
        rightPane.setStyle("-fx-background-radius: 0 6 6 0; -fx-border-radius: 0 6 6 0; -fx-background-color: " + Settings.CSL2);
    }

    @FXML
    void leftArrowMousePress(MouseEvent event) {
        leftPane.setStyle("-fx-background-radius: 6 0 0 6; -fx-border-radius: 6 0 0 6; -fx-background-color: " + Settings.CSL4);
        event.consume();
    }

    @FXML
    void leftArrowMouseRelease(MouseEvent event) {
        leftPane.setStyle("-fx-background-radius: 6 0 0 6; -fx-border-radius: 6 0 0 6; -fx-background-color: " + Settings.CSL3);
        setValue(value - 0.1f);
    }

    @FXML
    void mouseEnter(MouseEvent event) {
        rightPane.setVisible(true);
        leftPane.setVisible(true);
    }

    @FXML
    void mouseExit(MouseEvent event) {
        rightPane.setVisible(false);
        leftPane.setVisible(false);
    }

    @FXML
    void rightArrowMouseEnter(MouseEvent event) {
        centerPane.setStyle("-fx-background-radius: 6; -fx-border-radius: 6; -fx-background-color: " + Settings.CSL2);
        raft.setStyle("-fx-background-radius: 6; -fx-border-radius: 6; -fx-background-color: " + Settings.CSL2);
        leftPane.setStyle("-fx-background-radius: 6 0 0 6; -fx-border-radius: 6 0 0 6; -fx-background-color: " + Settings.CSL2);
        rightPane.setStyle("-fx-background-radius: 0 6 6 0; -fx-border-radius: 0 6 6 0; -fx-background-color: " + Settings.CSL3);
    }

    @FXML
    void rightArrowMousePress(MouseEvent event) {
        rightPane.setStyle("-fx-background-radius: 0 6 6 0; -fx-border-radius: 0 6 6 0; -fx-background-color: " + Settings.CSL4);
        event.consume();
    }

    @FXML
    void rightArrowMouseRelease(MouseEvent event) {
        rightPane.setStyle("-fx-background-radius: 0 6 6 0; -fx-border-radius: 0 6 6 0; -fx-background-color: " + Settings.CSL3);
        setValue(value + 0.1f);
    }

}
