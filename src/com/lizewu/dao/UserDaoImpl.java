package com.lizewu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lizewu.entity.User;
import com.lizewu.util.DBUtil;

public class UserDaoImpl implements UserDao {
	
	String sql = "";
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String name = "";
	String pwd = "";
	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addUser(User user) {
//		 TODO Auto-generated method stub
		sql = "insert into tb_user(username,password,gender,interest) values(?,?,?,?)";
		int count = 0;
		try {
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getGender());
			ps.setString(4, user.getInterest());
			count = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			DBUtil.close(rs, ps, conn);
		}
		return count;
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		sql = "delete  from tb_user where id =?";
		boolean flag = false;
		
		try {
			 conn = DBUtil.getConnection();
			 ps = conn.prepareStatement(sql);
			 
			 ps.setInt(1,id);
			
			int count = ps.executeUpdate();
			if(count>0)
			{
				flag = true;
			}
			else
			{
				flag = false;
			}
			DBUtil.close(rs, ps, conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			DBUtil.close(rs, ps, conn);
		}
		return flag;
	}

	@Override
	public void updateUser(int id,User user) {
		// TODO Auto-generated method stub
		conn = DBUtil.getConnection();
		sql = "update tb_user set "+"username=?,password=?,gender=?,interest=? where id=?";
		try
		{
			//获得预编译对象
			ps = conn.prepareStatement(sql);
			//代替问号的缺省值
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getGender());
			ps.setString(4, user.getInterest());
			ps.setInt(5, id);
			rs = ps.executeQuery();
			DBUtil.close(rs, ps, conn);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			DBUtil.close(rs, ps, conn);
		}
	}
	
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		
		List<User> list = new ArrayList<User>();
		sql = "select * from tb_user";
		
		try {
			//1.得到查询结果集
			 conn = DBUtil.getConnection();
			 ps = conn.prepareStatement(sql);
			//2.查询操作
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setGender(rs.getString("gender"));
				user.setInterest(rs.getString("interest"));
				list.add(user);
			}
			
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally
		{
			DBUtil.close(rs, ps, conn);
		}
	}
	
	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		sql = "select * from tb_user where id=?";
		conn = DBUtil.getConnection();
		User user = new User();
		try
		{
			ps = conn.prepareStatement(sql);
			//对SQL语句中的占位符设值
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next())
			{
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setGender(rs.getString("gender"));
				user.setInterest(rs.getString("interest"));
			}
			DBUtil.close(rs, ps, conn);
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			DBUtil.close(rs, ps, conn);
		}
		return user;
	}

	@Override
	public boolean checkUserRepeat(User user) {
		// TODO Auto-generated method stub
		boolean  flag = false;
		sql = "select username,password from tb_user where username =?";
		try
		{
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,user.getUsername());
			
			rs = ps.executeQuery();
			if(rs.next())
			{
				flag = true;
			}
			else
			{
				flag = false;
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			DBUtil.close(rs, ps, conn);
		}
		return flag;
	}

	@Override
	public boolean userLogin(User user) {
		// TODO Auto-generated method stub
		//注意此处应该让boolean设置为true,而不是false,否则后面的话会得不到正确的返回结果
		boolean  flag = true;
		
		sql = "select username,password from tb_user where username =? and password=?";
		try
		{
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,user.getUsername());
			ps.setString(2, user.getPassword());
			rs = ps.executeQuery();

			while(rs.next())
			{
				 name = rs.getString("username");
				 pwd = rs.getString("password");
			}
			
			System.out.println(name);
			System.out.println(pwd);
			if((name.equals(user.getUsername())) && (pwd.equals(user.getPassword())))
			{
				flag = true;
			}
			else
			{
				flag = false;
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			DBUtil.close(rs, ps, conn);
		}
		return flag;
	}

	

}
