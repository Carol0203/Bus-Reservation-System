package com.jsu.rjxy.wyr.controller;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.junit.Test;

import com.jsu.rjxy.wyr.dao.DatabaseConnectionSql;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
/**
 * 账号注册类
 * @author 52820
 *
 */
@SuppressWarnings("serial")
public class Register extends JInternalFrame {
	private JPanel contentPane;
	private JTextField textField;
	
	public JTextField getTextField_2() {
		return textField_2;
	}

	public void setTextField_2(JTextField textField_2) {
		this.textField_2 = textField_2;
	}

	public JTextField getTextField_3() {
		return textField_3;
	}

	public void setTextField_3(JTextField textField_3) {
		this.textField_3 = (JPasswordField) textField_3;
	}

	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField textField_3;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 账号注册界面方法
	 */
	public Register() {
		setBounds(40, 40, 480, 343);
		setTitle("\u4F1A\u5458\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u624B\u673A\u53F7");
		label.setFont(new Font("宋体", Font.PLAIN, 14));
		label.setBounds(30, 37, 64, 22);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u77ED\u4FE1\u9A8C\u8BC1\u7801");
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBounds(30, 80, 81, 28);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u7528\u6237\u540D");
		label_2.setFont(new Font("宋体", Font.PLAIN, 14));
		label_2.setBounds(30, 128, 64, 22);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("\u5BC6\u7801");
		label_3.setFont(new Font("宋体", Font.PLAIN, 14));
		label_3.setBounds(30, 177, 64, 22);
		contentPane.add(label_3);
		
		textField = new JTextField();
		textField.setBounds(138, 38, 188, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(138, 84, 188, 22);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(138, 129, 188, 22);
		contentPane.add(textField_2);
		
		JButton btnNewButton = new JButton("获取验证码");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "已发送验证码");
			}
		});
		
		textField_3 = new JPasswordField();
		textField_3.setBounds(138, 178, 188, 21);
		contentPane.add(textField_3);
		btnNewButton.setBounds(335, 83, 110, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("注册");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a1 = textField_2.getText();
				@SuppressWarnings("deprecation")
				String a2 = String.valueOf(textField_3.getText());
				String[] str1= {a1};
				String sql1 = "select * from user where username=?";
				ResultSet ret=new DatabaseConnectionSql().search(sql1,str1);
				try {
					if(!ret.next()) {
						String[] str = new String[] {a1,a2};
						String sql = "insert into user (username,password) values(?,?)";
						new DatabaseConnectionSql().add(sql, str);
						JOptionPane.showMessageDialog(null, "注册成功！");
					}
					else {
						JOptionPane.showMessageDialog(null, "该账户名已存在，请重新输入");
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(154, 225, 117, 35);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_11 = new JButton("退出");
		btnNewButton_11.setFont(new Font("楷体", Font.PLAIN, 20));
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_11.setBounds(352, 270, 93, 34);
		contentPane.add(btnNewButton_11);
		
		}
}
