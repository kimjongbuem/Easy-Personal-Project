package Chess;

public class MainClass {

	public static void main(String[] args) {
		Chess chess = new Chess();
		while(true) {
			String instruction = Chess.sc.nextLine();
			if(chess.start(instruction))
				chess.chessMapShow();
			else if(chess.end(instruction))
				return ;
//			else if(chess.update(instruction)) {
//				//로직//
//			}
			else {
				System.out.println("다시입력해주세요!");
			}
		}
	}
}
