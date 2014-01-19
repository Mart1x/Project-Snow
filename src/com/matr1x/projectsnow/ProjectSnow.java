package com.matr1x.projectsnow;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class ProjectSnow extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	
	public static int width = 300;
	public static int height = width / 16 * 9;
	private int scale = 3;
	
	private Thread thread;
	private JFrame frame;
	private boolean running = false;
	
	public ProjectSnow() {
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		
		frame = new JFrame();
	}
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this, "Project Snow");
		thread.start();
	}
	
	public synchronized void stop() {
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		while(running) {
			
		}
		
	}
	
	public static void main(String args[]) {
		ProjectSnow game = new ProjectSnow();
		game.frame.setResizable(false);
		game.frame.setTitle("Project Snow Pre - Alpha 0.0.1a");
		game.frame.add(game);
		game.frame.pack();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null);
		game.frame.setVisible(true);
		
		game.start();
	}
	
}