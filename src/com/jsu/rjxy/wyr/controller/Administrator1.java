package com.jsu.rjxy.wyr.controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jsu.rjxy.wyr.dao.DatabaseToExcel;
import com.jsu.rjxy.wyr.dao.ExcelToDatabase;
import com.jsu.rjxy.wyr.service.Deleting;
import com.jsu.rjxy.wyr.service.Entering;
import com.jsu.rjxy.wyr.service.Selecting;
import com.jsu.rjxy.wyr.service.Updating;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Color;
/**
 * 管理员主界面窗口类
 * @author 52820
 *
 */
public class Administrator1 extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Administrator1 frame = new Administrator1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 管理员操作界面方法
	 */
	public Administrator1() {
		setTitle("\u8F66\u7968\u7BA1\u7406");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(390, 170, 638, 433);
		contentPane = new JPanel(){//重写paint的一个方法绘制背景图片
            @Override
            protected void paintComponent(Graphics g) {
         	    super.paintComponent(g);
         	    ImageIcon img = new ImageIcon("source\\img\\bg.jpg");  
  	            img.paintIcon(this, g, -350, -100);
            }
       };
        contentPane.setOpaque(true);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u8FDB\u5165\u8F66\u7968\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 28));
		lblNewLabel.setBounds(172, 21, 334, 72);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u5F55\u5165");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Entering a=new Entering();
				a.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(38, 149, 89, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Selecting b=new Selecting();
				b.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(189, 149, 89, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u5220\u9664");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deleting d=new Deleting();
				d.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_2.setBounds(341, 149, 89, 39);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("\u4FEE\u6539");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Updating up=new Updating();
				up.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_3.setBounds(490, 149, 89, 39);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("\u8FD4\u56DE");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_4.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_4.setBounds(480, 333, 99, 39);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_3_1 = new JButton("\u5BFC\u51FA\u6570\u636E\u5230Excel");
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatabaseToExcel.main(null);
				JOptionPane.showMessageDialog(null, "已导出数据到Excel！");
			}
		});
		btnNewButton_3_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_3_1.setBounds(80, 241, 198, 39);
		contentPane.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_2 = new JButton("\u5BFC\u5165Excel\u6587\u4EF6");
		btnNewButton_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExcelToDatabase.main(null);
				JOptionPane.showMessageDialog(null, "已导入Excel文件！");
			}
		});
		btnNewButton_3_2.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_3_2.setBounds(341, 241, 172, 39);
		contentPane.add(btnNewButton_3_2);
	}
}
