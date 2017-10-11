package it.dstech.service;

import it.dstech.dao.UserDao;
import it.dstech.dao.UserDaoImpl;
import it.dstech.model.User;

public class UserServiceImpl implements UserService {

	UserDao dao = new UserDaoImpl();

	@Override
	public void saveUser(User user) {
		dao.saveUser(user);
	}

	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		return dao.getUserByUsernameAndPassword(username, password);
	}

}
