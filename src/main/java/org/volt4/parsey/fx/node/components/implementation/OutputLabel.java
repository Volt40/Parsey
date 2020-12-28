package org.volt4.parsey.fx.node.components.implementation;

import org.volt4.parsey.fx.node.components.IOComponent;
import org.volt4.parsey.node.NodeInput;
import org.volt4.parsey.node.NodeOutput;

@Deprecated
public class OutputLabel<T> extends IOLabel implements IOComponent<T> {

    private NodeOutput<T> linkedOutput;

    /**
     * Constructs a OutputLabel with the given parameters.
     * @param label
     * @param height
     */
    public OutputLabel(String label, double height) {
        super(label, IOLabel.Type.OUTPUT, height);
        linkedOutput = new NodeOutput<>(label);
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
    public NodeOutput<T> getLinkedOutput() {
        return linkedOutput;
    }

    @Override
    public NodeInput<T> getLinkedInput() {
        return null;
    }

    @Override
    public void setInputted(boolean inputted) {
        // Unused
    }

}
