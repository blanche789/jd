package com.jd.maintain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

import com.jd.common.JDBCUtil;
import com.jd.maintain.dto.UserInfoDto;

public class UserInfoDao {
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;

	public void saveUser(UserInfoDto userInfoDto) {
	
		try {
			con = JDBCUtil.getConnection();
			String sql = "insert into user_info(user_name,password,telephone) values(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, userInfoDto.getUserName());
			ps.setBytes(2, userInfoDto.getPassword());
			ps.setString(3, userInfoDto.getTelephone());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("保存用户失败");
		} finally {
			JDBCUtil.clear(con, ps, null);
			}
	}
	
	public UserInfoDto queryByUserName(String userName) {
			
		UserInfoDto userInfoDto = null;
		try {
			con = JDBCUtil.getConnection();
			String sql = "select * from user_info where user_name = ?";
			ps = con.prepareStatement(sql);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			if(rs.next()) {
				userInfoDto = new UserInfoDto();
				userInfoDto.setId(rs.getInt("id"));
				userInfoDto.setPassword(rs.getBytes("password"));
				userInfoDto.setTelephone(rs.getString("telephone"));
				userInfoDto.setUserName(rs.getString("user_name"));
			}
		} catch (SQLException e) {
			System.out.println("数据查询失败");
		} finally {
			JDBCUtil.clear(con, ps, rs);
			}
		return userInfoDto;
	}
	

	public static void main(String[] args) {
		UserInfoDao uid = new UserInfoDao();
		UserInfoDto userInfoDto = uid.queryByUserName("user01");
		System.out.println(userInfoDto.getId());
		System.out.println(userInfoDto.getUserName());
		System.out.println(userInfoDto.getTelephone());
		System.out.println(Arrays.toString(userInfoDto.getPassword()));
	
	}

}
