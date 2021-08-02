package dev.fabi.tilegame.states;

import java.awt.Graphics;

import dev.fabi.tilegame.entities.creatures.Player;

public class GameState extends State{
	
	private Player player;

	public GameState() {
		//https://www.youtube.com/watch?v=Bxf0EfO5_dY&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=12
		player = new Player(100,100);
	}
	
	@Override
	public void tick() {
		player.tick();
	}

	@Override
	public void render(Graphics g) {
		player.render(g);
	}

}
