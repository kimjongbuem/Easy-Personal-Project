package Omok;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Frames extends JFrame{
	public Frames(String str) {
		JFrame frame = new JFrame(str);
		frame.setSize(830,830);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		BadukMap map = new BadukMap();
		Board board = new Board(map);
		frame.add(board);
		frame.addMouseListener(new MouseEventHandler(this, map, board));
		frame.setVisible(true);
	}
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}
