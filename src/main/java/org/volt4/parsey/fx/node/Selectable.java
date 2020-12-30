package org.volt4.parsey.fx.node;

import javafx.geometry.Rectangle2D;

/**
 * Editor objects that are able to be selected should all implement this.
 *
 * @version 1.0
 *
 */
public interface Selectable {

    /**
     * Returns true if <I>any</I> parts of the selectable are contained within the box.
     * @param box Box to check.
     * @return true if <I>any</I> parts of the selectable are contained within the box.
     */
    boolean containsAny(Rectangle2D box);

    /**
     * Returns true if <I>all</I> parts of the selectable are contained within the box.
     * @param box Box to check.
     * @return true if <I>all</I> parts of the selectable are contained within the box.
     */
    boolean containsAll(Rectangle2D box);

    /**
     * Called when this is selected as the primary.
     */
    void selectPrimary();

    /**
     * Called when this is selected as the secondary.
     */
    void selectSecondary();

    /**
     * Called when this is deselected.
     */
    void deSelect();

}
