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

	private int x;
	private int y;

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

	public Vector2i(Vector2i vector) {
		set(vector.x, vector.y);
	}

	@Override
	public Vector2i set(Integer x, Integer y) {
		this.x = x;
		this.y = y;
		return this;
	}
	
	public Vector2i set(Vector2i vector) {
		this.x = vector.x;
		this.y = vector.y;
		return this;
	}

	public Vector2i add(Vector2i vector) {
		this.x += vector.x;
		this.y += vector.y;
		return this;
	}

	@Override
	public Vector2i add(Integer x, Integer y) {
		this.x += x;
		this.y += y;
		return this;
	}

	public Vector2i subtract(Vector2i vector) {
		this.x -= vector.x;
		this.y -= vector.y;
		return this;
	}

	@Override
	public Vector2i subtract(Integer x, Integer y) {
		this.x -= x;
		this.y -= y;
		return this;
	}

	public double distanceFrom(Vector2i vector) {
		double dx = x - vector.x;
		double dy = y - vector.y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Vector2i setX(int x) {
		this.x = x;
		return this;
	}

	public Vector2i setY(int y) {
		this.y = y;
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vector2i) {
			Vector2i vector = (Vector2i) obj;
			return vector.getX() == this.getX() && vector.getY() == this.getY();
		}
		return false;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ":" + x + "," + y;
	}
}