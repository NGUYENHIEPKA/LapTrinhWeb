package vn.HiepKa.services.impl;

import vn.HiepKa.dao.IUserDao;
import vn.HiepKa.dao.impl.UserDaoImpl;
import vn.HiepKa.models.UserModel;
import vn.HiepKa.services.IUserService;

public class UserService implements IUserService{
	//lấy toàn bộ hàm trong tầng đao của user
	IUserDao userDao = new UserDaoImpl();
	
	@Override
	public UserModel login(String username, String password) {
		UserModel user = this.FindByUserName(username);
		if (user != null && password.equals(user.getPassword())) {
		return user;
		}
		return null;
	}

	@Override
	public UserModel FindByUserName(String username) {
		
		return userDao.findByUserName(username);
	}
	public static void main(String[] args) {
		IUserService userService = new UserService();
		System.out.println(userService.FindByUserName("hiepka"));
	}
}
