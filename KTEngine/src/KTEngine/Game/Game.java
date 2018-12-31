package KTEngine.Game;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Game implements Runnable{

	//Aspect ratio here is 4:3
	private static final float SCALE = 1.5f;
	private static final int  WIDTH = (int)(800 * SCALE);
	private static final int  HEIGHT = (int)(600 * SCALE);
	
	private boolean running = false;
	private Thread thread;
	private Screen screen;
	private Camera camera;
	private InputHandler inputHandler;
	
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
		
		camera = new Camera(WIDTH, HEIGHT, 10, 10, screen.getPixels());
		inputHandler = new InputHandler();
		screen.addKeyListener(inputHandler);
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
		//Beautiful, clean, testing code below Kappa.

		ViewableGameObject test = new ViewableGameObject(new Sprite("res/beauty.png"));
		ViewableGameObject test32 = new ViewableGameObject(new Sprite("res/32x32.png"));
		ViewableGameObject[] testarr = new ViewableGameObject[2];
		testarr[0] = test;
		testarr[1] = test32;

		int red = (int)Math.floor(Math.random() * 255);
		int green = (int)Math.floor(Math.random() * 255);
		int blue = (int)Math.floor(Math.random() * 255);

		while(running) {
			//draws the randomly chosen background color.
			for(int y = 0; y < HEIGHT;y++) {
				for(int x = 0; x < WIDTH;x++) {
					screen.setPixel(x, y, red, green, blue);
				}
			}
			camera.display(testarr);
			screen.render();
			tick();
		}
	}	
	
	public void tick() {
		float xStep = 0.011f;
		float yStep = 0.011f;

		if(inputHandler.w.isPressed()) {
			camera.updatePos(camera.getTransform().pos.x, camera.getTransform().pos.y + yStep, camera.getTransform().pos.z);
		}
		if(inputHandler.s.isPressed()) {
			camera.updatePos(camera.getTransform().pos.x, camera.getTransform().pos.y - yStep, camera.getTransform().pos.z);
		}
		if(inputHandler.a.isPressed()) {
			camera.updatePos(camera.getTransform().pos.x - xStep, camera.getTransform().pos.y, camera.getTransform().pos.z);
		}
		if(inputHandler.d.isPressed()) {
			camera.updatePos(camera.getTransform().pos.x + xStep, camera.getTransform().pos.y, camera.getTransform().pos.z);
		}
		//TODO: Game code.
	}

	public static void main(String[] args) {
		Game game = new Game();
		game.start();
	}
}
