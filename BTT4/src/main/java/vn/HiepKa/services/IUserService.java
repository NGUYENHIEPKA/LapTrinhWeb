package vn.HiepKa.services;

import vn.HiepKa.models.UserModel;

public interface IUserService {
	UserModel login(String username, String password);
	UserModel FindByUserName(String username);
	boolean register (String username, String password, String fullname);
}
