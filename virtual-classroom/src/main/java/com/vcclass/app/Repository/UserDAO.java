package com.vcclass.app.Repository;

import java.util.List;

import javax.sql.DataSource;

import com.vcclass.app.Data.*;

public interface UserDAO {
	
	public void setDataSource(DataSource dataSource);
	public User GetUser (int id);
	public List<User> GetAllUsers();
	public List<User> GetTeachers();
	public List<User> GetStudents();
	public int AddUser (User user);
	public boolean DeleteUser (int id);
	public boolean UpdateUser(User user);
	public boolean ValidateUser(int id);
	public User LoginUser(String email, String password); 

}
