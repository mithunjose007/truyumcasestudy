package com.cognizant.truyum.dao;
import java.util.*;
import java.sql.*;
import java.io.*;
public class ConnectionHandler {
  public static Connection con;
  public static Properties properties=new Properties();
  
  public static Connection getConnection() throws SQLException,ClassNotFoundException{
	  try {
		  FileInputStream fis =new FileInputStream("C:\\Users\\MITHUN JOSE\\eclipse-workspace2\\truYum\\connection.properties");
	       properties.load(fis);
		  Class.forName(properties.getProperty("driver"));
		  con=DriverManager.getConnection(properties.getProperty("connection-url"),properties.getProperty("user"),
				  properties.getProperty("password"));
	  }catch (IOException e) {
		  e.printStackTrace();
	  }
	  return con;
  }
}
