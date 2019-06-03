package Omok;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Component extends JComponent{
	public void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		for(int cnt = 0; cnt<=19;cnt++)
		g.drawLine(40*cnt + 20, 20, 40*cnt + 20, 780);
		
		for(int cnt = 0; cnt<=19;cnt++)
			g.drawLine(20, 40*cnt + 20, 780 , 40*cnt + 20);
	}
}

//g.fillOval(10, 10, 30, 30); ³ôÀÌ¶û ³ÐÀÌ 30ÀÌÀû´çÇÏ³×..