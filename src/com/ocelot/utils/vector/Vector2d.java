package com.ocelot.utils.vector;

/**
 * This class is a vector that holds 2 doubles.
 * 
 * @author Ocelot5836
 * @since 1.4.6
 */
public class Vector2d extends Vector {

	private double x;
	private double y;

	/**
	 * Creates a new blank vector with the positions of 0, 0.
	 */
	public Vector2d() {
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
	public Vector2d(double x, double y) {
		set(x, y);
	}

	public Vector2d(Vector2d vector) {
		set(vector.x, vector.y);
	}

	public Vector2d set(double x, double y) {
		this.x = x;
		this.y = y;
		return this;
	}

	public Vector2d add(Vector2d vector) {
		this.x += vector.x;
		this.y += vector.y;
		return this;
	}

	public Vector2d subtract(Vector2d vector) {
		this.x -= vector.x;
		this.y -= vector.y;
		return this;
	}

	public double distanceFrom(Vector2d vector) {
		double dx = x - vector.x;
		double dy = y - vector.y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public Vector2d setX(double x) {
		this.x = x;
		return this;
	}

	public Vector2d setY(double y) {
		this.y = y;
		return this;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vector2d) {
			Vector2d vector = (Vector2d) obj;
			return vector.getX() == this.getX() && vector.getY() == this.getY();
		}
		return false;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + ":" + x + "," + y;
	}
}