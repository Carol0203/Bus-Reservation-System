package com.jsu.rjxy.wyr.controller;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import org.junit.Test;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import com.jsu.rjxy.wyr.dao.DatabaseConnectionSql;

import javax.swing.JPasswordField;
/**
 * ��¼������
 * @author 52820
 *
 */
public class Login {

	private JFrame frame;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_2_1;
	private JPasswordField textField_1;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
		});
	}
	
	public Login() {
		initialize();
	}

	/**
	 * ��¼�����ʼ������
	 */
	@Test
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		
				@SuppressWarnings("serial")
				JDesktopPane desktopPane = new JDesktopPane() {
			@Override
			public void paintComponent(Graphics g) {//�ػ���屳��
				//����һ��δ��ʼ����ͼ��ͼ�꣬�ο�API
				ImageIcon icon=new ImageIcon("source\\img\\�羰3.png");
				//����ָ��ͼ���������ŵ��ʺ�ָ�������ڲ���ͼ�񣬲ο�API
				g.drawImage(icon.getImage(), 0, 0, this.getWidth(), this.getHeight(),this);
			}
		};
		
		JLabel label = new JLabel("�û���");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("����", Font.PLAIN, 22));
		label.setBounds(68, 92, 87, 50);
		desktopPane.add(label);
		
		JLabel label_1 = new JLabel("����");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("����", Font.PLAIN, 22));
		label_1.setBounds(85, 173, 61, 41);
		desktopPane.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(165, 102, 198, 35);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("����Ա");
		rdbtnNewRadioButton.setFont(new Font("����", Font.PLAIN, 20));
		rdbtnNewRadioButton.setBounds(151, 264, 102, 35);
		desktopPane.add(rdbtnNewRadioButton);
		
	
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("�ÿ�");
		rdbtnNewRadioButton_1.setFont(new Font("����", Font.PLAIN, 20));
		rdbtnNewRadioButton_1.setBounds(320, 264, 102, 35);
		desktopPane.add(rdbtnNewRadioButton_1);
		ButtonGroup group=new ButtonGroup();
		group.add(rdbtnNewRadioButton );
		group.add(rdbtnNewRadioButton_1);
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
		);
		
		JButton btnNewButton = new JButton("��  ¼");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if(checkUsername() & checkPassword()&&rdbtnNewRadioButton_1.isSelected()) {
					String username = textField.getText();
	                @SuppressWarnings("deprecation")
					String password = textField_1.getText();
	                String sql = "select * from user where username=? and password=?";
            	    String[] str = new String[] {username , password};
            	    ResultSet ret=new DatabaseConnectionSql().search(sql, str);
            	    try {
						if(ret.next()) {
							JOptionPane.showMessageDialog(null, "�ÿ͵�¼�ɹ���");
						}
						else {
							JOptionPane.showMessageDialog(null, "��¼ʧ��");
						}
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
            	    //��ת���ÿ���ҳ��
            	    FrmMain1 fm=new FrmMain1();
            	    fm.setVisible(true);
				}
					else if(checkUsername() & checkPassword()&&rdbtnNewRadioButton.isSelected()) {
						String username = textField.getText();
		                @SuppressWarnings("deprecation")
						String password = textField_1.getText();
		                String s = "select * from management where mngusername=? and mngpassword=?";
	            	    String[] str1 = new String[] {username , password};
	            	    ResultSet ret=new DatabaseConnectionSql().search(s, str1);
	            	    try {
							if(ret.next()) {
								JOptionPane.showMessageDialog(null, "����Ա��¼�ɹ���");
							}
							else {
								JOptionPane.showMessageDialog(null, "��¼ʧ��");
							}
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						//��ת������Ա����
						Administrator1 adm=new Administrator1();
						adm.setVisible(true);
					}
			}
		});


		btnNewButton.setFont(new Font("����", Font.PLAIN, 22));
		btnNewButton.setBounds(176, 359, 193, 41);
		desktopPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u9009\u62E9\u89D2\u8272\uFF1A");
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 22));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(35, 256, 131, 50);
		desktopPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u6B22\u8FCE\u767B\u9646\u5728\u7EBF\u8F66\u7968\u67E5\u8BE2\u9884\u8BA2\u7BA1\u7406\u7CFB\u7EDF");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(46, 10, 480, 72);
		desktopPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("\u514D\u8D39\u6CE8\u518C");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register cf1=new Register();
				desktopPane.add(cf1);
				cf1.setVisible(true);
				try {
					cf1.setSelected(true);
				} catch (PropertyVetoException e1) {
					e1.printStackTrace();
				}		
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 16));
		btnNewButton_1.setBounds(455, 428, 102, 35);
		desktopPane.add(btnNewButton_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(407, 101, 107, 29);
		desktopPane.add(lblNewLabel_2);
		
		lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("����", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(407, 176, 107, 29);
		desktopPane.add(lblNewLabel_2_1);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(165, 178, 198, 35);
		desktopPane.add(textField_1);
		frame.getContentPane().setLayout(groupLayout);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\52820\\Desktop\\\u7528\u6237\u56FE\u6807.png"));
		frame.setTitle("\u7528\u6237\u767B\u5F55");
		frame.setBounds(400, 170, 598, 515);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	/**
	 * �ж��û����Ƿ�Ϊ�շ���
	 * @return
	 */
	public boolean checkUsername() {//�û���
		// �ж��ַ����Ƿ�Ϊ��
		String username = textField.getText();
		if (username.length() == 0) {
			lblNewLabel_2.setText("����Ϊ�գ�");
			return false;
		}
		return true;
	}
	/**
	 *  �ж������Ƿ�Ϊ�շ���
	 * @return
	 */
	public boolean checkPassword() {//����
		// �ж��ַ����Ƿ�Ϊ��
		String password = textField_1.getText();
		if (password.length() == 0) {
			lblNewLabel_2_1.setText("����Ϊ�գ�");
			return false;
		}
		return true;
	}
	
}
