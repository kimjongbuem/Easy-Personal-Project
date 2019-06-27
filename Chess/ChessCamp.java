package Chess;
public class ChessCamp {
	private boolean BWFlag;
	private Piece piece[];
	public static boolean selection = true;
	public ChessCamp(boolean BWFlag) {
		piece = new Piece[16];
		this.BWFlag = BWFlag;
			
		if (BWFlag) { // 블랙팀일때! 콘솔대문자
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
				System.out.println("잘못된 팀컬러 말을 선택하였습니다.");
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
	abstract class Piece{ // 먹힌 기물은  x = -1 , y = -1 set
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
			return color; // 참이면 블랙 , 펄스면 화이트
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
		private boolean overLap; // 해당 폰이 처음움직일 때 앞 두칸에 아무도 없으면 2칸 움직임 but 기물있다면 안됨.
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
			System.out.println("폰진입 testing,..");
		    if(color) {// 흑 팀이라면 y 좌표 현재칸 - 움직이는 칸 = 1 or 2칸 움직일수 있음... 적기물 취할시 x+/-칸 이동가능.
		    	if(curY - moveY == 1 && moveX == curX && getPieceName(moveX, moveY) ==null) {// 1칸 밑으로 움직이기가능..
		    		overLap = true; // 더이상 2칸 한번에 못감^^
		    		setX(moveX); setY(moveY);
		    	}
		    	else if(curY - moveY == 2 && moveX == curX && overLapMoveCheck(moveX, moveY) && !overLap) { //밑으로 두칸 움직이기 가능함.
		    		overLap = true;
		    		setX(moveX); setY(moveY);
		    	}
		    }else { // 화이트 팀
		    	if(curY - moveY == -1 && moveX == curX && getPieceName(moveX, moveY) ==null) {// 1칸 밑으로 움직이기가능..
		    		overLap = true; // 더이상 2칸 한번에 못감^^
		    		setX(moveX); setY(moveY);
		    	}
		    	else if(curY - moveY == -2 && moveX == curX && overLapMoveCheck(moveX, moveY) && !overLap) { //밑으로 두칸 움직이기 가능함.
		    		overLap = true;
		    		setX(moveX); setY(moveY);
		    	}
		    }
			
		}
	}
}

