import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;

public class PopUp extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JFrame frame = new JFrame();
	private JTextPane text = new JTextPane();
	private JButton jbtn = new JButton("<html><font size = 25>Neustart</font></html>");
	
	public PopUp(Model model, Control control) {
		frame.setLayout(new GridLayout(2,1));
		jbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				control.restart();
				setVisible(false);
			}
		});
		text.setContentType("text/html");
		text.setEditable(false);
		frame.setBounds(0, 0, 400, 730);
		frame.getContentPane().add(text);
		frame.getContentPane().add(jbtn);
		
	}
	public void setVisible(boolean bool) {
		frame.setVisible(bool);
	}
	
	public void setText(String text) {
		this.text.setText("<html><font size = 25>" + text + "</font></html>");
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
