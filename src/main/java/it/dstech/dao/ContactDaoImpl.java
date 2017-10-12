package it.dstech.dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import it.dstech.model.Contact;
import it.dstech.model.User;

public class ContactDaoImpl extends HibernateDao implements ContactDao {

	@Override
	public void saveContact(Contact contact) {
		persist(contact);
	}

	// @Override
	// public Contact getContactById(int id) {
	// Query query = select("SELECT c FROM Contact c WHERE c.id=:id");
	// query.setParameter("id", id);
	// return (Contact) query.uniqueResult();
	// }

	@Override
	public Contact getContactById(int id) {
		Criteria cr = getSession().createCriteria(Contact.class);
		cr.add(Restrictions.eq("id", id));
		return (Contact) cr.uniqueResult();
	}

	// @SuppressWarnings("unchecked")
	// @Override
	// public ArrayList<Contact> getListContactsByUser(User user) {
	// Query query = select("SELECT c FROM Contact c JOIN c.user u WHERE
	// u.id=:id");
	// query.setParameter("id", user.getId());
	// return (ArrayList<Contact>) query.list();
	// }

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Contact> getListContactsByUser(User user) {
		Criteria cr = getSession().createCriteria(Contact.class, "contact");
		cr.createAlias("contact.user", "user");
		cr.add(Restrictions.eq("user.id", user.getId()));
		return (ArrayList<Contact>) cr.list();
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
