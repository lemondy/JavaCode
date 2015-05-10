package com.wtu.softengineer.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.UnsupportedEncodingException;

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

import test.JFSwingDynamicChart;

public class BloodSugarWave extends JFrame{
	private TimeSeries series;  
    private double lastValue = 100.0;  
      
    /** 
     * 构造 
     */  
    public BloodSugarWave() {  
        getContentPane().setBackground(Color.green);  
    }  
  
    /** 
     * 创建应用程序界面 
     */  
    public void createUI() {  
        this.series = new TimeSeries("BloodSugarWave", Millisecond.class);  
        TimeSeriesCollection dataset = new TimeSeriesCollection(this.series);  
        ChartPanel chartPanel = new ChartPanel(createChart(dataset));  
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));  
  
        JPanel buttonPanel = new JPanel();  
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));  
        add(chartPanel);  
        add(buttonPanel, BorderLayout.SOUTH);  
    }  
  
    /** 
     * 根据结果集构造JFreechart报表对象 
     *  
     * @param dataset 
     * @return 
     */  
    private JFreeChart createChart(XYDataset dataset) {  
        JFreeChart result;
		result = ChartFactory.createTimeSeriesChart(null, null,  null, dataset, false, false, false);
		 XYPlot plot = (XYPlot) result.getPlot();  
	        ValueAxis axis = plot.getDomainAxis();  
	        axis.setAutoRange(true);  
	        axis.setFixedAutoRange(60000.0);  
	        axis = plot.getRangeAxis();  
	        axis.setRange(0.0, 200.0);  
	        return result;
	
    }  
  
  
    /** 
     * 动态运行 
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
  
    // 主函数入口  
    public static void main(String[] args) {  
        JFSwingDynamicChart jsdChart = new JFSwingDynamicChart();  
       // jsdChart.setTitle("Swing动态折线图");  
        jsdChart.createUI();  
        jsdChart.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        jsdChart.setBounds(100, 100, 900, 600);  
        jsdChart.setVisible(true);  
        
        jsdChart.dynamicRun();  
    }  
}
