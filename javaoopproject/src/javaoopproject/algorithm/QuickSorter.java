package javaoopproject.algorithm;

import java.awt.*;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javax.swing.*;

import javaoopproject.utils.*;

public class QuickSorter extends JPanel{
    private final static int BAR_WIDTH = 30;
    private final static int BAR_HEIGHT = 400;
    private int[]list;
    private static JPanel mainPanel;

    private QuickSorter(int[] list){
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

        public void swap(int[]list, int i, int j){
            int temp = list[i];
            list[i] = list[j];
            list[j] = temp;

            publish( Arrays.copyOf(list, list.length) );
            try { Thread.sleep(100); } catch (Exception e) {}
        }

        public int partition(int[] list, int low, int high){
            int pivot = list[high];

            int i = (low - 1);

            for(int j = low; j <= (high - 1); j++){
                if(list[j] < pivot){
                    i++;
                    swap(list, i, j);
                }
            }

            swap(list, i + 1, high);

            return (i + 1);
        }

        public void QuickSort(int[] list, int low, int high){
            if(low < high){
                int pi = partition(list, low, high);

                QuickSort(list, low, pi - 1);
                QuickSort(list, pi + 1, high);
            }
        }

        @Override
        protected Void doInBackground(){
            int n = list.length;

            QuickSort(list, 0, n - 1);

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

    private static int[]generateListNumbers(){
        int[] list = new int[20];

        Random random = new Random();
        for(int i = 0; i < list.length; i++){
            list[i] = random.nextInt(QuickSorter.BAR_HEIGHT);
        }

        return list;
    }

    public static JPanel runQuickSort(){
        QuickSorter quickSort = new QuickSorter(StringUtils.generateListNumbers());

        JLabel title = new JLabel("Quick Sort");
        
        JButton generate = new JButton("Generate Data");
        generate.addActionListener((e)->quickSort.setItems(StringUtils.generateListNumbers()));
        JButton sort = new JButton("Sort Data");
        sort.addActionListener((e) -> quickSort.sort());

        JPanel bottomPanel = new JPanel();
        bottomPanel.add(generate);
        bottomPanel.add(sort);
        
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(quickSort, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
        mainPanel.add(title, BorderLayout.NORTH);

        return mainPanel;
    }
}