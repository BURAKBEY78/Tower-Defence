package td.GameObjects;

import java.awt.Graphics2D;
import java.util.ArrayList;


public class Handler extends GameObject{
public ArrayList<GameObject> objects = new ArrayList<>();

	
	@Override
	public void tick() {
		for(int i = 0;i < objects.size();i++) {
			objects.get(i).tick();
		}
	}

	@Override
	public void draw(Graphics2D g) {	
		for(int i = 0;i < objects.size();i++) {
			objects.get(i).draw(g);
		}
	}
	
	public void addObject(GameObject go) {
		objects.add(go);
	}
	
	public void removeObject(GameObject go) {
		objects.remove(go);
	}
	
	public void removeObject(int index) {
		objects.remove(index);
	}

}
