package com.ocelot.thread;

/**
 * <em><b>Copyright (c) 2018 Ocelot5836.</b></em>
 * 
 * <br>
 * </br>
 * 
 * Simply holds an id.
 * 
 * @author Ocelot5836
 * @since 1.5.4
 */
public class IdAssigner {

	private int baseId;

	/**
	 * Creates a new id assigner.
	 * 
	 * @param baseId
	 *            The base id that will be incremented each time {@link #next()} is called.
	 */
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