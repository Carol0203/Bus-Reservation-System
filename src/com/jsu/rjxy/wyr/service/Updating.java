package com.jsu.rjxy.wyr.service;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jsu.rjxy.wyr.dao.DatabaseConnectionSql;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
/**
 * 管理员修改信息类
 * @author 52820
 *
 */
@SuppressWarnings("serial")
public class Updating extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Updating frame = new Updating();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 修改信息方法
	 */
	public Updating() {
		setTitle("\u4FEE\u6539\u6C7D\u8F66\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(390, 200, 624, 579);
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
		
		JLabel lblNewLabel = new JLabel("\u4FEE\u6539\u4FE1\u606F");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel.setBounds(227, 10, 144, 53);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(201, 73, 157, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a1=String.valueOf(textField.getText());
				String[] str = new String[] {a1};
				String s="select * from selecting where carnumber=?";
				ResultSet rt=new DatabaseConnectionSql().search(s,str);
				try {
					if(rt.next()) {
						//添加确认提示框，会返回一个整数
						int isUpdate = JOptionPane.showConfirmDialog(null, "确定修改", "提示", JOptionPane.YES_NO_CANCEL_OPTION);
						 
						//如果这个整数等于JOptionPane.YES_OPTION，则说明你点击的是“确定”按钮，则允许继续操作，否则结束
						if(isUpdate == JOptionPane.YES_OPTION){
							String a2=textField_1.getText();
							String a3=textField_2.getText();
							String a4=textField_3.getText();
							String a5=String.valueOf(textField_4.getText());
							String a6=String.valueOf(textField_5.getText());
							String[] str1 = new String[] {a2,a3,a4,a5,a6,a1};
							String sql="update selecting set start=?,destination=?,time=?,price=?,ticket=? where carnumber=?";
							new DatabaseConnectionSql().add(sql,str1);
						    JOptionPane.showMessageDialog(null, "修改成功！");
						}	else if(isUpdate == JOptionPane.NO_OPTION||isUpdate == JOptionPane.CANCEL_OPTION)
							dispose();
					}
					else
						JOptionPane.showMessageDialog(null, "当前车次不存在，请重新输入");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(109, 458, 119, 47);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(381, 458, 119, 47);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("\u8F66\u6B21\uFF1A");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(87, 71, 69, 26);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(201, 136, 157, 28);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(201, 196, 157, 28);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(201, 256, 157, 28);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(201, 319, 157, 28);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(201, 378, 157, 28);
		contentPane.add(textField_5);
		
		JLabel lblNewLabel_1_1 = new JLabel("\u51FA\u53D1\u57CE\u5E02\uFF1A");
		lblNewLabel_1_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(61, 134, 100, 26);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("\u5230\u8FBE\u57CE\u5E02\uFF1A");
		lblNewLabel_1_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(60, 194, 101, 26);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("\u51FA\u53D1\u65F6\u95F4\uFF1A");
		lblNewLabel_1_3.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1_3.setBounds(56, 254, 100, 26);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("\u4EF7\u683C\uFF1A");
		lblNewLabel_1_4.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1_4.setBounds(87, 317, 69, 26);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("\u7968\u6570\uFF1A");
		lblNewLabel_1_5.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1_5.setBounds(87, 376, 69, 26);
		contentPane.add(lblNewLabel_1_5);
	}
	
}
