package it.dstech.dao;

import org.hibernate.Query;
import org.hibernate.Session;

import it.dstech.config.HibernateUtil;

public abstract class HibernateDao {

	private static Session session;

	public static Session getSession() {
		if (session == null)
			session = HibernateUtil.getSessionFactory().openSession();
		return session;
	}

	public static void closeSession() {
		session.close();
	}

	static Object persist(Object object) {
		session.beginTransaction();
		session.persist(object);
		session.getTransaction().commit();
		return object;
	}

	static Query select(String queryHQL) {
		return session.createQuery(queryHQL);
	}

	static Object update(Object object) {
		session.beginTransaction();
		session.update(object);
		session.getTransaction().commit();
		return object;
	}

	static Object delete(Object object) {
		session.beginTransaction();
		session.delete(object);
		session.getTransaction().commit();
		return object;
	}

}
