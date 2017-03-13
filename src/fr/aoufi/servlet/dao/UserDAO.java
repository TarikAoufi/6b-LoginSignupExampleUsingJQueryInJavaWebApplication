package fr.aoufi.servlet.dao;

import fr.aoufi.servlet.model.User;

public interface UserDAO {

	public int createUser(User user);
	
	public User loginUser(User user);
	
}
