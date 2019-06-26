package Chess;
public class ChessCamp {
	private boolean BWFlag;
	private Piece piece[];
	public ChessCamp(boolean BWFlag) {
		piece = new Piece[16];
		this.BWFlag = BWFlag;
			
		if (BWFlag) { // 블랙팀일때! 콘솔대문자
			piece[0]= new King(8, 5,BWFlag);
			piece[1] = new Queen(8, 4,BWFlag);
			piece[2] = new Bishop(8,3,BWFlag);piece[3] = new Bishop(8,6,BWFlag);
			piece[4] = new Knight(8,2,BWFlag); piece[5] = new Knight(8,7,BWFlag);
			piece[6] = new Rook(8,1,BWFlag); piece[7] = new Rook(8,8,BWFlag);
			for(int i = 1; i<= 8 ;i++)
				piece[7+i] = new Pawn(7,i,BWFlag);
			
		}else {
			piece[0]= new King(1, 5,BWFlag);
			piece[1] = new Queen(1, 4,BWFlag);
			piece[2] = new Bishop(1,3,BWFlag);piece[3] = new Bishop(1,6,BWFlag);
			piece[4] = new Knight(1,2,BWFlag); piece[5] = new Knight(1,7,BWFlag);
			piece[6] = new Rook(1,1,BWFlag); piece[7] = new Rook(1,8,BWFlag);
			for(int i = 1; i<= 8 ;i++)
				piece[7+i] = new Pawn(2,i,BWFlag);
		}
	}
	public String getPieceName(int x, int y) {
		for(int i = 0; i<16;i++) {
			if(piece[i].getX() == x && piece[i].getY() == y)
				return piece[i].getName();
		}
	return null;
	}
}
abstract class Piece{ // 먹힌 기물은  x = -1 , y = -1 set
	int x, y;
	boolean color; 
	String name;
	void move(int x, int y) {
		
	}
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
}

class Queen extends Piece {
	public Queen(int x, int y, boolean color) {
		this.x = x ;this.y = y;this.color = color;
		if(color == true)
			name="Q";
		else
			name="q";
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
}

class Knight extends Piece{
	public Knight(int x, int y, boolean color) {
		this.x = x ;this.y = y; this.color = color;
		if(color == true)
			name="K";
		else
			name="k";
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
}

class Pawn extends Piece{
	public Pawn(int x, int y, boolean color) {
		this.x = x ;this.y = y;this.color = color;
		if(color == true)
			name="P";
		else
			name="p";
	}
}
