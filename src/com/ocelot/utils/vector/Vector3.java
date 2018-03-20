package com.ocelot.utils.vector;

/**
 * <em><b>Copyright (c) 2018 Ocelot5836.</b></em>
 * 
 * <br>
 * </br>
 * 
 * The basic root for a vector with 3 values.
 * 
 * @author Ocelot5836
 * @since 1.4.6
 */
public abstract class Vector3<A, B, C> {

	/**
	 * Sets the values in the vector to the specified.
	 * 
	 * @param a
	 *            The first value
	 * @param b
	 *            The second value
	 * @param c
	 *            The third value
	 * @return The vector
	 */
	public abstract Vector3<A, B, C> set(A a, B b, C c);

	/**
	 * Adds the values in the vector from the specified.
	 * 
	 * @param a
	 *            The first value
	 * @param b
	 *            The second value
	 * @param c
	 *            The third value
	 * @return The vector
	 */
	public abstract Vector3<A, B, C> add(A a, B b, C c);

	/**
	 * Subtracts the values in the vector from the specified.
	 * 
	 * @param a
	 *            The first value
	 * @param b
	 *            The second value
	 * @param c
	 *            The third value
	 * @return The vector
	 */
	public abstract Vector3<A, B, C> subtract(A a, B b, C c);

	@Override
	public abstract String toString();

}