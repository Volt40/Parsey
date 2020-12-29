package org.volt4.parsey.fx.node.components;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * This class represents a connection handle. That is the dot
 * on the sides of nodes that is used to form connections. Every
 * dot has a different color that is meant to designate various
 * data types.
 *
 * @version 1.0
 *
 */
public abstract class ConnectionHandle extends AnchorPane {

    /**
     * Constructs a ConnectionHandle with the given color.
     * @param color Color of the ConnectionHandle.
     */
    public ConnectionHandle(HandleColor color) {
        // Set up appearance.
        setPrefSize(10, 10);
        getStyleClass().add(color.getStyleClassName());
        // Set up handlers.
        setOnMouseDragged(e -> onDrag(e));
        setOnMouseReleased(e -> onRelease(e));
    }

    /**
     * Called when the mouse drags on this handle.
     * @param event Event object.
     */
    public abstract void onDrag(MouseEvent event);

    /**
     * Called when the mouse releases from this handle (when the drag is finished).
     * @param event Event object.
     */
    public abstract void onRelease(MouseEvent event);

    /**
     * Represents the color of a handle.
     */
    public enum HandleColor {

        // Definitions.
        GREY("nc-grey"),
        YELLOW("nc-yellow"),
        PURPLE("nc-purple"),
        GREEN("nc-green");

        // The name of the style class.
        private String styleClassName;

        /**
         * Creates a HandleColor with the appropriate style class.
         * @param styleClassName Name of the style class.
         */
        HandleColor(String styleClassName) {
            this.styleClassName = styleClassName;
        }

        /**
         * Returns the name of the correct style class for this color.
         * @return the name of the correct style class for this color.
         */
        public String getStyleClassName() {
            return styleClassName;
        }

    }

}
