package javaoopproject.algorithm;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.swing.*;
import javaoopproject.utils.*;

public class InsertSorter extends JPanel{
    private final static int BAR_WIDTH = 30;
    private final static int BAR_HEIGHT = 400;
    private int[]list;
    private static JPanel mainPanel;

    private InsertSorter(int[] list){
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
            for (int i = 1; i < n; ++i) {
                int key = list[i];
                int j = i - 1;

                while (j >= 0 && list[j] > key) {
                	list[j + 1] = list[j];
                    j = j - 1;
                }
                list[j + 1] = key;

                publish( Arrays.copyOf(list, list.length) );
                try { Thread.sleep(100); } catch (Exception e) {}
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

    public static JPanel runSelectionSort(){
    	InsertSorter selectionSort = new InsertSorter(StringUtils.generateListNumbers());

        JLabel title = new JLabel("Insert Sort");
        
        JButton generate = new JButton("Generate Data");
        generate.addActionListener((e)->selectionSort.setItems(StringUtils.generateListNumbers()));
        JButton sort = new JButton("Sort Data");
        sort.addActionListener((e) -> selectionSort.sort());

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(generate);
        bottomPanel.add(sort);
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(selectionSort, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        mainPanel.add(title, BorderLayout.NORTH);

        return mainPanel;
    }
}