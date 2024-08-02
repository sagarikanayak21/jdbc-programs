// Delete a record from STUDENT table using DriverManager

package com.sn.driverManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DriverManagerExercise2 {
	public static void main(String[] args) {
		DriverManagerExercise2 obj = new DriverManagerExercise2();
		obj.deleteRecord(104);
	}
	private void deleteRecord(int sid) {
		String sql = "delete from student where sid = " + sid;
		System.out.println("SQL statement: "+sql);
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
			System.out.println("Exception Occured");
		}
	}
}
