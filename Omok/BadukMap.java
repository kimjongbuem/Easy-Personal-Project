package Omok;

public class BadukMap {
	private int badukMapArray[][]; // ����� ���� �迭��Ǥ�
	private boolean checkBW = true; // �������
	public BadukMap() {
		badukMapArray = new int[20][20]; // 0��° �ε��� �迭�� ��������.
		for(int i = 1 ; i<20;i++)
			for(int j = 1 ; j<20;j++) {
				badukMapArray[i][j] = BadukColor.NONE;
			}
	}
	public void setMap(boolean isBlack, int x, int y) {
		if(checkBadukAal(x, y)) {
			if(isBlack)
				badukMapArray[x][y] = BadukColor.BLACK;
			else
				badukMapArray[x][y] = BadukColor.WHITE;
		}else {
			// �޽��� â ���� 
		}
	}
	public boolean checkBadukAal(int x, int y) {
		if(getBadukState(x,y)==BadukColor.NONE)
			return true;
		return false;
	}
	public int getBadukState(int x, int y) {
		return badukMapArray[x][y];
	}
}
