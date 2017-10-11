package it.dstech.service;

import java.util.ArrayList;

import it.dstech.model.Contact;
import it.dstech.model.User;

public interface ContactService {

	void saveContact(Contact contact);

	Contact getContactById(int id);

	ArrayList<Contact> getListContactsByUser(User user);

	void updateContact(Contact contact);

	void deleteContact(Contact contact);

}
