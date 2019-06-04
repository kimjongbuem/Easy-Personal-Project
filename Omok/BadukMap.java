package Omok;

public class BadukMap {
	private int badukMapArray[][]; // 오목알 놓는 배열고악ㄴ
	private boolean isBlack;

	public BadukMap() {
		isBlack = true;
		badukMapArray = new int[21][21]; // 0번째 인덱스 배열은 생각안함.
		for (int i = 1; i < 21; i++)
			for (int j = 1; j < 21; j++) {
				badukMapArray[i][j] = BadukColor.NONE;
			}
	}

	public void setMap(boolean isBlack, int x, int y) {
		if (checkBadukAal(x, y)) {
			if (isBlack)
				badukMapArray[y][x] = BadukColor.BLACK;
			else
				badukMapArray[y][x] = BadukColor.WHITE;
		} else {
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
		if (getBadukState(x, y) == BadukColor.NONE)
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

	public int getPositionState(int x, int y) {
		return badukMapArray[y][x];
	}

	public boolean checkWin(int x, int y) {
		if(checkStragihtL1R4(x,y) || checkStragihtR1L4(x, y) ||
			checkStragihtL2R3(x, y) || checkStragihtR2L3(x, y) || checkStragihtCenter(x, y) ||
		 checkDiagonalL1R4(x, y) || checkDiagonalL4R1(x,y) || checkDiagonalL2R3(x, y)
		 || checkDiagonalL3R2(x, y) || checkDiagonalCenterLR(x, y) || checkDiagonalCenterRL(x, y) ||
		 checkDiagonalR1L4(x, y) || checkDiagonalR2L3(x, y) || checkDiagonalR3L2(x, y) ||
		 checkDiagonalR4L1(x, y)
		 )
			return true;
		else
		return false; // 아직승리못함!
	}

	public boolean checkStragihtL1R4(int x, int y) {
		try {
		for(int idxX = 0; idxX < 5; idxX++) { // 맨왼쪽
			if(badukMapArray[y][x]!= badukMapArray[y][x+idxX])
				return false;
		}
		}catch(IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}
	public boolean checkStragihtR1L4(int x, int y) {
		try {
		for(int idxX = 0; idxX < 5; idxX++) { // 맨오른쪽
			if(badukMapArray[y][x]!= badukMapArray[y][x-idxX])
				return false;
		}
		}catch(IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}
	public boolean checkStragihtL2R3(int x, int y) {
		try {
		if(badukMapArray[y][x]!= badukMapArray[y][x-1])
				return false;
		for(int idxX = 1; idxX < 4; idxX++) { // 맨오른쪽
			if(badukMapArray[y][x]!= badukMapArray[y][x+idxX])
				return false;
		}
		}catch(IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}
	public boolean checkStragihtR2L3(int x, int y) {
		try {
		if(badukMapArray[y][x]!= badukMapArray[y][x+1])
				return false;
		for(int idxX = 1; idxX < 4; idxX++) { // 맨오른쪽
			if(badukMapArray[y][x]!= badukMapArray[y][x-idxX])
				return false;
		}
		}catch(IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}
	public boolean checkStragihtCenter(int x, int y) {
		try {
		for(int idxX = 1; idxX <= 2; idxX++) { // 맨오른쪽
			if(badukMapArray[y][x]!= badukMapArray[y][x+idxX])
				return false;
		}
		for(int idxX = 1; idxX <= 2; idxX++) { // 맨오른쪽
			if(badukMapArray[y][x]!= badukMapArray[y][x-idxX])
				return false;
		}
		}catch(IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}
	public boolean checkDiagonalR4L1(int x, int y) {
		try {
		for(int idxY = 1, idxX = 1; idxX < 5; idxX++,idxY++) { // R -> L 맨 왼쪽
			if(badukMapArray[y][x]!= badukMapArray[y-idxY][x+idxX])
				return false;
		}
		}catch(IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}
	public boolean checkDiagonalR1L4(int x, int y) {
		try {
		for(int idxY = 1, idxX = 1; idxX < 5; idxX++,idxY++) { // L -> R 맨 오른쪽
			if(badukMapArray[y][x]!= badukMapArray[y+idxY][x-idxX])
				return false;
		}
		}catch(IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}
	public boolean checkDiagonalR3L2(int x, int y) {
		try {
			if(badukMapArray[y][x]!= badukMapArray[y + 1][x - 1])
				return false;
		for(int idxY = 1, idxX = 1; idxX < 4; idxX++,idxY++) { // L -> R 맨 오른쪽
			if(badukMapArray[y][x]!= badukMapArray[y-idxY][x+idxX])
				return false;
		}
		}catch(IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}
	public boolean checkDiagonalR2L3(int x, int y) {
		try {
			if(badukMapArray[y][x]!= badukMapArray[y - 1][x + 1])
				return false;
		for(int idxY = 1, idxX = 1; idxX < 4; idxX++,idxY++) { // L -> R 맨 오른쪽
			if(badukMapArray[y][x]!= badukMapArray[y+idxY][x-idxX])
				return false;
		}
		}catch(IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}
	public boolean checkDiagonalCenterRL(int x, int y) {
		try {
		for(int idxY = 1, idxX = 1; idxX < 3; idxX++,idxY++) { // L -> R 맨 오른쪽
			if(badukMapArray[y][x]!= badukMapArray[y+idxY][x-idxX])
				return false;
		}
		for(int idxY = 1, idxX = 1; idxX < 3; idxX++,idxY++) { // L -> R 맨 오른쪽
			if(badukMapArray[y][x]!= badukMapArray[y-idxY][x+idxX])
				return false;
		}
		}catch(IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}
	//
	public boolean checkDiagonalL1R4(int x, int y) {
		try {
		for(int idxY = 1, idxX = 1; idxX < 5; idxX++,idxY++) { // L -> R 맨 왼쪽
			if(badukMapArray[y][x]!= badukMapArray[y+idxY][x+idxX])
				return false;
		}
		}catch(IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}
	public boolean checkDiagonalL4R1(int x, int y) {
		try {
		for(int idxY = 1, idxX = 1; idxX < 5; idxX++,idxY++) { // L -> R 맨 오른쪽
			if(badukMapArray[y][x]!= badukMapArray[y-idxY][x-idxX])
				return false;
		}
		}catch(IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}
	public boolean checkDiagonalL2R3(int x, int y) {
		try {
			if(badukMapArray[y][x]!= badukMapArray[y - 1][x - 1])
				return false;
		for(int idxY = 1, idxX = 1; idxX < 4; idxX++,idxY++) { // L -> R 맨 오른쪽
			if(badukMapArray[y][x]!= badukMapArray[y+idxY][x+idxX])
				return false;
		}
		}catch(IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}
	public boolean checkDiagonalL3R2(int x, int y) {
		try {
			if(badukMapArray[y][x]!= badukMapArray[y + 1][x + 1])
				return false;
		for(int idxY = 1, idxX = 1; idxX < 4; idxX++,idxY++) { // L -> R 맨 오른쪽
			if(badukMapArray[y][x]!= badukMapArray[y-idxY][x-idxX])
				return false;
		}
		}catch(IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}
	public boolean checkDiagonalCenterLR(int x, int y) {
		try {
		for(int idxY = 1, idxX = 1; idxX < 3; idxX++,idxY++) { // L -> R 맨 오른쪽
			if(badukMapArray[y][x]!= badukMapArray[y-idxY][x-idxX])
				return false;
		}
		for(int idxY = 1, idxX = 1; idxX < 3; idxX++,idxY++) { // L -> R 맨 오른쪽
			if(badukMapArray[y][x]!= badukMapArray[y+idxY][x+idxX])
				return false;
		}
		}catch(IndexOutOfBoundsException e) {
			return false;
		}
		return true;
	}
}
