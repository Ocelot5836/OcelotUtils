package com.ocelot.utils.vector;

/**
 * This class is a vector that holds 2 floats.
 * 
 * @author Ocelot5836
 * @since 1.4.6
 */
public class Vector2f extends Vector {

	private float x;
	private float y;

	/**
	 * Creates a new blank vector with the positions of 0, 0.
	 */
	public Vector2f() {
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
	public Vector2f(float x, float y) {
		set(x, y);
	}

	public Vector2f(Vector2f vector) {
		set(vector.x, vector.y);
	}

	public Vector2f set(float x, float y) {
		this.x = x;
		this.y = y;
		return this;
	}

	public Vector2f add(Vector2f vector) {
		this.x += vector.x;
		this.y += vector.y;
		return this;
	}

	public Vector2f subtract(Vector2f vector) {
		this.x -= vector.x;
		this.y -= vector.y;
		return this;
	}

	public double distanceFrom(Vector2f vector) {
		double dx = x - vector.x;
		double dy = y - vector.y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public Vector2f setX(float x) {
		this.x = x;
		return this;
	}

	public Vector2f setY(float y) {
		this.y = y;
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vector2f) {
			Vector2f vector = (Vector2f) obj;
			return vector.getX() == this.getX() && vector.getY() == this.getY();
		}
		return false;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ":" + x + "," + y;
	}
}