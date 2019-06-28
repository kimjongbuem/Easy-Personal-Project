package Chess;
public class ChessCamp {
	private boolean BWFlag;
	private Piece piece[];
	private int totalCount = 0;
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
				System.out.println("잘못된 팀컬러 말을 선택하였습니다.");
				return;
			}
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
		public abstract void move(int moveX, int moveY, ChessCamp otherCamp);
		public void setName(String name) {
			this.name = name;
		}
		public abstract boolean overLapMove(int moveX, int moveY , ChessCamp otherCamp);
		public boolean otherCampCatch(int moveX, int moveY, ChessCamp otherCamp) {
			if (otherCamp.getPieceName(moveX, moveY) == null) // 적기물 없으면 false
				return false;
			otherCamp.getPiece(moveX, moveY).setX(-1); // 다시안나오게 -1 값넣어줌.
			return true;
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
		public boolean rightUpper(int moveX, int moveY , ChessCamp otherCamp) {
			int curY = getY(); int curX = getX();
			int num = moveY - curY; // 몇번반복할지..
			for(int i = 1; i<=num-1;i++) {
				if (getPieceName(curX + i, curY + i) != null || otherCamp.getPieceName(curX + i, curY + i) != null) {
					return false;
				}
			}if(getPiece(curX + num, curY + num) != null) return false;
			if (otherCampCatch(moveX, moveY, otherCamp))
				return true; // 해당지점까지 다른 기물이 없고 움직일 위치에 적 기물을 잡는다.
			return true; // 해당 지점까지 다른 기물이없으니.. oK!
		}
		public boolean leftUpper(int moveX, int moveY , ChessCamp otherCamp) {
			int curY = getY(); int curX = getX();
			int num = moveY - curY; // 몇번반복할지..
			for(int i = 1; i<=num-1;i++) {
				if (getPieceName(curX - i, curY + i) != null || otherCamp.getPieceName(curX - i, curY + i) != null) {
					return false;
				}
			}if(getPiece(curX - num, curY + num) != null) return false;
			if (otherCampCatch(moveX, moveY, otherCamp))
				return true; // 해당지점까지 다른 기물이 없고 움직일 위치에 적 기물을 잡는다.
			return true; // 해당 지점까지 다른 기물이없으니.. oK!
		}
		public boolean rightDown(int moveX, int moveY , ChessCamp otherCamp) {
			int curY = getY(); int curX = getX();
			int num = -(moveY - curY); // 몇번반복할지..
			for(int i = 1; i<=num-1;i++) {
				if (getPieceName(curX + i, curY - i) != null || otherCamp.getPieceName(curX + i, curY + i) != null) {
					return false;
				}
			}if(getPiece(curX + num, curY - num) != null) return false;
			if (otherCampCatch(moveX, moveY, otherCamp))
				return true; // 해당지점까지 다른 기물이 없고 움직일 위치에 적 기물을 잡는다.
			return true; // 해당 지점까지 다른 기물이없으니.. oK!
		}
		public boolean leftDown(int moveX, int moveY , ChessCamp otherCamp) {
			int curY = getY(); int curX = getX();
			int num = -(moveY - curY); // 몇번반복할지..
			for(int i = 1; i<=num-1;i++) {
				if (getPieceName(curX - i, curY - i) != null || otherCamp.getPieceName(curX - i, curY - i) != null) {
					return false;
				}
			}if(getPiece(curX - num, curY - num) != null) return false;
			if (otherCampCatch(moveX, moveY, otherCamp))
				return true; // 해당지점까지 다른 기물이 없고 움직일 위치에 적 기물을 잡는다.
			return true; // 해당 지점까지 다른 기물이없으니.. oK!
		}
		public boolean overLapMoveX(int moveX, ChessCamp otherCamp) {
			int curX = getX();
			int curY = getY();
			int num = moveX - curX;

			if (num > 0) { // 오른쪽 이동시....
				for (int i = 1; i <= num - 1; i++) {
					if (getPieceName(curX + i, curY) != null || otherCamp.getPieceName(curX + i, curY) != null) {
						return false;
					}
				}
				if (getPieceName(curX+ num, curY ) != null) return false;
			} else { // 왼쪽이동시....
				num = -num;
				for (int i = 1; i <= num - 1; i++) {
					if (getPieceName(curX - i, curY) != null || otherCamp.getPieceName(curX - i, curY) != null) {
						return false;
					}
				}
				if (getPieceName(curX - num, curY ) != null) return false;
			}
			if (otherCampCatch(moveX, curY, otherCamp))
				return true; // 해당지점까지 다른 기물이 없고 움직일 위치에 적 기물을 잡는다.
			
			return true; // 해당 지점까지 다른 기물이없으니.. oK!
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
			} else { 
				num = -num;
				for (int i = 1; i <= num - 1; i++) {
					if (getPieceName(curX, curY + i) != null || otherCamp.getPieceName(curX, curY + i) != null) {
						return false;
					}
				}
				if (getPieceName(curX, curY + num) != null) return false;
			}
			if (otherCampCatch(curX, moveY, otherCamp))
				return true; // 해당지점까지 다른 기물이 없고 움직일 위치에 적 기물을 잡는다.
			
			return true; // 해당 지점까지 다른 기물이없으니.. oK!
		}
	}
	class King extends Piece{
		boolean isLive;
		public King(int x, int y, boolean color) {
			this.x = x ;this.y = y; this.color = color;
			isLive = true;
			if(color == true)
				name="K";
			else
				name="k";
		}
		public boolean getIsLive() {
			return isLive;
		}
		@Override
		public void move(int moveX, int moveY, ChessCamp otherCamp) {
			System.out.println("킹 testing...");
		
			if (overLapMove(moveX, moveY, otherCamp)) {
				setX(moveX);
				setY(moveY);
				ChessCamp.selection = !ChessCamp.selection; // 이동성공시만 컬러를 바꾸자!!
			}
			else System.out.println("해당 기물이 해당 지점 까지 이동 할 수 없습니다.");
			
		}
		@Override
		public boolean overLapMove(int moveX, int moveY, ChessCamp otherCamp) {
			int absoluteX = moveX - getX();
			int absoluteY = moveY - getY();
			if (absoluteX < 0)
				absoluteX = -absoluteX;
			if (absoluteY < 0)
				absoluteY = -absoluteY;
			if (absoluteX > 1 || absoluteY > 1 || getPieceName(moveX, moveY)!= null)
				return false;
			else if(upper(moveX, moveY, otherCamp)|| upperLeft(moveX, moveY, otherCamp) || upperRight(moveX, moveY, otherCamp)
					|| down(moveX, moveY, otherCamp) || downLeft(moveX, moveY, otherCamp) || downRight(moveX, moveY, otherCamp)
					|| left(moveX, moveY, otherCamp) || right(moveX, moveY, otherCamp)) return true;
			if(otherCampCatch(moveX, moveY, otherCamp)) return true;
			return false;
		}
		
		public boolean upper(int moveX, int moveY , ChessCamp otherCamp) {
			int curX = getX(); int curY = getY();
			if(moveX == curX && moveY - curY != 1) return false;
			return true;
		}
		public boolean upperLeft(int moveX, int moveY , ChessCamp otherCamp) {
			int curX = getX(); int curY = getY();
			if(curX - moveX !=  1 && moveY - curY != 1) return false;
			return true;
		}
		public boolean upperRight(int moveX, int moveY , ChessCamp otherCamp) {
			int curX = getX(); int curY = getY();
			if(curX - moveX !=  -1 && moveY - curY != 1) return false;
			return true;
		}
		public boolean right(int moveX, int moveY , ChessCamp otherCamp) {
			int curX = getX(); int curY = getY();
			if(curX - moveX !=  -1 && moveY == curY ) return false;
			return true;
		}
		public boolean down(int moveX, int moveY , ChessCamp otherCamp) {
			int curX = getX(); int curY = getY();
			if(curX == moveX  && moveY - curY != -1) return false;
			return true;
		}
		public boolean downRight(int moveX, int moveY , ChessCamp otherCamp) {
			int curX = getX(); int curY = getY();
			if(curX - moveX != -1 && moveY - curY != -1) return false;
			return true;
		}
		public boolean downLeft(int moveX, int moveY , ChessCamp otherCamp) {
			int curX = getX(); int curY = getY();
			if(curX - moveX != 1&& moveY - curY != -1) return false;
			return true;
		}
		public boolean left(int moveX, int moveY , ChessCamp otherCamp) {
			int curX = getX(); int curY = getY();
			if(curX - moveX != 1 && moveY == curY ) return false;
			return true;
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
			System.out.println("퀸 testing...");
			if (overLapMove(moveX, moveY, otherCamp)) {
				setX(moveX);
				setY(moveY);
				ChessCamp.selection = !ChessCamp.selection; // 이동성공시만 컬러를 바꾸자!!
			}
			else System.out.println("해당 기물이 해당 지점 까지 이동 할 수 없습니다.");
			
		}
		@Override
		public boolean overLapMove(int moveX, int moveY , ChessCamp otherCamp) {
			int curX = getX(); int curY = getY();
			if(curX == moveX) { // 세로의 움직임 퀸 
				return overLapMoveY(moveY, otherCamp);
			}
			else if(curY == moveY){ // 가로 움직임 퀸
				return overLapMoveX(moveX, otherCamp);
			}
			int verticalVal =  moveY -curY;// 세로값 
			int horizontalVal = moveX - curX; //가로값
			
			int absorlteX = horizontalVal; if(absorlteX  < 0) absorlteX = - absorlteX; 
			int absorlteY = verticalVal; if(absorlteY  < 0) absorlteY = - absorlteY;
			if((curX == moveX || moveY == curY) || (absorlteX != absorlteY)) return false; // 대각으로 움직이니까 움직이는 위치 지점이랑 현재 위치지점이랑 같으면 안됨.
			if(verticalVal > 0 && horizontalVal > 0 ) return rightUpper(moveX, moveY, otherCamp);// 우상 대각선 
			else if (verticalVal > 0 && horizontalVal < 0 ) return leftUpper(moveX, moveY, otherCamp);//좌상 대각선
			else if (verticalVal < 0 && horizontalVal > 0 ) return rightDown(moveX, moveY, otherCamp); //우하 대각선			
			else if (verticalVal < 0 && horizontalVal < 0 ) return leftDown(moveX, moveY, otherCamp); //좌하 대각선
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
			System.out.println("비숍 testing..");
			if (overLapMove(moveX, moveY, otherCamp)) {
				setX(moveX);
				setY(moveY);
				ChessCamp.selection = !ChessCamp.selection; // 이동성공시만 컬러를 바꾸자!!
			}
			else System.out.println("해당 기물이 해당 지점 까지 이동 할 수 없습니다.");
		}
		@Override
		public boolean overLapMove(int moveX, int moveY , ChessCamp otherCamp) {
			int curX = getX(); int curY = getY(); 
			int verticalVal =  moveY -curY;// 세로값 
			int horizontalVal = moveX - curX; //가로값
			int absorlteX = horizontalVal; if(absorlteX  < 0) absorlteX = - absorlteX; 
			int absorlteY = verticalVal; if(absorlteY  < 0) absorlteY = - absorlteY;
			if((curX == moveX || moveY == curY) || (absorlteX != absorlteY)) return false; // 대각으로 움직이니까 움직이는 위치 지점이랑 현재 위치지점이랑 같으면 안됨.
			//비숍은 4개의 방향을 통해 구현을 할것임. 오른쪽 위 대각, 왼쪽 위 대각, 왼쪽 밑 대각 오른 쪽 밑 대각
			
			if(verticalVal > 0 && horizontalVal > 0 ) return rightUpper(moveX, moveY, otherCamp);// 우상 대각선 
			else if (verticalVal > 0 && horizontalVal < 0 ) return leftUpper(moveX, moveY, otherCamp);//좌상 대각선
			else if (verticalVal < 0 && horizontalVal > 0 ) return rightDown(moveX, moveY, otherCamp); //우하 대각선			
			else if (verticalVal < 0 && horizontalVal < 0 ) return leftDown(moveX, moveY, otherCamp); //좌하 대각선
			return false;
		}
	}

	class Knight extends Piece{
		public Knight(int x, int y, boolean color) {
			this.x = x ;this.y = y; this.color = color;
			if(color == true)
				name="N";
			else
				name="n";
		}
		@Override
		public void move(int moveX, int moveY, ChessCamp otherCamp) {
			System.out.println("나이트 testing...");
			if (upperMove(moveX, moveY, otherCamp) || downMove(moveX, moveY, otherCamp) ||
				leftMove(moveX, moveY, otherCamp)||rightMove(moveX, moveY, otherCamp)) {
				setX(moveX);
				setY(moveY);
				ChessCamp.selection = !ChessCamp.selection; // 이동성공시만 컬러를 바꾸자!!
			}
			else System.out.println("해당 기물이 해당 지점 까지 이동 할 수 없습니다.");			
		}
		@Override
		public boolean overLapMove(int moveX, int moveY , ChessCamp otherCamp) {return false;}
		// 화이트 시점방향 함수들.. //
		public boolean upperMove(int moveX, int moveY, ChessCamp otherCamp) {
			// 화이트 팀기준 윗방향으로 가는 나이트.... 물론 블랙팀도 가능하나 시점 상 화이트팀이 보이는방향으로..
			int curX = getX(); int curY = getY(); 
			if(moveX - curX == 1) ; else if(moveX - curX == -1); else return false;
			if(moveY - curY == 2 ) {
				if(getPieceName(moveX, moveY)!= null) // 아군기물이 있다면..
					return false;
				else if (otherCampCatch(moveX, moveY, otherCamp))
					return true; // 움직일 위치에 적 기물을 잡는다.
			}else return false;
			return true;
		}
		public boolean rightMove(int moveX, int moveY, ChessCamp otherCamp) {
			int curX = getX(); int curY = getY(); 
			if(moveY - curY == 1) ; else if(moveY - curY == -1); else return false;
			if(moveX - curX == 2 ) {
				if(getPieceName(moveX, moveY)!= null) // 아군기물이 있다면..
					return false;
				else if (otherCampCatch(moveX, moveY, otherCamp))
					return true; // 움직일 위치에 적 기물을 잡는다.
			}else return false;
			return true;
		}
		public boolean downMove(int moveX, int moveY, ChessCamp otherCamp) {
			int curX = getX(); int curY = getY(); 
			if(moveX - curX == 1) ; else if(moveX - curX == -1); else return false;
			if(moveY - curY == -2 ) {
				if(getPieceName(moveX, moveY)!= null) // 아군기물이 있다면..
					return false;
				else if (otherCampCatch(moveX, moveY, otherCamp))
					return true; // 움직일 위치에 적 기물을 잡는다.
			}else return false;
			return true;
		}
		public boolean leftMove(int moveX, int moveY, ChessCamp otherCamp) {
			int curX = getX(); int curY = getY(); 
			if(moveY - curY == 1) ; else if(moveY - curY == -1); else return false;
			if(moveX - curX == -2 ) {
				if(getPieceName(moveX, moveY)!= null) // 아군기물이 있다면..
					return false;
				else if (otherCampCatch(moveX, moveY, otherCamp))
					return true; // 움직일 위치에 적 기물을 잡는다.
			}else return false;
			return true;
		}
	}

	class Rook extends Piece{
		// 룩은 y축 이동 일때만 색에따른 값을 다르게 주면 된다. x축 이동시에는 색에 따른 이동 값은 상관이없기 때문... 
		public Rook(int x, int y, boolean color) {
			this.x = x ;this.y = y; this.color = color;
			if(color == true)
				name="R";
			else
				name="r";
		}
		@Override
		public void move(int moveX, int moveY, ChessCamp otherCamp) {
			System.out.println("룩 testing...");
			if (overLapMove(moveX, moveY, otherCamp)) {
				setX(moveX);
				setY(moveY);
				ChessCamp.selection = !ChessCamp.selection; // 이동성공시만 컬러를 바꾸자!!
			}
			else System.out.println("해당 기물이 해당 지점 까지 이동 할 수 없습니다.");
		}
		@Override
		public boolean overLapMove(int moveX, int moveY , ChessCamp otherCamp) {
			int curX = getX();
			if(curX == moveX) { // 세로의 움직임 
				return overLapMoveY(moveY, otherCamp);
			}
			else { // 가로 움직임
				return overLapMoveX(moveX, otherCamp);
			}
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
		public void move(int moveX, int moveY , ChessCamp otherCamp) {
			System.out.println("폰진입 testing,..");
				if (overLapMove(moveX, moveY, otherCamp) || otherCampCatch(moveX, moveY, otherCamp)) { // 밑으로 두칸 움직이기 가능함.
					overLap = true;
					setX(moveX);
					setY(moveY);
					ChessCamp.selection = !ChessCamp.selection; // 이동성공시만 컬러를 바꾸자!!
				}
				else System.out.println("해당 기물이 이동할 수 없습니다.");
		}
		@Override
		public boolean overLapMove(int moveX, int moveY, ChessCamp otherCamp) {
			int curX = getX(); int curY = getY();
			if(curX != moveX) return false;
			int num = curY - moveY;
			
			if(num < 0) num = - num;
			if(num == 2 && overLap)
				return false;
			
			if(color) { // 블랙팀이면
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
	}
}

