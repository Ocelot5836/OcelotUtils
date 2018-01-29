package com.ocelot.gfx;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

import com.ocelot.OcelotUtils;
import com.ocelot.utils.LoadingUtils;
import com.ocelot.utils.Stopwatch;

/**
 * Represents a basic sheet made of texture atlas sprites.
 * 
 * @author Ocelot5836
 * @since 1.5
 */
public class TextureAtlas {

	/** The default missing image sprite. */
	public static final TextureAtlasSprite MISSING = new TextureAtlasSprite(LoadingUtils.EMPTY_IMAGE16);
	/** The default empty image sprite. */
	public static final TextureAtlasSprite EMPTY;

	static {
		BufferedImage image = new BufferedImage(16, 16, BufferedImage.TYPE_INT_RGB);
		for (int y = 0; y < 16; y++) {
			for (int x = 0; x < 16; x++) {
				if (x == 0 || y == 0) {
					image.setRGB(x, y, 0x7f007f);
				} else {
					image.setRGB(x, y, 0xff00ff);
				}
			}
		}
		EMPTY = new TextureAtlasSprite(image);
	}

	private String name;
	private int width;
	private int height;
	private int spriteWidth;
	private int spriteHeight;
	private boolean debug;
	private BufferedImage stitchedTexture;
	private Map<String, TextureAtlasSprite> sprites;

	/**
	 * Creates a texture atlas using the name specified.
	 * 
	 * @param name
	 *            The name of the atlas
	 * @param tileWidth
	 *            The width in tiles of the texture atlas
	 * @param tileHeight
	 *            The height in tiles of the texture atlas
	 * @param spriteWidth
	 *            The width of each sprite
	 * @param spriteHeight
	 *            The height of each sprite
	 */
	public TextureAtlas(String name, int width, int height, int spriteWidth, int spriteHeight) {
		this(name, width, height, spriteWidth, spriteHeight, false);
	}

	/**
	 * Creates a texture atlas using the name specified.
	 * 
	 * @param name
	 *            The name of the atlas
	 * @param tileWidth
	 *            The width in tiles of the texture atlas
	 * @param tileHeight
	 *            The height in tiles of the texture atlas
	 * @param spriteWidth
	 *            The width of each sprite
	 * @param spriteHeight
	 *            The height of each sprite
	 * @param debug
	 *            Whether or not the atlas should generate a debug image or not
	 */
	public TextureAtlas(String name, int tileWidth, int tileHeight, int spriteWidth, int spriteHeight, boolean debug) {
		this.name = name;
		this.width = tileWidth * spriteWidth;
		this.height = tileHeight * spriteHeight;
		this.spriteWidth = spriteWidth;
		this.spriteHeight = spriteHeight;
		this.debug = debug;
		this.sprites = new HashMap<String, TextureAtlasSprite>();
	}

	/**
	 * Stitches the image together to populate the stitched image texture.
	 */
	public TextureAtlas stitch() {
		OcelotUtils.getLogger().info("Stitching Atlas:" + name);
		Stopwatch watch = new Stopwatch();
		watch.start();

		try {
			int rows = width / spriteWidth;
			int cols = height / spriteHeight;
			int chunks = rows * cols;

			int chunkWidth, chunkHeight;
			int type;

			BufferedImage[] buffImages = new BufferedImage[chunks];
			int imgi = 0;
			for (Entry<String, TextureAtlasSprite> sprite : sprites.entrySet()) {
				buffImages[imgi] = sprite.getValue().getImage();
				imgi++;
			}

			if (imgi < buffImages.length) {
				for (int i = imgi; i < buffImages.length; i++) {
					buffImages[i] = EMPTY.getImage();
				}
			}

			type = buffImages[0].getType();
			chunkWidth = buffImages[0].getWidth();
			chunkHeight = buffImages[0].getHeight();

			BufferedImage finalImg = new BufferedImage(chunkWidth * cols, chunkHeight * rows, type);

			int num = 0;
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					finalImg.createGraphics().drawImage(buffImages[num], chunkWidth * j, chunkHeight * i, null);
					num++;
				}
			}

			if (debug) {
				File folder = new File("debug/");
				if (folder.mkdirs()) {
				} else {
				}

				ImageIO.write(finalImg, "png", new File("debug/" + name + ".png"));
			}
		} catch (IOException e) {
			OcelotUtils.getLogger().warning("Could not complete texture stitch!");
			e.printStackTrace();
			watch.delete();
			return this;
		}

		watch.stop();
		OcelotUtils.getLogger().info("Completed Stitching in " + watch.getTime() + "ms");
		watch.delete();
		return this;
	}

	/**
	 * Registers a sprite with the specified identifer.
	 * 
	 * @param identifier
	 *            The identifer for the sprite
	 * @param sprite
	 *            The sprite to register
	 */
	public void registerTexture(String identifier, TextureAtlasSprite sprite) {
		this.sprites.put(identifier, sprite);
	}

	/**
	 * @param identifer
	 *            The identifier for a specified sprite
	 * @return The sprite found using that identifier. If none was found, it returns the empty image sprite
	 */
	public TextureAtlasSprite getSprite(String identifer) {
		for (Entry<String, TextureAtlasSprite> sprite : sprites.entrySet()) {
			if (sprite.getKey() == identifer) {
				return sprite.getValue();
			}
		}
		return MISSING;
	}

	/**
	 * @return The stitched image. Only available after the image has been stitched
	 */
	public BufferedImage getStitchedTexture() {
		return stitchedTexture;
	}
}