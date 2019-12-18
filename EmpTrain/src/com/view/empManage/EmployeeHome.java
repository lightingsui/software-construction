package com.view.empManage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class EmployeeHome extends JInternalFrame {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeHome frame = new EmployeeHome();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EmployeeHome() {
		setSize(924, 534);
		setBackground(Color.cyan);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("欢迎使用电厂职工培训管理系统");
		lblNewLabel.setFont(new Font("华文行楷", Font.BOLD, 30));
		lblNewLabel.setBounds(245, 34, 453, 75);
		getContentPane().add(lblNewLabel);
		
		JLabel lblCopyrightSui = new JLabel("Copyright@ Sui");
		lblCopyrightSui.setFont(new Font("华文仿宋", Font.BOLD, 20));
		lblCopyrightSui.setBounds(390, 397, 187, 45);
		getContentPane().add(lblCopyrightSui);
		
		setVisible(true);
	}

}
