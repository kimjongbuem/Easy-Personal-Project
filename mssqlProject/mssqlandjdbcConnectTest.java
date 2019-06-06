package mssqlProject;

import java.sql.*;
import java.sql.SQLException;

public class mssqlandjdbcConnectTest {

	public static void main(String[] args) throws ClassNotFoundException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl = "jdbc:sqlserver://localhost:3779;database=largeDB;integratedSecurity=true";
            Connection conn = DriverManager.getConnection(connectionUrl);
            Statement stmt = conn.createStatement(); 
            System.out.println("MS-SQL 서버 접속에 성공하였습니다.");
            ResultSet rs = stmt.executeQuery("SELECT * FROM instructor");
            while( rs.next() ) {
                   String field1 = rs.getString("name");
                   String field2 = rs.getString("dept_name");
                   System.out.print(field1 + "\t");
                   System.out.println(field2);
                  }
            rs.close();
            stmt.close();    
            conn.close();
        } catch (SQLException sqle) {
            System.out.println("SQLException : " + sqle);
        }
    }

}
