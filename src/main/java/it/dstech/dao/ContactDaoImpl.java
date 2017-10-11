package it.dstech.dao;

import java.util.ArrayList;

import org.hibernate.Query;

import it.dstech.model.Contact;
import it.dstech.model.User;

public class ContactDaoImpl extends HibernateDao implements ContactDao {

	@Override
	public void saveContact(Contact contact) {
		persist(contact);
	}

	@Override
	public Contact getContactById(int id) {
		Query query = select("SELECT c FROM Contact c WHERE c.id=:id");
		query.setParameter("id", id);
		return (Contact) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Contact> getListContactsByUser(User user) {
		Query query = select("SELECT c FROM Contact c JOIN c.user u WHERE u.id=:id");
		query.setParameter("id", user.getId());
		return (ArrayList<Contact>) query.list();
	}

	@Override
	public void updateContact(Contact contact) {
		update(contact);
	}

	@Override
	public void deleteContact(Contact contact) {
		delete(contact);
	}

}
