package com.view.home;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class Home extends JPanel {
	public Home() {
		setSize(630, 474);
		setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel contentPane = new JPanel();
		contentPane.setBounds(0, 0, 630, 474);
		add(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("欢迎使用电厂职工培训管理系统");
		lblNewLabel.setBounds(70, 20, 448, 34);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("华文行楷", Font.BOLD, 30));
		
		JLabel lblCopyrightSui = new JLabel("Copyright@ Sui");
		lblCopyrightSui.setBounds(255, 425, 170, 27);
		contentPane.add(lblCopyrightSui);
		lblCopyrightSui.setFont(new Font("华文仿宋", Font.BOLD, 20));
		
		JLabel lbl_background = new JLabel(new ImageIcon("./images/main_background.jpg"));
		lbl_background.setBounds(0, 0, 630, 474);
		contentPane.add(lbl_background);
	}
}
