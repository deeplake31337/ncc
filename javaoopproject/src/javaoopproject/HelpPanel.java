package javaoopproject;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import javaoopproject.listener.*;

public class HelpPanel implements ActionListener {
    public JPanel createHelpPanel() {
    	JPanel helpPanel = new JPanel();
    	MyButton btnHelp = new MyButton(50, 30, Color.BLACK);
    	btnHelp.setText("Help");
    	helpPanel.add(btnHelp);
    	btnHelp.addActionListener(new HelpButtonClickListener());
    	MyButton btnAbout = new MyButton(50, 30, Color.BLACK);
    	btnAbout.setText("About");
    	helpPanel.add(btnAbout);
    	btnAbout.addActionListener(new AboutButtonClickListener());
    	MyButton btnExist = new MyButton(50, 30, Color.BLACK);
    	btnExist.setText("Exit");
    	btnExist.addActionListener(new CloseProgramListener());
    	helpPanel.add(btnExist);
    	return helpPanel;
    }

	@Override
	public void actionPerformed(ActionEvent e) {		
	}
}
