package javaoopproject;

import java.awt.*;

import java.awt.event.*;
import java.math.BigInteger;

import javax.swing.*;

import javaoopproject.MyButton;
import javaoopproject.algorithm.InsertSorter;
import javaoopproject.algorithm.QuickSorter;
import javaoopproject.algorithm.bubbleSorter;
import javaoopproject.exception.*;
import javaoopproject.listener.*;

public class app extends JFrame{
    private static final int WIDTH = 800;
    private static final int HEIGHT = 1000;
    JPanel homePanel;
    JPanel bubbleSortPanel;
    JPanel InsertSortPanel;
    JPanel quickSortPanel;

    private class BubbleSortListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            homePanel.setVisible(false);
            bubbleSortPanel.setVisible(true);
            InsertSortPanel.setVisible(false);
            quickSortPanel.setVisible(false);
        }
    }
    private class HomePanelListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            homePanel.setVisible(true);
            bubbleSortPanel.setVisible(false);
            InsertSortPanel.setVisible(false);
            quickSortPanel.setVisible(false);
        }
    }
    private class InsetSortPanelListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            homePanel.setVisible(false);
            bubbleSortPanel.setVisible(false);
            InsertSortPanel.setVisible(true);
            quickSortPanel.setVisible(false);
        }
    }
    private class QuickSortPanelListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            homePanel.setVisible(false);
            bubbleSortPanel.setVisible(false);
            InsertSortPanel.setVisible(false);
            quickSortPanel.setVisible(true);
        }
    }
    
    private JPanel createHelpPanel() {
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
    
    public app(){
        super("Sorting Algorithms");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        JLabel welcomeInfo = new JLabel("WELCOME!! Choose from the menu above for desired algorithm and click sort to see the magic happen!!");
        homePanel = new JPanel();
        homePanel.setLayout(new BorderLayout());
        homePanel.add(welcomeInfo, BorderLayout.NORTH);
        homePanel.setVisible(true);
        homePanel.add(createHelpPanel());
        add(homePanel);

        bubbleSortPanel = bubbleSorter.runBubbleSort();
        bubbleSortPanel.setVisible(false);
        add(bubbleSortPanel);

        InsertSortPanel = InsertSorter.runSelectionSort();
        InsertSortPanel.setVisible(false);
        add(InsertSortPanel);

        quickSortPanel = QuickSorter.runQuickSort();
        quickSortPanel.setVisible(false);
        add(quickSortPanel);


        JMenu menu = new JMenu("Menu");
        JMenuItem homeChoice = new JMenuItem("Home");
        homeChoice.addActionListener(new HomePanelListener());
        menu.add(homeChoice);
        JMenuItem bubbleChoice = new JMenuItem("Bubble Sort");
        bubbleChoice.addActionListener(new BubbleSortListener());
        menu.add(bubbleChoice);
        JMenuItem selectionChoice = new JMenuItem("Insert Sort");
        selectionChoice.addActionListener(new InsetSortPanelListener());
        menu.add(selectionChoice);
        JMenuItem quickChoice = new JMenuItem("Quick Sort");
        quickChoice.addActionListener(new QuickSortPanelListener());
        menu.add(quickChoice);

        JMenuBar bar = new JMenuBar();
        bar.add(menu);
        setJMenuBar(bar);
    }

    public static void main(String[] args){
        app gui = new app();
        gui.setVisible(true);
    }
}