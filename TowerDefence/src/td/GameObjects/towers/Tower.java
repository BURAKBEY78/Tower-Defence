package td.GameObjects.towers;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import td.GameObjects.GameObject;


//TODO: SmallTower.java silinecek.Onun yerine Tower'a ID veya Type parametresini vereceðiz
//Ona göre çalýþacak.

public class Tower extends GameObject{
	int x,y,w,h,mouse_x,mouse_y;
	boolean clicked;
	BufferedImage img;
	String path;
	
	public Tower(int x,int y,int w,int h,String path) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.path = path;
		try {
			this.img = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public Rectangle getBounds() {
		return new Rectangle(x,y,w,h);
	}




	
}
