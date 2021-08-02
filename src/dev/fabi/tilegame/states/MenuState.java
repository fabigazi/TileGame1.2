package dev.fabi.tilegame.states;

import java.awt.Color;
import java.awt.Graphics;

import dev.fabi.tilegame.Game;

public class MenuState extends State{

	public MenuState(Game game) {
		super(game);
	}
	
	@Override
	public void tick() {
		//System.out.println(game.getMouseManager().getMouseX() + "  "+ game.getMouseManager().getMouseY());
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(game.getMouseManager().getMouseX(), game.getMouseManager().getMouseY(), 8, 8);
	}

}
