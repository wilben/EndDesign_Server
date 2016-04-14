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
	/**
	 * 登录
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return
	 */
	public int login(String username, String password) {
		int b = -1;
		GetConn getConn = new GetConn();
		ResultSet rs = null, rs1 = null;
		Connection conn = getConn.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("select * from user_info where binary username=? and binary password=?");
			ps.setString(1, username);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if (rs.next()) {
				b = 0;
			}
			PreparedStatement ps1 = conn
					.prepareStatement("select * from designer_info where binary username=? and binary password=?");
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

	/**
	 * 注册
	 * 
	 * @param user
	 *            用户信息
	 * @return
	 */
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

	/**
	 * 查询设计师列表
	 * 
	 * @return
	 */
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
				designer.setSex(rs.getString(3));
				designer.setAvatar(rs.getString(5));
				designer.setRealname(rs.getString(6));
				designer.setRole(rs.getInt(7));
				designer.setArea(rs.getString(13));
				designer.setStyle(rs.getString(8));
				list.add(designer);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 用户名是否存在
	 * 
	 * @param username
	 *            用户名
	 * @return
	 */
	public boolean check(String username) {
		boolean b = false;
		GetConn getConn = new GetConn();
		ResultSet rs = null, rs1 = null;
		Connection conn = getConn.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("select * from user_info where binary username=?");
			ps.setString(1, username);

			rs = ps.executeQuery();
			PreparedStatement ps1 = conn
					.prepareStatement("select * from designer_info where binary username=?");
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

	/**
	 * 查询头像
	 * 
	 * @param username
	 *            用户名
	 * @param role
	 *            角色
	 * @return
	 */
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
						.prepareStatement("select avatar from user_info where binary username=?");
			} else {
				ps = conn
						.prepareStatement("select avatar from designer_info where binary username=?");
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

	/**
	 * 查询用户个人信息
	 * 
	 * @param username
	 *            用户名
	 * @return
	 */
	public User getU_Info(String username) {
		// TODO Auto-generated method stub
		User user = new User();
		GetConn getConn = new GetConn();
		PreparedStatement ps = null;
		Connection conn = getConn.getConnection();
		try {
			ps = conn
					.prepareStatement("select * from user_info where binary username=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user.setUsername(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setSex(rs.getString(3));
				user.setAge(rs.getString(4));
				user.setAvatar(rs.getString(5));
				user.setRealname(rs.getString(6));
				user.setRole(rs.getInt(7));
				user.setStyle(rs.getString(8));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * 查询设计师个人信息
	 * 
	 * @param username
	 *            用户名
	 * @return
	 */
	public Designer getD_Info(String username) {
		// TODO Auto-generated method stub
		Designer designer = new Designer();
		GetConn getConn = new GetConn();
		PreparedStatement ps = null;
		Connection conn = getConn.getConnection();
		try {
			ps = conn
					.prepareStatement("select * from designer_info where binary username=?");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				designer.setUsername(rs.getString(1));
				designer.setSex(rs.getString(3));
				designer.setAge(rs.getString(4));
				designer.setAvatar(rs.getString(5));
				designer.setRealname(rs.getString(6));
				designer.setConcept(rs.getString(9));
				designer.setMotto(rs.getString(10));
				designer.setWork(rs.getString(11));
				designer.setArea(rs.getString(13));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return designer;
	}

	/**
	 * 修改密码
	 * 
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @param role
	 *            角色
	 * @return
	 */
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
						.prepareStatement("update user_info set password=?  where binary username=?");
			} else {
				ps = conn
						.prepareStatement("update designer_info set password=?  where binary username=?");

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

	/**
	 * 修改用户个人信息
	 * 
	 * @param user
	 *            用户信息
	 * @return
	 */
	public boolean saveU_Info(User user) {
		// TODO Auto-generated method stub
		boolean b = false;
		GetConn getConn = new GetConn();
		int i = 0;
		PreparedStatement ps;
		String s1 = null;
		String s2 = null;
		Connection conn = getConn.getConnection();
		try {
			s1 = "update user_info set realname=?,age=?,sex=?,avatar=?  where binary username=?";
			s2 = "update user_info set realname=?,age=?,sex=?  where binary username=?";

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

	/**
	 * 修改设计师个人信息
	 * 
	 * @param designer
	 *            设计师信息
	 * @return
	 */
	public boolean saveD_Info(Designer designer) {
		// TODO Auto-generated method stub
		boolean b = false;
		GetConn getConn = new GetConn();
		int i = 0;
		PreparedStatement ps;
		String s1 = null;
		String s2 = null;
		Connection conn = getConn.getConnection();
		try {
			s1 = "update designer_info set realname=?,age=?,sex=?,concept=?,motto=?,work=?,area=?,avatar=?  where binary username=?";
			s2 = "update designer_info set realname=?,age=?,sex=?,concept=?,motto=?,work=?,area=?  where binary username=?";

			if (designer.getAvatar().equals("")) {
				ps = conn.prepareStatement(s2);
				ps.setString(8, designer.getUsername());
			} else {
				ps = conn.prepareStatement(s1);
				ps.setString(8, designer.getAvatar());
				ps.setString(9, designer.getUsername());
			}
			ps.setString(1, designer.getRealname());
			ps.setString(2, designer.getAge());
			ps.setString(3, designer.getSex());
			ps.setString(4, designer.getConcept());
			ps.setString(5, designer.getMotto());
			ps.setString(6, designer.getWork());
			ps.setString(7, designer.getArea());
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

	/**
	 * 查询设计师详情
	 * 
	 * @param username
	 *            设计师名
	 * @return
	 */
	public Designer getDesignerDetail(String username) {
		// TODO Auto-generated method stub
		GetConn getConn = new GetConn();
		ResultSet rs = null;
		Designer designer = new Designer();
		Connection conn = getConn.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("select * from designer_info where binary username=?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				designer.setUsername(rs.getString(1));
				designer.setSex(rs.getString(3));
				designer.setAge(rs.getString(4));
				designer.setAvatar(rs.getString(5));
				designer.setRealname(rs.getString(6));
				designer.setRole(rs.getInt(7));
				designer.setStyle(rs.getString(8));
				designer.setConcept(rs.getString(9));
				designer.setMotto(rs.getString(10));
				designer.setWork(rs.getString(11));
				designer.setPeriod(rs.getString(12));
				designer.setArea(rs.getString(13));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return designer;
	}

	/**
	 * 查询作品列表
	 * 
	 * @param username
	 *            设计师名
	 * @return
	 */
	public List<Project> getWorks(String username) {
		// TODO Auto-generated method stub
		GetConn getConn = new GetConn();
		ResultSet rs = null;
		List<Project> list = new ArrayList<Project>();
		Project work;
		Connection conn = getConn.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("select * from work_view where binary designername=?");
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

	/**
	 * 查询项目详情
	 * 
	 * @param workId
	 *            项目Id
	 * @param state
	 *            项目状态
	 * @return
	 */
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
					project.setWorkId(rs.getInt(1));
					project.setTitle(rs.getString(2));
					project.setTime(rs.getString(4));
					project.setDescription(rs.getString(5));
					project.setState(rs.getInt(6));
					project.setDesignername(rs.getString(3));
					project.setUsername(rs.getString(7));
					project.setStyle(rs.getString(8));
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
					project.setWorkId(rs.getInt(1));
					project.setTitle(rs.getString(3));
					project.setDesignername(rs.getString(7));
					project.setUsername(rs.getString(6));
					project.setDescription(rs.getString(4));
					project.setTime(rs.getString(2));
					project.setState(rs.getInt(5));
					project.setStyle(rs.getString(8));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return project;
	}

	/**
	 * 查询经典案例列表
	 * 
	 * @return
	 */
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
				caseItem.setStyle(rs.getString(5));
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

	/**
	 * 查询项目列表
	 * 
	 * @param username
	 *            用户名
	 * @param state
	 *            项目状态
	 * @param role
	 *            角色
	 * @return
	 * @throws SQLException
	 */
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
					ps = conn
							.prepareStatement("select a.workId from  (select workId from work where state = 1 and binary"
									+ name
									+ "=? )as a where a.workId not in"
									+ "(select workId from work_info group by workId)");
					ps.setString(1, username);
					rs1 = ps.executeQuery();
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
				ps = conn
						.prepareStatement("select * from projects_view where binary "
								+ name + "=? and state =1");
				ps.setString(1, username);
				rs1 = ps.executeQuery();
				ps = conn
						.prepareStatement("select * from projects_view where binary "
								+ name + "=? and state =2");
				ps.setString(1, username);
				rs2 = ps.executeQuery();
				ps = conn
						.prepareStatement("select a.workId from  (select workId from work where binary "
								+ name
								+ " =?)as a where a.workId not in"
								+ "(select workId from work_info group by workId)");
				ps.setString(1, username);
				rs4 = ps.executeQuery();
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
				ps = conn.prepareStatement("select * from work where binary "
						+ name + "=? and state =?");
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

	/**
	 * 新建项目
	 * 
	 * @param project
	 *            项目信息
	 * @return
	 */
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

	/**
	 * 修改我的风格
	 * 
	 * @param username
	 *            用户名
	 * @param style
	 *            风格
	 * @param role
	 *            角色
	 * @return
	 */
	public String saveStyle(String username, String style, String role) {
		String result = null;
		GetConn getConn = new GetConn();
		int num = 0;
		PreparedStatement ps = null;
		Connection conn = getConn.getConnection();
		try {
			if (role.equals("0")) {
				ps = conn
						.prepareStatement("update user_info set style=?  where binary username=?");
			} else {
				ps = conn
						.prepareStatement("update designer_info set style=?  where binary username=?");
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

	/**
	 * 查询我的风格
	 * 
	 * @param username
	 *            用户名
	 * @param role
	 *            角色
	 * @return
	 */
	public String getStyle(String username, String role) {
		String result = null;
		GetConn getConn = new GetConn();
		Connection conn = getConn.getConnection();
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			if (role.equals("0")) {
				ps = conn
						.prepareStatement("select style from user_info  where binary username=?");
			} else {
				ps = conn
						.prepareStatement("select style from designer_info  where binary username=?");
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

	/**
	 * 修改项目状态
	 * 
	 * @param workId
	 *            项目Id
	 * @param state
	 *            项目状态
	 * @return
	 */
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

	/**
	 * 修改项目信息
	 * 
	 * @param project
	 * @return
	 */
	public boolean updateProject(Project project) {
		boolean b = false;
		GetConn getConn = new GetConn();
		int i = 0, k = 1;
		PreparedStatement ps;
		String s1 = null;
		String s2 = null;
		String imageUrl = "";
		ArrayList<String> list = project.getImageUrls();
		Connection conn = getConn.getConnection();
		try {
			s1 = "update work set title=?,description=?,style=? where workId=?";
			s2 = "insert work_info (image,workId) values (?,?) ";

			ps = conn.prepareStatement(s1);
			ps.setString(1, project.getTitle());
			ps.setString(2, project.getDescription());
			ps.setString(3, project.getStyle());
			ps.setInt(4, project.getWorkId());
			i = ps.executeUpdate();
			if (list.size() > 0) {
				for (int j = 0; j < list.size(); j++) {
					imageUrl = list.get(j);
					ps = conn.prepareStatement(s2);
					ps.setString(1, imageUrl);
					ps.setInt(2, project.getWorkId());
					k = k * ps.executeUpdate();
				}
			}
			if (i > 0 && k != 0) {
				b = true;
			} else {
				b = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	/**
	 * 查询设计师
	 * 
	 * @param content
	 *            设计师名
	 * @return
	 */
	public List<Designer> searchDesigner(String content) {
		List<Designer> list = new ArrayList<Designer>();
		GetConn getConn = new GetConn();
		Connection conn = getConn.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("select * from designer_info  where username like ?");
			ps.setString(1, "%" + content + "%");
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

	public boolean register(Designer designer) {
		boolean b = false;
		GetConn getConn = new GetConn();
		int i = 0;
		Connection conn = getConn.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("insert designer_info (username,password,sex,age,realname,role)  values (?,?,?,?,?,?)");
			ps.setString(1, designer.getUsername());
			ps.setString(2, designer.getPassword());
			ps.setString(3, designer.getSex());
			ps.setString(4, designer.getAge());
			ps.setString(5, designer.getRealname());
			ps.setInt(6, designer.getRole());
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

	public boolean modifyDesigner(Designer designer) {
		// TODO Auto-generated method stub
		boolean b = false;
		GetConn getConn = new GetConn();
		int i = 0;
		Connection conn = getConn.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("update designer_info set sex=?,age=?,avatar=?,realname=?,role=?,style=?,concept=?,motto=?,work=?,period=?,area=? where username=?");
			ps.setString(1, designer.getSex());
			ps.setString(2, designer.getAge());
			ps.setString(3, designer.getAvatar());
			ps.setString(4, designer.getRealname());
			ps.setInt(5, designer.getRole());
			ps.setString(6, designer.getStyle());
			ps.setString(7, designer.getConcept());
			ps.setString(8, designer.getMotto());
			ps.setString(9, designer.getWork());
			ps.setString(10, designer.getPeriod());
			ps.setString(11, designer.getArea());
			ps.setString(12, designer.getUsername());
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

	public boolean deleteInfo(String username, int role) {
		// TODO Auto-generated method stub
		boolean b = false;
		GetConn getConn = new GetConn();
		int i = 0;
		PreparedStatement ps;
		Connection conn = getConn.getConnection();
		try {
			if (role == 1) {
				ps = conn
						.prepareStatement("delete from designer_info where username=?");
			} else {
				ps = conn
						.prepareStatement("delete from user_info where username=?");
			}
			ps.setString(1, username);
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

	public boolean resetPwd(String username, int role) {
		// TODO Auto-generated method stub
		boolean b = false;
		GetConn getConn = new GetConn();
		int i = 0;
		PreparedStatement ps;
		Connection conn = getConn.getConnection();
		try {
			if (role == 1) {
				ps = conn
						.prepareStatement("update designer_info set password='000000' where username=?");
			} else {
				ps = conn
						.prepareStatement("update user_info set password='000000' where username=?");
			}
			ps.setString(1, username);
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

	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		List<User> list = new ArrayList<User>();
		GetConn getConn = new GetConn();
		Connection conn = getConn.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("select * from user_info where role=0");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUsername(rs.getString(1));
				user.setSex(rs.getString(3));
				user.setRealname(rs.getString(6));
				user.setRole(rs.getInt(7));
				user.setStyle(rs.getString(8));
				list.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean modifyuser(User user) {
		// TODO Auto-generated method stub
		boolean b = false;
		GetConn getConn = new GetConn();
		int i = 0;
		Connection conn = getConn.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("update user_info set sex=?,age=?,avatar=?,realname=?,role=?,style=? where username=?");
			ps.setString(1, user.getSex());
			ps.setString(2, user.getAge());
			ps.setString(3, user.getAvatar());
			ps.setString(4, user.getRealname());
			ps.setInt(5, user.getRole());
			ps.setString(6, user.getStyle());
			ps.setString(7, user.getUsername());
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

	public List<Project> selectAllProject(int cur, int DATA_PER_PAGE) {
		// TODO Auto-generated method stub
		List<Project> list = new ArrayList<Project>();
		GetConn getConn = new GetConn();
		Connection conn = getConn.getConnection();
		try {
			PreparedStatement ps = conn
					.prepareStatement("select * from work order by time limit ?,?");
			ps.setInt(1, (cur - 1) * DATA_PER_PAGE);
			ps.setInt(2, DATA_PER_PAGE);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Project project = new Project();
				project.setWorkId(rs.getInt(1));
				project.setTime(rs.getString(2));
				project.setTitle(rs.getString(3));
				project.setState(rs.getInt(5));
				project.setUsername(rs.getString(6));
				project.setDesignername(rs.getString(7));
				list.add(project);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean modifyProject(Project project) {
		boolean b = false;
		GetConn getConn = new GetConn();
		int i = 0, k = 1;
		PreparedStatement ps;
		String s1 = null;
		Connection conn = getConn.getConnection();
		try {
			s1 = "update work set title=?,description=?,style=?,time=?,state=? where workId=?";
			ps = conn.prepareStatement(s1);
			ps.setString(1, project.getTitle());
			ps.setString(2, project.getDescription());
			ps.setString(3, project.getStyle());
			ps.setString(4, project.getTime());
			ps.setInt(5, project.getState());
			ps.setInt(6, project.getWorkId());
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

	public int getTotalRecord() {
		// TODO Auto-generated method stub
		GetConn getConn = new GetConn();
		Connection conn = getConn.getConnection();
		int num = 0;
		try {
			PreparedStatement ps = conn
					.prepareStatement("select count(*) from work ");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				num = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	public int getTotalRecord(String content1, String content2) {
		// TODO Auto-generated method stub
		GetConn getConn = new GetConn();
		Connection conn = getConn.getConnection();
		int num = 0, state = 3;
		PreparedStatement ps;
		ResultSet rs = null;
		try {
			if (content1.equals("") && content2.equals("")) {
				ps = conn.prepareStatement("select count(*) from work");
				rs = ps.executeQuery();
			} else if (!content1.equals("") && content2.equals("")) {
				ps = conn
						.prepareStatement("select count(*) from work where title like ? or username like ? or designername like ?");
				ps.setString(1, "%" + content1 + "%");
				ps.setString(2, "%" + content1 + "%");
				ps.setString(3, "%" + content1 + "%");
				rs = ps.executeQuery();
			} else if (content1.equals("") && !content2.equals("")) {
				if (content2.equals("已取消")) {
					state = -1;
				} else if (content2.equals("待设计")) {
					state = 0;
				} else if (content2.equals("设计中")) {
					state = 1;
				} else if (content2.equals("已完成")) {
					state = 2;
				}
				ps = conn
						.prepareStatement("select count(*) from work where state=?");
				ps.setInt(1, state);
				rs = ps.executeQuery();
			} else {
				if (content2.equals("已取消")) {
					state = -1;
				} else if (content2.equals("待设计")) {
					state = 0;
				} else if (content2.equals("设计中")) {
					state = 1;
				} else if (content2.equals("已完成")) {
					state = 2;
				}
				ps = conn
						.prepareStatement("select count(*) from work where title like ? or username like ? or designername like ? and state=?");
				ps.setString(1, "%" + content1 + "%");
				ps.setString(2, "%" + content1 + "%");
				ps.setString(3, "%" + content1 + "%");
				ps.setInt(4, state);
				rs = ps.executeQuery();
			}
			if (rs.next()) {
				num = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}

	public List<Project> selectAllProject(String content1, String content2,
			int cur, int DATA_PER_PAGE) {
		// TODO Auto-generated method stub
		List<Project> list = new ArrayList<Project>();
		GetConn getConn = new GetConn();
		int state = 3;
		Connection conn = getConn.getConnection();
		PreparedStatement ps;
		ResultSet rs = null;
		try {
			if (content1.equals("") && content2.equals("")) {
				ps = conn
						.prepareStatement("select * from work order by time limit ?,?");
				ps.setInt(1, (cur - 1) * DATA_PER_PAGE);
				ps.setInt(2, DATA_PER_PAGE);
				rs = ps.executeQuery();
			} else if (!content1.equals("") && content2.equals("")) {
				ps = conn
						.prepareStatement("select * from work where title like ? or username like ? or designername like ? order by time limit ?,?");
				ps.setString(1, "%" + content1 + "%");
				ps.setString(2, "%" + content1 + "%");
				ps.setString(3, "%" + content1 + "%");
				ps.setInt(4, (cur - 1) * DATA_PER_PAGE);
				ps.setInt(5, DATA_PER_PAGE);
				rs = ps.executeQuery();
			} else if (content1.equals("") && !content2.equals("")) {
				if (content2.equals("已取消")) {
					state = -1;
				} else if (content2.equals("待设计")) {
					state = 0;
				} else if (content2.equals("设计中")) {
					state = 1;
				} else if (content2.equals("已完成")) {
					state = 2;
				}
				ps = conn
						.prepareStatement("select * from work where state=? order by time limit ?,?");
				ps.setInt(1, state);
				ps.setInt(2, (cur - 1) * DATA_PER_PAGE);
				ps.setInt(3, DATA_PER_PAGE);
				rs = ps.executeQuery();
			} else {
				if (content2.equals("已取消")) {
					state = -1;
				} else if (content2.equals("待设计")) {
					state = 0;
				} else if (content2.equals("设计中")) {
					state = 1;
				} else if (content2.equals("已完成")) {
					state = 2;
				}
				ps = conn
						.prepareStatement("select * from work where title like ? or username like ? or designername like ? and state=? order by time limit ?,?");
				ps.setString(1, "%" + content1 + "%");
				ps.setString(2, "%" + content1 + "%");
				ps.setString(3, "%" + content1 + "%");
				ps.setInt(4, state);
				ps.setInt(5, (cur - 1) * DATA_PER_PAGE);
				ps.setInt(6, DATA_PER_PAGE);
				rs = ps.executeQuery();
			}
			while (rs.next()) {
				Project project = new Project();
				project.setWorkId(rs.getInt(1));
				project.setTime(rs.getString(2));
				project.setTitle(rs.getString(3));
				project.setState(rs.getInt(5));
				project.setUsername(rs.getString(6));
				project.setDesignername(rs.getString(7));
				list.add(project);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
