package com.ocelot.utils.vector;

/**
 * <em><b>Copyright (c) 2018 Ocelot5836.</b></em>
 * 
 * <br>
 * </br>
 * 
 * This class is a vector that holds 3 doubles.
 * 
 * @author Ocelot5836
 * @since 1.4.6
 */
public class Vector3d extends Vector3<Double, Double, Double> {

	public double x;
	public double y;
	public double z;

	/**
	 * Creates a new blank vector with the positions of 0.0, 0.0, 0.0.
	 */
	public Vector3d() {
		set(0.0d, 0.0d, 0.0d);
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
	public Vector3d(double x, double y, double z) {
		set(x, y, z);
	}

	/**
	 * Creates a new vector with the values of the supplied vector.
	 * 
	 * @param vector
	 *            The vector to copy the values from
	 */
	public Vector3d(Vector3d vector) {
		set(vector.x, vector.y, vector.z);
	}

	/**
	 * Sets the values in the vector to the values of another vector.
	 * 
	 * @param vector
	 *            The vector to copy the values from
	 */
	public Vector3d set(Vector3d vector) {
		return set(vector.x, vector.y, vector.z);
	}

	@Override
	public Vector3d set(Double x, Double y, Double z) {
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
	public Vector3d add(Vector3d vector) {
		return add(vector.x, vector.y, vector.z);
	}

	@Override
	public Vector3d add(Double x, Double y, Double z) {
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
	public Vector3d subtract(Vector3d vector) {
		return subtract(vector.x, vector.y, vector.z);
	}

	@Override
	public Vector3d subtract(Double x, Double y, Double z) {
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
	public double distanceFrom(Vector3d vector) {
		double dx = x - vector.x;
		double dy = y - vector.y;
		double dz = z - vector.z;
		return Math.sqrt(dx * dx + dy * dy + dz * dz);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vector3d) {
			Vector3d vector = (Vector3d) obj;
			return vector.x == this.x && vector.y == this.y && vector.z == this.z;
		}
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "-" + x + ", " + y + "," + z;
	}
}