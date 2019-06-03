package Omok;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseEventHandler implements MouseListener{
	Graphics g;
	public MouseEventHandler(Graphics g) {
		this.g = g;
	}
	public void drawBadukAal(int x, int y) {
		g.setColor(Color.BLACK);
		g.drawOval(x, y, 20, 20);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
			int x = e.getX();
	        int y = e.getY();
	        System.out.println("Mouse Clicked at X: " + x + " - Y: " + y);
	      drawBadukAal(x, y);
	}
	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {	}
}
