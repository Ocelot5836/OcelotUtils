package com.ocelot.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * <em><b>Copyright (c) 2018 Ocelot5836.</b></em>
 * 
 * <br>
 * </br>
 * 
 * Does some basic handling for loggers.
 * 
 * @author Ocelot5836
 * @since 1.3.2
 */
public class Logging {

	private static Map<String, Logger> loggers = new HashMap<String, Logger>();

	/**
	 * Used to get a specified logger.
	 * 
	 * @param name
	 *            The name of the logger to search for
	 * @return The logger that was found by the specified name
	 */
	public static Logger getLogger(String name) {
		if (loggers.containsKey(name)) {
			return loggers.get(name);
		} else {
			loggers.put(name, new Logger(name));
			return loggers.get(name);
		}
	}
}