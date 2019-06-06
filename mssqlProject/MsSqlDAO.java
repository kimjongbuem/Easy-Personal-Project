package mssqlProject;

import java.sql.*;
import java.sql.SQLException;
public class MsSqlDAO {
	 Connection conn;
	 Statement stmt;
	public MsSqlDAO() {
		try {
	        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	        String connectionUrl = "jdbc:sqlserver://localhost:3779;database=largeDB;integratedSecurity=true";
	        conn = DriverManager.getConnection(connectionUrl);
	        stmt = conn.createStatement(); 
	        System.out.println("MS-SQL 서버 접속에 성공하였습니다.");
	    } catch (SQLException sqle) {
	        System.out.println("SQLException : " + sqle);
	    } catch(ClassNotFoundException e) {
	    	 System.out.println("SQLException : " + e);
	    }
	}
	public void getSumSalaryofInstructor() {
		try {
		String q1SQL = "SELECT dept_name, (case when dept_name is null then 0.00"
				+ " else SUM(salary) end) as sum_salary"
				+ " from instructor group by dept_name";
		ResultSet rs = stmt.executeQuery(q1SQL);
		System.out.println("dept_name\tsum_salary");
        while( rs.next() ) {
               String field1 = rs.getString("dept_name");
               String field2 = rs.getString("sum_salary");
               System.out.print(field1 + "\t");
               System.out.println(field2);
              }
		}
        catch (SQLException sqle) {
	        System.out.println("SQLException : " + sqle);
	    } 
	}
	public void show_Noprerquisite_course() {
		String q2SQL_1 = "select* from No_prerequisite_Course";
		try {
			ResultSet rs = stmt.executeQuery(q2SQL_1);
			 System.out.printf("%s %20s %30s %30s\n", "course_id" ,"title" ,"dept_name" ,"credits");
			 while( rs.next() ) {
	               String course_id = rs.getString("course_id");
	               String title = rs.getString("title");
	               String dept_name = rs.getString("dept_name");
	               String credits = rs.getString("credits");
	              
	               System.out.printf("%s %40s %20s %20s\n", course_id, title, dept_name, credits);
	              }
			}
	        catch (SQLException sqle) {
		        System.out.println("SQLException : " + sqle);
	        }	 
	}
	public void addNewDepartment(String dept_name , String building , int burget) {
		
	}
}

