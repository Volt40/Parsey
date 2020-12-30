package org.volt4.parsey.node;

/**
 * Thrown if something goes wrong when calculating the node network.
 *
 * @version 1.0
 *
 */
public class NodeException extends Exception {

	/**
	 * Serial version UID.
	 */
	private static final long serialVersionUID = 5348179140485417590L;

	/**
	 * Creates the Exception and throws it.
	 * @param errorMessage Message thrown.
	 */
	public NodeException(String errorMessage) {
		super(errorMessage);
	}

}
