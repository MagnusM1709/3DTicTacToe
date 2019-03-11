import javax.swing.JFrame; 
import javax.swing.JPanel; 

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/** 
 * Zeichnet einen Kreis mit dem Mittelpunkt mx/my und dem Radius r 
 *
 */ 
public class View extends JFrame implements MouseListener { 

	private static final long serialVersionUID = -2017347786539304581L;
	JFrame jfMain = new JFrame();
	JPanel panel = new JPanel();
	Graphics field;
	static final int circleSize= 30;
	int mousePosToFieldX[][][] = new int [4][4][4];
	int mousePosToFieldY[][][] = new int [4][4][4];
	Model model;
	Control control;
	PopUp popUp;
	
	public View(Model model, Control control) {
		this.model = model;
		this.control = control;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Zeichnen mit Java");
		setBounds(0, 0, 400, 730);
		setVisible(true);
		addMouseListener(this);
		popUp = new PopUp(model, control);
	}
	public void showPopUp() {
		if(control.check() == 11)popUp.setText("Grün hat Gewonnen");
		if(control.check() == 12)popUp.setText("Blau hat Gewonnen");
		popUp.setVisible(true);
	}

	@Override 
	public void paint(Graphics g) { // @Override ermöglicht dem Compiler die Kontrolle
		Insets insets = getInsets();
		int originX = insets.left;
		int originY = insets.top;
		int breite = getSize().width- insets.left - insets.right;
		int hoehe = getSize().height - insets.top- insets.bottom;
		g.setColor(Color.black);
		g.setFont(g.getFont().deriveFont(25.0f));
		g.clearRect(200, 80, 400, 300);
		g.drawString("Gewinne Blau: ", 220, 100);
		g.drawString("" + model.getWinsO(), 220, 130);
		
		g.drawString("Gewinne Grün: ", 220, 200);
		g.drawString("" + model.getWinsX(), 220, 230);
		if(model.isCurrentPlayer1())g.drawString("Grün ist dran", 220, 290);
		if(!model.isCurrentPlayer1())g.drawString("Blau ist dran", 220, 290);
		g.setColor(Color.gray);
		//g.clearRect(originX, originY, breite-1, hoehe-1);
		for(int i = 0; i < 4; i++ ) {
			for(int j = 0; j < 4; j++ ) {
				for(int k = 0; k < 4; k++ ) {
					int x = (35 * i) + 20 + (10 * j);
					int y = (35 * j) + 50 + (170 * k);
					if(model.getFeld(i, j, k) == 0)g.setColor(Color.gray);
					if(model.getFeld(i, j, k) == 1)g.setColor(Color.green);
					if(model.getFeld(i, j, k) == 2)g.setColor(Color.blue);
					
					g.fillOval(x, y, circleSize, circleSize);
					mousePosToFieldX[i][j][k] = x;
					mousePosToFieldY[i][j][k] = y;
					
				}
				
			}
		}
		
		
	}

	

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Mouse Pressed");
		int x = e.getX();
		int y = e.getY();
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				for(int k = 0; k < 4; k++) {
					if(mousePosToFieldX[i][j][k] <= x && mousePosToFieldX[i][j][k] >= x - circleSize) {
						if(mousePosToFieldY[i][j][k] <= y && mousePosToFieldY[i][j][k]>= y - circleSize) {
							System.out.println("y passt");
							control.setField(i,j,k);
							System.out.println(i + ", " + j + ", " + k);
							return;
						}
					}
				}
			}
		}
		System.out.println("X: " + x + " Y: " + y);
		System.out.println("X: " + mousePosToFieldX[0][0][0] + " Y: " + mousePosToFieldY[0][0][0]);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
} 
