package com.vcclass.app.Services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.sql.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vcclass.app.Data.*;

public class ServiceTest {

	public static void main(String[] args) throws ParseException {
		/*Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:8889/mydb", "root", "root");
			
			
			stmt = conn.createStatement();
			ResultSet results = stmt.executeQuery("select * from Student");
			ResultSetMetaData rsmd = results.getMetaData();
			int num = rsmd.getColumnCount();
			
			for(int i =1; i<=num;i++){
				System.out.print(rsmd.getColumnLabel(i)+"\t\t");
			}
			
			System.out.println("\n-----------------------------");
			
			while(results.next()){
				int id = results.getInt(1);
				String fname = results.getString(2);
				String lname = results.getString(3);
				System.out.println("\n"+id +"\t\t"+fname+"\t\t"+lname);
			}
			
			
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		
		/*
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		UserService student = (UserService) context.getBean("userService");
		
		List<User> students = student.GetStudents();
		
		for(User user : students){
			System.out.println("ID: "+user.GetUserId() +"\t\t Name: "+user.GetFirstName()+" "+user.GetLastName());
		}
		
		CourseService courses = (CourseService) context.getBean("courseService");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date mD = dateFormat.parse("2014/02/16");
		
		
		Course course = courses.GetCourse(6);
		
		CourseSession sess = new CourseSession(course, mD, "Merge Sort");
		int a = courses.CreateCourseSession(sess);
		System.out.println("ID of a: "+a);
		
		sess = courses.GetCourseSession(a);
		System.out.println("ID: "+sess.GetId() + " Meeting Time: "+sess.getMeetingDate() +" Topic: "+sess.getClassTopic());
		
		sess.setClassTopic("Array Lists");
		if(courses.UpdateCourseSession(sess))
			System.out.println("ID: "+sess.GetId()+" Topic: "+sess.getClassTopic());
		
		sess = courses.GetCourseSession(sess.GetId());
		System.out.println("Id: "+sess.GetId()+" Meeting Date: "+sess.getMeetingDate()+" Topic "+sess.getClassTopic());
		
		if( courses.DeleteCourseSession(sess.GetId() )){
			System.out.println("ID of course "+sess.GetId() +" was deleted");
		}
		*/
		
		/*
		User stud = new User("Student","KayVee", "GEE", "732873738", "kvgEEEe@test.com",  "good_luck");
		int a = student.AddUser(stud);
		System.out.println("ID of new student: "+a+ " firstname: " +stud.GetFirstName()+ "\n");
		
		stud = student.GetUser(a);
		stud.SetFirstName("Kester");
		if(student.UpdateUser(stud))
			System.out.println("ID: "+a+" was updated");
		
		
		System.out.println("ID: "+stud.GetUserId()+"\n");
		System.out.println("Name: "+stud.GetFirstName()+" "+stud.GetLastName()+"\n");
		
		if(student.DeleteUser( stud.GetUserId() ) ){
			System.out.println("ID: " +stud.GetUserId()+ " was deleted\n" );
		}
		
		List<User> list1 = student.GetAllUsers();
		
		for(User user : list1){
			System.out.println("ID: "+user.GetUserId());
		}
		*/
		
		
		/*****BEGIN QUESTION AND COMMENT TESTING******/
		/*
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		
		QuestionService question = (QuestionService) context.getBean("questionService");
		CommentService comment = (CommentService) context.getBean("commentService");
		UserService user = (UserService) context.getBean("userService");		

		User newStudent = user.GetUser(1);
		User newTeacher = user.GetUser(2);
		Question newQuestion = question.GetQuestion(5, 1, 2);
		Comment newComment = comment.GetComment(1, 4, 1);
		
		System.out.println(" ");
		System.out.println("This student is in the database: " + newStudent.GetFirstName() + " " + newStudent.GetLastName());
		System.out.println("This teacher is in the database: " + newTeacher.GetFirstName() + " " + newTeacher.GetLastName());
		System.out.println("This question is in the database: " + newQuestion.GetContents());
		System.out.println("This comment is in the database: " + newComment.GetContents());
		System.out.println(" ");

		
		
		//DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//java.util.Date mD = dateFormat.parse("2014-03-22 17:20:00");
		java.util.Date mD = new Date();
		java.sql.Date sqlDate = new java.sql.Date(mD.getTime());
		
		System.out.println(mD);
		System.out.println(sqlDate);
		System.out.println(" ");
		*/
		
		
		/*/////ADD QUESTION TEST
		Question addedQuestion = new Question(2, 1, sqlDate, "Contents of updated ADD method.",
				4, true, false, 2, false);
		
		int added = question.CreateQuestion(2, addedQuestion);
		
		if(added != 0)
			System.out.println("Question just added with ID number " + added);
		*/
		
		/*//////UPDATE QUESTION TEST
		Question updatedQuestion = new Question(5, 2, 1, mD, "Is this a question I just updated?", 4, true, false, 2, false);
		
		boolean upQuest = question.UpdateQuestion(updatedQuestion);
		
		if (upQuest)
			System.out.println("Question was updated.");
		else
			System.out.println("Question was not updated.");
		*/
		
		/*//////DELETE QUESTION TEST
		boolean deleted = question.DeleteQuestion(1,7);
		
		if(deleted)
			System.out.println("Question was deleted.");
		else
			System.out.println("Question was not deleted.");
		*/
		
		/*//////ADD COMMENT TEST
		Comment addedComment = new Comment(8, 1, "Contents of updated ADD comment method.", sqlDate);
		
		int added3 = comment.CreateComment(2, addedComment);
		
		
		if(added3 != 0)
			System.out.println("Comment just added with ID number " + added3);
		*/
		
		/*//////UPDATE COMMENT TEST
		Comment updatedComment = new Comment(3, 4, 1, "Updated Comment", mD);
		
		System.out.println("This is an updating comment: " + updatedComment.GetCommentId());
		
		boolean upComm = comment.UpdateComment(updatedComment);
		
		if (upComm)
			System.out.println("Comment was updated.");
		else
			System.out.println("Comment was not updated.");
		*/
		
		/*//////DELETE COMMENT TEST
		boolean deleted1 = comment.DeleteComment(1,3);
		
		if(deleted1)
			System.out.println("Comment was deleted.");
		else
			System.out.println("Comment was not deleted.");
		*/
		
		/*******END QUESTION AND COMMENT TESTING**********/
		
		

	}

}
