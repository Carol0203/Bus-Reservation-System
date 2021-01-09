package com.jsu.rjxy.wyr.service;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jsu.rjxy.wyr.dao.DatabaseConnectionSql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
/**
 * 旅客车票查询类
 * @author 52820
 *
 */
@SuppressWarnings("serial")
public class Ticket extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ticket frame = new Ticket();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 旅客车票查询方法
	 */
	public Ticket() {
		setTitle("\u8F66\u7968\u67E5\u8BE2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 501);
		contentPane = new JPanel(){//重写paint的一个方法绘制背景图片
            @Override
            protected void paintComponent(Graphics g) {
         	    super.paintComponent(g);
         	    ImageIcon img = new ImageIcon("source\\img\\风景2.jpg");  
  	            img.paintIcon(this, g, -350, -100);
            }
       };
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u51FA\u53D1\u57CE\u5E02");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel.setBounds(36, 119, 106, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5230\u8FBE\u57CE\u5E02");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(36, 198, 106, 42);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u51FA\u53D1\u65F6\u95F4");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("楷体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(36, 275, 106, 42);
		contentPane.add(lblNewLabel_2);
		
		//出发城市
		textField = new JTextField();
		textField.setBounds(152, 126, 186, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		//到达城市
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(152, 205, 186, 33);
		contentPane.add(textField_1);
		//出发时间
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(152, 282, 186, 33);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("立即搜索");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a1 = textField.getText();
				String a2 = textField_1.getText();
				String a3 = String.valueOf(textField_2.getText());
				String[] str = new String[] {a1,a2,a3};
				String sql = "select * from selecting where start=? and destination=? and time=?";
				ResultSet ret=new DatabaseConnectionSql().search(sql,str);
				try {
					if(ret.next()) {
						JOptionPane.showMessageDialog(null, "查找成功！  "
								+"车次："+ ret.getString(1)+"  "+"出发城市："+ret.getString(2)+"  "+"到达城市："+ret.getString(3)+"  "+"出发时间："+ret.getString(4)+"  "+"价格："+ret.getString(5)+"  "+"票数："+ret.getString(6));
					}
					else
						JOptionPane.showMessageDialog(null, "无相关车票信息");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 20));
		btnNewButton.setBounds(135, 359, 186, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u8FD4\u56DE");
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(455, 405, 105, 39);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("\u8F66\u7968\u67E5\u8BE2");
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("楷体", Font.PLAIN, 28));
		lblNewLabel_3.setBounds(193, 34, 173, 46);
		contentPane.add(lblNewLabel_3);
	}

}
