package com.vcclass.app.Data;



import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.codehaus.jackson.annotate.JsonProperty;



@Service
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class User {
	
	@JsonProperty(value="Id")
	private int UserId;
	
	@JsonProperty(value="AccountType")
	private String AccountType;
	
	@JsonProperty(value="FirstName")
	private String FirstName;
	
	@JsonProperty(value="LastName")
	private String LastName;
	
	@JsonProperty(value="Email")
	private String Email;
	
	@JsonProperty(value="Password")
	private String Password;
	
	@JsonProperty(value="SchoolName")
	private String SchoolName;
	
	
	public User(){
		this.UserId = -1;
		this.AccountType = null;
		this.FirstName = null;
		this.LastName = null;
		this.Email = null;
		this.Password = null;
		this.SchoolName = "Iona College";
	}
	
	public User(int id, String type,String fName, String lName, String login, String pword){
		this.UserId = id;
		this.AccountType = type;
		this.FirstName = fName;
		this.LastName = lName;
		this.Email = login;
		this.Password = pword;
		this.SchoolName = "Iona College";
	}

	public int GetUserId(){
		return this.UserId;
	}
	
	public void SetUserId(int id){
		this.UserId = id;
	}
	
	public String GetAccountType(){
		return this.AccountType;
	}
	
	public void SetAccountType(String type){
		this.AccountType = type;
	}
	
	public String GetFirstName(){
		return this.FirstName;
	}
	
	public void SetFirstName(String fname){
		this.FirstName = fname;
	}
	
	public String GetLastName(){
		return this.LastName;
	}
	
	public void SetLastName(String lname){
		this.LastName = lname;
	}
	
	public String GetEmail(){
		return this.Email;
	}
	
	public void SetEmail(String mail){
		this.Email = mail;
	}
	
	public String GetPassword(){
		return this.Password;
	}
	
	public void SetPassword(String pword){
		this.Password = pword;
	}
	
	public String GetSchoolName(){
		return this.SchoolName;
	}
	
	public void SetSchoolName(String name){
		this.SchoolName = name;
	}
}
