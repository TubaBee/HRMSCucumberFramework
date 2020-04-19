package com.hrms.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class StoringDtaFromDB {
	String dbUsername = "syntax_hrm";
	String dbPassword = "syntaxhrm123";

	// jdbc: type of driver: host : port/name of the database
	String dbURL = "jdbc:mysql://54.167.125.15:3306/syntaxhrm_mysql";

	@Test
	public void getDataFromDatabase() throws SQLException {
		Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
		System.out.println("Connection is created");
		Statement st = connection.createStatement();

		// ResultSet rset=st.executeQuery("select id, name, country_code from
		// ohrm_location");
		ResultSet rset = st.executeQuery("select * from ohrm_location");

		List<Map<String, String>> listData = new ArrayList<>();

		while (rset.next()) {

			Map<String, String> map = new LinkedHashMap<>();
			map.put("id", rset.getObject("id").toString());
			map.put("name", rset.getObject("name").toString());
			map.put("country_code", rset.getObject("country_code").toString());

			listData.add(map);
		}
		System.out.println(listData);
	}

	@Test
	public void getAnsStroreDataEnhanced() throws SQLException {

		Connection connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
		Statement st = connection.createStatement();
		ResultSet rset = st.executeQuery("select * from ohrm_location");

		ResultSetMetaData rsetMetaData =(ResultSetMetaData) rset.getMetaData();
		List<Map<String, String>> listData = new ArrayList<>();
		Map<String, String> rowMap;

		while (rset.next()) {
			rowMap = new LinkedHashMap<>();
			for (int i = 1; i <= rsetMetaData.getColumnCount(); i++) {
				rowMap.put(rsetMetaData.getColumnName(i), rset.getObject(i).toString());
			
			}listData.add(rowMap);
		}System.out.println(listData);	

//		while(rset.next()) {
//            Map<String, String> map = new LinkedHashMap<>();
//            
//            for(int i=1; i<=colNumber; i++) {
//                String key=rsetData.getColumnName(i);
//                String value = rset.getObject(i).toString();
//                    map.put(key, value);
//            }
//            listData.add(map);
//        }
//        for(Map<String, String> map:listData) {
//            System.out.println(map);
//        }

	}

}
