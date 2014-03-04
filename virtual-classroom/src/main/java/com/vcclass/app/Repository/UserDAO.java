package com.vcclass.app.Repository;

import javax.sql.DataSource;
import com.vcclass.app.Data.*;

public interface UserDAO {
	
	public User GetUserId (int id);
	public boolean AddUser (User user); // only if we arent having automated ids
	public boolean DeleteUser (int id);
	public boolean UpdateUser(int id);
	public boolean ValidateUser(int id);

}
