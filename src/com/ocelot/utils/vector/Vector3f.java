package com.ocelot.utils.vector;

/**
 * <em><b>Copyright (c) 2018 Ocelot5836.</b></em>
 * 
 * <br>
 * </br>
 * 
 * This class is a vector that holds 3 floats.
 * 
 * @author Ocelot5836
 * @since 1.4.6
 */
public class Vector3f extends Vector3<Float, Float, Float> {

	public float x;
	public float y;
	public float z;

	/**
	 * Creates a new blank vector with the positions of 0.0, 0.0, 0.0.
	 */
	public Vector3f() {
		set(0.0f, 0.0f, 0.0f);
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
	public Vector3f(float x, float y, float z) {
		set(x, y, z);
	}

	/**
	 * Creates a new vector with the values of the supplied vector.
	 * 
	 * @param vector
	 *            The vector to copy the values from
	 */
	public Vector3f(Vector3f vector) {
		set(vector.x, vector.y, vector.z);
	}

	/**
	 * Sets the values in the vector to the values of another vector.
	 * 
	 * @param vector
	 *            The vector to copy the values from
	 */
	public Vector3f set(Vector3f vector) {
		return set(vector.x, vector.y, vector.z);
	}

	@Override
	public Vector3f set(Float x, Float y, Float z) {
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
	public Vector3f add(Vector3f vector) {
		return add(vector.x, vector.y, vector.z);
	}

	@Override
	public Vector3f add(Float x, Float y, Float z) {
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
	public Vector3f subtract(Vector3f vector) {
		return subtract(vector.x, vector.y, vector.z);
	}

	@Override
	public Vector3f subtract(Float x, Float y, Float z) {
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
	public double distanceFrom(Vector3f vector) {
		double dx = x - vector.x;
		double dy = y - vector.y;
		double dz = z - vector.z;
		return Math.sqrt(dx * dx + dy * dy + dz * dz);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vector3f) {
			Vector3f vector = (Vector3f) obj;
			return vector.x == this.x && vector.y == this.y && vector.z == this.z;
		}
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "-" + x + ", " + y + "," + z;
	}
}