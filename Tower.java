package td.GameObjects.towers;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import td.GameObjects.GameObject;
import td.main.Game;
//TODO: SmallTower.java silinecek.Onun yerine Tower'a ID veya Type parametresini vereceðiz
//Ona göre çalýþacak.

public class Tower extends GameObject{
	int x,y,w,h;
	BufferedImage img;
	String path;
	Bullet bullet;
	
	public void setBullet(int r,float speed,float delaySeconds, Color c){
		bullet = new Bullet(x+w/2,y+h/2,r,speed,delaySeconds,c);
	}
	
	public Tower(int x,int y,int w,int h,int bulletsSize,String path) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.path = path;
		bullet = new Bullet(x+w/2,y+h/2,4,2.0f,1,Color.cyan);
		
		
		try {
			this.img = ImageIO.read(new File(path));
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void tick() {
		bullet.tick();
	}

	@Override
	public void draw(Graphics2D g) {
		bullet.draw(g);
		g.drawImage(img, x, y,Game.TileSize,Game.TileSize, null);
	}
	
	public class Bullet{
		double x,y;
		int r;
		Color c;
		double angle;
		float speed;
		float delaySeconds;
		int delay = 0;
		
		public Bullet(int x, int y,int r,float speed,float delaySeconds, Color c) {
			this.x = x;
			this.y = y;
			this.r = r;
			this.c = c;
			
			angle = rotateTo(0,0);
			
			this.speed = speed;
			this.delaySeconds = delaySeconds;
		}
		
		
		
		public void tick() {
			
			if(delay < delaySeconds/60) {
				delay++;
				System.out.println(delay);
			}else {
				x -= Math.cos(Math.toRadians(angle)) * speed;
				y -= Math.sin(Math.toRadians(angle)) * speed;
			}
		}
		
		public double rotateTo(double x,double y) {
			return (Math.atan2(this.y - y,this.x - x) * 180 / Math.PI);
		}
		
		public void draw(Graphics2D g) {
			g.setColor(c);
			g.fillOval((int)x, (int)y, r, r);	
		}
		
	}
}
