package com.ocelot.utils;

/**
 * <em><b>Copyright (c) 2018 Ocelot5836.</b></em>
 * 
 * <br>
 * </br>
 * 
 * Creates a stopwatch that will time the amount of time until it stops.
 * 
 * @author Ocelot5836
 * @since 1.4.5
 */
public class Stopwatch {

	private long msResult = 0;
	private boolean hasStarted;

	private long lastTime = System.nanoTime();
	private double nsPerUpdate = 1000000000D / 60D;

	private long lastTimer = System.currentTimeMillis();
	private double delta = 0;

	private long now = System.nanoTime();

	private boolean remove = false;

	public Stopwatch() {
		StopwatchManager.addWatch(this);
	}

	/** Updates the timer. */
	public void update() {
		if (hasStarted) {
			delta += (now - lastTime) / nsPerUpdate;
			lastTime = now;

			msResult++;

			while (delta >= 1) {
				delta -= 1;
			}

			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
			}
		} else {
			lastTime = System.nanoTime();
			nsPerUpdate = 1000000000D / 60D;

			lastTimer = System.currentTimeMillis();
			delta = 0;

			System.nanoTime();
		}
	}

	/**
	 * Starts the timer.
	 */
	public Stopwatch start() {
		reset();
		hasStarted = true;
		remove = false;
		return this;
	}

	/**
	 * Stops the timer.
	 */
	public Stopwatch stop() {
		hasStarted = false;
		return this;
	}

	/**
	 * Resets the timer to 0
	 */
	public Stopwatch reset() {
		msResult = 0;
		return this;
	}

	/**
	 * Deletes this timer from memory
	 */
	public Stopwatch delete() {
		remove = true;
		return this;
	}

	/**
	 * @return The time it took to reach from the start time to now
	 */
	public long getTime() {
		return msResult;
	}

	/**
	 * Sets the timer to the specified millisecond time.
	 * 
	 * @param ms
	 *            The time to set the timer at
	 */
	public Stopwatch setTime(long ms) {
		msResult = ms;
		return this;
	}

	/**
	 * Sets the timer to the specified millisecond time plus the existing time.
	 * 
	 * @param ms
	 *            The time to add to the timer
	 */
	public Stopwatch addTime(long ms) {
		msResult += ms;
		return this;
	}

	/**
	 * Sets the timer to the specified millisecond time minus the existing time.
	 * 
	 * @param ms
	 *            The time to remove from the timer
	 */
	public Stopwatch revokeTime(long ms) {
		addTime(-ms);
		return this;
	}

	/**
	 * @return Whether or not this stopwatch is being used or not
	 */
	public boolean shouldRemove() {
		return remove;
	}
}
