package td.GameObjects.towers;

import java.awt.Graphics2D;
import java.util.ArrayList;

public class TowerHandler{
	public ArrayList<Tower> towers = new ArrayList<>();
	

	public void draw(Graphics2D g) {
		for (int i = 0; i < towers.size(); i++) {
			towers.get(i).draw(g);
		}
	}

	public void tick() {
		for (int i = 0; i < towers.size(); i++) {
			towers.get(i).tick();
		}
	}
	
	public void addTower(Tower t) {
		towers.add(t);
	}
	
	public void deleteTower(Tower t) {
		towers.remove(t);
	}
	
}
