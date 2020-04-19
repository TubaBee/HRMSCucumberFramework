package com.hrms.practice;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.Test;

public class Recap {
	
	// jdbc: type of driver: host : port/name of the database
		String dbURL="jdbc:mysql://54.167.125.15:3306/syntaxhrm_mysql";
		String dbUsername="syntax_hrm";
		String dbPassword="syntaxhrm123";
		
		@Test
		public void gettingConnected() throws SQLException {
			Connection con=DriverManager.getConnection(dbURL, dbUsername, dbPassword);
			
			 DatabaseMetaData dbMetaData= con.getMetaData();
			 String dbName=dbMetaData.getDatabaseProductName();
			 System.out.println(dbName);
			
			Statement st=con.createStatement();
			ResultSet rset=st.executeQuery("select * from ohrm_skill");
			
		ResultSetMetaData rsetMetaDat= rset.getMetaData();
			int cols=rsetMetaDat.getColumnCount();
			System.out.println(cols);
			String colName;
			
			for (int i = 0; i < cols; i++) {
			 colName=rsetMetaDat.getColumnName(i);
				System.out.println("Column name = "+colName);
				
			}
			
			String id;
			String skill;
			
			while(rset.next()) {
				id=rset.getObject("id").toString();
				skill=rset.getObject("name").toString();
				System.out.println(id+" == "+skill);
			}
			
			rset.close();
			st.close();
			con.close();
			
			
		}
}
