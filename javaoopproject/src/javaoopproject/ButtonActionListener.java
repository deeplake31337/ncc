package javaoopproject;

import java.awt.event.ActionEvent;

import javax.swing.JButton;

import java.awt.event.ActionListener;

public class ButtonActionListener implements ActionListener{
	public void actionPerformed(ActionEvent e) {
		switch(((JButton)e.getSource()).getText()) {
		case ">":
		case "<":
		case "create":
		case "random":
		case "run":
		}
	}
}
