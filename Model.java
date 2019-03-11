public class Model {
	private int feld[][][]= new int[4][4][4];
	private int winsX = 0, winsO = 0, games = 0;
	private boolean currentPlayer1 = false;
	
	public int[][][] getFeld() {
		return feld;
	}

	public void setFeld(int feld[][][]) {
		this.feld = feld;
	}
	
	public int getFeld(int x, int y, int z) {
		if (feld[x][y][z] == 0 || feld[x][y][z] == 1 || feld[x][y][z] == 2)return feld[x][y][z];
		else return 0;
	}

	public void setFeld(int feld, int x, int y, int z) {
		this.feld[x][y][z] = feld;
	}

	public boolean isCurrentPlayer1() {
		return currentPlayer1;
	}

	public void setCurrentPlayer1(boolean currentPlayer1) {
		this.currentPlayer1 = currentPlayer1;
	}

	public int getWinsO() {
		return winsO;
	}

	public void setWinsO(int winsO) {
		this.winsO = winsO;
	}

	public int getWinsX() {
		return winsX;
	}

	public void setWinsX(int winsX) {
		this.winsX = winsX;
	}

	public int getGames() {
		return games;
	}

	public void setGames(int games) {
		this.games = games;
	}
}
