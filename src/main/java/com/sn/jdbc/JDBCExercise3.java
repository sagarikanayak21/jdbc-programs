// Update the first name and last name of a student record from STUDENT table 

package com.sn.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.Statement;
import java.util.Properties;

public class JDBCExercise3 {
	public static void main(String[] args) {
		JDBCExercise3 obj = new JDBCExercise3();
		obj.updateRecord(100, "Suman", "Patra");
		
	}
	private void updateRecord(int sid, String fName, String lName) {
		String sql = "update Student set first_name = '"+fName+"', last_name = '"+lName+"' where sid = "+sid+" ";
		System.out.println("String sql: "+sql);
		try {
//			Step1: Obtain the connection
			Class c = Class.forName("oracle.jdbc.driver.OracleDriver");
			Driver d = (Driver)c.newInstance();
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			Properties p = new Properties();
			p.put("user", "sys as sysdba");
			p.put("password", "admin");
			Connection con = d.connect(url, p);
			
//			Step2: Get the JDBC statement
			Statement st = con.createStatement();
			
//			Step3: Execute the statement
			int result = st.executeUpdate(sql);
			System.out.println("Result: "+result);
			
//			Step4: Close the connecion
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exception Occured");
		}
	}
}
