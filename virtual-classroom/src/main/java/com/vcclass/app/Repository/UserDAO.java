package com.vcclass.app.Repository;

import java.util.List;

import javax.sql.DataSource;

import com.vcclass.app.Data.*;

public interface UserDAO {
	
	public void setDataSource(DataSource dataSource);
	public Student GetUser (int id);
	public List<Student> GetAllUsers();
	public int AddUser (Student stud); // only if we arent having automated ids
	public boolean DeleteUser (int id);
	public boolean UpdateUser(Student stud);
	public boolean ValidateUser(int id);

}
