package com.ocelot.gfx;

import java.awt.image.BufferedImage;

import com.ocelot.utils.LoadingUtils;

/**
 * Represents a singe image out of a texture atlas.
 * 
 * @author Ocelot5836
 * @since 1.5
 */
public class TextureAtlasSprite {

	private int[] pixels;
	private int width;
	private int height;

	/**
	 * Creates a new sprite using the pixel data from the image.
	 * 
	 * @param image
	 *            The image to get the pixel data from
	 */
	public TextureAtlasSprite(BufferedImage image) {
		this.pixels = image.getRGB(0, 0, image.getWidth(), image.getHeight(), null, 0, image.getWidth());
		this.width = image.getWidth();
		this.height = image.getHeight();
	}

	/**
	 * Loads an image then does the same as the first constructor
	 * 
	 * @param path
	 *            The path to the image
	 */
	public TextureAtlasSprite(String path) {
		this(LoadingUtils.loadImage("atlas_sprite:" + path, path));
	}

	/**
	 * @return The image converted from RGB pixel data back into a buffered image
	 */
	public BufferedImage getImage() {
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				image.setRGB(x, y, pixels[x + y * width]);
			}
		}
		return image;
	}

	/**
	 * @return The RGB pixel data in raw form
	 */
	public int[] getPixels() {
		return pixels;
	}

	/**
	 * @return The width of the sprite
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return The height of the sprite
	 */
	public int getHeight() {
		return height;
	}
}