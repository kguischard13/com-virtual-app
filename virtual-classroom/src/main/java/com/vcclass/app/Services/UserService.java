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
	
	public Student GetUser(int id){
		Student stud = null;
		
		if(this.ValidateUser(id)){
			String sql = "select * from Student where StudID = ?";
			stud = jdbcTemplateObject.queryForObject(sql, new Object[]{id}, new RowMapper<Student>(){
				@Override
				public Student mapRow(ResultSet rs, int rowNum) throws SQLException{
					return new Student (rs.getInt("StudID"), rs.getString("FirstName"),
							rs.getString("LastName"),rs.getString("PhoneNumber"), rs.getString("Email"), rs.getString("Password"));
				}
			});
		}
		
		
		return stud;
		

	}
	
	public int AddUser (Student stud){
		String sql = "insert into Student (FirstName, LastName, PhoneNumber, Email, Password) values (?, ?,"
				+ "?,?,?)";
		//String sql2 = "select LAST_INSERT_ID()";
		String sql2 = "select max(StudID) from `Student`";
		jdbcTemplateObject.update(sql, stud.GetFirstName(), stud.GetLastName(), stud.GetPhoneNumber(),stud.GetEmail(),
				stud.GetPassword());
		
		
		return jdbcTemplateObject.queryForInt(sql2);
	}
	
	
	public boolean DeleteUser (int id){
		if(this.ValidateUser(id)){
			String sql = "delete from Student where StudID = ?";
			jdbcTemplateObject.update(sql,id);
			return true;
		}
		return false;
	}
	public boolean UpdateUser(Student stud){
		
		if(this.ValidateUser(stud.GetUserId())){
			String sql = "update Student set FirstName = ?, LastName = ?,  PhoneNumber = ?, Email = ?, Password = ? "
					+ "where StudID = ?";
			jdbcTemplateObject.update(sql, stud.GetFirstName(), stud.GetLastName(), stud.GetPhoneNumber(),stud.GetEmail(),
					stud.GetPassword(), stud.GetUserId());
			return true;
		}
		return false;
		
	}
	public boolean ValidateUser(int id){
		String sql = "select count(*) from Student where StudID = ?";
		if(jdbcTemplateObject.queryForInt(sql, id) == 0){
			return false;
		}
		return true;
	}


	public List<Student> GetAllUsers() {
		String sql = "select * from Student";
		List<Student> students = jdbcTemplateObject.query(sql, new RowMapper<Student>(){
			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException{
				return new Student (rs.getInt("StudID"), rs.getString("FirstName"),
						rs.getString("LastName"),rs.getString("PhoneNumber"), rs.getString("Email"), rs.getString("Password"));
			}
		});
		return students;
	}
	

}
