package org.volt4.parsey.fx.node;

import javafx.scene.control.ComboBox;
import org.volt4.parsey.fx.node.components.implementation.DropDown;
import org.volt4.parsey.fx.node.components.IOComponent;
import org.volt4.parsey.fx.node.components.implementation.OutputLabel;
import org.volt4.parsey.fx.node.components.implementation.ValueSlider;
import org.volt4.parsey.node.implementation.MathNode;

public class FXMathNode extends FXNode {

    private MathNode node;

    private ValueSlider value1;
    private ValueSlider value2;
    private ValueSlider base;
    private ValueSlider exponent;


    /**
     * Constructs an FXMathNode.
     */
    public FXMathNode(MathNode.Type type) {
        node = new MathNode(type);
        setLinkedNode(node);
        setLabel(type.getDisplayName());
        addOutputIOComponent(new OutputLabel<Double>("Value", 50), "Value", 0);
        String[] mathTypes = new String[MathNode.Type.values().length];
        for (int i = 0; i < mathTypes.length; i++)
            mathTypes[i] = MathNode.Type.values()[i].getDisplayName();
        int ddi = 0;
        for (int i = 0; i < MathNode.Type.values().length; i++)
            if (MathNode.Type.values()[i] == type) {
                ddi = i;
                break;
            }
        DropDown dd = new DropDown(mathTypes).setSelected(ddi);
        addComponent(dd, 15);
        addInputIOComponent(value1 = new ValueSlider(IOComponent.Type.INPUT, "Value"), "value1", 3);
        addInputIOComponent(value2 = new ValueSlider(IOComponent.Type.INPUT, "Value"), "value2", 3);
        addInputIOComponent(base = new ValueSlider(IOComponent.Type.INPUT, "Base"), "base", 3);
        addInputIOComponent(exponent = new ValueSlider(IOComponent.Type.INPUT, "Exponent"), "exponent", 3);
        dd.getEmbedded().valueProperty().addListener((un, oldValue, newValue) -> {
            for (MathNode.Type mt : MathNode.Type.values())
                if (mt.getDisplayName().equals(newValue)) {
                    update(mt);
                    break;
                }
        });
        update(type);
    }

    private void update(MathNode.Type type) {
        switch(type) {
            case ADD:
                value1.setComponentDisabled(false);
                value2.setComponentDisabled(false);
                base.setComponentDisabled(true);
                exponent.setComponentDisabled(true);
                break;
            case SUBTRACT:
                value1.setComponentDisabled(false);
                value2.setComponentDisabled(false);
                base.setComponentDisabled(true);
                exponent.setComponentDisabled(true);
                break;
            case MULTIPLY:
                value1.setComponentDisabled(false);
                value2.setComponentDisabled(false);
                base.setComponentDisabled(true);
                exponent.setComponentDisabled(true);
                break;
            case DIVIDE:
                value1.setComponentDisabled(false);
                value2.setComponentDisabled(false);
                base.setComponentDisabled(true);
                exponent.setComponentDisabled(true);
                break;
            case POWER:
                value1.setComponentDisabled(true);
                value2.setComponentDisabled(true);
                base.setComponentDisabled(false);
                exponent.setComponentDisabled(false);
                break;
            case LOGARITHM:
                value1.setComponentDisabled(false);
                value2.setComponentDisabled(true);
                base.setComponentDisabled(false);
                exponent.setComponentDisabled(true);
                break;
            case SQUARE_ROOT:
                value1.setComponentDisabled(false);
                value2.setComponentDisabled(true);
                base.setComponentDisabled(true);
                exponent.setComponentDisabled(true);
                break;
            case ABSOLUTE:
                value1.setComponentDisabled(false);
                value2.setComponentDisabled(true);
                base.setComponentDisabled(true);
                exponent.setComponentDisabled(true);
                break;
        }
        recalculateSize();
        setLabel(type.getDisplayName());
    }

}
