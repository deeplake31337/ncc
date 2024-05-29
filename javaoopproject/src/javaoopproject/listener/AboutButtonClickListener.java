package javaoopproject.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class AboutButtonClickListener implements ActionListener {
	String aboutInfo = "\nVisualSO, a sorting visualizer, is made by Team 16, Object-oriented Programming course (HUST20212) "
            + "with the support of:\n\n"
            + "1.Dr. Nguyen Thi Thu Trang\n"
            + "  Senior Lecture, Hanoi University of Science and Technology\n\n"
            + "2.Ms. Nguyen Thi Thu Giang and Mr. Vuong Dinh An\n"
            + "  Teaching Assistants, Hanoi University of Science and Technology\n\n\n"
            + "Our team includes:\n\n"
            + "1. Nguyen Tong Minh\n     20204885 - Elitech DS&AI K65\n\n"
            + "2. Ly Nhat Nam\n     20204886 - Elitech DS&AI K65\n\n"
            + "3. Pham Thanh Nam\n     20204921 - Elitech DS&AI K65\n\n"
            + "4. Nguyen Xuan Nam\n     20200422 - Elitech DS&AI K65";
	
	public void actionPerformed(ActionEvent e) {
		JFrame helpFrame = new JFrame("About us");
		JTextArea helpContent = new JTextArea(aboutInfo);
		helpContent.setOpaque(true);
		helpContent.setBackground(Color.black);
		helpContent.setForeground(Color.WHITE);
		helpContent.setEditable(false);
		helpContent.setFocusable(false);
		helpContent.setLineWrap(true);
		helpContent.setWrapStyleWord(true);
		helpContent.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		helpFrame.setSize(500,480);
		helpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		helpFrame.setLocationRelativeTo(null);
		helpFrame.setResizable(false);
		helpFrame.add(helpContent);
		helpFrame.setVisible(true);
		helpFrame.addWindowFocusListener(new WindowFocusListener() {
			@Override
			public void windowGainedFocus(WindowEvent e) {
			}
			@Override
			public void windowLostFocus(WindowEvent a) {
				((JFrame)a.getSource()).dispose();
			}
		});
	}
}