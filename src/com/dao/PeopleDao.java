package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.People;
import com.sun.swing.internal.plaf.basic.resources.basic;
import com.util.DBUtil;

//数据交互
public class PeopleDao {
	
	//数据注册用户
	public boolean register(People people) {
		Connection connection = DBUtil.getConn();
		//sql 注入
		String sql = "insert into people (username,password,sex,birthplace) values (?,?,?,?)";
		
		//String sql01 = "insert into people (username,password,confirmPwd,sex,birthplace) values ("+people.username+","+people.password+",";
        boolean flag = false;
		try {		
			System.out.println("==========");
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
		    preparedStatement.setString(1, people.username);
		    preparedStatement.setString(2, people.password);
		    preparedStatement.setInt(3, people.sex);
		    preparedStatement.setString(4, people.birthplace);
	        int success = preparedStatement.executeUpdate();
	        if(success > 0) {
	        	flag = true;
	        }	
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			flag = false;
		}
		return flag;
	}
	
	public boolean login(String username,String pwd) {	
		Connection connection  = DBUtil.getConn();
		String querySql = "select username,password from people where username=? and password = ?";
		boolean isLogin = false;
		try {
			PreparedStatement pStatement = connection.prepareStatement(querySql);
			pStatement.setString(1, username);
			pStatement.setString(2, pwd);
			//[[username:""，password:""]]
			ResultSet rs = pStatement.executeQuery();
			System.out.println("是否有第一行数据0："+rs.first());
			
			if(rs.first()) {
				isLogin = true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("登录查询失败");
		}
		return isLogin;
	}
	
	//获取所有用户列表	
	public ArrayList<People> getAllUserList(){
		Connection connection = DBUtil.getConn();
		ArrayList<People> userList = new ArrayList<People>();
		try {
			PreparedStatement pst = connection.prepareStatement("select * from people");			
		    ResultSet rSet =  pst.executeQuery();
		    while (rSet.next()) {
		    	People people = new People();
		    	
				int uId = rSet.getInt("id");
				people.id = uId;
				
				String username = rSet.getString("username");
				people.username = username;
				
				String password = rSet.getString("password");
				people.password = password;
				
				int uSex = rSet.getInt("sex");
				people.sex = uSex;
				
				String birthPlace = rSet.getString("birthplace");
				people.birthplace = birthPlace;
				
				
				userList.add(people);
				
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		System.out.println("列表userList:"+ userList);
		System.out.println("列表userSize:"+ userList.size());
		return userList;
	}
	
	//获取所有用户总数
	
	public int getAllPeopleCount() {
		int total = 0;
		Connection connection = DBUtil.getConn();
		String countSql = "select count(*) from people";
		try {
			PreparedStatement pStatement = connection.prepareStatement(countSql);
			ResultSet resultSet = pStatement.executeQuery();
			if(resultSet.first()) {
				total = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return total;
	}
	
	//获取用户列表	，做分页
		public ArrayList<People> getUserList(int offset,int max){
			Connection connection = DBUtil.getConn();
			ArrayList<People> userList = new ArrayList<People>();
			try {
				PreparedStatement pst = connection.prepareStatement("select * from people order by id limit "+offset +","+max);			
			    ResultSet rSet =  pst.executeQuery();
			    while (rSet.next()) {
			    	People people = new People();
			    	
					int uId = rSet.getInt("id");
					people.id = uId;
					
					String username = rSet.getString("username");
					people.username = username;
					
					String password = rSet.getString("password");
					people.password = password;
					
					int uSex = rSet.getInt("sex");
					people.sex = uSex;
					
					String birthPlace = rSet.getString("birthplace");
					people.birthplace = birthPlace;
					
					userList.add(people);
					
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			System.out.println("列表userList:"+ userList);
			
			return userList;
		}
		
		//获取某一用户数据
		public People findPeopleById(int uId) {
			Connection connection  = DBUtil.getConn();
			String querySql = "select * from people where id = ?";
			People people  = new People();
			people.id = uId;
			try {
				PreparedStatement pStatement = connection.prepareStatement(querySql);
				pStatement.setInt(1, uId);
				ResultSet resultSet = pStatement.executeQuery();
				if(resultSet.first()) {
					people.setUsername(resultSet.getString("username"));
					people.sex = resultSet.getInt("sex");
					people.birthplace = resultSet.getString("birthplace");
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			return people;
			
		}	
		
	   //更新某一用户
		
		public boolean updatePeople(People people) {
			Connection connection = DBUtil.getConn();
			String updateSql = "update people set username=?,sex =?,birthplace= ? where id =?";
			boolean result = false;
			try {
				PreparedStatement ps = connection.prepareStatement(updateSql);
				ps.setString(1, people.username);
				ps.setInt(2, people.sex);
				ps.setString(3, people.birthplace);
				ps.setInt(4, people.id);
				int flag = ps.executeUpdate();
				if(flag>0) {
					result = true;
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			return result;
			
		}
		
		public boolean updatePeople(Integer id,String username,Integer sex, String birthplace) {
			Connection connection = DBUtil.getConn();
			String updateSql = "update people set username=?,sex =?,birthplace= ? where id =?";
			boolean result = false;
			try {
				PreparedStatement ps = connection.prepareStatement(updateSql);
				ps.setString(1, username);
				ps.setInt(2, sex);
				ps.setString(3,birthplace);
				ps.setInt(4, id);
				int flag = ps.executeUpdate();
				if(flag>0) {
					result = true;
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			return result;
			
		}
		
		//删除用户
		
		public boolean deletePeopleById(int id) {
			
			boolean result = false;
			Connection connection = DBUtil.getConn();
			String deleteSql="delete from people where id=?";
			try {
				PreparedStatement pStatement =connection.prepareStatement(deleteSql);
				pStatement.setInt(1, id);
				int flag = pStatement.executeUpdate();
				if(flag > 0) {
					result = true;
				}
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			return result;
			
		}
		
		

}
