package javaoopproject.algorithm;

import java.awt.*;


import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.swing.*;
import javaoopproject.utils.*;

public class bubbleSorter extends JPanel {
    private final static int BAR_WIDTH = 30;
    private final static int BAR_HEIGHT = 400;
    private int[]list;
    
    private static JPanel mainPanel;

    public bubbleSorter(){
    }
    public bubbleSorter(int[] list){
        this.list = list;
    }

    private void setItems(int[] list){
        this.list = list;
        repaint();
    }

    private void sort(){
        new SortWorker(list).execute();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        for(int i = 0; i < list.length; i++){
            int x = i * BAR_WIDTH;
            int y = getHeight() - list[i];

            g.setColor( Color.RED );
            g.fillRect(x, y, BAR_WIDTH, list[i]);
            g.setColor( Color.BLUE );
            g.drawString("" + list[i], x, y);
        }
    }

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(list.length * BAR_WIDTH, BAR_HEIGHT + 20);
    }

    private class SortWorker extends SwingWorker<Void, int[]>{
        private int[] list;

        public SortWorker(int[] unsortedItems){
            list = Arrays.copyOf(unsortedItems, unsortedItems.length);
        }

        @Override
        protected Void doInBackground(){
            int n = list.length;
            int temp = 0;

            for(int i = 0; i < (n-1); i++){
                for(int j = 0; j < (n-i-1); j++){
                    if(list[j] > list[j+1]){
                        temp = list[j];
                        list[j] = list[j+1];
                        list[j+1] = temp;
                        
                        publish( Arrays.copyOf(list, list.length) );
                        try { Thread.sleep(100); } catch (Exception e) {}
                    }
                }
            }

            Toolkit tk = Toolkit.getDefaultToolkit();
            tk.beep();
            return null;
        }

        @Override
        protected void process(List<int[]> processList){
            int[] list = processList.get(processList.size() - 1);
            setItems( list );
        }

        @Override
        protected void done() {}
    }

    public static JPanel runBubbleSort(){
        bubbleSorter bubbleSort = new bubbleSorter(StringUtils.generateListNumbers());

        JLabel title = new JLabel("Bubble Sort");
        
        JButton generate = new JButton("Generate Data");
        generate.addActionListener((e)->bubbleSort.setItems(StringUtils.generateListNumbers()));
        JButton sort = new JButton("Sort Data");
        sort.addActionListener((e) -> bubbleSort.sort());

        JPanel bottomPanel = new JPanel();
        bottomPanel.add( generate );
        bottomPanel.add( sort );
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(bubbleSort, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        mainPanel.add(title, BorderLayout.NORTH);

        return mainPanel;
    }
}