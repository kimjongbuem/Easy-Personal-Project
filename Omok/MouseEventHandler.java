package Omok;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseEventHandler extends MouseAdapter{
	Frames gui;
	BadukMap map;
	Board board;
	public MouseEventHandler(Frames frame, BadukMap map, Board board) {
		gui = frame;
		this.map = map; this.board = board;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
			int x = (int)Math.round((e.getX()+20)/MapSize.BLOCK_SIZE);
	        int y = (int)Math.round((e.getY())/MapSize.BLOCK_SIZE);
	        System.out.println("Mouse Clicked at X: " + x + " - Y: " + y);
	        System.out.println("Mouse Clicked at X: " + e.getX() + " - Y: " + e.getY());
	      if(x < 1 || x > 20 || y < 1 || y> 20) {
	    	  // �޽���â �ùٸ����� ���ּ���!!
	    	  return;
	      }
	      if(!(map.getBadukState(x, y) == BadukColor.NONE)){
	    	  //�̵̹��� �÷��� �ֽ��ϴ� �޽���â����
	    	  return;
	      }
	      map.setMap(map.getFlagIsBlack(), x, y);
	      map.setFlagisBlack();
	      board.repaint();
	      // if() �¸���
	}
}
