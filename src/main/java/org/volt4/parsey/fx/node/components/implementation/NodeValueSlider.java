package org.volt4.parsey.fx.node.components.implementation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.volt4.parsey.fx.node.FXNodeBase;
import org.volt4.parsey.fx.node.components.ConnectionHandle;
import org.volt4.parsey.fx.node.components.InputNodeComponent;
import org.volt4.parsey.node.NodeInput;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * This component is a used to set a numerical value.
 *
 * Behaviour:
 * - Appears normally with a label and the value following it.
 * - If the cursor is hovering, two arrows are displayed that can be use to increment the value.
 * - Dragging on the center will fine tune the value.
 * - Clicking on the center will open a text field where a value can be typed in.
 *
 * @version 1.0
 *
 */
public class NodeValueSlider extends InputNodeComponent<Double> {

    // Location of this component's FXML.
    private static final String FXML_RESOURCE_LOCATION = "/fxml/nodes/components/ValueSlider.fxml";

    // Settings.
    private double STARTING_VALUE;
    private double INCREMENT_ARROWS;
    private double SCROLL_SCALE;

    // The label for this value slider.
    private String label;

    // Input this component controls.
    private NodeInput<Double> input;

    @FXML
    private AnchorPane rightPane;

    @FXML
    private Text valueText;

    @FXML
    private Text labelText;

    @FXML
    private AnchorPane leftPane;

    @FXML
    private TextField textField;

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
     * @param buffer Buffer <I>above</I> this component.
     * @param input Input this component needs to control.
     */
    public NodeValueSlider(NodeInput<Double> input, String label, double buffer) {
        // Initiate with default.
        this(input, label, buffer, 0.5, 0.1, 100);
    }

    /**
     * Constructs a value slider and imports the fxml resource.
     * @param input Input this component needs to control.
     * @param label Label for the value of this slider.
     * @param buffer Buffer <I>above</I> this component.
     * @param startingValue Starting value for this slider.
     * @param arrowIncrement Increment for clicking the arrows.
     * @param scrollScale Scale for the scroll increment.
     */
    public NodeValueSlider(NodeInput<Double> input, String label, double buffer, double startingValue, double arrowIncrement, double scrollScale) {
        super(FXML_RESOURCE_LOCATION, 30, buffer, input, true, ConnectionHandle.HandleColor.GREY);
        STARTING_VALUE = startingValue;
        INCREMENT_ARROWS = arrowIncrement;
        SCROLL_SCALE = scrollScale;
        this.input = input;
        this.label = label;
        this.buffer = buffer;
        // Set up.
        FXNodeBase.consumeDrag(this);
        labelText.setText(label);
        rightPane.setVisible(false);
        leftPane.setVisible(false);
        textField.setVisible(false);
        setValue(STARTING_VALUE);
    }

    /**
     * Sets the value of this ValueSlider
     * @param value Value to be set.
     */
    public void setValue(double value) {
        if (value < 1e-6 && value > -1e-6)
            // Prevents visual glitches.
            value = 0;
        value = round(value, 8); // Logical rounding.
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

    /**
     * Utility method for rounding doubles.
     * @param value
     * @param places
     * @return The rounded double.
     */
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
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
        setValue(value + dX / SCROLL_SCALE);
    }

    @FXML
    void centerMouseRelease(MouseEvent event) {
        dragging = false;
    }

    @FXML
    void centerClick(MouseEvent event) {
        if (dragging)
            return;
        textField.setText("" + value);
        textField.setVisible(true);
        textField.requestFocus();
    }

    @FXML
    void onEnter(ActionEvent event) {
        textField.setVisible(false);
        try {
            double newValue = Double.parseDouble(textField.getText());
            setValue(newValue);
        } catch(Exception e) { }
    }

    @FXML
    void leftArrowMouseRelease(MouseEvent event) {
        setValue(value - INCREMENT_ARROWS);
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
    void rightArrowMouseRelease(MouseEvent event) {
        setValue(value + INCREMENT_ARROWS);
    }

    @FXML
    void leftArrowClicked(MouseEvent event) {
        event.consume();
    }

    @FXML
    void rightArrowClicked(MouseEvent event) {
        event.consume();
    }

    /**
     * Gets a result.
     * @return a result
     */
    @Override
    public Double get() {
        return getValue();
    }

}
