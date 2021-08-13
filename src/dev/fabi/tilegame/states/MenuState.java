package dev.fabi.tilegame.states;

import java.awt.Color;
import java.awt.Graphics;

import dev.fabi.tilegame.Game;
import dev.fabi.tilegame.gfx.Assets;
import dev.fabi.tilegame.ui.ClickListener;
import dev.fabi.tilegame.ui.UIImageButton;
import dev.fabi.tilegame.ui.UIManager;

public class MenuState extends State{
	
	private UIManager uiManager;

	public MenuState(Game game) {
		super(game);
		uiManager = new UIManager();
		game.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(200,200,128,64, Assets.btn_start, new ClickListener() {

			@Override
			public void onClick() {
				State.setState(game.gameState);
			}
			
		}));
	}
	
	@Override
	public void tick() {
		uiManager.tick();
		//System.out.println(game.getMouseManager().getMouseX() + "  "+ game.getMouseManager().getMouseY());
	}

	@Override
	public void render(Graphics g) {
		uiManager.render(g);
		g.setColor(Color.RED);
		g.fillRect(game.getMouseManager().getMouseX(), game.getMouseManager().getMouseY(), 8, 8);
	}

}
