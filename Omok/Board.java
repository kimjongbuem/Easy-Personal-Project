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
		drawBadukAal(g, 1);
	}
	public void drawBadukAal(Graphics g,int isBlack) {
		if(isBlack == 1)// °ËÀº»ö Èæµ¹ Ä¥ÇÔ 
			g.drawOval(10, 10, 30, 30);
		else // ÇÏ¾áµ¹
			g.drawOval(10, 10, 20, 20);
	}
}

//g.fillOval(10, 10, 30, 30); ³ôÀÌ¶û ³ÐÀÌ 30ÀÌÀû´çÇÏ³×..

// 30 50 ³ôÀÌ. 