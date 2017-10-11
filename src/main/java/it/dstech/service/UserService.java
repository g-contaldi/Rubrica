package it.dstech.service;

import it.dstech.model.User;

public interface UserService {

	void saveUser(User user);

	User getUserByUsernameAndPassword(String username, String password);

}
