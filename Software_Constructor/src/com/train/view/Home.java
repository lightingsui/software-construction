package com.train.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

@SuppressWarnings("serial")
public class Home extends JPanel {
	public Home() {
		setBackground(Color.PINK);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("欢迎使用电厂职工培训管理系统");
		lblNewLabel.setFont(new Font("华文行楷", Font.BOLD, 26));
		lblNewLabel.setBounds(141, 41, 386, 75);
		add(lblNewLabel);
		
		JLabel lblCopyrightYachao = new JLabel("Copyright@ yachao");
		lblCopyrightYachao.setFont(new Font("Segoe Print", Font.BOLD, 19));
		lblCopyrightYachao.setBounds(344, 341, 235, 45);
		add(lblCopyrightYachao);
	}
	

}
