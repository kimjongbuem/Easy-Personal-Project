package mssqlProject;

import java.sql.*;
import java.sql.SQLException;
import java.util.Scanner;
public class MsSqlDAO {
	public static Scanner scanner = new Scanner(System.in);
	 Connection conn;
	 Statement stmt;
	 PreparedStatement pStmt;
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
	public void addNewDepartment(String dept_name , String building , double burget) {
		String q3SQL = "insert into department values(?,?,?)";
		try {
			conn.setAutoCommit(false); // 오토커밋 false
			pStmt = conn.prepareStatement(q3SQL);
			pStmt.setString(1, dept_name);
			pStmt.setString(2, building);
			pStmt.setDouble(3, burget);
			pStmt.executeUpdate();
			
			System.out.println("등록하시겠습니까? (1 등록 , 2 취소) : ");
			int msg = scanner.nextInt();
			scanner.nextLine();
			if(msg == 1)
			{
				conn.commit();
				System.out.println("등록되었습니다!");
				
			}else if(msg == 2) {
				conn.rollback();
				System.out.println("롤백(취소) 되었습니다!");
			}
			}
	        catch (SQLException sqle) {
	        	if(conn!=null) try{conn.rollback();  System.out.println("등록되지 않았습니다 롤백합니다2!!");}
	        	catch(SQLException e){}  
	        }	
		try {
			conn.setAutoCommit(true);
		} catch (SQLException e) {System.out.println("오토 커밋화 실패 ㅠㅠ");}
	}
	public void printTotalCredit(String instructor_name, int year) {
		//String q4SQL = "select distinct* from dbo.inst_advise_takes_year(?,?)";
			//String q4SQL = "select distinct* from dbo.inst_advise_takes_year("+instructor_name
			//		+","+year+")";
		String q4SQL ="select distinct* from dbo.inst_advise_takes_year('"+instructor_name+"' ,"+year+")";
		try {
			int cnt = 1;
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(q4SQL);
			System.out.printf("%3s %10s %10s %10s\n", "번호" ,"ID","name","tot_cred");
			while( rs.next() ) {
					int id = rs.getInt("ID");
					String name = rs.getString("name");
	               int totcred = rs.getInt("tot_cred");
	               System.out.printf("%3d번: %7d %10s %8d\n", cnt, id, name, totcred);
	               cnt++;
	              }
			
			}
			catch (SQLException sqle) {
		        System.out.println("SQLException : " + sqle);
	        }	 
	}
}

