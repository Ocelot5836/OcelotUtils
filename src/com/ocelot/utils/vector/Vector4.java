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
 * @since 1.5.7
 */
public abstract class Vector4<A, B, C, D> {

	/**
	 * Sets the values in the vector to the specified.
	 * 
	 * @param a
	 *            The first value
	 * @param b
	 *            The second value
	 * @param c
	 *            The third value
	 * @param d
	 *            The fourth value
	 * @return The vector
	 */
	public abstract Vector4<A, B, C, D> set(A a, B b, C c, D d);

	/**
	 * Adds the values in the vector from the specified.
	 * 
	 * @param a
	 *            The first value
	 * @param b
	 *            The second value
	 * @param c
	 *            The third value
	 * @param d
	 *            The fourth value
	 * @return The vector
	 */
	public abstract Vector4<A, B, C, D> add(A a, B b, C c, D d);

	/**
	 * Subtracts the values in the vector from the specified.
	 * 
	 * @param a
	 *            The first value
	 * @param b
	 *            The second value
	 * @param c
	 *            The third value
	 * @param d
	 *            The fourth value
	 * @return The vector
	 */
	public abstract Vector4<A, B, C, D> subtract(A a, B b, C c, D d);

	@Override
	public abstract String toString();

}