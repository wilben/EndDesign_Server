package com.gem.hsx.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gem.hsx.bean.Designer;
import com.gem.hsx.bean.User;
import com.gem.hsx.db.GetConn;

public class UserDaoImpl {
	public int login(String username, String password) {
		int b = -1;
		GetConn getConn = new GetConn();
		ResultSet rs = null, rs1 = null;
		Connection conn = getConn.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("select * from user_info where username=? and password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				b = 0;
			}
			PreparedStatement ps1 = conn
					.prepareStatement("select * from designer_info where username=? and password=?");
			ps1.setString(1, username);
			ps1.setString(2, password);
			rs1 = ps1.executeQuery();
			if (rs1.next()) {
				b = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	public boolean register(User user) {
		boolean b = false;
		GetConn getConn = new GetConn();
		int i = 0;
		Connection conn = getConn.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("insert into user_info values (?,?,?,?,?,?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getSex());
			ps.setString(4, user.getAge());
			ps.setString(5, user.getAvatar());
			ps.setString(6, user.getRealname());
			ps.setInt(7, user.getRole());
			i = ps.executeUpdate();
			if (i > 0) {
				b = true;
			} else {
				b = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;

	}

	public List<Designer> selectAllDesigner() {
		List<Designer> list = new ArrayList<Designer>();
		GetConn getConn = new GetConn();
		Connection conn = getConn.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("select * from designer_info");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Designer designer = new Designer();
				designer.setUsername(rs.getString(1));
				designer.setAvatar(rs.getString(5));
				designer.setArea(rs.getString(13));
				designer.setStyle(rs.getString(10));
				list.add(designer);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean check(String username) {
		boolean b = false;
		GetConn getConn = new GetConn();
		ResultSet rs = null, rs1 = null;
		Connection conn = getConn.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("select * from user_info where username=?");
			ps.setString(1, username);

			rs = ps.executeQuery();
			PreparedStatement ps1 = conn
					.prepareStatement("select * from designer_info where username=?");
			ps1.setString(1, username);

			rs1 = ps1.executeQuery();
			if (rs.next() || rs1.next()) {
				b = true;
			} else {
				b = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	public String getAvatar(String username) {
		// TODO Auto-generated method stub
		String url = null;
		GetConn getConn = new GetConn();
		ResultSet rs = null;
		Connection conn = getConn.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("select avatar from user_info where username=?");
			ps.setString(1, username);

			rs = ps.executeQuery();
			if (rs.next()) {
				url = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return url;
	}

	public User getInfo(String username) {
		// TODO Auto-generated method stub
		User user = new User();
		GetConn getConn = new GetConn();
		Connection conn = getConn.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("select * from user_info where username=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user.setUsername(rs.getString(1));
				user.setSex(rs.getString(3));
				user.setAge(rs.getString(4));
				user.setAvatar(rs.getString(5));
				user.setRealname(rs.getString(6));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public String changePwd(String username, String password) {
		// TODO Auto-generated method stub
		String result = null;
		GetConn getConn = new GetConn();
		int num = 0;
		Connection conn = getConn.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("update user_info set password=?  where username=?");
			ps.setString(1, password);
			ps.setString(2, username);

			num = ps.executeUpdate();
			if (num != 0) {
				result = "t";
			} else {
				result = "f";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean saveInfo(User user) {
		// TODO Auto-generated method stub
		boolean b = false;
		GetConn getConn = new GetConn();
		int i = 0;
		PreparedStatement ps;
		String s1 = "update user_info set realname=?,age=?,sex=?,avatar=?  where username=?";
		String s2 = "update user_info set realname=?,age=?,sex=?  where username=?";
		Connection conn = getConn.getConnection();
		try {
			if (user.getAvatar().equals("")) {
				ps = conn.prepareStatement(s2);
				ps.setString(4, user.getUsername());
			} else {
				ps = conn.prepareStatement(s1);
				ps.setString(4, user.getAvatar());
				ps.setString(5, user.getUsername());
			}
			ps.setString(1, user.getRealname());
			ps.setString(2, user.getAge());
			ps.setString(3, user.getSex());
			i = ps.executeUpdate();
			if (i > 0) {
				b = true;
			} else {
				b = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	public Designer getDesignerDetail(String username) {
		// TODO Auto-generated method stub
		GetConn getConn = new GetConn();
		ResultSet rs = null;
		Designer designer = new Designer();
		Connection conn = getConn.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("select * from designer_info where username=?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				designer.setUsername(rs.getString(1));
				designer.setAvatar(rs.getString(5));
				designer.setConcept(rs.getString(8));
				designer.setMotto(rs.getString(9));
				designer.setStyle(rs.getString(10));
				designer.setWork(rs.getString(11));
				designer.setPeriod(rs.getString(12));
				designer.setArea(rs.getString(13));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return designer;
	}

}
