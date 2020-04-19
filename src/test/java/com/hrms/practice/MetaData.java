package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class MetaData {

	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";

	// jdbc: type of driver: host : port/name of the database
	String dbURL = "jdbc:mysql://54.167.125.15:3306/syntaxhrm_mysql";

	@Test
	public void getMetaData() throws SQLException {

		Connection con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

		DatabaseMetaData dbData = con.getMetaData();
		String dbname = dbData.getDatabaseProductName();
		String dbversion = dbData.getDatabaseProductVersion();

		System.out.println(dbname);
		System.out.println(dbversion);
		
		Statement s=con.createStatement();
	ResultSet rs=s.executeQuery("select * from hs_hr_employees where emp_number=4353");
		rs.next();
		ResultSetMetaData resultData = rs.getMetaData();
		int colums=resultData.getColumnCount();
		System.out.println(colums);
		
		String columName=resultData.getColumnName(1);
		System.out.println(columName);
		
		for (int i = 1; i <= colums; i++) {
			String colName=resultData.getColumnName(i);
			System.out.println(colName);
		}
	}

}
