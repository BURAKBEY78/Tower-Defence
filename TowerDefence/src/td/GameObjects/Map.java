package td.GameObjects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

import td.main.Game;

import java.io.FileReader;

public class  Map extends GameObject{
	private int row,col;
	

	private int[][] map;
	
	public Map(int row,int col) {
		this.row = row;
		this.col = col;
		map = new int[row][col];
		File f = new File("Map.txt");
		
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			int c = 0;
			int r = 0;
			String line;
			
			while(c < col) {
				line = br.readLine();
				String[] split_line = line.split(" ");
				while (r < row) {
					int num = Integer.parseInt(split_line[r]);
					map[r][c] = num;
					r++;
				}
				r = 0;
				c++;
			}
			br.close();
			fr.close();
			
		
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
		for (int row = 0; row < map.length; row++) {
			for (int col = 0; col < map[0].length; col++) {
				if(map[row][col] == 0) {
					g.setColor(Color.green);
					g.fillRect(row * Game.TileSize, col * Game.TileSize, Game.TileSize, Game.TileSize);
				}else if(map[row][col] == 1) {
					g.setColor(new Color(200,100,50));
					g.fillRect(row * Game.TileSize, col * Game.TileSize, Game.TileSize, Game.TileSize);
				}g.setColor(Color.black);
				g.drawRect(row * Game.TileSize, col * Game.TileSize, Game.TileSize, Game.TileSize);
					
			}
		}
		
	}
	
	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}
	
}
