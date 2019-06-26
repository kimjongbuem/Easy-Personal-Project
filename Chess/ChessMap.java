package Chess;

public class ChessMap {
	ChessCamp[] camp;

	public ChessMap() {
		Maps mapNumber = new Maps();
		camp = new ChessCamp[2];
		camp[0] = new ChessCamp(true);// 블랙진영
		camp[1] = new ChessCamp(false);// 화이트진영
	}
	public void showMap() {
		String pieceBlackName, pieceWhiteName = null;
		for (int i = 8; i >= 1; i--) {
			for (int j = 1; j <= 8; j++) {
				pieceBlackName = camp[0].getPieceName(i, j);
				pieceWhiteName = camp[1].getPieceName(i, j);
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
