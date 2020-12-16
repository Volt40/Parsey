package org.volt4.parsey.fx.node.components;

import java.util.function.Supplier;

public class OutputLabel<T> extends IOLabel implements IOComponent<T> {

    /**
     * Constructs a OutputLabel with the given parameters.
     * @param label
     * @param height
     */
    public OutputLabel(String label, double height) {
        super(label, IOLabel.Type.OUTPUT, height);
    }

    @Override
    public boolean canSupply() {
        return false;
    }

    @Override
    public T supplyValue() {
        return null;
    }

    @Override
    public IOComponent.Type getType() {
        return null;
    }

    @Override
    public void setInputed(boolean inputed) {
        // Unused
    }

}
