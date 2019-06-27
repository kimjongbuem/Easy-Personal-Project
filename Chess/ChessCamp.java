package Chess;
public class ChessCamp {
	private boolean BWFlag;
	private Piece piece[];
	public static boolean selection = true;
	public ChessCamp(boolean BWFlag) {
		piece = new Piece[16];
		this.BWFlag = BWFlag;
			
		if (BWFlag) { // �����϶�! �ִܼ빮��
			piece[0]= new King(5, 8,BWFlag);
			piece[1] = new Queen(4, 8,BWFlag);
			piece[2] = new Bishop(3,8,BWFlag);piece[3] = new Bishop(6,8,BWFlag);
			piece[4] = new Knight(2,8,BWFlag); piece[5] = new Knight(7,8,BWFlag);
			piece[6] = new Rook(1,8,BWFlag); piece[7] = new Rook(8,8,BWFlag);
			for(int i = 1; i<= 8 ;i++)
				piece[7+i] = new Pawn(i,7,BWFlag);
			
		}else {
			piece[0]= new King(5, 1,BWFlag);
			piece[1] = new Queen(4, 1,BWFlag);
			piece[2] = new Bishop(3,1,BWFlag);piece[3] = new Bishop(6,1,BWFlag);
			piece[4] = new Knight(2,1,BWFlag); piece[5] = new Knight(7,1,BWFlag);
			piece[6] = new Rook(1,1,BWFlag); piece[7] = new Rook(8,1,BWFlag);
			for(int i = 1; i<= 8 ;i++)
				piece[7+i] = new Pawn(i,2,BWFlag);
		}
	}
	public boolean overLapMoveCheck(int moveX, int moveY) {
		return true;
	}
	public Piece getPiece(int x, int y) {
		for(int i = 0; i<16;i++) {
			if(piece[i].getX() == x && piece[i].getY() == y)
				return piece[i];
		}
		return null;
	}
	public String getPieceName(int x, int y) {
		for(int i = 0; i<16;i++) {
			if(piece[i].getX() == x && piece[i].getY() == y)
				return piece[i].getName();
		}
	return null;
	}
	public void move(int curX, int curY, int moveX, int moveY) {
			Piece pieceInfo = getPiece(curX, curY);
			if(pieceInfo.getTeamColor() == selection) {
				pieceInfo.move(curX, curY, moveX, moveY);
			}else {
				System.out.println("�߸��� ���÷� ���� �����Ͽ����ϴ�.");
				return;
			}
			ChessCamp.selection = !ChessCamp.selection;
	}
	public boolean getSelection() {
		return selection;
	}
	public void setSelection(boolean info) {
		selection = info;
	}
	abstract class Piece{ // ���� �⹰��  x = -1 , y = -1 set
		int x, y;
		boolean color; 
		String name;
		public abstract void move(int curX, int curY, int moveX, int moveY);
		public void setName(String name) {
			this.name = name;
		}
		public String getName() {
			return name;
		}
		public int getX() {
			return x;
		}
		public int getY() {
			return y;
		}
		public void setX(int x) {
			this.x = x;
		}
		public void setY(int y) {
			this.y = y;
		}
		public boolean getTeamColor() {
			return color; // ���̸� �� , �޽��� ȭ��Ʈ
		}
	}
	class King extends Piece{

		public King(int x, int y, boolean color) {
			this.x = x ;this.y = y; this.color = color;
			if(color == true)
				name="K";
			else
				name="k";
		}
		public int getKingX() {
			return x;
		}
		public int getKingY() {
			return y;
		}
		public void setKingX(int x) {
			this.x = x; 
		}
		public void setKingY(int y) {
			this.y = y; 
		}
		@Override
		public void move(int curX, int curY, int moveX, int moveY) {
			// TODO Auto-generated method stub
			
		}
	}

	class Queen extends Piece {
		public Queen(int x, int y, boolean color) {
			this.x = x ;this.y = y;this.color = color;
			if(color == true)
				name="Q";
			else
				name="q";
		}
		@Override
		public void move(int curX, int curY, int moveX, int moveY) {
			// TODO Auto-generated method stub
			
		}
	}

	class Bishop extends Piece{
		public Bishop(int x, int y, boolean color) {
			this.x = x ;this.y = y; this.color = color;
			if(color == true)
				name="B";
			else
				name="b";
		}
		@Override
		public void move(int curX, int curY, int moveX, int moveY) {
			// TODO Auto-generated method stub
			
		}
	}

	class Knight extends Piece{
		public Knight(int x, int y, boolean color) {
			this.x = x ;this.y = y; this.color = color;
			if(color == true)
				name="K";
			else
				name="k";
		}
		@Override
		public void move(int curX, int curY, int moveX, int moveY) {
			// TODO Auto-generated method stub
			
		}
	}

	class Rook extends Piece{
		public Rook(int x, int y, boolean color) {
			this.x = x ;this.y = y; this.color = color;
			if(color == true)
				name="R";
			else
				name="r";
		}
		@Override
		public void move(int curX, int curY, int moveX, int moveY) {
			// TODO Auto-generated method stub
			
		}
	}

	class Pawn extends Piece{
		private boolean overLap; // �ش� ���� ó�������� �� �� ��ĭ�� �ƹ��� ������ 2ĭ ������ but �⹰�ִٸ� �ȵ�.
		public Pawn(int x, int y, boolean color) {
			overLap = false;
			this.x = x ;this.y = y;this.color = color;
			if(color == true)
				name="P";
			else
				name="p";
		}
		@Override
		public void move(int curX, int curY, int moveX, int moveY) {
			System.out.println("������ testing,..");
		    if(color) {// �� ���̶�� y ��ǥ ����ĭ - �����̴� ĭ = 1 or 2ĭ �����ϼ� ����... ���⹰ ���ҽ� x+/-ĭ �̵�����.
		    	if(curY - moveY == 1 && moveX == curX && getPieceName(moveX, moveY) ==null) {// 1ĭ ������ �����̱Ⱑ��..
		    		overLap = true; // ���̻� 2ĭ �ѹ��� ����^^
		    		setX(moveX); setY(moveY);
		    	}
		    	else if(curY - moveY == 2 && moveX == curX && overLapMoveCheck(moveX, moveY) && !overLap) { //������ ��ĭ �����̱� ������.
		    		overLap = true;
		    		setX(moveX); setY(moveY);
		    	}
		    }else { // ȭ��Ʈ ��
		    	if(curY - moveY == -1 && moveX == curX && getPieceName(moveX, moveY) ==null) {// 1ĭ ������ �����̱Ⱑ��..
		    		overLap = true; // ���̻� 2ĭ �ѹ��� ����^^
		    		setX(moveX); setY(moveY);
		    	}
		    	else if(curY - moveY == -2 && moveX == curX && overLapMoveCheck(moveX, moveY) && !overLap) { //������ ��ĭ �����̱� ������.
		    		overLap = true;
		    		setX(moveX); setY(moveY);
		    	}
		    }
			
		}
	}
}

