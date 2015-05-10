package com.wtu.lemon.calendar;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * 
 * @author dell
 *你那日历显示好有点问题，比如2012-11和我电脑上显示的不一致，算法有问题，还有下面week有问题
 */
public class CalenderExample 
{
	public static void main(String[] args) 
	{
		new GoodWindow();
	}

}
class GoodWindow extends JFrame implements ItemListener
{
	JComboBox list=null;
	CalenderPane calenderPane=null;
	Container con=null;
	GoodWindow()
	{
		list=new JComboBox();
		for(int i=2000;i<2020;i++)
		{
			String temp=""+i;
		list.addItem(temp);
		}
		list.addItemListener(this);
		con=this.getContentPane();
		con.add(list,BorderLayout.NORTH);
		calenderPane=new CalenderPane(2005);
		con.add(calenderPane,BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,400,240);
		setVisible(true);
		validate();
	}
	public void itemStateChanged(ItemEvent e)
	{
		con.remove(calenderPane);
		String str=(String)list.getSelectedItem();
		int year=Integer.parseInt(str);
		calenderPane=new CalenderPane(year);
		con.add(calenderPane,BorderLayout.CENTER);
		con.validate();
		validate();
	}
}
class CalenderPane extends JPanel implements ActionListener
{
	JTable table;
	Object a[][]=new Object[6][7];
	Object name[]={"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
	JButton nextMonth,previousMonth;
	int year=2005,month=1;
	CalendarBean calendar;
	JLabel showMessage=new JLabel("",JLabel.CENTER);
	public CalenderPane(int year)
	{
		setLayout(new BorderLayout());
		calendar=new CalendarBean();
		calendar.setYear(year);
		calendar.setMonth(month);
		String day[]=calendar.getCalendar();
		table=new JTable(a,name);
		table.setRowSelectionAllowed(false);
		setTable(day);
		nextMonth=new JButton("下月");
		previousMonth=new JButton("上月");
		
		nextMonth.addActionListener(this);
		previousMonth.addActionListener(this);
		
		JPanel pNorth=new JPanel(),pSouth=new JPanel();
		
		pNorth.add(previousMonth);
		pNorth.add(nextMonth);
		pSouth.add(showMessage);
		
		showMessage.setText("日历："+calendar.getYear()+"年"+calendar.getMonth()+"月");
		add(new JScrollPane(table),BorderLayout.CENTER);
		add(pNorth,BorderLayout.NORTH);
		add(pSouth,BorderLayout.SOUTH);
		validate();	
		
	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==nextMonth)
		{
			month=month+1;
			if(month>12)
			{
				month=1;
			}
			calendar.setMonth(month);
			String day[]=calendar.getCalendar();
			setTable(day);
			table.repaint();
		}
		else if(e.getSource()==previousMonth)
		{
			month=month-1;
			if(month<1)
			{
				month=12;
			}
			calendar.setMonth(month);
			String day[]=calendar.getCalendar();
			setTable(day);
			table.repaint();
		}
		showMessage.setText("日历："+calendar.getYear()+"年"+calendar.getMonth()+"月");
	}
	public void setTable(String day[])
	{
			int n=0;
			for(int i=0;i<6;i++)
			{
				for(int j=0;j<7;j++)
				{
					a[i][j]=day[n];
					n++;
				}
			}
	}
}
class CalendarBean
{
		String day[];
		int year=2005,month=0;
	public void setYear(int year)
	{
		this.year=year;
	}
	public int getYear()
    {
		return year;
    }
	public void setMonth(int month)
	{
		this.month=month;
	}
	public int getMonth()
	{
		return month;
	}
	public String[] getCalendar()
	{
		String a[]=new String[42];
		Calendar ca=Calendar.getInstance();
		ca.set(year,month-1,1);
		//int week=ca.get(Calendar.DAY_OF_WEEK-1);    这里用的有点问题，week = 335；所以下面会抛出数组越界的异常
		int week = Calendar.DAY_OF_WEEK;
		int day=0;
		if(month==1||month==3||month==5||month==7||month==10||month==12)
			day=31;
		if(month==4||month==6||month==9||month==11)
			day=30;
		if(month==2)
		{
			if(((year%4==0)&&(year%100!=0))||(year%400==0))
				day=29;
			else day=28;
		}
		for(int i = week, n = 1;i < week+day; i++)
		{
			a[i]=String.valueOf(n);
			n++;
		}
		return a;
	}
}
 
