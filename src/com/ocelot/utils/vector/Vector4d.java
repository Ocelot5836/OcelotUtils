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
public class Vector4d extends Vector4<Double, Double, Double, Double> {

	private double x;
	private double y;
	private double z;
	private double w;

	/**
	 * Creates a new blank vector with the positions of 0.0, 0.0, 0.0, 0.0.
	 */
	public Vector4d() {
		set(0.0d, 0.0d, 0.0d, 0.0d);
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
	public Vector4d(double x, double y, double z, double w) {
		set(x, y, z, w);
	}

	/**
	 * Creates a new vector with the values of the supplied vector.
	 * 
	 * @param vector
	 *            The vector to copy the values from
	 */
	public Vector4d(Vector4d vector) {
		set(vector.x, vector.y, vector.z, vector.w);
	}

	/**
	 * Sets the values in the vector to the values of another vector.
	 * 
	 * @param vector
	 *            The vector to copy the values from
	 */
	public Vector4d set(Vector4d vector) {
		return set(vector.x, vector.y, vector.z, vector.w);
	}

	@Override
	public Vector4d set(Double x, Double y, Double z, Double w) {
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
	public Vector4d add(Vector4d vector) {
		return add(vector.x, vector.y, vector.z, vector.w);
	}

	@Override
	public Vector4d add(Double x, Double y, Double z, Double w) {
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
	public Vector4d subtract(Vector4d vector) {
		return subtract(vector.x, vector.y, vector.z, vector.w);
	}

	@Override
	public Vector4d subtract(Double x, Double y, Double z, Double w) {
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
	public double distanceFrom(Vector4d vector) {
		double dx = x - vector.x;
		double dy = y - vector.y;
		double dz = z - vector.z;
		double dw = w - vector.w;
		return Math.sqrt(dx * dx + dy * dy + dz * dz + dw * dw);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vector4d) {
			Vector4d vector = (Vector4d) obj;
			return vector.x == this.x && vector.y == this.y && vector.z == this.z && vector.w == this.w;
		}
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "-" + x + ", " + y + "," + z + "," + w;
	}
}