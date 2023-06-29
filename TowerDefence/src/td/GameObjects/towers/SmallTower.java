package td.GameObjects.towers;

import java.awt.Graphics2D;


public class SmallTower extends Tower{
	
	
	boolean clicked = true;
	int mouse_x,mouse_y;
	
	public SmallTower(int x, int y, int w, int h, String path) {
		super(x, y, w, h, path);
	}

	@Override
	public void draw(Graphics2D g) {
		g.drawImage(img, x, y, w, h, null);
	}

	@Override
	public void tick() {
		
	}
	
	

}
