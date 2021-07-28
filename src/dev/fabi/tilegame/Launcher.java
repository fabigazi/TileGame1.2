package dev.fabi.tilegame;

public interface Launcher {
	
	public static void main (String[] atgs) {
		Game game = new Game("Tile Game!", 400, 400);
		game.start();
				
	}
}
