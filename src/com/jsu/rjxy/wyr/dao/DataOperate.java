package com.jsu.rjxy.wyr.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
/**
 * ��ȡ���ݿ��ֶΡ���¼��
 */
public class DataOperate{
	@SuppressWarnings({ "rawtypes", "static-access", "unchecked" })
	/**
	 * ��ȡ���ݿ��ֶΡ���¼����
	 * @param sql
	 * @return
	 */	
	public static Vector<Vector> getSelectAll(String sql){
		
	Vector<Vector> rows=new Vector<Vector>();//����Ҫ���ص����м�¼����
	DatabaseConnectionSql dbcs=new DatabaseConnectionSql();//ʹ��1�ж�����������ݿ����
	try(Connection conn=dbcs.getConnection();//��ȡ���ݿ��
		PreparedStatement pstmt=conn.prepareStatement(sql);){//ʵ����PreparedStatement
		ResultSet rs=pstmt.executeQuery();//ִ�в�ѯ��䣬����ŵ����ݼ���
		while(rs.next()) {//�������ݼ�
			Vector row=new Vector();//����������
			row.add(rs.getInt(1));//��ȡ��һ���ֶ�
			row.add(rs.getString(2));//��ȡ�ڶ����ֶ�
			row.add(rs.getString(3));//��ȡ�������ֶ�
			row.add(rs.getString(4));//��ȡ���ĸ��ֶ�
			row.add(rs.getInt(5));//��ȡ������ֶ�
			row.add(rs.getInt(6));//��ȡ�������ֶ�
			rows.add(row);//����������ӵ���¼������
		}
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return rows;//��������������
	}
}
