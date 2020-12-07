package org.volt4.parsey.node.implementation;

import java.util.ArrayList;
import java.util.List;

import org.volt4.parsey.node.logic.Node;
import org.volt4.parsey.node.logic.NodeException;
import org.volt4.parsey.node.logic.NodeInput;
import org.volt4.parsey.node.logic.NodeOutput;

/**
 * A simple math node. Performs most normal operations between two inputs.
 *
 * @version 1.0
 *
 */
public class MathNode extends Node {
	
	/**
	 * Type of this MathNode.
	 */
	private Type type;
	
	/*
	 * Inputs.
	 */
	public NodeInput<Float> value1;
	public NodeInput<Float> value2;
	public NodeInput<Float> base;
	public NodeInput<Float> exponent;
	
	/*
	 * Ouputs.
	 */
	public NodeOutput<Float> outputValue;
	
	/**
	 * Constructs a MathNode with the given type.
	 * @param type Type of this operation.
	 */
	public MathNode(Type type) {
		// Add all inputs.
		value1 = new NodeInput<Float>("Value");
		value2 = new NodeInput<Float>("Value");
		base = new NodeInput<Float>("Base");
		exponent = new NodeInput<Float>("Exponent");
		// Add all outputs.
		outputValue = new NodeOutput<Float>("Value");
		// Set the type.
		setType(type);
	}
	
	/**
	 * Sets the type (operation) of this math node.
	 * @param type Type to be set.
	 */
	public void setType(Type type) {
		this.type = type;
		for (NodeInput<?> input : inputs())
			input.setDisabled(true);
		switch(type) {
		case ABSOLUTE:
			value1.setDisabled(false);
			break;
		case ADD:
			value1.setDisabled(false);
			value2.setDisabled(false);
			break;
		case DIVIDE:
			value1.setDisabled(false);
			value2.setDisabled(false);
			break;
		case LOGARITHM:
			value1.setDisabled(false);
			base.setDisabled(false);
			break;
		case MULTIPLY:
			value1.setDisabled(false);
			value2.setDisabled(false);
			break;
		case POWER:
			base.setDisabled(false);
			exponent.setDisabled(false);
			break;
		case SQUARE_ROOT:
			value1.setDisabled(false);
			break;
		case SUBTRACT:
			value1.setDisabled(false);
			value2.setDisabled(false);
			break;
		}
	}

	@Override
	protected Object[] calculate(Object[] inputs) throws NodeException {
		Object output = null;
		if (type == null)
			throw new NodeException("Operation is invalid");
		switch(type) {
		case ABSOLUTE:
			float value = (Float) inputs[0];
			output = Math.abs(value);
			break;
		case ADD:
			float value1 = (Float) inputs[0];
			float value2 = (Float) inputs[1];
			output = value1 + value2;
			break;
		case DIVIDE:
			float value3 = (Float) inputs[0];
			float value4 = (Float) inputs[1];
			output = value3 / value4;
			break;
		case LOGARITHM:
			float value12 = (Float) inputs[0];
			float value13 = (Float) inputs[2];
			output = Math.log(value12) / Math.log(value13);
			break;
		case MULTIPLY:
			float value5 = (Float) inputs[0];
			float value6 = (Float) inputs[1];
			output = value5 * value6;
			break;
		case POWER:
			float value7 = (Float) inputs[2];
			float value8 = (Float) inputs[3];
			output = Math.pow(value7, value8);
			break;
		case SQUARE_ROOT:
			float value9 = (Float) inputs[0];
			output = Math.sqrt(value9);
			break;
		case SUBTRACT:
			float value10 = (Float) inputs[0];
			float value11 = (Float) inputs[1];
			output = value10 - value11;
			break;
		}
		return new Object[] {output};
	}
	
	/**
	 * Type of MathNode. Lists the different operations.
	 */
	public enum Type {
		
		ADD("Add", "The sum of the two values."), 
		SUBTRACT("Subtract", "The difference between the two values."), 
		MULTIPLY("Multiply", "The product of the two values."), 
		DIVIDE("Divide", "The division of the first value by the second value."), 
		POWER("Power", "The Base raised to the power of Exponent."), 
		LOGARITHM("Logarithm", "The log of the value with a Base as its base."), 
		SQUARE_ROOT("Square Root", "The square root of the value."), 
		ABSOLUTE("Absolute", "The input value is read with without regard to its sign. This turns negative values into positive values.");
		
		/**
		 * Display name of the operation.
		 */
		private String displayName;
		
		/**
		 * Description of the operation.
		 */
		private String description;
		
		/**
		 * Constructs a Type.
		 * @param displayName Display name of the operation.
		 * @param description Description of the operation.
		 */
		private Type(String displayName, String description) {
			this.displayName = displayName;
			this.description = description;
		}

		/**
		 * @return the displayName
		 */
		public String getDisplayName() {
			return displayName;
		}

		/**
		 * @return the description
		 */
		public String getDescription() {
			return description;
		}
		
	}

	@Override
	public List<NodeInput<?>> inputs() {
		List<NodeInput<?>> list = new ArrayList<NodeInput<?>>();
		list.add(value1);
		list.add(value2);
		list.add(base);
		list.add(exponent);
		return list;
	}

	@Override
	public List<NodeOutput<?>> outputs() {
		List<NodeOutput<?>> list = new ArrayList<NodeOutput<?>>();
		list.add(outputValue);
		return list;
	}
	
}
