package Omok;

import java.awt.Color;
//import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Frames extends JFrame implements MouseListener{
	public Frames(String str) {
		JFrame frame = new JFrame(str);
		frame.setSize(830,830);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground( new Color(255,204,102));
		frame.add(new Component());
		frame.addMouseListener(this);
		frame.setVisible(true);
	}

	public void drawBadukAal(int x, int y) {
		this.getGraphics().setColor(Color.BLACK);
		this.getGraphics().drawOval(x, y, 20, 20);
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
