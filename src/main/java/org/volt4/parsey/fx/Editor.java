package org.volt4.parsey.fx;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

/**
 * Editor in which nodes are manipulated.
 *
 * @version 1.0
 *
 */
public class Editor extends AnchorPane {

    // Location of this object's FXML.
    private static final String FXML_RESOURCE_LOCATION = "/fxml/Editor.fxml";

    /**
     * Constructs an editor.
     */
    public Editor() {
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

}
