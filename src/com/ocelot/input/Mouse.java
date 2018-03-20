package com.ocelot.input;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JFrame;

/**
 * <em><b>Copyright (c) 2018 Ocelot5836.</b></em>
 * 
 * <br>
 * </br>
 * 
 * This class can be used to handle any type of mouse event.
 * 
 * @author Ocelot5836
 * @since 1.2
 */
public class Mouse implements MouseListener, MouseMotionListener, MouseWheelListener, FocusListener {

	/** The instance of this class to register with the {@link JFrame} */
	public static final Mouse INSTANCE = new Mouse();

	private static int mouseX;
	private static int mouseY;
	private static int mouseDX;
	private static int mouseDY;
	private static int mouseButton = -1;
	private static int mouseWheelRotation;

	@Override
	public void focusGained(FocusEvent e) {

	}

	@Override
	public void focusLost(FocusEvent e) {
		mouseButton = -1;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		mouseWheelRotation = e.getWheelRotation();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		mouseButton = e.getButton();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseButton = -1;
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {
		mouseX = -1;
		mouseY = -1;
	}

	/**
	 * @return The mouse x position
	 */
	public static int getX() {
		return mouseX;
	}

	/**
	 * @return The mouse y position
	 */
	public static int getY() {
		return mouseY;
	}

	/**
	 * @return The mouse x position while being dragged across the screen
	 */
	public static int getDraggedX() {
		return mouseDX;
	}

	/**
	 * @return The mouse y position while being dragged across the screen
	 */
	public static int getDraggedY() {
		return mouseDY;
	}

	/**
	 * @return The mouse button that was pressed.
	 */
	public static int getButton() {
		return mouseButton;
	}

	/**
	 * Checks whether or not the mouse button is pressed and if it is equal to the specified button.
	 * 
	 * @param id
	 *            The button id
	 * @return if the currently pressed button is the same as the one specified by the id
	 */
	public static boolean isPressed(int id) {
		return mouseButton == id;
	}

	/**
	 * @return The direction of the mouse wheel movement.
	 */
	public static int getMouseWheelRotation() {
		return mouseWheelRotation;
	}
}