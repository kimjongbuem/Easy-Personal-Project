package Omok;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Frames extends JFrame{
	public Frames(String str) {
		JFrame frame = new JFrame(str);
		frame.setSize(840,840);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground( new Color(255,204,102));
		frame.add(new Component());
		frame.setVisible(true);
	}
}
