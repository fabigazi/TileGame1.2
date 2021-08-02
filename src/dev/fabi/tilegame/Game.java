package dev.fabi.tilegame;
//hi test one
//hi this is a bigger test to see if thigits will work

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import dev.fabi.tilegame.display.Display;
import dev.fabi.tilegame.gfx.Assets;
import dev.fabi.tilegame.states.GameState;
import dev.fabi.tilegame.states.MenuState;
import dev.fabi.tilegame.states.State;

public class Game implements Runnable{
	
	private Display display;
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics g;
	
	//States
	private State gameState;
	private State menuState;
	
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;		
	}
	//Initializes the Display
	private void init() {
		display = new Display(title, width, height);
		Assets.init();
		
		//declare all states here
		gameState = new GameState();
		menuState = new MenuState();
		State.setState(gameState);
	}
	
	
	//the unit of time that passes
	private void tick() {
		if(State.getState() != null)
			State.getState().tick();
	}
	//Drawing the image on the window
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		//Draw Here!


		if(State.getState() != null)
			State.getState().render(g);
		
		//End Drawing!
		bs.show();
		g.dispose();
	}
	//the run method that completes runnable
	public void run() {
		init();
		//the video #10
		//https://www.youtube.com/watch?v=w1aB5gc38C8&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=10
		int fps = 60; //1900 with no animation 1500 seems to be limit with minimal animation
		double timePerTick = 1000000000 / fps; //1 x 10^9 nano sec in one sec
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime)/timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			if(timer >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}
	//Initializes running and the threads
	public synchronized void start() {
		if(running)
			return;
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	//terminates running and hte threads
	public synchronized void stop()	{
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch(InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


