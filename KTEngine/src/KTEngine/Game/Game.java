package KTEngine.Game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

public class Game implements Runnable{

	//Aspect ratio here is 4:3
	private static final float SCALE = 1.5f;
	private static final int  WIDTH = (int)(800 * SCALE);
	private static final int  HEIGHT = (int)(600 * SCALE);
	private static final double WORLD_UNITS_TO_PIXEL_RATIO = 1.0/100.0;
	
	private boolean running = false;
	private Thread thread;
	private Screen screen;
	private Camera camera;
	private InputHandler inputHandler;
	
	//Beautiful, clean, testing code below Kappa.
	TestPlayer ply = new TestPlayer(new Sprite("res/map.png", WORLD_UNITS_TO_PIXEL_RATIO));
	ArrayList<ViewableGameObject> scene;
	
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
		frame.add(screen, BorderLayout.CENTER);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		camera = new Camera(WIDTH, HEIGHT, 2, 2, screen.getPixels());
		inputHandler = new InputHandler();
		screen.addKeyListener(inputHandler);

		camera.updatePos(-3,0);
		ply.transform.updatePos(-3,0);
		ply.updateRec();
		Map map = new Map("res/map.png","res/map.txt", WORLD_UNITS_TO_PIXEL_RATIO, 32);
		scene = map.getMap();
		scene.add(ply);
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
		int red = (int)Math.floor(Math.random() * 255);
		int green = (int)Math.floor(Math.random() * 255);
		int blue = (int)Math.floor(Math.random() * 255);
		while(running) {
			//Draws the randomly chosen background color.
			for(int y = 0; y < HEIGHT;y++) {
				for(int x = 0; x < WIDTH;x++) {
					screen.setPixel(x, y, red, green, blue);
				}
			}
			camera.display(scene);
			screen.render();
			tick();
		}
	}	
	
	public void tick() {
		double xStep = 0.011;
		double yStep = 0.011;

		if(inputHandler.w.isPressed()) {
			camera.updatePos(camera.transform.pos.x, camera.transform.pos.y + yStep);
			ply.transform.updatePos(ply.transform.pos.x, ply.transform.pos.y + yStep);
			ply.updateRec();
		}
		if(inputHandler.s.isPressed()) {
			camera.updatePos(camera.transform.pos.x, camera.transform.pos.y - yStep);
			ply.transform.updatePos(ply.transform.pos.x, ply.transform.pos.y - yStep);
			ply.updateRec();
		}
		if(inputHandler.a.isPressed()) {
			camera.updatePos(camera.transform.pos.x - xStep, camera.transform.pos.y);
			ply.transform.updatePos(ply.transform.pos.x - xStep, ply.transform.pos.y);
			ply.updateRec();
		}
		if(inputHandler.d.isPressed()) {
			camera.updatePos(camera.transform.pos.x + xStep, camera.transform.pos.y);
			ply.transform.updatePos(ply.transform.pos.x + xStep, ply.transform.pos.y);
			ply.updateRec();
		}
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}
}
