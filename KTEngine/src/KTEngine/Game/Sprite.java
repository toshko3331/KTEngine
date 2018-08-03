package KTEngine.Game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Sprite {

	private BufferedImage content;
	private int[] texels;
	private int width;
	private int height;
	private String imagePath;
	private float worldUnitsToPixelRatio; // No setter for now because if it changes from the 
										// default the Sprite's world space rectangle needs to be recalculated. 
										// A system that invalidates the rectangle and forces a recalculation in the  
										// ViewableGameObject class needs to be implemented first.
	
	public Sprite(String imagePath) {
		worldUnitsToPixelRatio = 1.0f / 100.0f; //For every one world unit, there are 100 pixels.
		this.imagePath = imagePath;
		try {
			//Reason for not loading it directly to content is because the 
			//imageType parameter needs to equal "BufferedImage.TYPE_INT_RGB"
			BufferedImage tempImg = ImageIO.read(new File(imagePath));
			int tempWidth = tempImg.getWidth();
			int tempHeight = tempImg.getHeight();
			content = new BufferedImage(tempWidth, tempHeight, BufferedImage.TYPE_INT_RGB);//TODO: Eventually change to ARGB.
		
		    Graphics2D g = content.createGraphics();
		    g.drawImage(tempImg, 0, 0, tempWidth, tempHeight, null);
		    g.dispose();
		    
		    texels = ((DataBufferInt)content.getRaster().getDataBuffer()).getData();
		} catch (IOException e) {
		}
		width = content.getWidth();
		height = content.getHeight();
	}
	
	public BufferedImage getImage() {
		return content;
	}
	
	public float getWorldUnitsToPixelRatio(){
		return worldUnitsToPixelRatio;
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int[] getTexels() {
		return texels;
	}
	
	public int getTexel(int index) {
		return texels[index];
	}
	
	public int getTexel(int x, int y) {
		return texels[width * y + x];
	}
	
	public String getImagePath() {
		return imagePath;
	}
	
}
