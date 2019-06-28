package Chess;
public class ChessCamp {
	private boolean BWFlag;
	private Piece piece[];
	private int totalCount = 0;
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
	public void move(int curX, int curY, int moveX, int moveY, ChessCamp otherCamp) {
			Piece pieceInfo = getPiece(curX, curY);
			if(pieceInfo.getTeamColor() == selection) {
				pieceInfo.move(moveX, moveY, otherCamp);
			}else {
				System.out.println("�߸��� ���÷� ���� �����Ͽ����ϴ�.");
				return;
			}
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
		public abstract void move(int moveX, int moveY, ChessCamp otherCamp);
		public void setName(String name) {
			this.name = name;
		}
		public abstract boolean overLapMove(int moveX, int moveY , ChessCamp otherCamp);
		public abstract boolean otherCampCatch(int moveX, int moveY , ChessCamp otherCamp);
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
		public void move(int moveX, int moveY, ChessCamp otherCamp) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public boolean overLapMove(int moveX, int moveY , ChessCamp otherCamp) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean otherCampCatch(int moveX, int moveY, ChessCamp otherCamp) {
			// TODO Auto-generated method stub
			return false;
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
		public void move(int moveX, int moveY, ChessCamp otherCamp) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public boolean overLapMove(int moveX, int moveY, ChessCamp otherCamp ) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean otherCampCatch(int moveX, int moveY, ChessCamp otherCamp) {
			// TODO Auto-generated method stub
			return false;
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
		public void move(int moveX, int moveY, ChessCamp otherCamp) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public boolean overLapMove(int moveX, int moveY , ChessCamp otherCamp) {
			// TODO Auto-generated method stub
			return false;
		}
		@Override
		public boolean otherCampCatch(int moveX, int moveY, ChessCamp otherCamp) {
			// TODO Auto-generated method stub
			return false;
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
		public void move(int moveX, int moveY, ChessCamp otherCamp) {
			System.out.println("����Ʈ testing...");
			if (upperMove(moveX, moveY, otherCamp) || downMove(moveX, moveY, otherCamp) ||
				leftMove(moveX, moveY, otherCamp)||rightMove(moveX, moveY, otherCamp)) {
				setX(moveX);
				setY(moveY);
				ChessCamp.selection = !ChessCamp.selection; // �̵������ø� �÷��� �ٲ���!!
			}
			else System.out.println("�ش� �⹰�� �ش� ���� ���� �̵� �� �� �����ϴ�.");			
		}
		@Override
		public boolean overLapMove(int moveX, int moveY , ChessCamp otherCamp) {return false;}
		@Override
		public boolean otherCampCatch(int moveX, int moveY, ChessCamp otherCamp) {
			if (otherCamp.getPieceName(moveX, moveY) == null) // ���⹰ ������ false
				return false;
			otherCamp.getPiece(moveX, moveY).setX(-1); // �ٽþȳ����� -1 ���־���.
			return true;
		}
		// ȭ��Ʈ �������� �Լ���.. //
		public boolean upperMove(int moveX, int moveY, ChessCamp otherCamp) {
			// ȭ��Ʈ ������ ���������� ���� ����Ʈ.... ���� ������ �����ϳ� ���� �� ȭ��Ʈ���� ���̴¹�������..
			int curX = getX(); int curY = getY(); 
			if(moveX - curX == 1) ; else if(moveX - curX == -1); else return false;
			if(moveY - curY == 2 ) {
				if(getPieceName(moveX, moveY)!= null) // �Ʊ��⹰�� �ִٸ�..
					return false;
				else if (otherCampCatch(moveX, moveY, otherCamp))
					return true; // ������ ��ġ�� �� �⹰�� ��´�.
			}else return false;
			return true;
		}
		public boolean rightMove(int moveX, int moveY, ChessCamp otherCamp) {
			int curX = getX(); int curY = getY(); 
			if(moveY - curY == 1) ; else if(moveY - curY == -1); else return false;
			if(moveX - curX == 2 ) {
				if(getPieceName(moveX, moveY)!= null) // �Ʊ��⹰�� �ִٸ�..
					return false;
				else if (otherCampCatch(moveX, moveY, otherCamp))
					return true; // ������ ��ġ�� �� �⹰�� ��´�.
			}else return false;
			return true;
		}
		public boolean downMove(int moveX, int moveY, ChessCamp otherCamp) {
			int curX = getX(); int curY = getY(); 
			if(moveX - curX == 1) ; else if(moveX - curX == -1); else return false;
			if(moveY - curY == -2 ) {
				if(getPieceName(moveX, moveY)!= null) // �Ʊ��⹰�� �ִٸ�..
					return false;
				else if (otherCampCatch(moveX, moveY, otherCamp))
					return true; // ������ ��ġ�� �� �⹰�� ��´�.
			}else return false;
			return true;
		}
		public boolean leftMove(int moveX, int moveY, ChessCamp otherCamp) {
			int curX = getX(); int curY = getY(); 
			if(moveY - curY == 1) ; else if(moveY - curY == -1); else return false;
			if(moveX - curX == -2 ) {
				if(getPieceName(moveX, moveY)!= null) // �Ʊ��⹰�� �ִٸ�..
					return false;
				else if (otherCampCatch(moveX, moveY, otherCamp))
					return true; // ������ ��ġ�� �� �⹰�� ��´�.
			}else return false;
			return true;
		}
	}

	class Rook extends Piece{
		// ���� y�� �̵� �϶��� �������� ���� �ٸ��� �ָ� �ȴ�. x�� �̵��ÿ��� ���� ���� �̵� ���� ����̾��� ����... 
		public Rook(int x, int y, boolean color) {
			this.x = x ;this.y = y; this.color = color;
			if(color == true)
				name="R";
			else
				name="r";
		}
		@Override
		public void move(int moveX, int moveY, ChessCamp otherCamp) {
			System.out.println("�� testing...");
			if (overLapMove(moveX, moveY, otherCamp)) {
				setX(moveX);
				setY(moveY);
				ChessCamp.selection = !ChessCamp.selection; // �̵������ø� �÷��� �ٲ���!!
			}
			else System.out.println("�ش� �⹰�� �ش� ���� ���� �̵� �� �� �����ϴ�.");
		}
		@Override
		public boolean overLapMove(int moveX, int moveY , ChessCamp otherCamp) {
			int curX = getX();
			if(curX == moveX) { // ������ ������ 
				return overLapMoveY(moveY, otherCamp);
			}
			else { // ���� ������
				return overLapMoveX(moveX, otherCamp);
			}
		}
		@Override
		public boolean otherCampCatch(int moveX, int moveY, ChessCamp otherCamp) {
			if (otherCamp.getPieceName(moveX, moveY) == null) // ���⹰ ������ false
				return false;
			otherCamp.getPiece(moveX, moveY).setX(-1); // �ٽþȳ����� -1 ���־���.
			return true;
		}
		
		public boolean overLapMoveX(int moveX, ChessCamp otherCamp) {
			int curX = getX();
			int curY = getY();
			int num = moveX - curX;

			if (num > 0) { // ������ �̵���....
				for (int i = 1; i <= num - 1; i++) {
					if (getPieceName(curX + i, curY) != null || otherCamp.getPieceName(curX + i, curY) != null) {
						return false;
					}
				}
				if (getPieceName(curX+ num, curY ) != null) return false;
			} else { // �����̵���....
				num = -num;
				for (int i = 1; i <= num - 1; i++) {
					if (getPieceName(curX - i, curY) != null || otherCamp.getPieceName(curX - i, curY) != null) {
						return false;
					}
				}
				if (getPieceName(curX - num, curY ) != null) return false;
			}
			if (otherCampCatch(moveX, curY, otherCamp))
				return true; // �ش��������� �ٸ� �⹰�� ���� ������ ��ġ�� �� �⹰�� ��´�.
			
			return true; // �ش� �������� �ٸ� �⹰�̾�����.. oK!
		}
		
		
		public boolean overLapMoveY(int moveY, ChessCamp otherCamp) {
			int curX = getX();
			int curY = getY();
			int num = curY - moveY;
	
			if (num > 0) { 
				for (int i = 1; i <= num - 1; i++) {
					if (getPieceName(curX, curY - i) != null || otherCamp.getPieceName(curX, curY - i) != null) {
						return false;
					}
				}
				if (getPieceName(curX, curY - num) != null) return false;
			} else { // ȭ��Ʈ ��
				num = -num;
				for (int i = 1; i <= num - 1; i++) {
					if (getPieceName(curX, curY + i) != null || otherCamp.getPieceName(curX, curY + i) != null) {
						return false;
					}
				}
				if (getPieceName(curX, curY + num) != null) return false;
			}
			if (otherCampCatch(curX, moveY, otherCamp))
				return true; // �ش��������� �ٸ� �⹰�� ���� ������ ��ġ�� �� �⹰�� ��´�.
			
			return true; // �ش� �������� �ٸ� �⹰�̾�����.. oK!
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
		public void move(int moveX, int moveY , ChessCamp otherCamp) {
			System.out.println("������ testing,..");
				if (overLapMove(moveX, moveY, otherCamp) || otherCampCatch(moveX, moveY, otherCamp)) { // ������ ��ĭ �����̱� ������.
					overLap = true;
					setX(moveX);
					setY(moveY);
					ChessCamp.selection = !ChessCamp.selection; // �̵������ø� �÷��� �ٲ���!!
				}
				else System.out.println("�ش� �⹰�� �̵��� �� �����ϴ�.");
		}
		@Override
		public boolean overLapMove(int moveX, int moveY, ChessCamp otherCamp) {
			int curX = getX(); int curY = getY();
			if(curX != moveX) return false;
			int num = curY - moveY;
			
			if(num < 0) num = - num;
			if(num == 2 && overLap)
				return false;
			
			if(color) { // �����̸�
				for(int i = 1; i<=num;i++) {
					if(getPieceName(curX, curY - i) != null || otherCamp.getPieceName(curX, curY - i) != null)
						return false;
				}
			}else {
				for(int i = 1; i<=num;i++) {
					if(getPieceName(curX, curY + i) != null || otherCamp.getPieceName(curX, curY - i) != null)
						return false;
				}
			}
			return true;
		}
		@Override
		public boolean otherCampCatch(int moveX, int moveY, ChessCamp otherCamp) {
			if (otherCamp.getPieceName(moveX, moveY) == null) // ���⹰ ������ false
				return false;
			otherCamp.getPiece(moveX, moveY).setX(-1); // �ٽþȳ����� -1 ���־���.
			return true;

		}
	}
}

