package javaoopproject.listener;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class HelpButtonClickListener implements ActionListener {
	
	String helpInfo = "Sorting Alogorithm is a basic concept that every "
            + "programmer should have known.\n \n "
            + "There are a lot of sorting algorithms, "
            + "but to be suitable with our project, we only focus on 3 algorithms: \n"
            + "+ Merge Sort\n"
            + "+ Counting Sort\n"
            + "+ Radix Sort\n \n"
            + "This application invented aiming to the purpose of visualizing "
            + "these alogrithms in a colorful way to help "
            + "user understand this concept easier and meet our class "
            + "project needs.\n \n"
            + "Without loss of generality, we assume that we will sort only Integers, "
            + "not necessarily distinct, in non-decreasing order in this visualization.\n\n"
            + "Our app is inspired of Visualgo so we named it as VisualSO as "
            + "Visual Sorting algorithms.\n \n"
            + "Everything you need is:\n "
            + "1.Choosing one of 3 algorithms in the blocks to start your journey\n "
            + "2.Create your own array or random array by the leftside button\n "
            + "3.Click Sort and view it visualizes, the explanation will be demonstrate on "
            + "the right side and flow controller at the bottom.\n"
            + "Have fun!";
	
	public void actionPerformed(ActionEvent e) {
		JFrame helpFrame = new JFrame("help menu");
		JTextArea helpContent = new JTextArea(helpInfo);
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
