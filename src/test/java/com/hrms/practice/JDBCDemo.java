package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class JDBCDemo {

	String dbUsername="syntax_hrm";
	String dbPassword="syntaxhrm123";
	
	// jdbc: type of driver: host : port/name of the database
	String dbURL="jdbc:mysql://54.167.125.15:3306/syntaxhrm_mysql";
	
	@Test
	public void getDataFromDatabase() throws SQLException {
		Connection connection=DriverManager.getConnection(dbURL, dbUsername,dbPassword);
		System.out.println("Connection is created");
	
	Statement st=connection.createStatement();
	
	ResultSet rSet=st.executeQuery("select * from ohrm_nationality");
	rSet.next();
	String firstRowData=rSet.getString("name");
	System.out.println(firstRowData);
	rSet.next();
	String secondRowData=rSet.getObject("name").toString();
	System.out.println(secondRowData);
	
	String data;
	while(rSet.next()){
	data=rSet.getObject("name").toString();	
	System.out.println(data);
	//System.out.println(data.length());
	}
	rSet.close();
	st.close();
	connection.close();
	}
	
	
}
