package com.spring.jdbcnew;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbcnew.Student;
import com.spring.jdbcnew.StudentDAO;
import com.spring.jdbcnew.StudentMapper;

public class StudentJDBCTemplate implements StudentDAO{

	 private DataSource dataSource;
	   private JdbcTemplate jdbcTemplateObject;
	   
	   public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }
	   public void create(String name, Integer age) {
	      String SQL = "insert into Student (name, age) values (?, ?)";
	      
	      jdbcTemplateObject.update( SQL, name, age);
	      System.out.println("Created Record Name = " + name + " Age = " + age);
	      return;
	   }
	   public List<Student> listStudents() {
	      String SQL = "select * from Student";
	      List <Student> students = jdbcTemplateObject.query(SQL,  new StudentMapper());
	      return students;

}
}