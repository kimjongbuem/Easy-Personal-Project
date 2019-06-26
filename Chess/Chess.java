package Chess;

import java.util.Scanner;

public class Chess {
	private ChessMap map;
	public static Scanner sc;
	//private boolean reStart;
	public Chess() {
		sc = new Scanner(System.in);
		System.out.println("체스 게임을 시작 합니다.");
		System.out.println("게임 시작 : start");
		System.out.println("게임 종료: end");
		System.out.println("게임 이동 : move source위치 , 타겟 위치");
		map = new ChessMap();
	}
	public void reStart() {
		System.out.println("다시 시작합니다!");
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
