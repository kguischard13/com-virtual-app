package com.vcclass.app.Data;



import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.codehaus.jackson.annotate.JsonProperty;



@Service
@Scope(WebApplicationContext.SCOPE_REQUEST)
public class Student {
	
	@JsonProperty(value="StudId")
	private int StudId;

	@JsonProperty(value="FirstName")
	private String FirstName;
	
	@JsonProperty(value="LastName")
	private String LastName;
	
	@JsonProperty(value="PhoneNumber")
	private String PhoneNumber;
	
	@JsonProperty(value="Email")
	private String Email;
	
	@JsonProperty(value="Password")
	private String Password;
	
	@JsonProperty(value="SchoolName")
	private String SchoolName;
	
	
	public Student(){
		this.StudId = -1;
		this.FirstName = null;
		this.LastName = null;
		this.PhoneNumber = null;
		this.Email = null;
		this.Password = null;
		this.SchoolName = "Iona College";
	}
	
	public Student(int id,String fName, String lName,String pnum,String login, String pword){
		this.StudId = id;
		this.FirstName = fName;
		this.LastName = lName;
		this.PhoneNumber = pnum;
		this.Email = login;
		this.Password = pword;
		this.SchoolName = "Iona College";
	}

	public int GetUserId(){
		return this.StudId;
	}
	
	public void SetUserId(int id){
		this.StudId = id;
	}
	
	public String GetAccountType(){
		return this.PhoneNumber;
	}
	
	public void SetAccountType(String pnum){
		this.PhoneNumber = pnum;
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
