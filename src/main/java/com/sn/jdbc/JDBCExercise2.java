// Delete a record from STUDENT table

package com.sn.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.Statement;
import java.util.Properties;

public class JDBCExercise2 {
	private static void deleteRecord(int sid){
		String sql = "delete from student where sid = "+ sid;
		System.out.println("sql:"+sql);
		try {
//			Step1: Obtain a connection
			Class c = Class.forName("oracle.jdbc.driver.OracleDriver");
			Driver d = (Driver)c.newInstance();
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			Properties p = new Properties();
			p.put("user", "sys as sysdba");
			p.put("password", "admin");
			Connection con = d.connect(url, p);
			
//			Step2: Get the jdbc statement
			Statement st = con.createStatement();
			
//			Step3: Execute the statement
			int result = st.executeUpdate(sql);
			System.out.println("Result= "+result);
			
//			Step4: Close the connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Exeception occured");
		}
	}
	public static void main(String[] args) {
		deleteRecord(104);
	}
}
