package KTEngine.Game;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Screen extends Canvas {
	
	private BufferStrategy bs;
	private int width;
	private int height;
	private Dimension size;
	private BufferedImage image;
	private int[] pixels;
	private static final long serialVersionUID = 1L;
	
	public Screen(int WIDTH, int HEIGHT) {
		size = new Dimension(WIDTH,HEIGHT);
		width = size.width;
		height = size.height;
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	}
	
	public void render() {
		bs = getBufferStrategy(); // Why do we have to get this every single render cycle? Shouldn't it stay constant?

		if(bs == null){
			createBufferStrategy(3);
			requestFocus(); // Idk why, maybe it forces SWING to process the buffer strategy request?
			return;
		}

		Graphics g = bs.getDrawGraphics();
		g.drawImage(image,0,0,null);
		g.dispose();
		bs.show();
	}
	
	
	public void setPixel(int x, int y, int red, int green, int blue) {
		pixels[width * y + x] = (red<<16) | (green<<8) | blue;
	}
}
