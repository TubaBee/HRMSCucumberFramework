package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Deneme {
	
	String dbUsername="syntax_hrm";
	String dbPassword="syntaxhrm123";
	//jdbc: type of driver: host : port/name of the database
	String dbURL="jdbc:mysql://54.167.125.15:3306/syntaxhrm_mysql";
	
	String dbSQL="select * from hs_hr_employees order by emp_firstname";
	
	@Test
	public void getData() throws SQLException {
		Connection con=DriverManager.getConnection(dbURL, dbUsername, dbPassword);
		System.out.println("Connection is successfully");
		
		Statement st=con.createStatement();
		
		ResultSet rs=st.executeQuery(dbSQL);
		
		while(rs.next()) {
		System.out.println(rs.getString("emp_firstname")+" -- "+rs.getString("emp_lastname"));
		
		}	
		System.out.println("--------------------------------------------");
	
	}
	

}
