package com.wtu.softengineer.ui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class InsulinPump extends javax.swing.JFrame {
	private JRadioButton power;
	private JPanel jPanel1;
	private JButton mannual;
	private JButton addDose;
	private JTextField jt_currentBlood;
	private JLabel currentBlood;
	private JTextField jTextField1;
	private JLabel insulinReservior;
	private JLabel jl_battery;
	private JTextField jt_runtime;
	private JLabel runtime;
	private JTextField jt_cumulative;
	private JLabel cumulativeInsulin;
	private JTextField jt_lastInsulin;
	private JLabel lastInsulin;
	private JTextField time;
	private JLabel manInsulinDose;
	private JButton decrease;
	private JTextField InsulinDose;
	private JTextArea showWave;
	private JLabel battery;
	private JProgressBar jProgressBar1;
	private JButton autoRun;
	private JLabel currentTime;
	private JLabel jLabel1;
	private JTextArea warning;
	private JButton switchOff;
	private JButton switchOn;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				InsulinPump inst = new InsulinPump();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public InsulinPump() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			this.setTitle("\u80f0\u5c9b\u7d20\u6cf5\u6a21\u62df\u5668");
			getContentPane().setLayout(null);
			{
				power = new JRadioButton();
				getContentPane().add(power, "Center");
				power.setText("power");
				power.setBounds(20, 10, 71, 32);
			}
			{
				jPanel1 = new JPanel();
				getContentPane().add(jPanel1, "East");
				jPanel1.setLayout(null);
				jPanel1.setBounds(649, 12, 170, 343);
				{
					switchOn = new JButton();
					jPanel1.add(switchOn);
					switchOn.setText("\u6253\u5f00");
					switchOn.setBounds(34, 79, 60, 34);
				}
				{
					jProgressBar1 = new JProgressBar();
					jPanel1.add(jProgressBar1);
					jProgressBar1.setBounds(12, 12, 99, 16);
				}
				{
					autoRun = new JButton();
					jPanel1.add(autoRun);
					autoRun.setText("\u81ea\u52a8");
					autoRun.setBounds(34, 265, 60, 34);
				}
				{
					switchOff = new JButton();
					jPanel1.add(switchOff);
					switchOff.setText("\u5173\u95ed");
					switchOff.setBounds(34, 144, 60, 31);
				}
				{
					mannual = new JButton();
					jPanel1.add(mannual);
					mannual.setText("\u624b\u52a8");
					mannual.setBounds(34, 207, 60, 29);
				}
				{
					jl_battery = new JLabel();
					jPanel1.add(jl_battery);
					jl_battery.setBounds(123, 12, 35, 10);
					jl_battery.setText("100%");
				}
			}
			{
				battery = new JLabel();
				getContentPane().add(battery);
				battery.setText("\u7535\u91cf");
				battery.setBounds(607, 25, 24, 17);
			}
			{
				showWave = new JTextArea();
				getContentPane().add(showWave);
				showWave.setBounds(247, 146, 378, 166);
			}
			{
				InsulinDose = new JTextField();
				getContentPane().add(InsulinDose);
				InsulinDose.setBounds(490, 87, 55, 24);
			}
			{
				addDose = new JButton();
				getContentPane().add(addDose);
				addDose.setText("\u254b");
				addDose.setBounds(573, 76, 21, 24);
			}
			{
				decrease = new JButton();
				getContentPane().add(decrease);
				decrease.setText("\u2501");
				decrease.setBounds(573, 111, 21, 24);
			}
			{
				manInsulinDose = new JLabel();
				getContentPane().add(manInsulinDose);
				manInsulinDose.setText("\u624b\u52a8\u72b6\u6001\u6ce8\u5c04\u91cf");
				manInsulinDose.setBounds(394, 90, 84, 17);
			}
			{
				time = new JTextField();
				getContentPane().add(time);
				time.setBounds(439, 9, 79, 24);
			}
			{
				lastInsulin = new JLabel();
				getContentPane().add(lastInsulin);
				lastInsulin.setText("\u4e0a\u4e00\u6b21\u6ce8\u5c04\u80f0\u5c9b\u7d20\u91cf\uff1a");
				lastInsulin.setBounds(12, 186, 131, 17);
			}
			{
				jt_lastInsulin = new JTextField();
				getContentPane().add(jt_lastInsulin);
				jt_lastInsulin.setBounds(155, 183, 60, 24);
			}
			{
				cumulativeInsulin = new JLabel();
				getContentPane().add(cumulativeInsulin);
				cumulativeInsulin.setText("\u7d2f\u79ef\u80f0\u5c9b\u7d20\u91cf\uff1a");
				cumulativeInsulin.setBounds(32, 235, 92, 17);
			}
			{
				jt_cumulative = new JTextField();
				getContentPane().add(jt_cumulative);
				jt_cumulative.setBounds(155, 232, 60, 24);
			}
			{
				runtime = new JLabel();
				getContentPane().add(runtime);
				runtime.setText("\u7cfb\u7edf\u5df2\u8fd0\u884c\u65f6\u95f4");
				runtime.setBounds(247, 349, 84, 17);
			}
			{
				jt_runtime = new JTextField();
				getContentPane().add(jt_runtime);
				jt_runtime.setBounds(349, 346, 56, 24);
			}
			{
				insulinReservior = new JLabel();
				getContentPane().add(insulinReservior);
				insulinReservior.setText("\u80f0\u5c9b\u7d20\u5bb9\u5668\u5269\u4f59\u91cf\uff1a");
				insulinReservior.setBounds(12, 284, 112, 17);
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1);
				jTextField1.setBounds(155, 277, 60, 24);
			}
			{
				currentBlood = new JLabel();
				getContentPane().add(currentBlood);
				currentBlood.setText("\u5f53\u524d\u8840\u7cd6\u542b\u91cf\uff1a");
				currentBlood.setBounds(36, 157, 88, 17);
			}
			{
				jt_currentBlood = new JTextField();
				getContentPane().add(jt_currentBlood);
				jt_currentBlood.setBounds(155, 147, 60, 24);
			}
			{
				warning = new JTextArea();
				getContentPane().add(warning);
				warning.setBounds(70, 63, 177, 58);
			}
			{
				jLabel1 = new JLabel();
				getContentPane().add(jLabel1);
				jLabel1.setText("\u8b66\u544a");
				jLabel1.setBounds(28, 79, 24, 17);
			}
			{
				currentTime = new JLabel();
				getContentPane().add(currentTime);
				currentTime.setText("\u5f53\u524d\u65f6\u95f4");
				currentTime.setBounds(373, 12, 48, 17);
			}
			pack();
			this.setSize(835, 434);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
