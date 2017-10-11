package it.dstech.service;

import java.util.ArrayList;

import it.dstech.dao.ContactDao;
import it.dstech.dao.ContactDaoImpl;
import it.dstech.model.Contact;
import it.dstech.model.User;

public class ContactServiceImpl implements ContactService {

	ContactDao dao = new ContactDaoImpl();

	@Override
	public void saveContact(Contact contact) {
		dao.saveContact(contact);
	}

	@Override
	public Contact getContactById(int id) {
		return dao.getContactById(id);
	}

	@Override
	public ArrayList<Contact> getListContactsByUser(User user) {
		return dao.getListContactsByUser(user);
	}

	@Override
	public void updateContact(Contact contact) {
		dao.updateContact(contact);
	}

	@Override
	public void deleteContact(Contact contact) {
		dao.deleteContact(contact);
	}

}
