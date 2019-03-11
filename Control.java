
public class Control {
	Model model;
	View view;
	public Control() {
		model = new Model();
		view = new View(model, this);
	}
	
	public void setField(int x, int y, int z) {
		if(!checkWinner()) {
			if(model.getFeld(x, y, z) == 0) {
				if(model.isCurrentPlayer1())model.setFeld(1, x, y, z);
				else model.setFeld(2, x, y, z);
				changePlayer();
				checkWinner();
				update();
			}
		}
		
	}
	public void update() {
		view.repaint();
	}
	
	
	
	public boolean checkWinner() {
		if(check() == 11 || check() == 12) {
			showPopUp();
			if(check() == 11) {
				model.setWinsX(model.getWinsX()+1); 
				System.out.println("Green Wins");
			}
			if(check() == 12) {
				model.setWinsO(model.getWinsO()+1); 
				System.out.println("Blue Wins");
			}
			return true;
		}
		return false;
	}
  
	public boolean checkDraw() {
		if(check() == 1) {
			return true;
		}
		return false;
	}
  
  	public void changePlayer() {
  		model.setCurrentPlayer1(!model.isCurrentPlayer1());
  	}
  
  	public void restart() {
  		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				for(int k = 0; k < 4; k++) {
					model.setFeld(0, i, j, k);
				}
			}
  		}
  		update();
  	}
				

  
  	public void showPopUp() {
  		view.showPopUp();
  	}
  	
  	private int calculate() {
  		int zwischenFeld[][][] = new int[3][3][3];
  		zwischenFeld = model.getFeld();
  		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				int temp[] = new int[4];
				for(int k = 0; k < 4; k++) {
					temp[k] = zwischenFeld[i][j][k];
				}
				if(temp[0] == temp[1] && temp[0] == temp[2] && temp[0] == temp[3] && temp[0] != 0) {
					if(temp[0] == 1)return 11;//Blue Wins
					if(temp[0] == 2)return 12;//Green Wins
				}
			}
  		}
  		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				int temp[] = new int[4];
				for(int k = 0; k < 4; k++) {
					temp[k] = zwischenFeld[i][k][j];
				}
				if(temp[0] == temp[1] && temp[0] == temp[2] && temp[0] == temp[3] && temp[0] != 0) {
					if(temp[0] == 1)return 11;//Blue Wins
					if(temp[0] == 2)return 12;//Green Wins
				}
			}
  		}
  		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				int temp[] = new int[4];
				for(int k = 0; k < 4; k++) {
					temp[k] = zwischenFeld[k][i][j];
				}
				if(temp[0] == temp[1] && temp[0] == temp[2] && temp[0] == temp[3] && temp[0] != 0) {
					if(temp[0] == 1)return 11;
					if(temp[0] == 2)return 12;
				}
			}
  		}
  		for(int i = 0; i < 4; i++) {
			int temp[] = new int[4];
			for(int k = 3; k >= 4; k--) {
				temp[k] = zwischenFeld[i][i][k];
			}
			if(temp[0] == temp[1] && temp[0] == temp[2] && temp[0] == temp[3] && temp[0] != 0) {
				
				if(temp[0] == 1)return 11;
				if(temp[0] == 2)return 12;
			}

  		}
  		/*for(int i = 3; i >= 0; i--) {
			int temp[] = new int[4];
			for(int k = 0; k < 4; k++) {
				temp[k] = zwischenFeld[k][i][k];
			}
			if(temp[0] == temp[1] && temp[0] == temp[2] && temp[0] == temp[3] && temp[0] != 0) {
				
				if(temp[0] == 1)return 11;
				if(temp[0] == 2)return 12;
			}

  		}*/
  		return 1;
  	}
  	public int check()
	{
  		int tab[][][] = model.getFeld();
		for(int a=1;a<3;a++) {
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					if(tab[i][j][0]==a) {
						for(int k=1;k<4;k++) {
							if(tab[i][j][k]!=a)
								break;
							if(k==3)
								return a +10;
						}//------16wins------------
					}
					if(tab[i][0][j]==a) {
						for(int k=1;k<4;k++)
						{
							if(tab[i][k][j]!=a)
								break;
							if(k==3)
								return a + 10;
						}//------16wins------------
					}
					if(tab[0][i][j]==a) {
						for(int k=1;k<4;k++)
						{
							if(tab[k][i][j]!=a)
							break;
							if(k==3)
							return a + 10;
						}//------16wins------------
					}
				}
			}
			//---------------48wins-----------------------------------
			
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					if(tab[j][i][j]!=a)
						break;
					if(j==3)
						return a + 10;
				}//-----4wins------------------------
				for(int j=0;j<4;j++) {
					if(tab[j][j][i]!=a)
						break;
					if(j==3)
						return a + 10;
				}//-----4wins------------------------
				for(int j=0;j<4;j++) {
					if(tab[j][i][3-j]!=a)
						break;
					if(j==3)
						return a + 10;
				}//-----4wins------------------------
				for(int j=0;j<4;j++) {
					if(tab[j][3-j][i]!=a)
					break;
					if(j==3)
					return a + 10;
				}//-----4wins------------------------
			}
			//---------------16wins-----------------------------------
			if((tab[1][1][1]==a)&&(tab[0][0][0]==tab[1][1][1])&&(tab[2][2][2]==tab[3][3][3])&&(tab[1][1][1]==tab[2][2][2]))
				return a + 10;
			if((tab[1][1][2]==a)&&(tab[0][0][3]==tab[1][1][2])&&(tab[2][2][1]==tab[3][3][0])&&(tab[3][3][0]==tab[1][1][2]))
				return a + 10;
			if((tab[1][2][1]==a)&&(tab[0][3][0]==tab[1][2][1])&&(tab[2][1][2]==tab[3][0][3])&&(tab[2][1][2]==tab[1][2][1]))
				return a + 10;
			if((tab[2][1][1]==a)&&(tab[0][3][3]==tab[1][2][2])&&(tab[2][1][1]==tab[3][0][0])&&(tab[3][0][0]==tab[2][1][1]))
				return a + 10;
			//------------4 main diagonals----------------------------
			for(int i=0;i<4;i++) {
				for(int j=0;j<4;j++) {
					if(tab[i][j][j]!=a)
						break;
					if(j==3)
						return a + 10;
				}//-----------4diagonals-----------
				for(int j=0;j<4;j++) {
					if(tab[i][j][3-j]!=a)
						break;
					if(j==3)
						return a + 10;
				}//-----------4diagonals-----------
				//---------------------8diagonals----------------------
			}
		}
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				for(int k=0;k<4;k++) {
					if(tab[i][j][k]==0)
						return 0;
					if((i==3)&&(j==3)&&(k==3))
						return 1;
				}
			}
		}
		return 0;
	}
}
