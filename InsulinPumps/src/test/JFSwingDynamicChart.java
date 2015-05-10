package test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

public class JFSwingDynamicChart extends JFrame implements ActionListener {  
    private TimeSeries series;  
    private double lastValue = 100.0;  
      
    /** 
     * ���� 
     */  
    public JFSwingDynamicChart() {  
        getContentPane().setBackground(Color.green);  
    }  
  
    /** 
     * ����Ӧ�ó������ 
     */  
    public void createUI() {  
        this.series = new TimeSeries("Ѫ�ǲ���ͼ", Millisecond.class);  
        TimeSeriesCollection dataset = new TimeSeriesCollection(this.series);  
        ChartPanel chartPanel = new ChartPanel(createChart(dataset));  
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));  
  
        JPanel buttonPanel = new JPanel();  
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));  
        add(chartPanel);  
        add(buttonPanel, BorderLayout.SOUTH);  
    }  
  
    /** 
     * ���ݽ��������JFreechart������� 
     *  
     * @param dataset 
     * @return 
     */  
    private JFreeChart createChart(XYDataset dataset) {  
        JFreeChart result = ChartFactory.createTimeSeriesChart("Swing��̬����ͼ", "ϵͳ��ǰʱ��",  
                "��̬��ֵ�仯", dataset, true, true, false);  
        XYPlot plot = (XYPlot) result.getPlot();  
        ValueAxis axis = plot.getDomainAxis();  
        axis.setAutoRange(true);  
        axis.setFixedAutoRange(60000.0);  
        axis = plot.getRangeAxis();  
        axis.setRange(0.0, 200.0);  
        return result;  
    }  
  
    public void actionPerformed(ActionEvent e) {  
    }  
  
    /** 
     * ��̬���� 
     */  
    public void dynamicRun() {  
        while (true) {  
            double factor = 0.90 + 0.2 * Math.random();  
            this.lastValue = this.lastValue * factor;  
            Millisecond now = new Millisecond();  
            this.series.add(new Millisecond(), this.lastValue);  
            try {  
                Thread.currentThread().sleep(100);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
  
    // ���������  
    public static void main(String[] args) {  
        JFSwingDynamicChart jsdChart = new JFSwingDynamicChart();  
        jsdChart.setTitle("Swing��̬����ͼ");  
        jsdChart.createUI();  
        jsdChart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        jsdChart.setBounds(100, 100, 900, 600);  
        jsdChart.setVisible(true);  
//      Color c=new Color((int)(Math.random()*256),(int)(Math.random()*256),(int)(Math.random()*256));   
          
        jsdChart.dynamicRun();  
    }  
  
}  