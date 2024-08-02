// Insert record into STUDENT table

package com.sn.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.Statement;
import java.util.Properties;

public class JDBCExercise1 {
	public static void main(String[] args) {
//		String sql = "insert into Student values(100,'Sangita','Behera','MCom','Comm.','F','Bhadrak')";
//		String sql = "insert into Student values(101,'Sagarika','Nayak','MCA','MCA','F','Bhadrak')";
//		String sql = "insert into Student values(102,'Archana','Swain','MBA','MBA','F','Jajpur')";
//		String sql = "insert into Student values(103,'Priyanka','Behera','MSc','MSc','F','Bhadrak')";
		String sql = "insert into Student values(104,'Pinali','Rath','MCA','MCA','F','Kendrapada')";
		Connection con = null;
		try {
//			Step1: Obtain the connection
			Class c = Class.forName("oracle.jdbc.driver.OracleDriver");
			Driver d = (Driver)c.newInstance();
			String url = "jdbc:oracle:thin:@localhost:1521:XE";
			Properties p = new Properties();
			p.put("user", "sys as sysdba");
			p.put("password", "admin");
			con = d.connect(url,p);
			
//			Step2: Get JDBC statement
			Statement  st = con.createStatement();
			
//			Step3: Execute the statement
			st.executeUpdate(sql);
			
//			Step4: Close the connection
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Execption Occured");
		}
	}
}
