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
			int x = (int)Math.round((e.getX()+20)/MapSize.ONEBLOCK_SIZE);
	        int y = (int)Math.round((e.getY())/MapSize.ONEBLOCK_SIZE);
	        System.out.println("Mouse Clicked at X: " + x + " - Y: " + y);
	        System.out.println("Mouse Clicked at X: " + e.getX() + " - Y: " + e.getY());
	      if(x < 1 || x > 20 || y < 1 || y> 20) {
	    	  gui.showMessage("잘못된 입력입니다!");
	    	  return;
	      }
	      if(!(map.getBadukState(x, y) == BadukColor.NONE)){
	    	  gui.showMessage("이미 바둑알이 올려져 있는 곳입니다!");
	    	  return;
	      }
	      map.setMap(map.getFlagIsBlack(), x, y);
	      
	      board.repaint();
	      if(map.checkWin(x, y)) //승리시
	      {		
	    	  if(map.getFlagIsBlack())
	    		  gui.showMessage("흑돌이 승리하였습니다!");
	    	  else
	    		  gui.showMessage("백돌이 승리하였습니다!");
	    	  System.exit(0);
	      }
	      
	      map.setFlagisBlack();
	}
}
