package com.vcclass.app.Repository;

import javax.sql.DataSource;
import com.vcclass.app.Data.*;

public interface UserDAO {
	
	public User GetUserId (int id);
	public void AddNewUser (User user); // only if we arent having automated ids
	public void DeleteUser (int id);
	public void UpdateUser(int id);
	public boolean ValidateUser(int id);

}
