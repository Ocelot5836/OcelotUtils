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

	private double x;
	private double y;
	private double z;

	/**
	 * Creates a new blank vector with the positions of 0, 0.
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
	 */
	public Vector3d(double x, double y, double z) {
		set(x, y, z);
	}

	public Vector3d(Vector3d vector) {
		set(vector.x, vector.y, vector.z);
	}

	@Override
	public Vector3d set(Double x, Double y, Double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		return this;
	}

	public Vector3d set(Vector3d vector) {
		this.x = vector.x;
		this.y = vector.y;
		return this;
	}

	public Vector3d add(Vector3d vector) {
		this.x += vector.x;
		this.y += vector.y;
		this.z += vector.z;
		return this;
	}

	@Override
	public Vector3d add(Double x, Double y, Double z) {
		this.x += x;
		this.y += y;
		this.z += z;
		return this;
	}

	public Vector3d subtract(Vector3d vector) {
		this.x -= vector.x;
		this.y -= vector.y;
		this.z -= vector.z;
		return this;
	}

	@Override
	public Vector3d subtract(Double x, Double y, Double z) {
		this.x -= x;
		this.y -= y;
		this.z -= z;
		return this;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	public Vector3d setX(double x) {
		this.x = x;
		return this;
	}

	public Vector3d setY(double y) {
		this.y = y;
		return this;
	}

	public void setZ(double z) {
		this.z = z;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vector3d) {
			Vector3d vector = (Vector3d) obj;
			return vector.getX() == this.getX() && vector.getY() == this.getY();
		}
		return false;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ":" + x + "," + y + "," + z;
	}
}