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
 * ���ݿ�������
 * @author 52820
 *
 */
public class DatabaseConnectionSql {
	//����MySQL���ݿ���������
		private static final String DBRIVER="com.mysql.cj.jdbc.Driver";
		//����MySQL���ݿ����ӵ�ַ��db_library�ɸĳ��Լ������ݿ�����
		private static final String DBURL="jdbc:mysql://localhost:3306/yhgl?serverTimezone=GMT%2B8";
		private static final String DBUSER="root"; //MySQL���ݿ������û���
		private static final String PASSWORD="wangyiran010203"; //MySQL���ݿ���������

		private static Connection conn=null; //�������Ӷ���
		private static ResultSet ret;
		/**
		 * ���ݿ����ӷ���
		 * @return
		 */
		public static Connection getConnection() {//�������ݿ����Ӷ���
			try {
				Class.forName(DBRIVER);
			conn=DriverManager.getConnection(DBURL,DBUSER,PASSWORD);
			//System.out.println("�����ɹ�");
			}
			catch(Exception e){
				
			}
			return conn;
		}
		/**
		 * ���ݿ�رշ���
		 * @param conn
		 * @param stmt
		 * @param ret
		 */
		public void close(Connection conn,Statement stmt,ResultSet ret) {//�ر���������
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
		 * ���ݿ��ѯ����
		 * @param sql
		 * @param str
		 * @return
		 */
		//��ѯ
		public static ResultSet search(String sql, String str[]) {
	    	try {
	    		getConnection();
	    		PreparedStatement pst = conn.prepareStatement(sql);//���ݿ�Ĳ�������
	            if (str != null) {
	                for (int i = 0; i < str.length; i++) {
	                	//��str[i]��Ϊ��i+1������
	                	//sql���û�е�0�����ݣ�1��ʼ
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
		 * ���ݿ���ɾ�޸ķ���
		 * @param sql
		 * @param str
		 * @return
		 */
		// ��ɾ�޸�
	    public int add(String sql, String str[]) {
	        int a = 0;
	        try {
	        	getConnection();
	    		PreparedStatement pst = conn.prepareStatement(sql);//���ݿ�Ĳ�������
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
		 * ���CarRecord���͵����м�¼
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
