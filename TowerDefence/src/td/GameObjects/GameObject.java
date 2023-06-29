package td.GameObjects;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public abstract class GameObject {
	
	public int x,y,w,h;
	
	public abstract void tick();
	public abstract void draw(Graphics2D g);
	
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
