package it.dstech.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue
	private int id;

	private String username;

	private String password;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Contact> listContacts;

	public User() {
		listContacts = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Contact> getListContacts() {
		return listContacts;
	}

	public void setListContacts(ArrayList<Contact> listContacts) {
		this.listContacts = listContacts;
	}

}
