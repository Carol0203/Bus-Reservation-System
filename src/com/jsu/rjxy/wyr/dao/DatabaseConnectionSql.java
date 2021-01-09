package com.jsu.rjxy.wyr.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 数据库层操作类
 * @author 52820
 *
 */
public class DatabaseConnectionSql {
	//定义MySQL数据库驱动程序
		private static final String DBRIVER="com.mysql.cj.jdbc.Driver";
		//定义MySQL数据库连接地址，db_library可改成自己的数据库名称
		private static final String DBURL="jdbc:mysql://localhost:3306/yhgl?serverTimezone=GMT%2B8";
		private static final String DBUSER="root"; //MySQL数据库连接用户名
		private static final String PASSWORD="wangyiran010203"; //MySQL数据库连接密码

		private static Connection conn=null; //保存连接对象
		private static ResultSet ret;
		/**
		 * 数据库连接方法
		 * @return
		 */
		public static Connection getConnection() {//返回数据库连接对象
			try {
				Class.forName(DBRIVER);
			conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
			//System.out.println("启动成功");
			}
			catch(Exception e){
				
			}
			return conn;
		}
		/**
		 * 数据库关闭方法
		 * @param conn
		 * @param stmt
		 * @param ret
		 */
		public void close(Connection conn,Statement stmt,ResultSet ret) {//关闭数据连接
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(ret!=null) {
				try {
					ret.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		/**
		 * 数据库查询方法
		 * @param sql
		 * @param str
		 * @return
		 */
		//查询
		public static ResultSet search(String sql, String str[]) {
	    	try {
	    		getConnection();
	    		PreparedStatement pst = conn.prepareStatement(sql);//数据库的操作对象
	            if (str != null) {
	                for (int i = 0; i < str.length; i++) {
	                	//把str[i]设为第i+1个数据
	                	//sql语句没有第0个数据，1开始
	                    pst.setString(i + 1, str[i]);
	                }
	            }
	            ret = pst.executeQuery();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return ret;
	}
		
		/**
		 * 数据库增删修改方法
		 * @param sql
		 * @param str
		 * @return
		 */
		// 增删修改
	    public int add(String sql, String str[]) {
	        int a = 0;
	        try {
	        	getConnection();
	    		PreparedStatement pst = conn.prepareStatement(sql);//数据库的操作对象
	            if (str != null) {
	                for (int i = 0; i < str.length; i++) {
	                    pst.setString(i + 1, str[i]);
	                }
	            }
	            a = pst.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return a;
	    }
		
	    /*
		 * 获得CarRecord类型的所有记录
		 */
		public static List<CarRecord> getAllCarRecord(String sql, String[] str) {
			List<CarRecord> list = new ArrayList<>();
			try {
				ResultSet res = DatabaseConnectionSql.search(sql, str);

				while (res.next()) {
					String carnumber = res.getString("carnumber");
					String start = res.getString("start");
					String destination = res.getString("destination");
					String time = res.getString("time");
					int price = res.getInt("price");
					int ticket = res.getInt("ticket");
					
					list.add(new CarRecord(carnumber, start, destination,time,price,ticket));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}

	public static void main(String[] args) {
		Connection conn=null;
		conn=DatabaseConnectionSql.getConnection();
		System.out.println(conn);
	}

}
