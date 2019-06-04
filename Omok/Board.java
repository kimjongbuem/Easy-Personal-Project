package Omok;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Board extends JPanel{
	/**
	 * 
	 */
	public int STONE_ZIZE = 30;
	private BadukMap map;
	private static final long serialVersionUID = 1L;
	public Board(BadukMap map) {
		this.map = map;
		
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(new Color(255,204,102));
		g.setColor(Color.BLACK);
		for(int cnt = 0; cnt<=19;cnt++)
			g.drawLine(40*cnt + 20, 20, 40*cnt + 20, 780);
		for(int cnt = 0; cnt<=19;cnt++)
			g.drawLine(20, 40*cnt + 20, 780 , 40*cnt + 20);
		drawBadukAal(g, map.getFlagIsBlack());
	}
	public void drawBadukAal(Graphics g, boolean isBlack) {
		for(int y = 1;y<=20;y++) {
			for(int x = 1;x<= 20;x++) {
				if(map.getBadukState(x, y)== BadukColor.BLACK)
				{
					g.setColor(Color.BLACK);
					g.fillOval((x-1)*MapSize.ONEBLOCK_SIZE + 5, (y-1)*MapSize.ONEBLOCK_SIZE + 7, MapSize.BLOCK_SIZE, MapSize.BLOCK_SIZE);
				}
				else if(map.getBadukState(x, y) == BadukColor.WHITE)
				{
					g.setColor(Color.WHITE);
					g.fillOval((x-1)*MapSize.ONEBLOCK_SIZE + 5, (y-1)*MapSize.ONEBLOCK_SIZE + 7, MapSize.BLOCK_SIZE, MapSize.BLOCK_SIZE);
				}
			}
		}
	}
}
