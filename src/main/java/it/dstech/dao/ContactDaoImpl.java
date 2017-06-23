package it.dstech.dao;

import java.util.ArrayList;

import javax.persistence.Query;

import it.dstech.model.Contact;
import it.dstech.model.User;

public class ContactDaoImpl extends ServicesCrud implements ContactDao {

	@Override
	public void saveContact(Contact contact) {
		jpaCreate(contact);
	}

	@Override
	public Contact getContactById(int id) {
		Query query = jpaRead("SELECT c FROM Contact c WHERE c.id=:id");
		query.setParameter("id", id);
		return (Contact) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Contact> getListContactsByUser(User user) {
		Query query = jpaRead("SELECT c FROM Contact c JOIN c.user u WHERE u.id=:id");
		query.setParameter("id", user.getId());
		return (ArrayList<Contact>) query.getResultList();
	}

	@Override
	public void updateContact(Contact contact) {
		jpaUpdate(contact);
	}

	@Override
	public void deleteContact(Contact contact) {
		jpaDelete(contact);
	}

}
