package com.vcclass.app.Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
	//private SimpleDriverDataSource dataSource;
	
	
	private DataSource dataSource;
	
	private JdbcTemplate jdbc;
	private List<User> users;
	
	
	public UserService(){
		//dataSource = new SimpleDriverDataSource();
		//DriverManagerDataSource ds = new DriverManagerDataSource();
		//ds.setDriverClassName("com.mysql.jdbc.Driver");
		//ds.setUrl("jdbc:mysql://localhost:8889/mydb");
		//ds.setUsername("root");
		//ds.setPassword("root");
		jdbc = new JdbcTemplate(dataSource);
		//Class.forName("com.mysql.jdbc.Driver").newInstance();
		//dataSource.setDriverClass(com.mysql.jdbc.Driver);
		// access database.........
	}
	//edit for teachers/students
	public List<User> getUser(int userid){
		this.users = this.jdbc.query("select * from Student where userId = ?", new Object[]{userid},
		new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException{
				return new User (rs.getInt("StudID"),rs.getString("PhoneNumber"), rs.getString("FirstName"),
						rs.getString("LastName"), rs.getString("Email"), rs.getString("Password"));
			}
		}); 
		return users;
	}

}
