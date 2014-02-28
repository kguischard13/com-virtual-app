package com.vcclass.app.Services;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;


//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
//import org.springframework.jdbc.datasource.SimpleDriverDataSource;
//import org.springframework.jdbc.datasource.DriverManagerDataSource;
//import org.springframework.beans.factory.annotation.Autowired;
//test

import com.vcclass.app.Data.Student;

public class UserService {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	
	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public Student GetStudent(Integer id){
		
		String sql = "select * from Student where StudID = ?";
		Student stud = jdbcTemplateObject.queryForObject(sql, new Object[]{id}, new RowMapper<Student>(){
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException{
				return new Student (rs.getInt("StudID"), rs.getString("FirstName"),
						rs.getString("LastName"),rs.getString("PhoneNumber"), rs.getString("Email"), rs.getString("Password"));
			}
		});
		return stud;

	}
	
	
	

}
