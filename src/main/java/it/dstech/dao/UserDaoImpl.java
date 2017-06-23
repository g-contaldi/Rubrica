package it.dstech.dao;

import javax.persistence.Query;

import it.dstech.model.User;

public class UserDaoImpl extends ServicesCrud implements UserDao {

	@Override
	public void saveUser(User user) {
		jpaCreate(user);
	}

	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		Query query = jpaRead("SELECT u FROM User u WHERE u.username=:username AND u.password=:password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		return (User) query.getSingleResult();
	}

}
