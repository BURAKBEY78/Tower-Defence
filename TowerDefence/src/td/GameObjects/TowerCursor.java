package td.GameObjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import td.main.Game;

public class TowerCursor extends GameObject{
	
	private int mouse_x,mouse_y;
	BufferedImage img;
	private boolean visible;
	
	public TowerCursor() {
		
	}
	
	public TowerCursor(String path) {
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void tick() {
		mouse_x = MouseInfo.getPointerInfo().getLocation().x;
		mouse_y = MouseInfo.getPointerInfo().getLocation().y;
		
		if(mouse_x % Game.TileSize != 0) {
			mouse_x -= mouse_x % Game.TileSize;
		}if(mouse_y % Game.TileSize != 0) {
			mouse_y -= mouse_y % Game.TileSize;
		}
		
		setX(mouse_x);
		setY(mouse_y);
	}

	@Override
	public void draw(Graphics2D g) {
		if(visible) {
			g.drawImage(img, x, y, Game.TileSize, Game.TileSize, null);
			g.setColor(new Color(0,255,0,100));
			g.fillRect(x, y, Game.TileSize, Game.TileSize);
		}
	}
	
	public void setImage(String path) {
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void setVisible(boolean visible) {
		this.visible = visible;
	}public boolean getVisible() {
		return visible;
	}
	
}
