package it.dstech.dao;

import it.dstech.model.User;

public interface UserDao {

	void saveUser(User user);
	
	User getUserByUsernameAndPassword(String username, String password);

}
