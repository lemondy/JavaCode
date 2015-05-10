package com.wtu.lemon.main;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.wtu.lemon.dao.UserDB;

public class Login extends JFrame {
	
	private static final long serialVersionUID = 1L;
	/**
	 * 添加各种控件
	 */
	 
	//主界面的各种控件
	//private JFrame mainFrame;   //主界面的Frame 
	private JButton jb_login, jb_regist; 
	private JPanel jp_mainPanel;
	private String name, pass,identity; 
	private JTextField jt_userName ;
	private JPasswordField jp_passWord ;
	private JLabel logo , jl_user , jl_pass;
	private Dimension screenSize;   //获取当前屏幕的各种属性
	private JRadioButton jrb_tea,jrb_stu,jrb_adm;   //the identity
	private Enumeration<AbstractButton> enumerat;
	private ButtonGroup bg;   //ButtonGroup is not a component ,so it cannot be put into the panel(container)
	 
	//登陆成功的控件
	private JFrame jf_succFrame;
	private JLabel jl_succName ,jl_succPass,jl_succId,jl_succAge,jl_succPhone,jl_succIDF;
	private JPanel jp_succPanel;
	//存储信息
	 
	//注册界面的各种控件
	private JFrame jf_registFrame;
	private JLabel jl_registName ,jl_registPass , jl_registPassCof,jl_registAge,jl_registPhone,jl_registIDF;
 	private JTextField jt_registName,jt_registAge,jt_registPhone,jt_registIDF;
	private JPasswordField jt_registPass , jt_registPassCof;
	private JButton jb_ok , jb_cancle;
 	private JPanel jp_regist ;
 	
 	//对数据库中的数据进行读写
 	UserDB udb = null;
	
	/**
	 * 初始化界面
	 */
	public Login(){
		Container contain = getContentPane();
		contain.setLayout(new BorderLayout());
		//北部图标
		logo = new JLabel();
		logo.setIcon(new ImageIcon("pic/lemon.jpg"));
		contain.add(logo,"North");
		
		jp_mainPanel = new JPanel();
		jp_mainPanel.setLayout(null);
		//登录标签
		jl_user = new JLabel("用户名");
		jl_user.setBounds(70, 30, 50, 20);
		jl_user.setFont(new Font("宋体", Font.PLAIN, 12));
		jp_mainPanel.add(jl_user);
		//用户输入用户名的区域
		jt_userName = new JTextField("",20);
		jt_userName.setHorizontalAlignment(JTextField.LEFT);
		jt_userName.setBounds(120, 30, 160, 20);
		jp_mainPanel.add(jt_userName);
		
		
		//密码标签
		jl_pass = new JLabel("密码");
		jl_pass.setBounds(70, 60, 50, 20);
		jl_pass.setFont(new Font("宋体", Font.PLAIN, 12));
		jp_mainPanel.add(jl_pass);
		//密码输入区
		jp_passWord = new JPasswordField("",20);
		jp_passWord.setBounds(120, 60, 160, 20);
		jp_passWord.setHorizontalAlignment(JTextField.LEFT);
		jp_mainPanel.add(jp_passWord);
		
		//choose identity
		jrb_tea = new JRadioButton("老师",false);
		jrb_tea.setBounds(110,90,80,40);
		
		jrb_stu = new JRadioButton("学生",true);
		jrb_stu.setBounds(200,90,80,40);
		jrb_stu.setHorizontalAlignment(JRadioButton.LEFT);
		
		jrb_adm = new JRadioButton("管理员",false);
		jrb_adm.setBounds(280,90,90,40);
		jrb_stu.setHorizontalAlignment(JRadioButton.LEFT);
		
		bg = new ButtonGroup();
		bg.add(jrb_tea);
		bg.add(jrb_stu);
		bg.add(jrb_adm);
		
		jp_mainPanel.add(jrb_tea);
		jp_mainPanel.add(jrb_stu);
		jp_mainPanel.add(jrb_adm);
		//登录按钮
		jb_login = new JButton("登录");
		jb_login.setBounds(120, 130, 60, 20);
		jp_mainPanel.add(jb_login);
		jb_login.addActionListener(new LoginActionListener());
		
	
		//注册按钮
		jb_regist = new JButton("注册");
		jb_regist.setBounds(200, 130, 60, 20);
		jb_regist.setHorizontalAlignment(JButton.LEFT);
		jp_mainPanel.add(jb_regist,"Center");
		jb_regist.addActionListener(new RegistActionListener());
		
		contain.add(jp_mainPanel);
		//设置主界面的属性
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(400,300);
		setLocation((int)screenSize.getHeight() / 2, (int)screenSize.getWidth() / 5);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}
	
	//响应登录按钮
	class LoginActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			udb = new UserDB();
			enumerat = bg.getElements();
			while(enumerat.hasMoreElements()){
				JRadioButton jrb = (JRadioButton)enumerat.nextElement();
				if(jrb.isSelected())
					identity = jrb.getText();
			}
			name = jt_userName.getText();
			pass = String.copyValueOf(jp_passWord.getPassword());
		 
			if(udb.query(name, pass,identity)){
				//save the user information in the String array
				String[] result = udb.queryInfor(name, pass);
				
				if(result != null){
					jf_succFrame = new JFrame("登录成功");
					Container c = jf_succFrame.getContentPane();
					jp_succPanel = new JPanel();
					jp_succPanel.setLayout(null);
					
					jl_succId = new JLabel();
					jl_succId.setText("ID号："+Integer.parseInt(result[0]));
					jl_succId.setBounds(70,5,100,200);
					jp_succPanel.add(jl_succId);
					
					jl_succName = new JLabel();
					jl_succName.setText("用户名："+name);
					jl_succName.setBounds(70, 25, 100, 200);
					jp_succPanel.add(jl_succName);
					
					jl_succPass = new JLabel();
					jl_succPass.setText("密码："+pass);
					jl_succPass.setBounds(70, 45, 100, 200);
					jp_succPanel.add(jl_succPass);
					
					jl_succAge = new JLabel();
					jl_succAge.setText("年龄："+result[3]);
					jl_succAge.setBounds(70,65,100,200);
					jp_succPanel.add(jl_succAge);
					
					jl_succPhone = new JLabel();
					jl_succPhone.setText("电话号码："+result[4]);
					jl_succPhone.setBounds(70,85,200,200);
					jp_succPanel.add(jl_succPhone);
					
					jl_succIDF = new JLabel();
					jl_succIDF.setText("身份：" + result[5]);
					jl_succIDF.setBounds(70,105,100,200);
					jp_succPanel.add(jl_succIDF);
					
					c.add(jp_succPanel,"Center");
					jf_succFrame.setSize(400, 300);
					jf_succFrame.setLocation(400, 300);
					jf_succFrame.setVisible(true);
					jf_succFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
				}
			}else
				JOptionPane.showMessageDialog(null, "账号或密码不正确，请确保该用户存在", "提示", JOptionPane.INFORMATION_MESSAGE);
		
			
		}
		
	}
	
	
	//注册响应
	class RegistActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			name = jt_userName.getText();
			pass = String.copyValueOf(jp_passWord.getPassword());
				
			jf_registFrame = new JFrame("注册新用户");
			Container c = jf_registFrame.getContentPane();
			jp_regist = new JPanel(); 
			jp_regist.setLayout(null);
			//register name
			jl_registName = new JLabel();
			jl_registName.setText("用户名：");
			jl_registName.setBounds(70, 60, 100, 20);
			jp_regist.add(jl_registName);
			
			jt_registName = new JTextField("",20);
			jt_registName.setBounds(130,60,100,20);
			jt_registName.setHorizontalAlignment(JLabel.LEFT);
			jp_regist.add(jt_registName);
			//register password
			jl_registPass = new JLabel();
			jl_registPass.setText("密码：");
			jl_registPass.setBounds(70, 90, 100, 20);
			jp_regist.add(jl_registPass);
			
			jt_registPass = new JPasswordField("",20);
			jt_registPass.setBounds(130,90,100,20);
			jt_registPass.setHorizontalAlignment(JLabel.LEFT);
			jp_regist.add(jt_registPass);
			
			jl_registPassCof = new JLabel();
			jl_registPassCof.setText("确认密码：");
			jl_registPassCof.setBounds(70, 120, 100, 20);
			jp_regist.add(jl_registPassCof);
			
			jt_registPassCof = new JPasswordField("",20);
			jt_registPassCof.setBounds(130,120,100,20);
			jt_registPassCof.setHorizontalAlignment(JLabel.LEFT);
			jp_regist.add(jt_registPassCof);
			//register age
			jl_registAge = new JLabel("年龄：");
			jl_registAge.setBounds(70, 150, 100, 20);
			jp_regist.add(jl_registAge);
			
			jt_registAge = new JTextField("",20);
			jt_registAge.setBounds(130,150,100,20);
			jp_regist.add(jt_registAge);
			
			//register phone
			jl_registPhone = new JLabel("电话：");
			jl_registPhone.setBounds(70,180,100,20);
			jp_regist.add(jl_registPhone);
			
			jt_registPhone = new JTextField("",20);
			jt_registPhone.setBounds(130,180,100,20);
			jp_regist.add(jt_registPhone);
			
			//register identity
			jl_registIDF = new JLabel("身份：");
			jl_registIDF.setBounds(70,210,100,20);
			jp_regist.add(jl_registIDF);
			
			jt_registIDF = new JTextField("",20);
			jt_registIDF.setBounds(130,210,100,20);
			jp_regist.add(jt_registIDF);
			
			jb_ok = new JButton("确定");
			jb_ok.setBounds(130, 240, 60, 30);
			jp_regist.add(jb_ok);
			jb_ok.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					udb = new UserDB();
					if(String.copyValueOf(jt_registPass.getPassword()).equals(String.copyValueOf(jt_registPassCof.getPassword()))){
						
						if(udb.regist(jt_registName.getText(),jt_registPass.getText(),Integer.parseInt(jt_registAge.getText()),jt_registPhone.getText(),jt_registIDF.getText()))
							JOptionPane.showMessageDialog(null,"注册成功","successful",JOptionPane.INFORMATION_MESSAGE);
						else
							JOptionPane.showMessageDialog(null,"注册失败","successful",JOptionPane.INFORMATION_MESSAGE);

						 
					}else
						JOptionPane.showMessageDialog(null, "密码两次不同，重新输入", "提示", JOptionPane.INFORMATION_MESSAGE);

					
				}

			});
			
			jb_cancle = new JButton("取消");
			jb_cancle.setBounds(220, 240, 60, 30);
			jb_cancle.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					 jf_registFrame.dispose();
				}
				
			});
			jp_regist.add(jb_cancle);
			
			c.add(jp_regist,"Center");
			jf_registFrame.setSize(450, 350);
			jf_registFrame.setLocation(400, 300);
			jf_registFrame.setVisible(true);
			jf_registFrame.setResizable(false);
			jf_registFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
			c.add(jp_regist,"Center");
		}
		
	}
	
	  
	 
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new Login();
	}


}
