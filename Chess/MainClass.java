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
//				//����//
//			}
			else {
				System.out.println("�ٽ��Է����ּ���!");
			}
		}
	}
}
