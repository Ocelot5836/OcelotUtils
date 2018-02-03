package com.ocelot.thread;

/**
 * Simply holds an id.
 * 
 * @author Ocelot5836
 */
public class IdAssigner {

	private int baseId;

	public IdAssigner(int baseId) {
		this.baseId = baseId;
	}

	/**
	 * @return The next id
	 */
	public int next() {
		return baseId++;
	}

	/**
	 * @return The current id
	 */
	public int getCurrentId() {
		return baseId;
	}
}