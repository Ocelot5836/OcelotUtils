package com.ocelot.utils.vector;

/**
 * <em><b>Copyright (c) 2018 Ocelot5836.</b></em>
 * 
 * <br>
 * </br>
 * 
 * This class is a vector that holds 2 integers.
 * 
 * @author Ocelot5836
 * @since 1.4.6
 */
public class Vector2i extends Vector2<Integer, Integer> {

	public int x;
	public int y;

	/**
	 * Creates a new blank vector with the positions of 0, 0.
	 */
	public Vector2i() {
		set(0, 0);
	}

	/**
	 * Creates a new vector with the specified positions.
	 * 
	 * @param x
	 *            The x position
	 * @param y
	 *            The y position
	 */
	public Vector2i(int x, int y) {
		set(x, y);
	}

	/**
	 * Sets the values in the vector to the values of another vector.
	 * 
	 * @param vector
	 *            The vector to copy the values from
	 */
	public Vector2i set(Vector2i vector) {
		return set(vector.x, vector.y);
	}

	@Override
	public Vector2i set(Integer x, Integer y) {
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
	public Vector2i add(Vector2i vector) {
		return add(vector.x, vector.y);
	}

	@Override
	public Vector2i add(Integer x, Integer y) {
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
	public Vector2i subtract(Vector2i vector) {
		return subtract(vector.x, vector.y);
	}

	@Override
	public Vector2i subtract(Integer x, Integer y) {
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