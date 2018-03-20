package com.ocelot.utils;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <em><b>Copyright (c) 2018 Ocelot5836.</b></em>
 * 
 * <br>
 * </br>
 * 
 * Sends text into the console with the time, name, and logging level. This is a very simple way to print text and can be improved in many ways.
 * 
 * @author Ocelot5836
 * @since 1.0
 */
public class Logger {

	private String name;

	public Logger(String name) {
		this.name = name;
	}

	/**
	 * Logs a message to the console.
	 * 
	 * @param level
	 *            The level of the message
	 * @param name
	 *            The source of the message
	 * @param msg
	 *            The message itself
	 */
	private void log(LogLevel level, String msg) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
		String formattedDate = sdf.format(date);

		level.getStream().println(String.format("[%s] [%s/%s] %s", formattedDate, name, level.getDisplay(), msg));
		if (level == LogLevel.SEVERE) {
			System.exit(-1);
		}

		// switch (level) {
		// default:
		// case INFO:
		// System.out.println(String.format("[%s] [%s/INFO] %s", formattedDate, name, msg));
		// break;
		// case DEBUG:
		// System.out.println(String.format("[%s] [%s/DEBUG] %s", formattedDate, name, msg));
		// break;
		// case WARNING:
		// System.out.println(String.format("[%s] [%s/WARNING] %s", formattedDate, name, msg));
		// break;
		// case SEVERE:
		// System.out.println(String.format("[%s] [%s/SEVERE] %s", formattedDate, name, msg));
		// System.exit(-1);
		// break;
		// }
	}

	/**
	 * Logs an info message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void info(String msg) {
		log(LogLevel.INFO, msg);
	}

	/**
	 * Logs a debug message.
	 * 
	 * @param msg
	 *            The message to be sent
	 * @param line
	 *            The line number shown for easy removal of this line
	 */
	public void debug(String msg, int line) {
		log(LogLevel.DEBUG, String.format("[Line: %s] %s", line, msg));
	}

	/**
	 * Logs a warning message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void warning(String msg) {
		log(LogLevel.WARNING, msg);
	}

	/**
	 * Logs a severe message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void severe(String msg) {
		log(LogLevel.SEVERE, msg);
	}

	/**
	 * Logs an info message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void info(int msg) {
		log(LogLevel.INFO, Integer.toString(msg));
	}

	/**
	 * Logs a debug message.
	 * 
	 * @param msg
	 *            The message to be sent
	 * @param line
	 *            The line number shown for easy removal of this line
	 */
	public void debug(int msg, int line) {
		log(LogLevel.DEBUG, "[Line: " + line + "] " + Integer.toString(msg));
	}

	/**
	 * Logs a warning message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void warning(int msg) {
		log(LogLevel.WARNING, Integer.toString(msg));
	}

	/**
	 * Logs a severe message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void severe(int msg) {
		log(LogLevel.SEVERE, Integer.toString(msg));
	}

	/**
	 * Logs an info message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void info(double msg) {
		log(LogLevel.INFO, Double.toString(msg));
	}

	/**
	 * Logs a debug message.
	 * 
	 * @param msg
	 *            The message to be sent
	 * @param line
	 *            The line number shown for easy removal of this line
	 */
	public void debug(double msg, int line) {
		log(LogLevel.DEBUG, "[Line: " + line + "] " + Double.toString(msg));
	}

	/**
	 * Logs a warning message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void warning(double msg) {
		log(LogLevel.WARNING, Double.toString(msg));
	}

	/**
	 * Logs a severe message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void severe(double msg) {
		log(LogLevel.SEVERE, Double.toString(msg));
	}

	/**
	 * Logs an info message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void info(float msg) {
		log(LogLevel.INFO, Float.toString(msg));
	}

	/**
	 * Logs a debug message.
	 * 
	 * @param msg
	 *            The message to be sent
	 * @param line
	 *            The line number shown for easy removal of this line
	 */
	public void debug(float msg, int line) {
		log(LogLevel.DEBUG, "[Line: " + line + "] " + Float.toString(msg));
	}

	/**
	 * Logs a warning message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void warning(float msg) {
		log(LogLevel.WARNING, Float.toString(msg));
	}

	/**
	 * Logs a severe message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void severe(float msg) {
		log(LogLevel.SEVERE, Float.toString(msg));
	}

	/**
	 * Logs an info message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void info(long msg) {
		log(LogLevel.INFO, Long.toString(msg));
	}

	/**
	 * Logs a debug message.
	 * 
	 * @param msg
	 *            The message to be sent
	 * @param line
	 *            The line number shown for easy removal of this line
	 */
	public void debug(long msg, int line) {
		log(LogLevel.DEBUG, "[Line: " + line + "] " + Long.toString(msg));
	}

	/**
	 * Logs a warning message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void warning(long msg) {
		log(LogLevel.WARNING, Long.toString(msg));
	}

	/**
	 * Logs a severe message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void severe(long msg) {
		log(LogLevel.SEVERE, Long.toString(msg));
	}

	/**
	 * Logs an info message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void info(boolean msg) {
		log(LogLevel.INFO, Boolean.toString(msg));
	}

	/**
	 * Logs a debug message.
	 * 
	 * @param msg
	 *            The message to be sent
	 * @param line
	 *            The line number shown for easy removal of this line
	 */
	public void debug(boolean msg, int line) {
		log(LogLevel.DEBUG, "[Line: " + line + "] " + Boolean.toString(msg));
	}

	/**
	 * Logs a warning message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void warning(boolean msg) {
		log(LogLevel.WARNING, Boolean.toString(msg));
	}

	/**
	 * Logs a severe message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void severe(boolean msg) {
		log(LogLevel.SEVERE, Boolean.toString(msg));
	}

	/**
	 * Logs an info message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void info(Object msg) {
		String string = String.valueOf(msg);
		synchronized (this) {
			log(LogLevel.INFO, string);
		}
	}

	/**
	 * Logs a debug message.
	 * 
	 * @param msg
	 *            The message to be sent
	 * @param line
	 *            The line number shown for easy removal of this line
	 */
	public void debug(Object msg, int line) {
		String string = String.valueOf(msg);
		synchronized (this) {
			log(LogLevel.DEBUG, "[Line: " + line + "] " + string);
		}
	}

	/**
	 * Logs a warning message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void warning(Object msg) {
		String string = String.valueOf(msg);
		synchronized (this) {
			log(LogLevel.WARNING, string);
		}
	}

	/**
	 * Logs a severe message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void severe(Object msg) {
		String string = String.valueOf(msg);
		synchronized (this) {
			log(LogLevel.SEVERE, string);
		}
	}

	/**
	 * Logs an info message.
	 */
	public void info() {
	}

	/**
	 * Logs a debug message.
	 */
	public void debug() {
	}

	/**
	 * Logs a warning message.
	 */
	public void warning() {
	}

	/**
	 * Logs a severe message.
	 */
	public void severe() {
	}

	private enum LogLevel {
		INFO("INFO", System.out), DEBUG("DEBUG", System.out), WARNING("WARNING", System.err), SEVERE("SEVERE", System.err);

		private String display;
		private PrintStream stream;

		private LogLevel(String display, PrintStream stream) {
			this.display = display;
			this.stream = stream;
		}

		public String getDisplay() {
			return display;
		}

		public PrintStream getStream() {
			return stream;
		}
	}

	public String getName() {
		return name;
	}

	/**
	 * Returns the logger with the specified name or a new one if it isn't found.
	 * 
	 * @param name
	 *            The name of the logger to find
	 * @return The logger found
	 * @deprecated Use {@link Logging} instead.
	 */
	public static Logger getLogger(String name) {
		return Logging.getLogger(name);
	}
}