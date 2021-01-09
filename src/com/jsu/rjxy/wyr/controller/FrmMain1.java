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
 * 旅客主界面类
 * @author 52820
 *
 */
@SuppressWarnings("serial")
public class FrmMain1 extends JFrame {

	private JPanel contentPane;
	private JTable table;// 定义表格
	private DefaultTableModel model;// 定义表格数据模型

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
	 * 旅客主界面方法
	 */
	
	public FrmMain1() {
		setTitle("\u5728\u7EBF\u8F66\u7968\u9884\u5B9A");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmMain1.class.getResource("/img/汽车图标.png")));
		setBounds(390, 200, 878, 577);
		contentPane = new JPanel(){//重写paint的一个方法绘制背景图片
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
		
		//设置滚动面板
				JScrollPane scrollPane = new JScrollPane();// 创建滚动面板
				scrollPane.setBounds(47, 73, 770, 377);// 设置大小与位置
				contentPane.add(scrollPane);// 将滚动面板加入到内容面板中

				// 使用动态数组数据（列标题与行数据）
				Vector<String> titles = new Vector<String>();// 定义动态数组表示表格标题
				Collections.addAll(titles, "车次","出发城市", "到达城市", "出发时间","价格","票数");
				String sql="select * from selecting order by carnumber asc";//定义查询语句
				Vector<Vector> stuInfo = DataOperate.getSelectAll(sql);// 从数据库中读取所有行数据

				
				table = new JTable(model);// 使用DefaultTableModel数据模型实例化表格
				table = new JTable(stuInfo,titles);// 使用静态数据实例化表格
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
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		toolBar.add(btnNewButton_1);
		btnNewButton_1.setIcon(new ImageIcon(FrmMain1.class.getResource("/img/j6.png")));
		
		JButton btnNewButton_2 = new JButton("\u8BA2\u7968");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Purchase pc=new Purchase();
				pc.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 20));
		toolBar.add(btnNewButton_2);
		btnNewButton_2.setIcon(new ImageIcon(FrmMain1.class.getResource("/img/j8.png")));
		
		JButton btnNewButton_3 = new JButton("\u5E2E\u52A9\u4E2D\u5FC3");
		btnNewButton_3.setFont(new Font("宋体", Font.PLAIN, 20));
		toolBar.add(btnNewButton_3);
		btnNewButton_3.setIcon(new ImageIcon(FrmMain1.class.getResource("/img/search64.png")));
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(700, 482, 102, 33);
		contentPane.add(btnNewButton);


	}
}
