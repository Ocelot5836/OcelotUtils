package com.ocelot.utils;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ocelot.OcelotUtils;

/**
 * <em><b>Copyright (c) 2018 Ocelot5836.</b></em>
 * 
 * <br>
 * </br>
 * 
 * Sends text into the console with the time, name, and logging level. This is a very simple way to print text and can be improved in many ways. It may not be the most efficient at logging either and will probably be removed!
 * 
 * @author Ocelot5836
 * @since 1.0
 */
public class Logger {

	private String name;

	Logger(String name) {
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
	 */
	public void debug(String msg) {
		log(LogLevel.DEBUG, String.format("[%s:%s] %s", Utils.getClass(3), Utils.getLineNumber(3), msg));
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
	public void info(byte msg) {
		log(LogLevel.INFO, Byte.toString(msg));
	}

	/**
	 * Logs a debug message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void debug(byte msg) {
		log(LogLevel.DEBUG, String.format("[%s:%s] %s", Utils.getClass(3), Utils.getLineNumber(3), msg));
	}

	/**
	 * Logs a warning message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void warning(byte msg) {
		log(LogLevel.WARNING, Integer.toString(msg));
	}

	/**
	 * Logs a severe message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void severe(byte msg) {
		log(LogLevel.SEVERE, Integer.toString(msg));
	}

	/**
	 * Logs an info message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void info(short msg) {
		log(LogLevel.INFO, Short.toString(msg));
	}

	/**
	 * Logs a debug message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void debug(short msg) {
		log(LogLevel.DEBUG, String.format("[%s:%s] %s", Utils.getClass(3), Utils.getLineNumber(3), msg));
	}

	/**
	 * Logs a warning message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void warning(short msg) {
		log(LogLevel.WARNING, Short.toString(msg));
	}

	/**
	 * Logs a severe message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void severe(short msg) {
		log(LogLevel.SEVERE, Short.toString(msg));
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
	 */
	public void debug(int msg) {
		log(LogLevel.DEBUG, String.format("[%s:%s] %s", Utils.getClass(3), Utils.getLineNumber(3), msg));
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
	public void info(float msg) {
		log(LogLevel.INFO, Float.toString(msg));
	}

	/**
	 * Logs a debug message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void debug(float msg) {
		log(LogLevel.DEBUG, String.format("[%s:%s] %s", Utils.getClass(3), Utils.getLineNumber(3), msg));
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
	public void info(double msg) {
		log(LogLevel.INFO, Double.toString(msg));
	}

	/**
	 * Logs a debug message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void debug(double msg) {
		log(LogLevel.DEBUG, String.format("[%s:%s] %s", Utils.getClass(3), Utils.getLineNumber(3), msg));
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
	public void info(long msg) {
		log(LogLevel.INFO, Long.toString(msg));
	}

	/**
	 * Logs a debug message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void debug(long msg) {
		log(LogLevel.DEBUG, String.format("[%s:%s] %s", Utils.getClass(3), Utils.getLineNumber(3), msg));
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
	public void debug(boolean msg) {
		log(LogLevel.DEBUG, String.format("[%s:%s] %s", Utils.getClass(3), Utils.getLineNumber(3), msg));
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
		synchronized (this) {
			log(LogLevel.INFO, String.valueOf(msg));
		}
	}

	/**
	 * Logs a debug message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void debug(Object msg) {
		synchronized (this) {
			log(LogLevel.DEBUG, String.format("[%s:%s] %s", Utils.getClass(3), Utils.getLineNumber(3), String.valueOf(msg)));
		}
	}

	/**
	 * Logs a warning message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void warning(Object msg) {
		synchronized (this) {
			log(LogLevel.WARNING, String.valueOf(msg));
		}
	}

	/**
	 * Logs a severe message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void severe(Object msg) {
		synchronized (this) {
			log(LogLevel.SEVERE, String.valueOf(msg));
		}
	}

	/**
	 * Logs an info message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void info(Object[] msg) {
		StringBuilder builder = new StringBuilder("[");
		OcelotUtils.getUtils().addScheduledTask(() -> {
			for (int i = 0; i < msg.length; i++) {
				builder.append(msg[i]);
				if (i < msg.length - 1)
					builder.append(", ");
			}
			log(LogLevel.INFO, String.valueOf(builder.append("]").toString()));
		});
	}

	/**
	 * Logs a debug message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void debug(Object[] msg) {
		StringBuilder builder = new StringBuilder("[");
		OcelotUtils.getUtils().addScheduledTask(() -> {
			for (int i = 0; i < msg.length; i++) {
				builder.append(msg[i]);
				if (i < msg.length - 1)
					builder.append(", ");
			}
			log(LogLevel.DEBUG, String.format("[%s:%s] %s", Utils.getClass(2), Utils.getLineNumber(2), String.valueOf(String.valueOf(builder.append("]").toString()))));
		});
	}

	/**
	 * Logs a warning message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void warning(Object[] msg) {
		StringBuilder builder = new StringBuilder("[");
		OcelotUtils.getUtils().addScheduledTask(() -> {
			for (int i = 0; i < msg.length; i++) {
				builder.append(msg[i]);
				if (i < msg.length - 1)
					builder.append(", ");
			}
			log(LogLevel.WARNING, String.valueOf(builder.append("]").toString()));
		});
	}

	/**
	 * Logs a severe message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void severe(Object[] msg) {
		StringBuilder builder = new StringBuilder("[");
		OcelotUtils.getUtils().addScheduledTask(() -> {
			for (int i = 0; i < msg.length; i++) {
				builder.append(msg[i]);
				if (i < msg.length - 1)
					builder.append(", ");
			}
			log(LogLevel.SEVERE, String.valueOf(builder.append("]").toString()));
		});
	}

	/**
	 * Logs an info message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void info(byte[] msg) {
		OcelotUtils.getUtils().addScheduledTask(() -> {
			Byte[] array = new Byte[msg.length];
			for (int i = 0; i < array.length; i++) {
				array[i] = msg[i];
			}
			info(array);
		});
	}

	/**
	 * Logs a debug message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void debug(byte[] msg) {
		OcelotUtils.getUtils().addScheduledTask(() -> {
			Byte[] array = new Byte[msg.length];
			for (int i = 0; i < array.length; i++) {
				array[i] = msg[i];
			}
			debug(array);
		});
	}

	/**
	 * Logs a warning message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void warning(byte[] msg) {
		OcelotUtils.getUtils().addScheduledTask(() -> {
			Byte[] array = new Byte[msg.length];
			for (int i = 0; i < array.length; i++) {
				array[i] = msg[i];
			}
			warning(array);
		});
	}

	/**
	 * Logs a severe message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void severe(byte[] msg) {
		OcelotUtils.getUtils().addScheduledTask(() -> {
			Byte[] array = new Byte[msg.length];
			for (int i = 0; i < array.length; i++) {
				array[i] = msg[i];
			}
			severe(array);
		});
	}

	/**
	 * Logs an info message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void info(short[] msg) {
		OcelotUtils.getUtils().addScheduledTask(() -> {
			Short[] array = new Short[msg.length];
			for (int i = 0; i < array.length; i++) {
				array[i] = msg[i];
			}
			info(array);
		});
	}

	/**
	 * Logs a debug message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void debug(short[] msg) {
		OcelotUtils.getUtils().addScheduledTask(() -> {
			Short[] array = new Short[msg.length];
			for (int i = 0; i < array.length; i++) {
				array[i] = msg[i];
			}
			debug(array);
		});
	}

	/**
	 * Logs a warning message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void warning(short[] msg) {
		OcelotUtils.getUtils().addScheduledTask(() -> {
			Short[] array = new Short[msg.length];
			for (int i = 0; i < array.length; i++) {
				array[i] = msg[i];
			}
			warning(array);
		});
	}

	/**
	 * Logs a severe message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void severe(short[] msg) {
		OcelotUtils.getUtils().addScheduledTask(() -> {
			Short[] array = new Short[msg.length];
			for (int i = 0; i < array.length; i++) {
				array[i] = msg[i];
			}
			severe(array);
		});
	}

	/**
	 * Logs an info message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void info(int[] msg) {
		OcelotUtils.getUtils().addScheduledTask(() -> {
			Integer[] array = new Integer[msg.length];
			for (int i = 0; i < array.length; i++) {
				array[i] = msg[i];
			}
			info(array);
		});
	}

	/**
	 * Logs a debug message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void debug(int[] msg) {
		OcelotUtils.getUtils().addScheduledTask(() -> {
			Integer[] array = new Integer[msg.length];
			for (int i = 0; i < array.length; i++) {
				array[i] = msg[i];
			}
			debug(array);
		});
	}

	/**
	 * Logs a warning message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void warning(int[] msg) {
		OcelotUtils.getUtils().addScheduledTask(() -> {
			Integer[] array = new Integer[msg.length];
			for (int i = 0; i < array.length; i++) {
				array[i] = msg[i];
			}
			warning(array);
		});
	}

	/**
	 * Logs a severe message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void severe(int[] msg) {
		OcelotUtils.getUtils().addScheduledTask(() -> {
			Integer[] array = new Integer[msg.length];
			for (int i = 0; i < array.length; i++) {
				array[i] = msg[i];
			}
			severe(array);
		});
	}

	/**
	 * Logs an info message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void info(float[] msg) {
		OcelotUtils.getUtils().addScheduledTask(() -> {
			Float[] array = new Float[msg.length];
			for (int i = 0; i < array.length; i++) {
				array[i] = msg[i];
			}
			info(array);
		});
	}

	/**
	 * Logs a debug message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void debug(float[] msg) {
		OcelotUtils.getUtils().addScheduledTask(() -> {
			Float[] array = new Float[msg.length];
			for (int i = 0; i < array.length; i++) {
				array[i] = msg[i];
			}
			debug(array);
		});
	}

	/**
	 * Logs a warning message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void warning(float[] msg) {
		OcelotUtils.getUtils().addScheduledTask(() -> {
			Float[] array = new Float[msg.length];
			for (int i = 0; i < array.length; i++) {
				array[i] = msg[i];
			}
			warning(array);
		});
	}

	/**
	 * Logs a severe message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void severe(float[] msg) {
		OcelotUtils.getUtils().addScheduledTask(() -> {
			Float[] array = new Float[msg.length];
			for (int i = 0; i < array.length; i++) {
				array[i] = msg[i];
			}
			severe(array);
		});
	}

	/**
	 * Logs an info message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void info(double[] msg) {
		OcelotUtils.getUtils().addScheduledTask(() -> {
			Double[] array = new Double[msg.length];
			for (int i = 0; i < array.length; i++) {
				array[i] = msg[i];
			}
			info(array);
		});
	}

	/**
	 * Logs a debug message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void debug(double[] msg) {
		OcelotUtils.getUtils().addScheduledTask(() -> {
			Double[] array = new Double[msg.length];
			for (int i = 0; i < array.length; i++) {
				array[i] = msg[i];
			}
			debug(array);
		});
	}

	/**
	 * Logs a warning message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void warning(double[] msg) {
		OcelotUtils.getUtils().addScheduledTask(() -> {
			Double[] array = new Double[msg.length];
			for (int i = 0; i < array.length; i++) {
				array[i] = msg[i];
			}
			warning(array);
		});
	}

	/**
	 * Logs a severe message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void severe(double[] msg) {
		OcelotUtils.getUtils().addScheduledTask(() -> {
			Double[] array = new Double[msg.length];
			for (int i = 0; i < array.length; i++) {
				array[i] = msg[i];
			}
			severe(array);
		});
	}

	/**
	 * Logs an info message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void info(long[] msg) {
		OcelotUtils.getUtils().addScheduledTask(() -> {
			Long[] array = new Long[msg.length];
			for (int i = 0; i < array.length; i++) {
				array[i] = msg[i];
			}
			info(array);
		});
	}

	/**
	 * Logs a debug message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void debug(long[] msg) {
		OcelotUtils.getUtils().addScheduledTask(() -> {
			Long[] array = new Long[msg.length];
			for (int i = 0; i < array.length; i++) {
				array[i] = msg[i];
			}
			debug(array);
		});
	}

	/**
	 * Logs a warning message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void warning(long[] msg) {
		OcelotUtils.getUtils().addScheduledTask(() -> {
			Long[] array = new Long[msg.length];
			for (int i = 0; i < array.length; i++) {
				array[i] = msg[i];
			}
			warning(array);
		});
	}

	/**
	 * Logs a severe message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void severe(long[] msg) {
		OcelotUtils.getUtils().addScheduledTask(() -> {
			Long[] array = new Long[msg.length];
			for (int i = 0; i < array.length; i++) {
				array[i] = msg[i];
			}
			severe(array);
		});
	}

	/**
	 * Logs an info message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void info(boolean[] msg) {
		OcelotUtils.getUtils().addScheduledTask(() -> {
			Boolean[] array = new Boolean[msg.length];
			for (int i = 0; i < array.length; i++) {
				array[i] = msg[i];
			}
			info(array);
		});
	}

	/**
	 * Logs a debug message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void debug(boolean[] msg) {
		OcelotUtils.getUtils().addScheduledTask(() -> {
			Boolean[] array = new Boolean[msg.length];
			for (int i = 0; i < array.length; i++) {
				array[i] = msg[i];
			}
			debug(array);
		});
	}

	/**
	 * Logs a warning message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void warning(boolean[] msg) {
		OcelotUtils.getUtils().addScheduledTask(() -> {
			Boolean[] array = new Boolean[msg.length];
			for (int i = 0; i < array.length; i++) {
				array[i] = msg[i];
			}
			warning(array);
		});
	}

	/**
	 * Logs a severe message.
	 * 
	 * @param msg
	 *            The message to be sent
	 */
	public void severe(boolean[] msg) {
		OcelotUtils.getUtils().addScheduledTask(() -> {
			Boolean[] array = new Boolean[msg.length];
			for (int i = 0; i < array.length; i++) {
				array[i] = msg[i];
			}
			severe(array);
		});
	}

	/**
	 * Logs an empty info message.
	 */
	public void info() {
		log(LogLevel.INFO, "");
	}

	/**
	 * Logs an empty debug message.
	 */
	public void debug() {
		log(LogLevel.DEBUG, String.format("[%s:%s] %s", Utils.getClass(3), Utils.getLineNumber(3), ""));
	}

	/**
	 * Logs an empty warning message.
	 */
	public void warning() {
		log(LogLevel.WARNING, "");
	}

	/**
	 * Logs an empty severe message.
	 */
	public void severe() {
		log(LogLevel.SEVERE, "");
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
	 * @deprecated Use {@link Logging} instead. Will be removed in 1.6
	 */
	public static Logger getLogger(String name) {
		return Logging.getLogger(name);
	}
}