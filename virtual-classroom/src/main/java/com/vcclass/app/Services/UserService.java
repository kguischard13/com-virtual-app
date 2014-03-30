package com.vcclass.app.Services;

import java.sql.*;
import java.util.*;

import com.vcclass.app.Repository.*;
import com.vcclass.app.Data.*;

import javax.sql.DataSource;





//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.datasource.SimpleDriverDataSource;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//test


public class UserService implements UserDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public User GetUser(int id){
		User user = null;
		
		if(this.ValidateUser(id)){
			String sql = "select * from User where Id = ?";
			user = jdbcTemplateObject.queryForObject(sql, new Object[]{id}, new RowMapper<User>(){
				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException{
					return new User (rs.getInt("Id"),rs.getString("AccountType") ,rs.getString("FirstName"),
							rs.getString("LastName"),rs.getString("PhoneNumber"), rs.getString("Email"), rs.getString("Password"));
				}
			});
		}
		
		
		return user;
		

	}
	
	public int AddUser (User user){
		String sql = "insert into User (AccountType, FirstName, LastName, PhoneNumber, Email, Password) values (?, ?, ?,"
				+ "?,?,?)";
		//String sql2 = "select LAST_INSERT_ID()";
		String sql2 = "select max(Id) from `User`";
		jdbcTemplateObject.update(sql, user.GetAccountType(),user.GetFirstName(), user.GetLastName(), user.GetPhoneNumber(),user.GetEmail(),
				user.GetPassword());
		
		
		return jdbcTemplateObject.queryForInt(sql2);
	}
	
	public boolean DeleteUser (int id){
		if(this.ValidateUser(id)){
			String sql = "delete from User where Id = ?";
			jdbcTemplateObject.update(sql,id);
			return true;
		}
		return false;
	}
	
	public boolean UpdateUser(User user){
		
		if(this.ValidateUser(user.GetId())){
			String sql = "update User set AccountType = ?, FirstName = ?, LastName = ?,  PhoneNumber = ?, Email = ?, Password = ? "
					+ "where Id = ?";
			jdbcTemplateObject.update(sql, user.GetAccountType(),user.GetFirstName(), user.GetLastName(), user.GetPhoneNumber(),user.GetEmail(),
					user.GetPassword(), user.GetId());
			return true;
		}
		return false;
		
	}
	
	public boolean ValidateUser(int id){
		String sql = "select count(*) from User where Id = ?";
		if(jdbcTemplateObject.queryForInt(sql, id) == 0){
			return false;
		}
		return true;
	}
	
	public boolean ValidateUser(String email, String password){
		String sql = "select count(*) from User where Email = ? AND Password = ?";
		if(jdbcTemplateObject.queryForInt(sql, email, password) == 0){
			return false;
		}
		return true;
	}
	
	public List<User> GetAllUsers(){
		String sql = "select * from User";
		List<User> users = jdbcTemplateObject.query(sql, new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException{
				return new User (rs.getInt("Id"),rs.getString("AccountType"),rs.getString("FirstName"),
						rs.getString("LastName"),rs.getString("PhoneNumber"), rs.getString("Email"), rs.getString("Password"));
			}
		});

		return users;

	}

	public List<User> GetTeachers(){
		String sql = "select * from User where AccountType LIKE 'Teacher'";
		List<User> users = jdbcTemplateObject.query(sql, new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException{
				return new User (rs.getInt("Id"),rs.getString("AccountType"),rs.getString("FirstName"),
						rs.getString("LastName"),rs.getString("PhoneNumber"), rs.getString("Email"), rs.getString("Password"));
			}
		});

		return users;
	}
	
	public List<User> GetStudents(){
		String sql = "select * from User where AccountType LIKE 'Student'";
		List<User> users = jdbcTemplateObject.query(sql, new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException{
				return new User (rs.getInt("Id"),rs.getString("AccountType"),rs.getString("FirstName"),
						rs.getString("LastName"),rs.getString("PhoneNumber"), rs.getString("Email"), rs.getString("Password"));
			}
		});

		return users;
		
	}

	public User LoginUser(String email, String password)
	{
		boolean isFound = this.ValidateUser(email, password); 
		
		if(isFound)
		{
			String sql = "select * from User where Email = ? AND Password = ?";
			User user = jdbcTemplateObject.queryForObject(sql, new Object[]{email, password}, new RowMapper<User>(){
				
				@Override
				public User mapRow(ResultSet rs, int rowNum) throws SQLException{
					return new User (rs.getInt("Id"),rs.getString("AccountType") ,rs.getString("FirstName"),
							rs.getString("LastName"),rs.getString("PhoneNumber"), rs.getString("Email"), rs.getString("Password"));
				}
			});
			
			return user;
		}
		else
		{
			return null; 
		}
	}
}
