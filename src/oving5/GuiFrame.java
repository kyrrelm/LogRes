package oving5;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class GuiFrame {
	
	public GuiFrame(Board b, long timeSpent, int iterations) {
		
		final JFrame f = new JFrame("Results: "+timeSpent+"ms, over "+iterations+" Iterations");
		JPanel panel = new JPanel(new GridLayout(b.k,b.k,0,0));
		
		for(int y=0; y<b.k; y++) {
			for(int x=0; x<b.k; x++) {
				JLabel l = null;
				if(b.getSquare(x, y).isQueen())
					l = new JLabel(new ImageIcon("images/queen.png"), JLabel.CENTER);
				else
					l = new JLabel(new ImageIcon("images/empty.png"), JLabel.CENTER);
				l.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
				panel.add(l);
			}
		}
		f.setContentPane(panel);
		f.setSize(b.k*30+30, b.k*30+30);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

}
