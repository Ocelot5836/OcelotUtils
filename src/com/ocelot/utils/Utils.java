package com.ocelot.utils;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;

/**
 * <em><b>Copyright (c) 2018 Ocelot5836.</b></em>
 * 
 * <br>
 * </br>
 * 
 * This class holds some random useful methods.
 * 
 * @author Ocelot5836
 * @since 1.3.3
 */
public class Utils {

	/**
	 * Sets the mouse position to the specified point.
	 * 
	 * @param p
	 *            The point to move the mouse to
	 */
	public static void setMousePosition(Point p) {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gs = ge.getScreenDevices();

		for (GraphicsDevice device : gs) {
			GraphicsConfiguration[] configurations = device.getConfigurations();
			for (GraphicsConfiguration config : configurations) {
				Rectangle bounds = config.getBounds();
				if (bounds.contains(p)) {
					Point b = bounds.getLocation();
					Point s = new Point(p.x - b.x, p.y - b.y);

					try {
						Robot r = new Robot(device);
						r.mouseMove(s.x, s.y);
					} catch (AWTException e) {
						e.printStackTrace();
					}

					return;
				}
			}
		}
		return;
	}

	/**
	 * Sets the mouse position to the specified x and y.
	 * 
	 * @param x
	 *            The x to move the mouse to
	 * @param y
	 *            The y to move the mouse to
	 */
	public static void setMousePosition(int x, int y) {
		setMousePosition(new Point(x, y));
	}

	/**
	 * @param index
	 *            The index of the line number search
	 * @return The line number found at the index
	 */
	public static int getLineNumber(int index) {
		if (index >= Thread.currentThread().getStackTrace().length)
			index = 0;
		return Thread.currentThread().getStackTrace()[index].getLineNumber();
	}

	/**
	 * @param index
	 *            The index of the line number search
	 * @return The class name found at the index
	 */
	public static String getClass(int index) {
		if (index >= Thread.currentThread().getStackTrace().length)
			index = 0;
		String name = Thread.currentThread().getStackTrace()[index].getClassName();
		return name.substring(name.lastIndexOf(".") + 1);
	}

	/**
	 * @return The full java version
	 */
	public static String getJavaVersion() {
		return System.getProperty("java.version");
	}

	/**
	 * @return The java version converted to an integer
	 */
	public static double getJavaVersioni() {
		char[] chars = new char[5];
		getJavaVersion().getChars(0, 4, chars, 0);
		return Double.parseDouble((chars[0] + "") + (chars[1] + "") + (chars[2] + "") + (chars[4] + ""));
	}
}