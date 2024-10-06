package vn.HiepKa.dao;

import java.sql.SQLException;
import java.util.List;

import vn.HiepKa.models.UserModel;

public interface IUserDao {

	List<UserModel> findAll();
	
	UserModel findById(int id);
	
	void insert(UserModel user) throws SQLException, Exception;
	
	UserModel findByUserName(String username);
	
	UserModel findByEmail(String email);
	
	public void resetPassword(String email, String newPassword);
}
