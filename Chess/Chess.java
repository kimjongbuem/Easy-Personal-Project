package Chess;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Chess {
	private ChessMap map;
	public static Scanner sc;
	//private boolean reStart;
	public Chess() {
		sc = new Scanner(System.in);
		System.out.println("ü�� ������ ���� �մϴ�.");
		System.out.println("���� ���� : start");
		System.out.println("���� ����: end");
		System.out.println("���� �̵� : move source��ġ , Ÿ�� ��ġ");
		map = new ChessMap();
	}
	public void reStart() {
		System.out.println("�ٽ� �����մϴ�!");
		map = new ChessMap();
		map.showMap();
	}
	public boolean start(String instruction) {
		if("start".equals(instruction))
			return true;
		else
			return false;
	}
	public boolean end(String instruction) {
		if("end".equals(instruction))
			return true;
		else
			return false;
	}
	public boolean update(String instruction) {
		StringTokenizer tokenizer = new StringTokenizer(instruction," /&*^%$");
		if(tokenizer.countTokens() != 3) {
			System.out.println("move ��ɾ �߸� �Ǿ����ϴ�.");
			return false;
		}
		String instructions[] = new String[3];
		for(int i = 0; i<3;i++) {
			instructions[i] = tokenizer.nextToken();
		}
		if(instructions[0].equals("move")) {
			
		}
		return true;
	}
	public void chessMapShow() {
		map.showMap();
	}
}
