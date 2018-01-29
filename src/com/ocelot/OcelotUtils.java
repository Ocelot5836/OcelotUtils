package com.ocelot;

import com.ocelot.audio.JukeBox;
import com.ocelot.utils.Logger;
import com.ocelot.utils.Logging;
import com.ocelot.utils.StopwatchManager;

/**
 * Updates and handles all of the utilities so they function without adding additional support.
 * 
 * @author Ocelot5836
 * @since 1.4.9
 */
public class OcelotUtils implements Runnable {

	private boolean running;
	@SuppressWarnings("unused")
	private int updates;
	private Logger logger = Logging.getLogger("OcelotUtils");

	/**
	 * Make sure to call this method or the program will be very buggy!
	 */
	public static void init(String[] args) {
		JukeBox.create();
		new OcelotUtils().start();
	}

	public void start() {
		logger.info("Starting...");
		running = true;
	}

	public void stop() {
		logger.info("Stopping...");
		running = false;
	}

	public void run() {
		long lastTime = System.nanoTime();
		double nsPerTick = 1000000000D / 60D;

		int updates = 0;

		long lastTimer = System.currentTimeMillis();
		double delta = 0;

		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nsPerTick;
			lastTime = now;

			while (delta >= 1) {
				updates++;
				update();
				delta -= 1;
			}

			if (System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 1000;
				this.updates = updates;
				updates = 0;
			}
		}
		stop();
	}

	public void update() {
		StopwatchManager.update();
	}

	@Override
	protected void finalize() throws Throwable {
		stop();
	}

	public static Logger getLogger() {
		return Logging.getLogger("OcelotUtils");
	}
}