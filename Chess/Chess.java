package Chess;

import java.util.Scanner;

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
		return true;
	}
	public void chessMapShow() {
		map.showMap();
	}
}
