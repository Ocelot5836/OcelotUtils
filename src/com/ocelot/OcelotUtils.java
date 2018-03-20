package com.ocelot;

import com.ocelot.audio.JukeBox;
import com.ocelot.thread.ThreadPool;
import com.ocelot.utils.Logger;
import com.ocelot.utils.Logging;
import com.ocelot.utils.StopwatchManager;

/**
 * <em><b>Copyright (c) 2018 Ocelot5836.</b></em>
 * 
 * <br>
 * </br>
 * 
 * Updates and handles all of the utilities so they function without adding additional support.
 * 
 * @author Ocelot5836
 * @since 1.4.9
 */
public class OcelotUtils implements Runnable {

	private static boolean initialized = false;

	private boolean running;
	@SuppressWarnings("unused")
	private int updates;
	private Logger logger = getLogger();
	private ThreadPool pool;
	private static OcelotUtils utils;

	private OcelotUtils() {
		pool = new ThreadPool(15);
		utils = this;
	}

	/**
	 * Make sure to call this method or the program will be very buggy! It starts the loops and such which controls all stopwatches and anything else that needs looping.
	 */
	public static void init(String[] args) {
		if (!initialized) {
			initialized = true;
			getLogger().info("Running " + OcelotUtilsInfo.NAME + " version " + OcelotUtilsInfo.VERSION);
			JukeBox.create();
			new OcelotUtils().start();
		}
	}

	/**
	 * This is used for debugging.
	 * 
	 * @deprecated please use {@link OcelotUtils#init(String[])} instead of this method.
	 */
	public static void main(String[] args) {
		OcelotUtils.init(args);
	}

	public void start() {
		if (running)
			return;
		logger.info("Starting...");

		new Thread(this, OcelotUtilsInfo.NAME).start();

		running = true;
	}

	public void stop() {
		if (!running)
			return;
		logger.info("Stopping...");
		running = false;
	}

	@Override
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

	public static Logger getLogger() {
		if (!initialized)
			throw new IllegalArgumentException(OcelotUtilsInfo.NAME + " was not initialized!");
		return Logging.getLogger(OcelotUtilsInfo.NAME);
	}

	public static OcelotUtils getUtils() {
		if (!initialized)
			throw new IllegalArgumentException(OcelotUtilsInfo.NAME + " was not initialized!");
		return utils;
	}

	/**
	 * DO NOT USE THIS. THIS IS FOR OCELOT UTILS AND SHOULD NOT BE USED FOR ANY OTHER PURPOSES!!! If you would like to have multi-threading, see {@link ThreadPool}.
	 */
	public void addScheduledTask(Runnable task) {
		pool.addScheduledTask(task);
	}
}