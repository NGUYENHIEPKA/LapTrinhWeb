package vn.HiepKa.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.HiepKa.configs.DBConnectSQL;
import vn.HiepKa.dao.IUserDao;
import vn.HiepKa.models.UserModel;

public class UserDaoImpl extends DBConnectSQL implements IUserDao {

	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	@Override
	public List<UserModel> findAll() {
		String sql = "select * from Table_1";
		List<UserModel> list = new ArrayList<UserModel>();
		try {
			conn = new DBConnectSQL().getConnection();
			if (conn == null) {
				System.out.println("Kết nối tới cơ sở dữ liệu thất bại.");
				return list;
			}
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new UserModel(rs.getInt("id"), rs.getString("username"), rs.getString("password"),
						rs.getString("images"), rs.getString("fullname"), rs.getString("email"), rs.getString("phone"),
						rs.getInt("roleid"), rs.getDate("createDate")));
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserModel findById(int id) {
		String sql = "select * from Table_1 where id = ?";

		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("images"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreateDate(rs.getDate("createDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO Table_1 (email, username, fullname, password, images, roleid, phone, createDate)"
				+ "VALUES ('', ?, ?, ?, '', 1, '', '')";

		try {
			conn = new DBConnectSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getFullname());
			ps.setString(3, user.getPassword());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public UserModel findByUserName(String username) {
		String sql = "select * from Table_1 where username = ?";

		try {
			conn = super.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			rs = ps.executeQuery();

			while (rs.next()) {
				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setEmail(rs.getString("email"));
				user.setUsername(rs.getString("username"));
				user.setFullname(rs.getString("fullname"));
				user.setPassword(rs.getString("password"));
				user.setImages(rs.getString("images"));
				user.setRoleid(Integer.parseInt(rs.getString("roleid")));
				user.setPhone(rs.getString("phone"));
				user.setCreateDate(rs.getDate("createDate"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

//	public static void main(String[] args) {
//		UserDaoImpl userDao = new UserDaoImpl();
//		List<UserModel> list = userDao.findAll();
//		for (UserModel user : list) {
//			System.out.println(user);
//
//		}
//	}

//	public static void main(String[] args) {
//	    UserDaoImpl userDao = new UserDaoImpl();
//	    int idToFind = 2; 
//	    UserModel user = userDao.findById(idToFind);
//	    
//	    if (user != null) {
//	        System.out.println("Thông tin người dùng với ID " + idToFind + ":");
//	        System.out.println(user);
//	    } else {
//	        System.out.println("Không tìm thấy người dùng với ID " + idToFind + ".");
//	    }
//	}
	public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        String usernameToFind = "hiepka";
        UserModel user = userDao.findByUserName(usernameToFind);
        if (user != null) {
            System.out.println("Thông tin người dùng với username '" + usernameToFind + "':");
            System.out.println("ID: " + user.getId());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Username: " + user.getUsername());
            System.out.println("Fullname: " + user.getFullname());
            System.out.println("Password: " + user.getPassword());
            System.out.println("Images: " + user.getImages());
            System.out.println("Role ID: " + user.getRoleid());
            System.out.println("Phone: " + user.getPhone());
            System.out.println("Create Date: " + user.getCreateDate());
        } else {
            System.out.println("Không tìm thấy người dùng với username '" + usernameToFind + "'.");
        }
    }

	@Override
	public UserModel findByEmail(String email) {
		String sql = "SELECT * FROM Table_1 WHERE email = ?";

        try {
            conn = new DBConnectSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new UserModel(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("images"),
                    rs.getString("fullname"),
                    rs.getString("email"),
                    rs.getString("phone"),
                    rs.getInt("roleid"),
                    rs.getDate("createDate")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
		return null;
	}

	@Override
	public void resetPassword(String email, String newPassword) {
		String sql = "UPDATE Table_1 SET password = ? WHERE email = ?";
        try {
            conn = new DBConnectSQL().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, newPassword);
            ps.setString(2, email);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

//	public static void main(String[] args) {
//		UserDaoImpl userDao = new UserDaoImpl();
//		UserModel newUser = new UserModel(5, "vanan", "777", "", "Van An", "vanan@gmail.com", "0765213678", 2,
//				java.sql.Date.valueOf("2004-01-01"));
//			try {
//				userDao.insert(newUser);
//				System.out.println("Đã chèn người dùng mới vào cơ sở dữ liệu.");
//			} catch (Exception e) {
//				e.printStackTrace();
//				System.out.println("Lỗi");
//			}		
//	}
}