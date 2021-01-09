package com.jsu.rjxy.wyr.controller;

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.util.Collections;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.jsu.rjxy.wyr.dao.DataOperate;
import com.jsu.rjxy.wyr.service.Purchase;
import com.jsu.rjxy.wyr.service.Ticket;

import javax.swing.JToolBar;
import javax.swing.RowSorter;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * �ÿ���������
 * @author 52820
 *
 */
@SuppressWarnings("serial")
public class FrmMain1 extends JFrame {

	private JPanel contentPane;
	private JTable table;// ������
	private DefaultTableModel model;// ����������ģ��

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMain1 frame = new FrmMain1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * �ÿ������淽��
	 */
	
	public FrmMain1() {
		setTitle("\u5728\u7EBF\u8F66\u7968\u9884\u5B9A");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmMain1.class.getResource("/img/����ͼ��.png")));
		setBounds(390, 200, 878, 577);
		contentPane = new JPanel(){//��дpaint��һ���������Ʊ���ͼƬ
            @Override
            protected void paintComponent(Graphics g) {
         	    super.paintComponent(g);
         	    ImageIcon img = new ImageIcon("source\\img\\bg.jpg");  
  	            img.paintIcon(this, g, 0, 0);
            }
       };
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//���ù������
				JScrollPane scrollPane = new JScrollPane();// �����������
				scrollPane.setBounds(47, 73, 770, 377);// ���ô�С��λ��
				contentPane.add(scrollPane);// �����������뵽���������

				// ʹ�ö�̬�������ݣ��б����������ݣ�
				Vector<String> titles = new Vector<String>();// ���嶯̬�����ʾ������
				Collections.addAll(titles, "����","��������", "�������", "����ʱ��","�۸�","Ʊ��");
				String sql="select * from selecting order by carnumber asc";//�����ѯ���
				Vector<Vector> stuInfo = DataOperate.getSelectAll(sql);// �����ݿ��ж�ȡ����������

				
				table = new JTable(model);// ʹ��DefaultTableModel����ģ��ʵ�������
				table = new JTable(stuInfo,titles);// ʹ�þ�̬����ʵ�������
				scrollPane.setViewportView(table);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(-15, 0, 1372, 47);
		contentPane.add(toolBar);
		
		JButton btnNewButton_1 = new JButton("\u6C7D\u8F66\u7968\u67E5\u8BE2");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ticket t=new Ticket();
				t.setLocationRelativeTo(null);
				t.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 20));
		toolBar.add(btnNewButton_1);
		btnNewButton_1.setIcon(new ImageIcon(FrmMain1.class.getResource("/img/j6.png")));
		
		JButton btnNewButton_2 = new JButton("\u8BA2\u7968");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Purchase pc=new Purchase();
				pc.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("����", Font.PLAIN, 20));
		toolBar.add(btnNewButton_2);
		btnNewButton_2.setIcon(new ImageIcon(FrmMain1.class.getResource("/img/j8.png")));
		
		JButton btnNewButton_3 = new JButton("\u5E2E\u52A9\u4E2D\u5FC3");
		btnNewButton_3.setFont(new Font("����", Font.PLAIN, 20));
		toolBar.add(btnNewButton_3);
		btnNewButton_3.setIcon(new ImageIcon(FrmMain1.class.getResource("/img/search64.png")));
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 20));
		btnNewButton.setBounds(700, 482, 102, 33);
		contentPane.add(btnNewButton);


	}
}
