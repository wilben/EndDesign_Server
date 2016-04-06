package com.gem.hsx.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gem.hsx.bean.Designer;
import com.gem.hsx.bean.Project;
import com.gem.hsx.bean.User;
import com.gem.hsx.db.GetConn;
import com.mysql.jdbc.Statement;

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
					.prepareStatement("insert into user_info values (?,?,?,?,?,?,?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getSex());
			ps.setString(4, user.getAge());
			ps.setString(5, user.getAvatar());
			ps.setString(6, user.getRealname());
			ps.setInt(7, user.getRole());
			ps.setString(8, user.getStyle());
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

	public String getAvatar(String username, int role) {
		// TODO Auto-generated method stub
		String url = null;
		GetConn getConn = new GetConn();
		ResultSet rs = null;
		PreparedStatement ps = null;
		Connection conn = getConn.getConnection();
		try {
			if (role == 0) {
				ps = conn
						.prepareStatement("select avatar from user_info where username=?");
			} else {
				ps = conn
						.prepareStatement("select avatar from designer_info where username=?");
			}
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

	public User getInfo(String username, String role) {
		// TODO Auto-generated method stub
		User user = new User();
		GetConn getConn = new GetConn();
		PreparedStatement ps = null;
		Connection conn = getConn.getConnection();
		try {
			if (role.equals("0")) {
				ps = conn
						.prepareStatement("select * from user_info where username=?");
			} else {
				ps = conn
						.prepareStatement("select * from designer_info where username=?");
			}
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

	public String changePwd(String username, String password, String role) {
		// TODO Auto-generated method stub
		String result = null;
		GetConn getConn = new GetConn();
		int num = 0;
		PreparedStatement ps = null;
		Connection conn = getConn.getConnection();
		try {
			if (role.equals("0")) {
				ps = conn
						.prepareStatement("update user_info set password=?  where username=?");
			} else {
				ps = conn
						.prepareStatement("update designer_info set password=?  where username=?");

			}
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
		String s1 = null;
		String s2 = null;
		Connection conn = getConn.getConnection();
		try {
			if (user.getRole() == 0) {
				s1 = "update user_info set realname=?,age=?,sex=?,avatar=?  where username=?";
				s2 = "update user_info set realname=?,age=?,sex=?  where username=?";
			} else {
				s1 = "update designer_info set realname=?,age=?,sex=?,avatar=?  where username=?";
				s2 = "update designer_info set realname=?,age=?,sex=?  where username=?";
			}

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

	public List<Project> getWorks(String username) {
		// TODO Auto-generated method stub
		GetConn getConn = new GetConn();
		ResultSet rs = null;
		List<Project> list = new ArrayList<Project>();
		Project work;
		Connection conn = getConn.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("select * from work_view where designername=?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			while (rs.next()) {
				work = new Project();
				work.setWorkId(rs.getInt(1));
				work.setTitle(rs.getString(2));
				work.setImage(rs.getString(3));
				work.setState(2);
				list.add(work);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Project getWorkDetail(int workId, int state) {
		// TODO Auto-generated method stub
		GetConn getConn = new GetConn();
		ResultSet rs = null, rs1 = null;
		ArrayList<String> list = new ArrayList<String>();
		Project project = new Project();
		boolean flag = true;
		Connection conn = getConn.getConnection();
		try {
			if (state == 1 || state == 2) {
				PreparedStatement ps = conn
						.prepareStatement("select * from workdetail_view where workId=?");
				ps.setInt(1, workId);
				rs = ps.executeQuery();
				if (rs.next()) {
					project.setTitle(rs.getString(2));
					project.setTime(rs.getString(4));
					project.setDescription(rs.getString(5));
					project.setState(rs.getInt(6));
					project.setDesignername(rs.getString(3));
					project.setUsername(rs.getString(7));
					PreparedStatement ps1 = conn
							.prepareStatement("select * from work_info where workId=?");
					ps1.setInt(1, workId);
					rs1 = ps1.executeQuery();
					while (rs1.next()) {
						list.add(rs1.getString(2));
					}
					project.setImageUrls(list);
					flag = false;
				}
			}
			if (flag) {
				PreparedStatement ps = conn
						.prepareStatement("select * from work where workId=?");
				ps.setInt(1, workId);
				rs = ps.executeQuery();
				if (rs.next()) {
					project.setTitle(rs.getString(3));
					project.setDesignername(rs.getString(7));
					project.setUsername(rs.getString(6));
					project.setTime(rs.getString(2));
					project.setState(rs.getInt(5));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return project;
	}

	public List<Project> selectAllCase() {
		// TODO Auto-generated method stub
		GetConn getConn = new GetConn();
		ResultSet rs = null, rs1 = null;
		Project caseItem;
		ArrayList<String> imageList;
		List<Project> caseList = new ArrayList<Project>();
		Connection conn = getConn.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("select * from project_view");
			rs = ps.executeQuery();
			while (rs.next()) {
				caseItem = new Project();
				caseItem.setImage(rs.getString(1));
				caseItem.setUsername(rs.getString(2));
				caseItem.setDescription(rs.getString(3));
				PreparedStatement ps1 = conn
						.prepareStatement("select * from work_info where workId =?");
				ps1.setInt(1, rs.getInt(4));
				rs1 = ps1.executeQuery();
				imageList = new ArrayList<String>();
				while (rs1.next()) {
					imageList.add(rs1.getString(2));
				}
				caseItem.setImageUrls(imageList);
				caseList.add(caseItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return caseList;
	}

	public List<com.gem.hsx.bean.Project> getProjects(String username,
			int state, String role) throws SQLException {
		// TODO Auto-generated method stub
		GetConn getConn = new GetConn();
		ResultSet rs = null, rs1 = null, rs2 = null, rs4 = null;
		Project project;
		PreparedStatement ps = null;
		String name = null;
		List<Project> projectList = new ArrayList<Project>();
		Connection conn = getConn.getConnection();
		Statement stmt = (Statement) conn.createStatement();
		String queryString = null;
		try {
			if (role.equals("0")) {
				name = "username";
			} else {
				name = "designername";
			}
			if (state == 1 || state == 2) {

				ps = conn.prepareStatement("select * from projects_view where "
						+ name + "=? and state =?");
				ps.setString(1, username);
				ps.setInt(2, state);
				rs = ps.executeQuery();
				while (rs.next()) {
					project = new Project();
					project.setWorkId(rs.getInt(1));
					project.setImage(rs.getString(4));
					project.setTitle(rs.getString(3));
					project.setTime(rs.getString(2));
					project.setUsername(rs.getString(6));
					project.setDesignername(rs.getString(7));
					project.setState(rs.getInt(5));
					projectList.add(project);
				}
				if (state == 1) {
					queryString = "select a.workId from  (select workId from work where state = 1 )as a where a.workId not in"
							+ "(select workId from work_info group by workId)";
					rs1 = stmt.executeQuery(queryString);
					while (rs1.next()) {
						ps = conn
								.prepareStatement("select * from work where workId =?");
						ps.setInt(1, rs1.getInt(1));
						rs2 = ps.executeQuery();
						if (rs2.next()) {
							project = new Project();
							project.setWorkId(rs2.getInt(1));
							project.setTitle(rs2.getString(3));
							project.setTime(rs2.getString(2));
							project.setUsername(rs2.getString(6));
							project.setDesignername(rs2.getString(7));
							project.setState(rs2.getInt(5));
							projectList.add(project);
						}
					}
				}
			} else if (state == 3) {
				ps = conn.prepareStatement("select * from projects_view where "
						+ name + "=? and state =1");
				ps.setString(1, username);
				rs1 = ps.executeQuery();
				ps = conn.prepareStatement("select * from projects_view where "
						+ name + "=? and state =2");
				ps.setString(1, username);
				rs2 = ps.executeQuery();
				queryString = "select a.workId from  (select workId from work )as a where a.workId not in"
						+ "(select workId from work_info group by workId)";
				rs4 = stmt.executeQuery(queryString);
				while (rs4.next()) {
					ps = conn
							.prepareStatement("select * from work where workId =?");
					ps.setInt(1, rs4.getInt(1));
					rs = ps.executeQuery();
					while (rs.next()) {
						project = new Project();
						project.setWorkId(rs.getInt(1));
						project.setTitle(rs.getString(3));
						project.setTime(rs.getString(2));
						project.setUsername(rs.getString(6));
						project.setDesignername(rs.getString(7));
						project.setState(rs.getInt(5));
						projectList.add(project);
					}
				}
				while (rs1.next()) {
					project = new Project();
					project.setWorkId(rs1.getInt(1));
					project.setImage(rs1.getString(4));
					project.setTitle(rs1.getString(3));
					project.setTime(rs1.getString(2));
					project.setUsername(rs1.getString(6));
					project.setDesignername(rs1.getString(7));
					project.setState(rs1.getInt(5));
					projectList.add(project);
				}
				while (rs2.next()) {
					project = new Project();
					project.setWorkId(rs2.getInt(1));
					project.setImage(rs2.getString(4));
					project.setTitle(rs2.getString(3));
					project.setTime(rs2.getString(2));
					project.setUsername(rs2.getString(6));
					project.setDesignername(rs2.getString(7));
					project.setState(rs2.getInt(5));
					projectList.add(project);
				}
			} else {
				ps = conn.prepareStatement("select * from work where " + name
						+ "=? and state =?");
				ps.setString(1, username);
				ps.setInt(2, state);
				rs = ps.executeQuery();
				while (rs.next()) {
					project = new Project();
					project.setWorkId(rs.getInt(1));
					project.setTitle(rs.getString(3));
					project.setTime(rs.getString(2));
					project.setUsername(rs.getString(6));
					project.setDesignername(rs.getString(7));
					project.setState(rs.getInt(5));
					projectList.add(project);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projectList;
	}

	public boolean launchProject(Project project) {
		boolean b = false;
		GetConn getConn = new GetConn();
		int i = 0;
		Connection conn = getConn.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("insert work (time,title,state,username,designername) values  (?,?,?,?,?)");
			ps.setString(1, project.getTime());
			ps.setString(2, project.getTitle());
			ps.setInt(3, project.getState());
			ps.setString(4, project.getUsername());
			ps.setString(5, project.getDesignername());
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

	public String saveStyle(String username, String style, String role) {
		String result = null;
		GetConn getConn = new GetConn();
		int num = 0;
		PreparedStatement ps = null;
		Connection conn = getConn.getConnection();
		try {
			if (role.equals("0")) {
				ps = conn
						.prepareStatement("update user_info set style=?  where username=?");
			} else {
				ps = conn
						.prepareStatement("update designer_info set style=?  where username=?");
			}
			ps.setString(1, style);
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

	public String getStyle(String username, String role) {
		String result = null;
		GetConn getConn = new GetConn();
		Connection conn = getConn.getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			if (role.equals("0")) {
				ps = conn
						.prepareStatement("select style from user_info  where username=?");
			} else {
				ps = conn
						.prepareStatement("select style from designer_info  where username=?");
			}
			ps.setString(1, username);

			rs = ps.executeQuery();
			if (rs.next()) {
				result = rs.getString(1);
			} else {
				result = "";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public String changeState(int workId, int state) {
		// TODO Auto-generated method stub
		String result = null;
		GetConn getConn = new GetConn();
		int num = 0;
		PreparedStatement ps = null;
		Connection conn = getConn.getConnection();
		try {
			ps = conn
					.prepareStatement("update work set state=?  where workId=?");
			ps.setInt(1, state);
			ps.setInt(2, workId);

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

}
