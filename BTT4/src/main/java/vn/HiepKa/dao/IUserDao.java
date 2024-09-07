package vn.HiepKa.dao;

import java.util.List;

import vn.HiepKa.models.UserModel;

public interface IUserDao {

	List<UserModel> findAll();
	
	UserModel findById(int id);
	
	void insert(UserModel user);
}
