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
 * ����Աɾ����¼��
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
	 * ɾ����Ϣ����
	 */
	public Deleting() {
		setTitle("\u5220\u9664\u6C7D\u8F66\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(390, 210, 482, 329);
		contentPane = new JPanel(){//��дpaint��һ���������Ʊ���ͼƬ
            @Override
            protected void paintComponent(Graphics g) {
         	    super.paintComponent(g);
         	    ImageIcon img = new ImageIcon("source\\img\\�羰2.jpg");  
  	            img.paintIcon(this, g, -350, -100);
            }
       };
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u8981\u5220\u9664\u8F66\u6B21");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 22));
		lblNewLabel.setBounds(56, 61, 187, 39);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(56, 110, 235, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("ɾ��");
		btnNewButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String a=String.valueOf(textField.getText());
				String[] str = new String[] {a};
				String s="select * from selecting where carnumber=?";
				ResultSet rt=new DatabaseConnectionSql().search(s,str);
				try {
					if(rt.next()) {
						//���ȷ����ʾ�򣬻᷵��һ������
						int isDelete = JOptionPane.showConfirmDialog(null, "ȷ��ɾ��", "��ʾ", JOptionPane.YES_NO_CANCEL_OPTION);
						 
						//��������������JOptionPane.YES_OPTION����˵���������ǡ�ȷ������ť������������������������
						if(isDelete == JOptionPane.YES_OPTION){
							String sql="delete from selecting where carnumber=?";
							new DatabaseConnectionSql().add(sql,str);
						    JOptionPane.showMessageDialog(null, "ɾ���ɹ�");
						}	else if(isDelete == JOptionPane.NO_OPTION||isDelete == JOptionPane.CANCEL_OPTION)
							dispose();
					}
					else
						JOptionPane.showMessageDialog(null, "��ǰ���β����ڣ�����������");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

		}
	});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 20));
		btnNewButton.setBounds(77, 181, 112, 39);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("�˳�");
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setBounds(338, 230, 105, 39);
		contentPane.add(btnNewButton_1);
		
	}

}
