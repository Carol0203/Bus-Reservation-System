package com.jsu.rjxy.wyr.service;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.junit.Test;

import com.jsu.rjxy.wyr.dao.DatabaseConnectionSql;

import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.awt.event.ActionEvent;
/**
 * 管理员录入信息类
 * @author 52820
 *
 */
@SuppressWarnings("serial")
public class Entering extends JFrame {

	private JPanel contentPane;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField;
	private JTextField textField_1;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Entering frame = new Entering();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 录入信息方法
	 */
	public Entering() {
		setTitle("\u5F55\u5165\u6C7D\u8F66\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(390, 200, 539, 539);
		contentPane = new JPanel(){//重写paint的一个方法绘制背景图片
            @Override
            protected void paintComponent(Graphics g) {
         	    super.paintComponent(g);
         	    ImageIcon img = new ImageIcon("source\\img\\风景3.png");  
  	            img.paintIcon(this, g, -350, -100);
            }
       };
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5F55\u5165\u4FE1\u606F");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel.setBounds(169, 10, 86, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u51FA\u53D1\u57CE\u5E02");
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(38, 137, 103, 34);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u5230\u8FBE\u57CE\u5E02");
		lblNewLabel_1_1.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(38, 203, 103, 32);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\u51FA\u53D1\u65F6\u95F4");
		lblNewLabel_1_2.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(38, 265, 103, 32);
		contentPane.add(lblNewLabel_1_2);
		
		JButton btnNewButton = new JButton("录入");
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * 写入文本文件
				 */
				String a1 = String.valueOf(textField_3.getText());
				String a2 = textField_4.getText();
				String a3 = textField_5.getText();
				String a4 = textField_6.getText();
				String a5 = String.valueOf(textField.getText());
				String a6 = String.valueOf(textField_1.getText());
				String[] str = new String[] {a1,a2,a3,a4,a5,a6};
				String w=a1+"\t"+a2+"\t"+a3+"\t"+a4+"\t"+a5+"\t"+a6+"\n";
				String sql = "insert into selecting (carnumber,start,destination,time,price,ticket) values(?,?,?,?,?,?)";
				new DatabaseConnectionSql().add(sql, str);
				JOptionPane.showMessageDialog(null, "录入成功！");
				File file = new File("D:\\用户信息.txt"); 
				Writer out=null;
				try {
					out=new FileWriter(file,true);
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
				try {
					out.write(w);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "已成功写入文件");
				try {
					out.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(101, 452, 93, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("退出");
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(296, 452, 93, 34);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u8F66\u6B21");
		lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(38, 83, 49, 28);
		contentPane.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(164, 83, 131, 28);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(164, 143, 131, 28);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(164, 208, 131, 28);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(164, 270, 131, 28);
		contentPane.add(textField_6);
		
		JLabel lblNewLabel_3 = new JLabel("\u4EF7\u683C");
		lblNewLabel_3.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(38, 319, 86, 34);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(164, 325, 131, 28);
		contentPane.add(textField);
		
		JLabel lblNewLabel_3_1 = new JLabel("\u7968\u6570");
		lblNewLabel_3_1.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(38, 378, 86, 34);
		contentPane.add(lblNewLabel_3_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(164, 384, 131, 28);
		contentPane.add(textField_1);
		
	}
}
