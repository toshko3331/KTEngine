package KTEngine.Game;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game implements Runnable{

	private static final int  WIDTH = 800;
	private static final int  HEIGHT = 800;
	
	private boolean running = false;
	private Thread thread;
	private Screen screen;
	
	public Game() {

		screen = new Screen(WIDTH, HEIGHT);
		Dimension size = new Dimension(WIDTH, HEIGHT);
		screen.setPreferredSize(size);
		screen.setMaximumSize(size);
		screen.setMinimumSize(size);
		
		JFrame frame = new JFrame("Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLayout(new BorderLayout());
		frame.add(screen,BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public synchronized void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		int color1 = (int)Math.floor(Math.random() * 255);
		int color2 = (int)Math.floor(Math.random() * 255);
		int color3 = (int)Math.floor(Math.random() * 255);
		while(running) {
			screen.render();
			tick();
			for(int y = 0; y < HEIGHT;y++) {
				for(int x = 0; x < WIDTH;x++) {
					screen.setPixel(x,y,color1,color2,color3);
				}
			}
		}
	}	
	
	public void tick() {
		//TODO: Game code.
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}
}
