package com.ocelot.utils.vector;

/**
 * This class is a vector that holds 3 floats.
 * 
 * @author Ocelot5836
 * @since 1.4.6
 */
public class Vector3f extends Vector  {

	private float x;
	private float y;
	private float z;

	/**
	 * Creates a new blank vector with the positions of 0, 0.
	 */
	public Vector3f() {
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
	public Vector3f(float x, float y, float z) {
		set(x, y, z);
	}

	public Vector3f(Vector3f vector) {
		set(vector.x, vector.y, vector.z);
	}

	public Vector3f set(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
		return this;
	}

	public Vector3f add(Vector3f vector) {
		this.x += vector.x;
		this.y += vector.y;
		this.z += vector.z;
		return this;
	}

	public Vector3f subtract(Vector3f vector) {
		this.x -= vector.x;
		this.y -= vector.y;
		this.z -= vector.z;
		return this;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public float getZ() {
		return z;
	}

	public Vector3f setX(float x) {
		this.x = x;
		return this;
	}

	public Vector3f setY(float y) {
		this.y = y;
		return this;
	}

	public void setZ(float z) {
		this.z = z;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Vector3f) {
			Vector3f vector = (Vector3f) obj;
			return vector.getX() == this.getX() && vector.getY() == this.getY();
		}
		return false;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + ":" + x + "," + y + "," + z;
	}
}