package com.ocelot;

import com.ocelot.audio.JukeBox;
import com.ocelot.thread.ThreadPool;
import com.ocelot.utils.LoadingUtils;
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
	private Logger logger = getLogger();
	private ThreadPool pool;
	private static OcelotUtils utils;

	public OcelotUtils() {
		pool = new ThreadPool(15);
	}

	/**
	 * Make sure to call this method or the program will be very buggy!
	 */
	public static void init(String[] args) {
		String[] version = LoadingUtils.loadTextToArrayFromURL("https://raw.githubusercontent.com/Ocelot5836/OcelotUtils/master/version.txt");
		if (version.length > 0)
			getLogger().info("Running " + OcelotUtils.class.getSimpleName() + " version " + version[0]);
		JukeBox.create();
		utils = new OcelotUtils();
		utils.start();
	}

	/**
	 * Does the same thing as init except this is used for debugging.
	 * 
	 * @deprecated please use {@link OcelotUtils#init(String[])} instead of this method.
	 */
	public static void main(String[] args) {
		OcelotUtils.init(args);
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

	public static Logger getLogger() {
		return Logging.getLogger("OcelotUtils");
	}

	public static OcelotUtils getUtils() {
		return utils;
	}

	/**
	 * DO NOT USE THIS. THIS IS FOR OCELOT UTILS AND SHOULD NOT BE USED FOR ANY OTHER PURPOSES!!! If you would like to have multi-threading, see {@link ThreadPool}.
	 */
	public void addScheduledTask(Runnable task) {
		pool.addScheduledTask(task);
	}
}