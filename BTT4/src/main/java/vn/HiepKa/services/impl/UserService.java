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
		if (user != null && password.trim().equals(user.getPassword().trim())) {
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

	@Override
	public boolean register(String username, String password, String fullname) {
		UserModel existingUser = userDao.findByUserName(username);
		if (existingUser != null) {
			return false; 
		}
		UserModel newUser = new UserModel();
		newUser.setUsername(username);
		newUser.setPassword(password); 
		newUser.setFullname(fullname);
		try {
	        userDao.insert(newUser);
	        return true;  
	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;  
	    }
	}
	public UserModel findByEmail(String email) {
        return userDao.findByEmail(email);
    }
	public boolean resetPassword(String email, String newPassword, String confirmPassword) {
        // Kiểm tra nếu mật khẩu mới và xác nhận trùng khớp
        if (newPassword.equals(confirmPassword)) {
            userDao.resetPassword(email, newPassword); // Cập nhật mật khẩu trong DB
            return true;
        }
        return false;
    }
}
