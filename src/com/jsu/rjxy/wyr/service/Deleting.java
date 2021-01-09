package com.jsu.rjxy.wyr.service;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.junit.Test;

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
import java.awt.Color;
/**
 * 管理员删除记录类
 * @author 52820
 *
 */
@SuppressWarnings("serial")
public class Deleting extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Deleting frame = new Deleting();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 删除信息方法
	 */
	public Deleting() {
		setTitle("\u5220\u9664\u6C7D\u8F66\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(390, 210, 482, 329);
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
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u8981\u5220\u9664\u8F66\u6B21");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 22));
		lblNewLabel.setBounds(56, 61, 187, 39);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(56, 110, 235, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("删除");
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String a=String.valueOf(textField.getText());
				String[] str = new String[] {a};
				String s="select * from selecting where carnumber=?";
				ResultSet rt=new DatabaseConnectionSql().search(s,str);
				try {
					if(rt.next()) {
						//添加确认提示框，会返回一个整数
						int isDelete = JOptionPane.showConfirmDialog(null, "确定删除", "提示", JOptionPane.YES_NO_CANCEL_OPTION);
						 
						//如果这个整数等于JOptionPane.YES_OPTION，则说明你点击的是“确定”按钮，则允许继续操作，否则结束
						if(isDelete == JOptionPane.YES_OPTION){
							String sql="delete from selecting where carnumber=?";
							new DatabaseConnectionSql().add(sql,str);
						    JOptionPane.showMessageDialog(null, "删除成功");
						}	else if(isDelete == JOptionPane.NO_OPTION||isDelete == JOptionPane.CANCEL_OPTION)
							dispose();
					}
					else
						JOptionPane.showMessageDialog(null, "当前车次不存在，请重新输入");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

		}
	});
		btnNewButton.setFont(new Font("楷体", Font.PLAIN, 20));
		btnNewButton.setBounds(77, 181, 112, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("退出");
		btnNewButton_1.setFont(new Font("楷体", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(338, 230, 105, 39);
		contentPane.add(btnNewButton_1);
		
	}

}
