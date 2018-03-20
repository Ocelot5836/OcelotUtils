package com.ocelot.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * <em><b>Copyright (c) 2018 Ocelot5836.</b></em>
 * 
 * <br>
 * </br>
 * 
 * Handles all of the stopwatches that are currently being used.
 * 
 * @author Ocelot5836
 * @since 1.4.5
 */
public class StopwatchManager {

	private static List<Stopwatch> stopwatches = new ArrayList<Stopwatch>();

	/**
	 * Updates all the stopwatches.
	 */
	public static void update() {
		for (Stopwatch watch : stopwatches) {
			watch.update();
		}

		for (int i = 0; i < stopwatches.size(); i++) {
			Stopwatch watch = stopwatches.get(i);
			if (watch.shouldRemove()) {
				stopwatches.remove(watch);
				i--;
			}
		}
	}

	/**
	 * Adds the specified watch to the watch list for updating and removing.
	 * 
	 * @param watch
	 *            The watch to add
	 */
	static void addWatch(Stopwatch watch) {
		stopwatches.add(watch);
	}
}