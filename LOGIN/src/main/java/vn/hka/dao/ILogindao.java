package vn.hka.dao;

import vn.hka.model.loginmodel;

public interface ILogindao {
	loginmodel findByUsername(String username);
}
