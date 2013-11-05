package oving5;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GuiFrame {
	
	/**
	 * Creates a JFrame that shows the final result
	 * @param b
	 * @param timeSpent
	 * @param iterations
	 */
	public GuiFrame(Board b, long timeSpent, int iterations, String first) {
		
		final JFrame f = new JFrame(first + " "+timeSpent+"ms, over "+iterations+" Iterations");
		JPanel panel = new JPanel(new GridLayout(b.k,b.k,0,0));
		
		//Add the images to the GridLayout.
		for(int y=0; y<b.k; y++) {
			for(int x=0; x<b.k; x++) {
				JLabel l = null;
				if(b.getSquare(x, y).isQueen())
					l = new JLabel(new ImageIcon("images/queen.png"), JLabel.CENTER);
				else
					l = new JLabel(new ImageIcon("images/empty.png"), JLabel.CENTER);
				l.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				panel.add(l);
			}
		}
		
		//"Initialize" the frame
		f.setContentPane(panel);
		f.setSize(b.k*30+30, b.k*30+30);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		//To get the frame to the front and gain focus.
		int state = f.getExtendedState();
		state &= ~JFrame.ICONIFIED;
		f.setExtendedState(state);
		f.setAlwaysOnTop(true);
		f.toFront();
		f.requestFocus();
		f.setAlwaysOnTop(false);
	}
}
