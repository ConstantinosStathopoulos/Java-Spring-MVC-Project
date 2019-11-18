package gr.hua.dit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
	
	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:postgresql://localhost:5432/huadb?useSSL=false";
		String user = "postgres";
		String pass = "admin";
		
		try {
            System.out.println("Connecting to postgres database: " + jdbcUrl);
            Connection con = DriverManager.getConnection(jdbcUrl, user, pass);
            System.out.println("Connection successfull.");
 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


