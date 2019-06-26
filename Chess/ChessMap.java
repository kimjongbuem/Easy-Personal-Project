package Chess;

public class ChessMap {
	ChessCamp[] camp;
	private int[][] chessMap;
	public ChessMap() {
		chessMap = new int[9][9]; // 0 인덱스 사용안할거임. 
		camp = new ChessCamp[2];
		camp[0] = new ChessCamp(true);//블랙진영
		camp[1] = new ChessCamp(false);//화이트진영
		for(int i = 0; i<9 ;i++) {
			for(int j = 0; j<9 ;j++) {
				chessMap[i][j]  = 0;
			}
		}
	}
	public void showMap() {
		String pieceBlackName, pieceWhiteName = null;
		for(int i = 8; i>=1;i--) {
			for(int j = 1; j<=8; j++) {
				pieceBlackName = camp[0].getPieceName(i, j);
				pieceWhiteName = camp[1].getPieceName(i, j);
				if(pieceBlackName == null && pieceWhiteName == null)
					System.out.print(".");
				else if(pieceBlackName !=null)
					System.out.print(pieceBlackName);
				else
					System.out.print(pieceWhiteName);
			}
			System.out.println("\t"+i);
		}
	}
}
