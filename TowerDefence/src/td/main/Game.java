package td.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import td.GameObjects.Handler;
import td.GameObjects.Map;
import td.GameObjects.TowerCursor;
import td.GameObjects.towers.SmallTower;
import td.GameObjects.towers.TowerHandler;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends JPanel implements Runnable,KeyListener,MouseListener{

	public static final int PanelWidth = 1200;
	public static final int PanelHeight = 800;
	public static final int TileSize = 48;
	private static final long serialVersionUID = -5246381792916149133L;
	private boolean running;
	
	public static final int MapRow = 20;
	public static final int MapCol = 15;
	
	
	BufferedImage img;
	TowerCursor towercursor;
	Handler handler;
	TowerHandler towerHandler;
	
	boolean[][]map_empty;
	public Game() {
		
		try {
			img = ImageIO.read(new File("res/Tank.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		running = true;
		towercursor = new TowerCursor();
		handler = new Handler();
		towerHandler = new TowerHandler();
		
		handler.addObject(new Map(MapRow,MapCol));
		map_empty = new boolean[MapRow][MapCol];
		
		for (int r = 0; r < MapRow; r++) {
			for (int c = 0; c < MapCol; c++) {
				map_empty[r][c] = false;
			}
		}
//		Panel ile ilgili basit ayarlar
		setBounds(0,0,PanelWidth,PanelHeight);
		requestFocus(); 
		addKeyListener(this);
		addMouseListener(this);
		setFocusTraversalKeysEnabled(false);
		setFocusable(true);
		
		Thread t = new Thread(this);
		t.start(); 
	}
	
	public void tick() {
		handler.tick();
		towerHandler.tick();
		towercursor.tick();
	}
	

	@Override
	public void paint(Graphics a) {
//		Daha kullanýþlý bir sýnýf Graphics2D
		Graphics2D g = (Graphics2D) a;
		
		g.clearRect(0, 0, PanelWidth, PanelHeight);
		handler.draw(g);
		
		g.drawImage(img, 1056, 0, Game.TileSize, Game.TileSize, null);
		towerHandler.draw(g);
		towercursor.draw(g);
	}
	
	@Override
	public void run() {
		while(true) {
			long lastTime = System.nanoTime();
			double deltaU = 0,deltaF = 0;
			int FPS = 60;
			int UPS = 60;
			final double timeU = 1000000000 / UPS;
			final double timeF = 1000000000 / FPS;
			
			while(running) {
				long now = System.nanoTime();
				
				deltaF += (now - lastTime) / timeF;
				deltaU += (now - lastTime) / timeU;
				lastTime = now;
				
				if(deltaU >= 1) {
					tick();
					deltaU--;
				}
				
				if(deltaF >= 1) {
					repaint();
					deltaF--;
				}
				
				
			}
		}
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(0);
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		addTower();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	
	//Kule eklerken konsolun çizdiði bulanýk görseli silip yerine Tower objesi ekliyor.
	void addTower() {
		if(!towercursor.getVisible()) {
			if(towercursor.getX() == 1056 && towercursor.getY()==0) {
				towercursor.setImage("res/Tank.png");
				towercursor.setVisible(true);
			}
		}else {
			towercursor.setVisible(false);
			
			if(towercursor.getX() > (MapRow-1)*Game.TileSize || towercursor.getY() > (MapCol-1)*Game.TileSize) {
				JOptionPane.showMessageDialog(this, "Hocam ora yassssssssssak");	
			}
			else if((map_empty[towercursor.getX()/Game.TileSize][towercursor.getY()/Game.TileSize] == true) ) {	
				JOptionPane.showMessageDialog(this, "Hocam ora yassssssssssak");
			}
			else {
				System.out.println(towercursor.getX());
				towerHandler.addTower(new SmallTower(towercursor.getX(),towercursor.getY(),Game.TileSize,Game.TileSize,"res/Tank.png"));
				map_empty[towercursor.getX()/Game.TileSize][towercursor.getY()/Game.TileSize] = true;
			}
			System.out.println(towerHandler.towers.size());
		}	
		
	}

	
	
	
}
