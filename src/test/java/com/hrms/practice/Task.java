package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Task {
	
	//Create connection to db and retrieve all job titles and store them inside arraylist
	
//	String dbUsername="syntax_hrm";
//	String dbPassword="syntaxhrm123";
//	
//	// jdbc: type of driver: host : port/name of the database
//	String dbURL="jdbc:mysql://54.167.125.15:3306/syntaxhrm_mysql";
//	
//	
//	@Test
//	public void getDataFromDatabase() throws SQLException {
//		Connection con=DriverManager.getConnection(dbURL, dbUsername, dbPassword);
//		System.out.println(con);
//		
//		Statement st=con.createStatement();
//		ResultSet rS=st.executeQuery("select job_title from ohrm_job_title");
//		
//		List<String> list=new ArrayList<>();
//		String dataJobTitle;
//		while(rS.next()) {
//		dataJobTitle=rS.getObject("job_title").toString();
//		list.add(dataJobTitle);
//		}
//		System.out.print(list);
//		
//		rS.close();
//		st.close();
//		con.close();
//	}
	
	
	
	
	// retrieve all data, store in array list and retrieve from the ArrayList one by
    // one
//    String userName = "syntax_hrm";
//    String password = "syntaxhrm123";
//    String dbURLO = "jdbc:mysql://54.167.125.15:3306/syntaxhrm_mysql";
//    @Test
//    public void retrieveAllJobTitles() throws SQLException {
//        List<String> job_titles = new ArrayList<>();
//        // get collection method
//        Connection connection = DriverManager.getConnection(dbURLO, userName, password);
//        // create an object of the statement class
//        Statement st = connection.createStatement();
//        // execute the query
//        ResultSet rset = st.executeQuery("select * from ohrm_job_title");
//        while (rset.next()) {
//            job_titles.add(rset.getString("job_title"));
//        }
//        System.out.println(job_titles);
//    }
//    
    
    
String dbUsername="syntax_hrm";
    
    String dbPassword="syntaxhrm123";
    
    String dbUrl="jdbc:mysql://54.167.125.15:3306/syntaxhrm_mysql";
    
    @Test
    public void getDataFromDatabase() throws SQLException {
        Connection connection=DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        
        System.out.println("Connection was created");
        
        Statement st=connection.createStatement();
        
        ResultSet result=st.executeQuery("select * from ohrm_job_title");
        List<String>rsList=new ArrayList<>();
        while(result.next()) {
            rsList.add(result.getString("job_title"));
        }
        for(String job:rsList) {
            System.out.println(job);
            
        }
        st.close();
        result.close();
        connection.close();
        
    }


	
	
	
}
