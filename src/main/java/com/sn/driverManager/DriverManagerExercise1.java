// Insert a record into STUDENT table using DriverManager 

package com.sn.driverManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DriverManagerExercise1 {
	public static void main(String[] args) {
		DriverManagerExercise1 obj = new DriverManagerExercise1();
		obj.insertRecord();
	}
	public void insertRecord() {
		String sql = "insert into Student values(104,'Geetika','Mohanta','MCA','MCA','F','Baripada')";
		try {
//			Step1: Obtain the connecton
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
