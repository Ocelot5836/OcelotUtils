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
public class Vector4i extends Vector4<Integer, Integer, Integer, Integer> {

	private int x;
	private int y;
	private int z;
	private int w;

	/**
	 * Creates a new blank vector with the positions of 0, 0, 0, 0.
	 */
	public Vector4i() {
		set(0, 0, 0, 0);
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
	 * @param w
	 *            The fourth value
	 */
	public Vector4i(int x, int y, int z, int w) {
		set(x, y, z, w);
	}

	/**
	 * Creates a new vector with the values of the supplied vector.
	 * 
	 * @param vector
	 *            The vector to copy the values from
	 */
	public Vector4i(Vector4i vector) {
		set(vector.x, vector.y, vector.z, vector.w);
	}

	/**
	 * Sets the values in the vector to the values of another vector.
	 * 
	 * @param vector
	 *            The vector to copy the values from
	 */
	public Vector4i set(Vector4i vector) {
		return set(vector.x, vector.y, vector.z, vector.w);
	}

	@Override
	public Vector4i set(Integer x, Integer y, Integer z, Integer w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
		return this;
	}

	/**
	 * Adds the supplied vector's positions to this vector's positions.
	 * 
	 * @param vector
	 *            The vector to copy the values from
	 */
	public Vector4i add(Vector4i vector) {
		return add(vector.x, vector.y, vector.z, vector.w);
	}

	@Override
	public Vector4i add(Integer x, Integer y, Integer z, Integer w) {
		this.x += x;
		this.y += y;
		this.z += z;
		this.w += w;
		return this;
	}

	/**
	 * Adds the supplied vector's positions to this vector's positions.
	 * 
	 * @param vector
	 *            The vector to copy the values from
	 */
	public Vector4i subtract(Vector4i vector) {
		return subtract(vector.x, vector.y, vector.z, vector.w);
	}

	@Override
	public Vector4i subtract(Integer x, Integer y, Integer z, Integer w) {
		this.x -= x;
		this.y -= y;
		this.z -= z;
		this.w -= w;
		return this;
	}

	/**
	 * Gets the distance from two vectors.
	 * 
	 * @param vector
	 *            The vector to get the distance from
	 * @return The distance from this vector and the supplied vector
	 */
	public double distanceFrom(Vector4i vector) {
		double dx = x - vector.x;
		double dy = y - vector.y;
		double dz = z - vector.z;
		double dw = w - vector.w;
		return Math.sqrt(dx * dx + dy * dy + dz * dz + dw * dw);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vector4i) {
			Vector4i vector = (Vector4i) obj;
			return vector.x == this.x && vector.y == this.y && vector.z == this.z && vector.w == this.w;
		}
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "-" + x + ", " + y + "," + z + "," + w;
	}
}