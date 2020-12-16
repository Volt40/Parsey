package org.volt4.parsey.fx.node;

import org.volt4.parsey.fx.node.components.DropDown;
import org.volt4.parsey.fx.node.components.IOComponent;
import org.volt4.parsey.fx.node.components.OutputLabel;
import org.volt4.parsey.fx.node.components.ValueSlider;
import org.volt4.parsey.node.implementation.MathNode;

public class FXMathNode extends FXNode {

    private MathNode node;

    /**
     * Constructs an FXMathNode.
     */
    public FXMathNode() {
        node = new MathNode(MathNode.Type.ADD);
        setLinkedNode(node);
        setLabel(MathNode.Type.ADD.getDisplayName());
        addOutputIOComponent(new OutputLabel<Double>("Value", 50), "Value", 0);
        String[] mathTypes = new String[MathNode.Type.values().length];
        for (int i = 0; i < mathTypes.length; i++)
            mathTypes[i] = MathNode.Type.values()[i].getDisplayName();
        addComponent(new DropDown(mathTypes), 15);
        addInputIOComponent(new ValueSlider(IOComponent.Type.INPUT, "Value"), "value1", 3);
        addInputIOComponent(new ValueSlider(IOComponent.Type.INPUT, "Value"), "value2", 3);
        addInputIOComponent(new ValueSlider(IOComponent.Type.INPUT, "Base"), "base", 3);
        addInputIOComponent(new ValueSlider(IOComponent.Type.INPUT, "Exponent"), "exponent", 3);
        recalculateSize();
    }
}
