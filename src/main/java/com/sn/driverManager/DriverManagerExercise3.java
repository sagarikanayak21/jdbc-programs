// Update course and department in STUDENT table using DriverManager 

package com.sn.driverManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DriverManagerExercise3 {
	public static void main(String[] args) {
		updateRecord(100, "MCom", "Comm.");
		
	}
	private static void updateRecord(int sid, String course, String dept) {
		String sql = " update student set course = '"+course+"' , department= '"+dept+"' where sid = "+sid+" ";
		System.out.println("String sql:" +sql);
		try {
//			Step1: Obtain the connection
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","sys as sysdba","admin");
			
//			Step2: Get the JDBC statement
			Statement st = con.createStatement();
			
//			Step3: Execute the statement
			int result = st.executeUpdate(sql);
			System.out.println("Result: "+result);
			
//			Step4: Close the connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception occured");
		}
	}
}
