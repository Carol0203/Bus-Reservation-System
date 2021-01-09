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
 * 管理员查询信息类
 * @author 52820
 *
 */
@SuppressWarnings("serial")
public class Selecting extends JFrame {
	private JPanel contentPane;// 定义窗体内容面板，放置各组件
	private JTable table;// 定义表格
	private JTextField txtKey;//定义查找关键字文本框
	private DefaultTableModel model;// 定义表格数据模型
	
	public static void main(String[] args) {
		Selecting frame = new Selecting();// 实例化窗体
		frame.setLocationRelativeTo(null);// 窗体居中
		frame.setVisible(true);// 窗体可见
	}

	/**
	 * 查询信息方法
	 */
	public Selecting() {
		setTitle("\u67E5\u8BE2\u6C7D\u8F66\u4FE1\u606F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置窗体关闭按钮
		setBounds(390, 200, 603, 481);// 设置窗体位置与大小
		contentPane = new JPanel(){//实例化内容面板
            @Override
            protected void paintComponent(Graphics g) {
         	    super.paintComponent(g);
         	    ImageIcon img = new ImageIcon("source\\img\\风景2.jpg");  
  	            img.paintIcon(this, g, -350, -100);
            }
       };
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));// 设置面板边框
		contentPane.setLayout(null);// 设置面板布局为绝对布局
		setContentPane(contentPane);// 将窗体默认面板

		//设置滚动面板
		JScrollPane scrollPane = new JScrollPane();// 创建滚动面板
		scrollPane.setBounds(45, 81, 504, 282);// 设置大小与位置
		contentPane.add(scrollPane);// 将滚动面板加入到内容面板中

		// 使用动态数组数据（列标题与行数据）
		Vector<String> titles = new Vector<String>();// 定义动态数组表示表格标题
		Collections.addAll(titles, "车次","出发城市", "到达城市", "出发时间","价格","票数");
		String sql="select * from selecting order by carnumber asc";//定义查询语句
		Vector<Vector> stuInfo = DataOperate.getSelectAll(sql);// 从数据库中读取所有行数据
		

		
		table = new JTable(model);// 使用DefaultTableModel数据模型实例化表格
		table = new JTable(stuInfo,titles);// 使用静态数据实例化表格
		scrollPane.setViewportView(table);
		
		JLabel lblKey = new JLabel("输入车次：");//文本标签
		lblKey.setForeground(Color.WHITE);
		lblKey.setFont(new Font("楷体", Font.PLAIN, 22));
		lblKey.setBounds(45, 16, 119, 47);
		contentPane.add(lblKey);
		
		txtKey = new JTextField();//文本框
		txtKey.setBounds(174, 18, 198, 41);
		contentPane.add(txtKey);
		txtKey.setColumns(10);

		JButton btnFind = new JButton("查找");//查找按钮
		btnFind.setFont(new Font("楷体", Font.PLAIN, 20));
		btnFind.addActionListener(new ActionListener() {//按钮单击事件
			public void actionPerformed(ActionEvent e) {
				String a1 = String.valueOf(txtKey.getText());
				String[] str = new String[] {a1};
				String sql = "select * from selecting where carnumber=? ";
				ResultSet ret=new DatabaseConnectionSql().search(sql,str);
				try {
					if(ret.next()) {
						JOptionPane.showMessageDialog(null, "查找成功！  "
								+"车次："+ ret.getString(1)+"  "+"出发城市："+ret.getString(2)+"  "+"到达城市："+ret.getString(3)+"  "+"出发时间："+ret.getString(4)+"  "+"价格："+ret.getString(5)+"  "+"票数："+ret.getString(6));
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
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(456, 392, 93, 33);
		contentPane.add(btnNewButton);
		}
	}

