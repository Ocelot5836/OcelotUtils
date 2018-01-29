package com.ocelot.utils.vector;

/**
 * This class is a vector that holds 3 integers.
 * 
 * @author Ocelot5836
 * @since 1.4.6
 */
public class Vector3i extends Vector  {

	private int x;
	private int y;
	private int z;

	/**
	 * Creates a new blank vector with the positions of 0, 0.
	 */
	public Vector3i() {
		set(0, 0, 0);
	}

	/**
	 * Creates a new vector with the specified positions.
	 * 
	 * @param x
	 *            The x position
	 * @param y
	 *            The y position
	 */
	public Vector3i(int x, int y, int z) {
		set(x, y, z);
	}

	public Vector3i(Vector3i vector) {
		set(vector.x, vector.y, vector.z);
	}

	public Vector3i set(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
		return this;
	}

	public Vector3i add(Vector3i vector) {
		this.x += vector.x;
		this.y += vector.y;
		this.z += vector.z;
		return this;
	}

	public Vector3i subtract(Vector3i vector) {
		this.x -= vector.x;
		this.y -= vector.y;
		this.z -= vector.z;
		return this;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	public Vector3i setX(int x) {
		this.x = x;
		return this;
	}

	public Vector3i setY(int y) {
		this.y = y;
		return this;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vector3i) {
			Vector3i vector = (Vector3i) obj;
			return vector.getX() == this.getX() && vector.getY() == this.getY();
		}
		return false;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ":" + x + "," + y + "," + z;
	}
}