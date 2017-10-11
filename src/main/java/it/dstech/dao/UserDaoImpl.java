package it.dstech.dao;

import org.hibernate.Query;

import it.dstech.model.User;

public class UserDaoImpl extends HibernateDao implements UserDao {

	@Override
	public void saveUser(User user) {
		persist(user);
	}

	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		Query query = select("SELECT u FROM User u WHERE u.username=:username AND u.password=:password");
		query.setParameter("username", username);
		query.setParameter("password", password);
		return (User) query.uniqueResult();
	}

}
