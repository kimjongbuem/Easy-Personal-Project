package Chess;

public class ChessMap {
	private ChessCamp[] camp;
	private Maps mapNumber;
	private boolean selection;// 흑선공
	public ChessMap() {
		selection = true;
		mapNumber = new Maps();
		camp = new ChessCamp[2];
		camp[0] = new ChessCamp(true);// 블랙진영
		camp[1] = new ChessCamp(false);// 화이트진영
	}
	public Maps getMaps() {
		return mapNumber;
	}
	
	public void move(int curX, int curY, int moveX, int moveY) {
		if(curX == -1 || curY == -1) {
			System.out.println("잘못된 입력입니다!");
			return;
		}
		if(camp[0].getPieceName(curX, curY)!=null) { // 흑
			camp[0].move(curX, curY, moveX, moveY);
		}
		else if(camp[1].getPieceName(curX, curY)!=null) { // 백
			camp[1].move(curX, curY, moveX, moveY);
		}
	}
	
	public void showMap() {
		String pieceBlackName, pieceWhiteName = null;
		for (int i = 8; i >= 1; i--) { // y 
			for (int j = 1; j <= 8; j++) { // x
				pieceBlackName = camp[0].getPieceName(j, i);
				pieceWhiteName = camp[1].getPieceName(j, i);
				if (pieceBlackName == null && pieceWhiteName == null)
					System.out.print(".");
				else if (pieceBlackName != null)
					System.out.print(pieceBlackName);
				else
					System.out.print(pieceWhiteName);
			}
			System.out.println("\t" + i);
		}
	}
	class Maps {
		String[][] chessMap;
		int x, y;
		public int getIntX(String s) {
			for (int i = 1; i < 9; i++) {
				for (int j = 1; j < 9; j++) {
					if(s.equals(chessMap[i][j]))
						return i;
				}
			}
			return -1; // 명령 에러
		}
		public int getIntY(String s) {
			for (int i = 1; i < 9; i++) {
				for (int j = 1; j < 9; j++) {
					if(s.equals(chessMap[i][j]))
						return j;
				}
			}
			return -1; // 명령 에러
		}
		public Maps() {
			chessMap = new String[9][9];
			for (int i = 1; i < 9; i++) {
				for (int j = 1; j < 9; j++) {
					switch (i) {
					case 1:
						chessMap[i][j] = "a" + j;
						break;
					case 2:
						chessMap[i][j] = "b" + j;
						break;
					case 3:
						chessMap[i][j] = "c" + j;
						break;
					case 4:
						chessMap[i][j] = "d" + j;
						break;
					case 5:
						chessMap[i][j] = "e" + j;
						break;
					case 6:
						chessMap[i][j] = "f" + j;
						break;
					case 7:
						chessMap[i][j] = "g" + j;
						break;
					case 8:
						chessMap[i][j] = "h" + j;
						break;
					}
				}
			}
		}
	}
}
