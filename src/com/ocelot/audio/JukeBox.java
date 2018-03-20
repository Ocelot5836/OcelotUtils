package com.ocelot.audio;

import java.io.IOException;
import java.util.HashMap;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import com.ocelot.OcelotUtils;

/**
 * <em><b>Copyright (c) 2018 Ocelot5836.</b></em>
 * 
 * <br>
 * </br>
 * 
 * This class has the capability to load and play wav files. Requires extra libraries to load and run mp3 files or mp4. Throws an exception if {@link JukeBox#create()} is not called.
 * 
 * @author Ocelot5836
 * @since 1.3
 */
public class JukeBox {

	/** The music clips stored in memory */
	public static HashMap<String, Clip> clips;

	private static int gap;
	private static boolean mute = false;
	private static boolean created = false;

	/**
	 * initializes the {@link JukeBox} variables and allows usage of the jukebox.
	 */
	public static void create() {
		if (!isCreated()) {
			clips = new HashMap<String, Clip>();
			gap = 0;
			created = true;
			OcelotUtils.getLogger().info("Jukebox created successfully");
		} else {
			OcelotUtils.getLogger().info("Jukebox is already created!");
		}
	}

	/**
	 * Loads an audio file into memory.
	 * 
	 * @param path
	 *            The file path
	 * @param name
	 *            The name of the sound
	 */
	public static void load(String path, String name) {
		OcelotUtils.getUtils().addScheduledTask(() -> {
			if (!created)
				throwException();
			if (clips.get(path) != null)
				return;
			try {
				Clip clip;
				AudioInputStream ais = AudioSystem.getAudioInputStream(JukeBox.class.getResourceAsStream(path));
				AudioFormat baseFormat = ais.getFormat();
				AudioFormat decodeFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16, baseFormat.getChannels(), baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);
				AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais);
				clip = AudioSystem.getClip();
				clip.open(dais);
				clips.put(name, clip);
			} catch (IOException e) {
				OcelotUtils.getLogger().warning(String.format("File %s at %s not found!", name, path));
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			} catch (UnsupportedAudioFileException e) {
				e.printStackTrace();
			}
		});
	}

	/**
	 * Stops all the sounds playing
	 */
	public static void stopAllSounds() {
		if (!created)
			throwException();
		for (String s : clips.keySet())
			stop(s);
	}

	/**
	 * Plays a specific audio file.
	 * 
	 * @param file
	 *            The clip to play
	 */
	public static void play(String file) {
		if (!created)
			throwException();
		play(file, gap);
	}

	/**
	 * Plays an audio file at the specified location.
	 * 
	 * @param file
	 *            The clip to play
	 * @param gap
	 *            The gap in the sound
	 */
	public static void play(String file, int gap) {
		if (!created)
			throwException();
		try {
			if (mute)
				return;
			Clip c = clips.get(file);
			if (c == null)
				return;
			if (c.isRunning())
				c.stop();
			c.setFramePosition(gap);
			while (!c.isRunning())
				c.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Sets the volume for a music clip.
	 * 
	 * @param clip
	 *            The clip
	 * @param volume
	 *            The volume in decibels
	 */
	public static void setVolume(String clip, float volume) {
		if (!created)
			throwException();
		if (clips.get(clip) == null || volume >= 7 || volume < -50)
			return;
		Clip c = clips.get(clip);
		FloatControl gainControl = (FloatControl) c.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(volume);
	}

	/**
	 * Stops the specified clip form playing.
	 * 
	 * @param clip
	 *            The clip to stop
	 */
	public static void stop(String clip) {
		if (!created)
			throwException();
		if (clips.get(clip) == null)
			return;
		if (clips.get(clip).isRunning())
			clips.get(clip).stop();
	}

	/**
	 * Resumes a clip of it is not already running.
	 * 
	 * @param clip
	 *            The clip to be resumed
	 */
	public static void resume(String clip) {
		if (!created)
			throwException();
		if (mute)
			return;
		if (clips.get(clip).isRunning())
			return;
		clips.get(clip).start();
	}

	/**
	 * Loops a specific clip.
	 * 
	 * @param clip
	 *            The clip to loop
	 */
	public static void loop(String clip) {
		if (!created)
			throwException();
		loop(clip, gap, gap, clips.get(clip).getFrameLength() - 1);
	}

	/**
	 * Loops a specific clip at the specified frame.
	 * 
	 * @param clip
	 *            The clip
	 * @param frame
	 *            The frame to start at
	 */
	public static void loop(String clip, int frame) {
		if (!created)
			throwException();
		loop(clip, frame, gap, clips.get(clip).getFrameLength() - 1);
	}

	/**
	 * Loops a specific clip at the specified start and end point.
	 * 
	 * @param clip
	 *            The clip
	 * @param start
	 *            The frame to start at
	 * @param end
	 *            The frame to end at
	 */
	public static void loop(String clip, int start, int end) {
		if (!created)
			throwException();
		loop(clip, gap, start, end);
	}

	/**
	 * Loops a specific clip at the specified frame, start, and end point.
	 * 
	 * @param clip
	 *            The clip
	 * @param frame
	 *            The frame to go to
	 * @param start
	 *            The start frame
	 * @param end
	 *            The end frame
	 */
	public static void loop(String clip, int frame, int start, int end) {
		if (!created)
			throwException();
		stop(clip);
		if (mute)
			return;
		clips.get(clip).setLoopPoints(start, end);
		clips.get(clip).setFramePosition(frame);
		clips.get(clip).loop(Clip.LOOP_CONTINUOUSLY);
	}

	/**
	 * Sets the clip position.
	 * 
	 * @param clip
	 *            The clip
	 * @param frame
	 *            The frame to set the song at
	 */
	public static void setPosition(String clip, int frame) {
		if (!created)
			throwException();
		clips.get(clip).setFramePosition(frame);
	}

	/**
	 * Gets the length of the frames in the clip.
	 * 
	 * @param clip
	 *            The clip to get the frames from
	 * @return The frames
	 */
	public static int getFrames(String clip) {
		if (!created)
			throwException();
		return clips.get(clip).getFrameLength();
	}

	/**
	 * Gets the position of the clip.
	 * 
	 * @param clip
	 *            The clip to get the position
	 * @return The frame position
	 */
	public static int getPosition(String clip) {
		if (!created)
			throwException();
		return clips.get(clip).getFramePosition();
	}

	/**
	 * Stops and closes a clip.
	 * 
	 * @param clip
	 *            The clip to close/remove
	 */
	public static void close(String clip) {
		if (!created)
			throwException();
		stop(clip);
		clips.get(clip).close();
	}

	/**
	 * @return Whether or not the jukebox has been created yet
	 */
	public static boolean isCreated() {
		return created;
	}

	/**
	 * Throws an exception. Used for this class only
	 */
	private static void throwException() {
		throw new RuntimeException("Jukebox was trying to be used before it was created!");
	}
}