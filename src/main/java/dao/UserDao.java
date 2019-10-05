package dao;

import java.util.List;

import models.UserData;

public interface UserDao {
	
	void addUser(UserData user);
	
	void updateUser(UserData user);
	
	public void updateEmailUser(UserData user);

	void deleteUser(int userCode);

	List<UserData> getAllUsers();
	
	public UserData selectOne(int userCode);
	
	public UserData selectOne(String email);
	
	public String loginCheck(UserData userData);

}
