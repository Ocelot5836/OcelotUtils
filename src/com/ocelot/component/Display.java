package com.ocelot.component;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

import com.ocelot.input.Keyboard;
import com.ocelot.input.Mouse;

/**
 * <em><b>Copyright (c) 2018 Ocelot5836.</b></em>
 * 
 * <br>
 * </br>
 * 
 * Creates a new JFrame with the basic components. The frame can be easily accessed and modified.
 * 
 * @author Ocelot5836
 * @since 1.4.3
 */
@SuppressWarnings("serial")
public class Display extends Canvas {

	private String title;
	private Dimension dimensions;
	private JFrame frame;

	/**
	 * Creates a new Display.
	 * 
	 * @param title
	 *            The title of the frame
	 * @param width
	 *            The width of the frame
	 * @param height
	 *            The height of the frame
	 */
	public Display(String title, int width, int height) {
		this(title, new Dimension(width, height));
	}

	/**
	 * Creates a new Display.
	 * 
	 * @param title
	 *            The title of the frame
	 * @param dimensions
	 *            The dimensions of the frame
	 */
	public Display(String title, Dimension dimensions) {
		this.title = title;
		this.dimensions = dimensions;
		this.setName(title.toLowerCase().replace(" ", "_") + "_canvas");
	}

	/**
	 * Creates the display with the specified title and dimensions as well as all the default settings.
	 */
	public Display createDisplay() {
		frame = new JFrame(title);

		frame.setMinimumSize(dimensions);
		frame.setMaximumSize(dimensions);
		frame.setPreferredSize(dimensions);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		frame.add(this, BorderLayout.CENTER);
		frame.pack();

		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		addKeyListener(Keyboard.INSTANCE);
		addFocusListener(Keyboard.INSTANCE);
		addMouseListener(Mouse.INSTANCE);
		addMouseMotionListener(Mouse.INSTANCE);
		addMouseWheelListener(Mouse.INSTANCE);
		addFocusListener(Mouse.INSTANCE);

		return this;
	}

	/**
	 * @return The title of the JFrame
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return The dimensions of the JFrame
	 */
	public Dimension getDimensions() {
		return dimensions;
	}

	/**
	 * @return The actual JFrame object
	 */
	public JFrame getFrame() {
		return frame;
	}

	@Override
	public String getName() {
		return this.getTitle();
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDimensions(Dimension dimensions) {
		this.dimensions = dimensions;
	}

	public void setDimensions(int width, int height) {
		this.dimensions = new Dimension(width, height);
	}
}