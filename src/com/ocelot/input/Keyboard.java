package com.ocelot.input;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;

import com.ocelot.OcelotUtils;

/**
 * <em><b>Copyright (c) 2018 Ocelot5836.</b></em>
 * 
 * <br>
 * </br>
 * 
 * This class can be called as a static class for checking all the key events. It has a focus listener so the keys can be disabled when the focus is lost.
 * 
 * @author Ocelot5836
 * @since 1.2
 */
public class Keyboard implements KeyListener, FocusListener {

	/** The instance of this class to register with the {@link JFrame} */
	public static final Keyboard INSTANCE = new Keyboard();

	private static boolean[] keys;
	private static boolean[] keysCheck;
	private static Map<Integer, List<Runnable>> pressedEvents;
	private static Map<Integer, List<Runnable>> releasedEvents;

	/**
	 * Initializes all the keys.
	 */
	public Keyboard() {
		keys = new boolean[KeyEvent.RESERVED_ID_MAX];
		keysCheck = new boolean[keys.length];
		for (int i = 0; i < keys.length; i++) {
			keys[i] = false;
			keysCheck[i] = false;
		}
		pressedEvents = new HashMap<Integer, List<Runnable>>();
		releasedEvents = new HashMap<Integer, List<Runnable>>();
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

	/**
	 * Adds a listener to be called when the specified key is pressed.
	 * 
	 * @param listener
	 *            The code to be called
	 * @param key
	 *            The key that has to be pressed to activate the listener
	 */
	public static void addKeyPressedListener(Runnable listener, int key) {
		pressedEvents.put(key, Arrays.asList(new Runnable[] { listener }));
	}

	/**
	 * Adds a listener to be called when the specified key is released.
	 * 
	 * @param listener
	 *            The code to be called
	 * @param key
	 *            The key that has to be released to activate the listener
	 */
	public static void addKeyReleasedListener(Runnable listener, int key) {
		releasedEvents.put(key, Arrays.asList(new Runnable[] { listener }));
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		keys[keyCode] = true;
		if (!keysCheck[keyCode]) {
			if (pressedEvents.containsKey(keyCode)) {
				List<Runnable> events = pressedEvents.get(keyCode);
				for (Runnable event : events) {
					OcelotUtils.getUtils().addScheduledTask(event);
				}
			}
			keysCheck[keyCode] = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
		keys[keyCode] = false;
		if (releasedEvents.containsKey(keyCode)) {
			List<Runnable> events = releasedEvents.get(keyCode);
			for (Runnable event : events) {
				OcelotUtils.getUtils().addScheduledTask(event);
			}
			keysCheck[keyCode] = false;
		}
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