package Omok;

import java.awt.Color;


import javax.swing.JFrame;

public class Frames extends JFrame{
	public Frames(String str) {
		JFrame frame = new JFrame(str);
		frame.setSize(800,800);
		frame.getContentPane().setBackground( new Color(255,204,102));
		frame.setVisible(true);
	}
}
