package com.ocelot.utils.vector;

/**
 * <em><b>Copyright (c) 2018 Ocelot5836.</b></em>
 * 
 * <br>
 * </br>
 * 
 * This class is a vector that holds 2 doubles.
 * 
 * @author Ocelot5836
 * @since 1.4.6
 */
public class Vector2d extends Vector2<Double, Double> {

	public double x;
	public double y;

	/**
	 * Creates a new blank vector with the positions of 0.0, 0.0.
	 */
	public Vector2d() {
		set(0.0, 0.0);
	}

	/**
	 * Creates a new vector with the specified positions.
	 * 
	 * @param x
	 *            The x position
	 * @param y
	 *            The y position
	 */
	public Vector2d(Double x, Double y) {
		set(x, y);
	}

	/**
	 * Creates a new vector with the values of the supplied vector.
	 * 
	 * @param vector
	 *            The vector to copy the values from
	 */
	public Vector2d(Vector2d vector) {
		set(vector.x, vector.y);
	}

	/**
	 * Sets the values in the vector to the values of another vector.
	 * 
	 * @param vector
	 *            The vector to copy the values from
	 */
	public Vector2d set(Vector2d vector) {
		return set(vector.x, vector.y);
	}

	@Override
	public Vector2d set(Double x, Double y) {
		this.x = x;
		this.y = y;
		return this;
	}

	/**
	 * Adds the supplied vector's positions to this vector's positions.
	 * 
	 * @param vector
	 *            The vector to copy the values from
	 */
	public Vector2d add(Vector2d vector) {
		return add(vector.x, vector.y);
	}

	@Override
	public Vector2d add(Double x, Double y) {
		this.x += x;
		this.y += y;
		return this;
	}

	/**
	 * Adds the supplied vector's positions to this vector's positions.
	 * 
	 * @param vector
	 *            The vector to copy the values from
	 */
	public Vector2d subtract(Vector2d vector) {
		return subtract(vector.x, vector.y);
	}

	@Override
	public Vector2d subtract(Double x, Double y) {
		this.x -= x;
		this.y -= y;
		return this;
	}

	/**
	 * Gets the distance from two vectors.
	 * 
	 * @param vector
	 *            The vector to get the distance from
	 * @return The distance from this vector and the supplied vector
	 */
	public double distanceFrom(Vector2d vector) {
		double dx = x - vector.x;
		double dy = y - vector.y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vector2d) {
			Vector2d vector = (Vector2d) obj;
			return vector.x == this.x && vector.y == this.y;
		}
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "-" + x + ", " + y;
	}
}