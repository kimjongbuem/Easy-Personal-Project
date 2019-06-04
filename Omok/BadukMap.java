package Omok;

public class BadukMap {
	private int badukMapArray[][]; // 오목알 놓는 배열고악ㄴ
	private boolean checkBW = true; // 흑백차례
	private boolean isBlack;
	public BadukMap() {
		isBlack = true;
		badukMapArray = new int[21][21]; // 0번째 인덱스 배열은 생각안함.
		for(int i = 1 ; i<21;i++)
			for(int j = 1 ; j<21;j++) {
				badukMapArray[i][j] = BadukColor.NONE;
			}
	}
	public void setMap(boolean isBlack, int x, int y) {
		if(checkBadukAal(x, y)) {
			if(isBlack)
				badukMapArray[y][x] = BadukColor.BLACK;
			else
				badukMapArray[y][x] = BadukColor.WHITE;
		}else {
			// 메시지 창 띄우기 
		}
	}
	public int getBlack() {
		return BadukColor.BLACK;
	}
	public int getWhite() {
		return BadukColor.WHITE;
	}
	public boolean checkBadukAal(int x, int y) {
		if(getBadukState(x,y)==BadukColor.NONE)
			return true;
		return false;
	}
	public int getBadukState(int x, int y) {
		return badukMapArray[y][x];
	}
	public boolean getFlagIsBlack() {
		return isBlack;
	}
	public void setFlagisBlack() {
		isBlack = !isBlack;
	}
	public int getPositionState(int x,int y) {
		return badukMapArray[y][x];
	}
}
