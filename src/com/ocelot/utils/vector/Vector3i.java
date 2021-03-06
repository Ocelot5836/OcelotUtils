package com.ocelot.utils.vector;

/**
 * <em><b>Copyright (c) 2018 Ocelot5836.</b></em>
 * 
 * <br>
 * </br>
 * 
 * This class is a vector that holds 3 integers.
 * 
 * @author Ocelot5836
 * @since 1.4.6
 */
public class Vector3i extends Vector3<Integer, Integer, Integer> {

	private int x;
	private int y;
	private int z;

	/**
	 * Creates a new blank vector with the positions of 0, 0.
	 */
	public Vector3i() {
		set(0, 0, 0);
	}

	/**
	 * Creates a new vector with the specified positions.
	 * 
	 * @param x
	 *            The x position
	 * @param y
	 *            The y position
	 * @param z
	 *            The z position
	 */
	public Vector3i(int x, int y, int z) {
		set(x, y, z);
	}

	/**
	 * Creates a new vector with the values of the supplied vector.
	 * 
	 * @param vector
	 *            The vector to copy the values from
	 */
	public Vector3i(Vector3i vector) {
		set(vector.x, vector.y, vector.z);
	}

	/**
	 * Sets the values in the vector to the values of another vector.
	 * 
	 * @param vector
	 *            The vector to copy the values from
	 */
	public Vector3i set(Vector3i vector) {
		return set(vector.x, vector.y, vector.z);
	}

	@Override
	public Vector3i set(Integer x, Integer y, Integer z) {
		this.x = x;
		this.y = y;
		this.z = z;
		return this;
	}

	/**
	 * Adds the supplied vector's positions to this vector's positions.
	 * 
	 * @param vector
	 *            The vector to copy the values from
	 */
	public Vector3i add(Vector3i vector) {
		return add(vector.x, vector.y, vector.z);
	}

	@Override
	public Vector3i add(Integer x, Integer y, Integer z) {
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}

	/**
	 * Adds the supplied vector's positions to this vector's positions.
	 * 
	 * @param vector
	 *            The vector to copy the values from
	 */
	public Vector3i subtract(Vector3i vector) {
		return subtract(vector.x, vector.y, vector.z);
	}

	@Override
	public Vector3i subtract(Integer x, Integer y, Integer z) {
		this.x -= x;
		this.y -= y;
		this.z -= z;
		return this;
	}

	/**
	 * Gets the distance from two vectors.
	 * 
	 * @param vector
	 *            The vector to get the distance from
	 * @return The distance from this vector and the supplied vector
	 */
	public double distanceFrom(Vector3i vector) {
		double dx = x - vector.x;
		double dy = y - vector.y;
		double dz = z - vector.z;
		return Math.sqrt(dx * dx + dy * dy + dz * dz);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vector3i) {
			Vector3i vector = (Vector3i) obj;
			return vector.x == this.x && vector.y == this.y && vector.z == this.z;
		}
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "-" + x + ", " + y + "," + z;
	}
}