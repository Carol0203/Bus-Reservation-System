package com.jsu.rjxy.wyr.service;

import java.util.Collections;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;

import com.jsu.rjxy.wyr.dao.DataOperate;
import com.jsu.rjxy.wyr.dao.DatabaseConnectionSql;
import java.awt.Color;
/**
 * ����Ա��ѯ��Ϣ��
 * @author 52820
 *
 */
@SuppressWarnings("serial")
public class Selecting extends JFrame {
	private JPanel contentPane;// ���崰��������壬���ø����
	private JTable table;// ������
	private JTextField txtKey;//������ҹؼ����ı���
	private DefaultTableModel model;// ����������ģ��
	
	public static void main(String[] args) {
		Selecting frame = new Selecting();// ʵ��������
		frame.setLocationRelativeTo(null);// �������
		frame.setVisible(true);// ����ɼ�
	}

	/**
	 * ��ѯ��Ϣ����
	 */
	public Selecting() {
		setTitle("\u67E5\u8BE2\u6C7D\u8F66\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ���ô���رհ�ť
		setBounds(390, 200, 603, 481);// ���ô���λ�����С
		contentPane = new JPanel(){//ʵ�����������
            @Override
            protected void paintComponent(Graphics g) {
         	    super.paintComponent(g);
         	    ImageIcon img = new ImageIcon("source\\img\\�羰2.jpg");  
  	            img.paintIcon(this, g, -350, -100);
            }
       };
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// �������߿�
		contentPane.setLayout(null);// ������岼��Ϊ���Բ���
		setContentPane(contentPane);// ������Ĭ�����

		//���ù������
		JScrollPane scrollPane = new JScrollPane();// �����������
		scrollPane.setBounds(45, 81, 504, 282);// ���ô�С��λ��
		contentPane.add(scrollPane);// �����������뵽���������

		// ʹ�ö�̬�������ݣ��б����������ݣ�
		Vector<String> titles = new Vector<String>();// ���嶯̬�����ʾ������
		Collections.addAll(titles, "����","��������", "�������", "����ʱ��","�۸�","Ʊ��");
		String sql="select * from selecting order by carnumber asc";//�����ѯ���
		Vector<Vector> stuInfo = DataOperate.getSelectAll(sql);// �����ݿ��ж�ȡ����������
		

		
		table = new JTable(model);// ʹ��DefaultTableModel����ģ��ʵ�������
		table = new JTable(stuInfo,titles);// ʹ�þ�̬����ʵ�������
		scrollPane.setViewportView(table);
		
		JLabel lblKey = new JLabel("���복�Σ�");//�ı���ǩ
		lblKey.setForeground(Color.WHITE);
		lblKey.setFont(new Font("����", Font.PLAIN, 22));
		lblKey.setBounds(45, 16, 119, 47);
		contentPane.add(lblKey);
		
		txtKey = new JTextField();//�ı���
		txtKey.setBounds(174, 18, 198, 41);
		contentPane.add(txtKey);
		txtKey.setColumns(10);

		JButton btnFind = new JButton("����");//���Ұ�ť
		btnFind.setFont(new Font("����", Font.PLAIN, 20));
		btnFind.addActionListener(new ActionListener() {//��ť�����¼�
			public void actionPerformed(ActionEvent e) {
				String a1 = String.valueOf(txtKey.getText());
				String[] str = new String[] {a1};
				String sql = "select * from selecting where carnumber=? ";
				ResultSet ret=new DatabaseConnectionSql().search(sql,str);
				try {
					if(ret.next()) {
						JOptionPane.showMessageDialog(null, "���ҳɹ���  "
								+"���Σ�"+ ret.getString(1)+"  "+"�������У�"+ret.getString(2)+"  "+"������У�"+ret.getString(3)+"  "+"����ʱ�䣺"+ret.getString(4)+"  "+"�۸�"+ret.getString(5)+"  "+"Ʊ����"+ret.getString(6));
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnFind.setBounds(436, 18, 113, 41);
		contentPane.add(btnFind);		
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 20));
		btnNewButton.setBounds(456, 392, 93, 33);
		contentPane.add(btnNewButton);
		}
	}

