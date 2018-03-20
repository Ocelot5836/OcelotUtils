package com.ocelot.utils.vector;

/**
 * <em><b>Copyright (c) 2018 Ocelot5836.</b></em>
 * 
 * <br>
 * </br>
 * 
 * The basic root for a vector with 2 values.
 * 
 * @author Ocelot5836
 * @since 1.4.6
 */
public abstract class Vector2<A, B> {

	/**
	 * Sets the values in the vector to the specified.
	 * 
	 * @param a
	 *            The first value
	 * @param b
	 *            The second value
	 * @return The vector
	 */
	public abstract Vector2<A, B> set(A a, B b);
	
	/**
	 * Adds the values in the vector from the specified.
	 * 
	 * @param a
	 *            The first value
	 * @param b
	 *            The second value
	 * @return The vector
	 */
	public abstract Vector2<A, B> add(A a, B b);

	/**
	 * Subtracts the values in the vector from the specified.
	 * 
	 * @param a
	 *            The first value
	 * @param b
	 *            The second value
	 * @return The vector
	 */
	public abstract Vector2<A, B> subtract(A a, B b);

	@Override
	public abstract String toString();

}