package it.dstech.dao;

import java.util.ArrayList;

import it.dstech.model.Contact;
import it.dstech.model.User;

public interface ContactDao {

	void saveContact(Contact contact);

	Contact getContactById(int id);

	ArrayList<Contact> getListContactsByUser(User user);

	void updateContact(Contact contact);

	void deleteContact(Contact contact);
}
