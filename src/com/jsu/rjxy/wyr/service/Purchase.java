package com.jsu.rjxy.wyr.service;

import java.awt.EventQueue;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.jsu.rjxy.wyr.dao.DataOperate;
import com.jsu.rjxy.wyr.dao.DatabaseConnectionSql;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
/**
 * ��Ʊ������
 * @author 52820
 *
 */
public class Purchase extends JFrame {

	private JPanel contentPane;
	private JTable table;// ������
	private DefaultTableModel model;// ����������ģ��
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Purchase frame = new Purchase();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * ��Ʊ��������
	 */
	public Purchase() {
		setTitle("\u8F66\u7968\u8BA2\u8D2D");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(390, 200, 619, 429);
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

		// ʹ�ö�̬�������ݣ��б����������ݣ�
		Vector<String> titles = new Vector<String>();// ���嶯̬�����ʾ������
		Collections.addAll(titles, "����","��������", "�������", "����ʱ��","�۸�","Ʊ��","����");
		String sql="select * from selecting";//�����ѯ���
		Vector<Vector> stuInfo = DataOperate.getSelectAll(sql);// �����ݿ��ж�ȡ����������

		//ʹ�þ�̬���ݴ���DefaultTableModel����ģ��
		model = new DefaultTableModel(){// ʹ��Vectorװ�ر������ģ�ͣ���дgetColumnClass������ʵ�ְ����е�������������
			public Class getColumnClass(int column) {//��ȡ�е�����
				Class returnValue;
				if ((column >= 0) && (column < getColumnCount())) {
					returnValue = getValueAt(0, column).getClass();
				} else {
					returnValue = Object.class;
				}
				return returnValue;
			}
		};
		table = new JTable(model);
		
		JLabel lblNewLabel = new JLabel("��Ʊ����");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("����", Font.PLAIN, 28));
		lblNewLabel.setBounds(229, 10, 147, 56);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("�����붩�����Σ�");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(73, 92, 224, 56);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(73, 164, 334, 41);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("����");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String a1 = String.valueOf(textField.getText());
				String[] s = new String[] {a1};
				String sql = "select * from selecting where carnumber=? and ticket != '0'";
				ResultSet ret=new DatabaseConnectionSql().search(sql,s);
				try {
					if(ret.next()) {
						synchronized (" ") {
							String sql1 = "update selecting set ticket=ticket-1 where carnumber=?";
							new DatabaseConnectionSql().add(sql1,s);
							ret.getString(6);//��ǰʣ��Ʊ��
							JOptionPane.showMessageDialog(null, "�����ɹ���");
							JOptionPane.showMessageDialog(null,"��" + Thread.currentThread().getName() + "������ʣ��" + ret.getString(6) + "�ų�Ʊ");
						}
					}
						else {
							JOptionPane.showMessageDialog(null, "�ó��γ�Ʊ������");
						}
					}catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 20));
		btnNewButton.setBounds(73, 302, 121, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("����");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 20));
		btnNewButton_1.setBounds(320, 302, 121, 41);
		contentPane.add(btnNewButton_1);
	}

}
