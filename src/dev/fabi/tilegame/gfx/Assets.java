package dev.fabi.tilegame.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	private static final int width = 25, height = 25;
	
	public static BufferedImage player, dirt, grass, stone, tree;
	
	public static BufferedImage[] btn_start;
	
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/SpriteSheet1.png"));
		
		btn_start = new BufferedImage[2];
		btn_start[1] = sheet.crop(0, 150, 100, 50);
		btn_start[0] = sheet.crop(100, 150, 100, 50);
		
		player = sheet.crop(50, 50, width, height);
		dirt = sheet.crop(75, 75, width, height);
		grass = sheet.crop(50, 75, width, height);
		stone = sheet.crop(50, 100, width, height);
		tree = sheet.crop(75, 50, width, height);
		
	}
}
