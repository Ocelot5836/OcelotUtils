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
public class Vector4f extends Vector4<Float, Float, Float, Float> {

	private float x;
	private float y;
	private float z;
	private float w;

	/**
	 * Creates a new blank vector with the positions of 0.0, 0.0, 0.0, 0.0.
	 */
	public Vector4f() {
		set(0.0f, 0.0f, 0.0f, 0.0f);
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
	public Vector4f(float x, float y, float z, float w) {
		set(x, y, z, w);
	}

	/**
	 * Creates a new vector with the values of the supplied vector.
	 * 
	 * @param vector
	 *            The vector to copy the values from
	 */
	public Vector4f(Vector4f vector) {
		set(vector.x, vector.y, vector.z, vector.w);
	}

	/**
	 * Sets the values in the vector to the values of another vector.
	 * 
	 * @param vector
	 *            The vector to copy the values from
	 */
	public Vector4f set(Vector4f vector) {
		return set(vector.x, vector.y, vector.z, vector.w);
	}

	@Override
	public Vector4f set(Float x, Float y, Float z, Float w) {
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
	public Vector4f add(Vector4f vector) {
		return add(vector.x, vector.y, vector.z, vector.w);
	}

	@Override
	public Vector4f add(Float x, Float y, Float z, Float w) {
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
	public Vector4f subtract(Vector4f vector) {
		return subtract(vector.x, vector.y, vector.z, vector.w);
	}

	@Override
	public Vector4f subtract(Float x, Float y, Float z, Float w) {
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
	public double distanceFrom(Vector4f vector) {
		double dx = x - vector.x;
		double dy = y - vector.y;
		double dz = z - vector.z;
		double dw = w - vector.w;
		return Math.sqrt(dx * dx + dy * dy + dz * dz + dw * dw);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vector4f) {
			Vector4f vector = (Vector4f) obj;
			return vector.x == this.x && vector.y == this.y && vector.z == this.z && vector.w == this.w;
		}
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "-" + x + ", " + y + "," + z + "," + w;
	}
}