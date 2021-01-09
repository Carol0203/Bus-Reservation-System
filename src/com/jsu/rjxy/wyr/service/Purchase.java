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
 * 车票订购类
 * @author 52820
 *
 */
public class Purchase extends JFrame {

	private JPanel contentPane;
	private JTable table;// 定义表格
	private DefaultTableModel model;// 定义表格数据模型
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
	 * 车票订购方法
	 */
	public Purchase() {
		setTitle("\u8F66\u7968\u8BA2\u8D2D");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(390, 200, 619, 429);
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

		// 使用动态数组数据（列标题与行数据）
		Vector<String> titles = new Vector<String>();// 定义动态数组表示表格标题
		Collections.addAll(titles, "车次","出发城市", "到达城市", "出发时间","价格","票数","操作");
		String sql="select * from selecting";//定义查询语句
		Vector<Vector> stuInfo = DataOperate.getSelectAll(sql);// 从数据库中读取所有行数据

		//使用静态数据创建DefaultTableModel数据模型
		model = new DefaultTableModel(){// 使用Vector装载表格数据模型，覆写getColumnClass方法，实现按各列的数据类型排序
			public Class getColumnClass(int column) {//获取列的类型
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
		
		JLabel lblNewLabel = new JLabel("车票订购");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 28));
		lblNewLabel.setBounds(229, 10, 147, 56);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("请输入订购车次：");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(73, 92, 224, 56);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(73, 164, 334, 41);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("订购");
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
							ret.getString(6);//当前剩余票数
							JOptionPane.showMessageDialog(null, "订购成功！");
							JOptionPane.showMessageDialog(null,"第" + Thread.currentThread().getName() + "个窗口剩余" + ret.getString(6) + "张车票");
						}
					}
						else {
							JOptionPane.showMessageDialog(null, "该车次车票已售罄");
						}
					}catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(73, 302, 121, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(320, 302, 121, 41);
		contentPane.add(btnNewButton_1);
	}

}
