package Omok;

public class BadukMap {
	private int badukMapArray[][]; // ����� ���� �迭��Ǥ�
	private boolean checkBW = true; // �������
	private boolean isBlack;
	public BadukMap() {
		isBlack = true;
		badukMapArray = new int[21][21]; // 0��° �ε��� �迭�� ��������.
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
			// �޽��� â ���� 
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
