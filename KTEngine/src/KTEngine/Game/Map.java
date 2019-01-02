package KTEngine.Game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import javax.imageio.ImageIO;

public class Map {

	private String mapImgPath;
	private String mapStrReference;
	private HashMap<Integer, String> colorNameKeyPair; 	// The key's (color) representation is open to change depending
														// on how the color is represented in the images.
	private ArrayList<String> mapLayout;
	private BufferedImage mapLayoutImg;
	private int mapWidth;
	private int mapHeight;
	private double worldToPxRatio;
	private int pxSqrLength;
	
	
	public Map(String mapImgPath, String mapStrReference, double worldToPxRatio, int pxSqrLength) {
		this.mapImgPath = mapImgPath;
		this.mapStrReference = mapStrReference;
		colorNameKeyPair = new HashMap<Integer, String>();
		this.worldToPxRatio = worldToPxRatio;
		this.pxSqrLength = pxSqrLength;
		mapLayout = new ArrayList<String>();
		this.load();
	}
	
	private void load() {
		this.buildRefrenceHashMap();
		this.buildMapLayout();
	}
	
	private void buildRefrenceHashMap() {
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(mapStrReference))) {
		    String line = null;
		    while ((line = reader.readLine()) != null) {
		    	String[] split = line.split(":");
		    	System.out.println();
		    	int color = Integer.parseInt(split[0], 16);
		    	String spritePath = split[1];
		        colorNameKeyPair.put(color, spritePath);
		    }
		} catch (IOException x) {
		    System.err.format("IOException: %s%n", x);
		}
	}
	
	private void buildMapLayout() {
		try {
			
			BufferedImage mapImg = ImageIO.read(new File(mapImgPath));
			mapWidth = mapImg.getWidth();
			mapHeight = mapImg.getHeight();
			mapLayoutImg = new BufferedImage(mapWidth, mapHeight,BufferedImage.TYPE_INT_RGB);
	
		    Graphics2D g = mapLayoutImg.createGraphics();
		    g.drawImage(mapImg, 0, 0, mapWidth, mapHeight, null);
		    g.dispose();
		    
		   	int[] texels = ((DataBufferInt)mapLayoutImg.getRaster().getDataBuffer()).getData();
		   	for (int i = 0; i < texels.length; i++) {
		   		String sprite = colorNameKeyPair.get(texels[i]);
		   		if(sprite != null) {
		   			mapLayout.add(sprite);
		   		}
		   	}
		} catch (IOException e) {
			
		}
	}
	
	public ArrayList<ViewableGameObject> getMap() {
		ArrayList<ViewableGameObject> map = new ArrayList<ViewableGameObject>();
		for(int y = 0; y < mapHeight; y++) {
			for(int x = 0; x < mapWidth; x++) {
				int index = y * mapWidth + x;
				if(mapLayout.get(index).equals("empty")) {
					continue;
				}
				ViewableGameObject tile = new ViewableGameObject(new Sprite(mapLayout.get(index), worldToPxRatio));
				double pixelsMakeUpX = ((1 - (tile.getSprite().getWidth()/pxSqrLength)) * pxSqrLength)/2;
				double pixelsMakeUpY = ((1 - (tile.getSprite().getHeight()/pxSqrLength)) * pxSqrLength)/2;
				
				tile.transform.pos.x = (x * pxSqrLength) * worldToPxRatio - (pixelsMakeUpX * worldToPxRatio);
				tile.transform.pos.y = (-y * pxSqrLength) * worldToPxRatio + (pixelsMakeUpY * worldToPxRatio);
				
				tile.updateRec();
				map.add(tile);
			}
		}
		return map;
	}
}
