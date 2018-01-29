package com.ocelot.input;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/**
 * This class can be called as a static class for checking all the key events. It has a focus listener so the keys can be disabled when the focus is lost.
 * 
 * @author Ocelot5836
 * @since 1.2
 */
public class Keyboard implements KeyListener, FocusListener {

	/** The instance of this class to register with the {@link JFrame} */
	public static final Keyboard INSTANCE = new Keyboard();

	private static boolean[] keys;

	/**
	 * Initializes all the keys.
	 */
	public Keyboard() {
		keys = new boolean[KeyEvent.RESERVED_ID_MAX];
		for (int i = 0; i < keys.length; i++) {
			keys[i] = false;
		}
	}

	/**
	 * Checks whether or not a key is pressed.
	 * 
	 * @param key
	 *            The key that is being checked using {@link KeyEvent}
	 * @return If the specified key is pressed
	 */
	public static boolean isKeyPressed(int key) {
		return keys[key];
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void focusGained(FocusEvent e) {

	}

	@Override
	public void focusLost(FocusEvent e) {
		for (int i = 0; i < keys.length; i++) {
			keys[i] = false;
		}
	}
}