package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//数据库连接
public class DBUtil {
	
	private static Connection con;
	
	private DBUtil() {		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/usermanage", "root", "root");
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("class类未找到");
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("数据库未链接成功");						
		}
	}
	
	public static Connection getConn() {
		new DBUtil();
		return con;
	}

}
