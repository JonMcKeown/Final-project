package com.mckeown.utils;

import java.sql.Connection;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.catalina.Context;

public class DBConnection {

	private static Connection connect = null;
	private static Statement statement = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;
    private static final String USER="mckeoj18";
    private static final String PWD="d425218"; 
    private static final String DB="mckeoj18";
    private static final String DRIVER=
        "jdbc:mysql://webdev.cs.uwosh.edu:4381/";
    private static final String DRIVER_CLASS="com.mysql.jdbc.Driver";
    private Connection conn;
    
    public DBConnection(){
    	
    	
    }
    
    
    public String addUser(String userName,String password, int age, String email, String phoneNbr, String firstName, String lastName)
    {

    	String userID = "0";
    	try
    	{

    		
    		Class.forName(DRIVER_CLASS);  // register the driver
      		String dbURL = DRIVER+DB;
      		System.out.println("Attempting connection");
      		conn = DriverManager.getConnection(dbURL,USER,PWD);
      		System.out.println("Connection successfully made");
	    	String query ="SELECT UserID FROM `Users` WHERE UserName= ? and Password = ?";
	        PreparedStatement pstmt=conn.prepareStatement(query);
	        pstmt.clearParameters(); 
	        pstmt.setString(1,userName);
			pstmt.setString(2,password);
			ResultSet result = pstmt.executeQuery();
			while(result.next())
			{
				userID=result.getString("UserID");
			}
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	
    	if(userID.equals("0"))
    	{
	    	try
	    	{
	    		Class.forName(DRIVER_CLASS);
	      		String dbURL = DRIVER+DB;
	      		//System.out.println("Attempting connection");
	      		//conn = DriverManager.getConnection(dbURL,USER,PWD);
	      		//System.out.println("Connection successfully made");
		    	String query ="INSERT INTO `Users`( `UserName`, `Password`) VALUES (?,?)";
		        PreparedStatement pstmt=conn.prepareStatement(query);
		        pstmt.clearParameters(); 
		        pstmt.setString(1,userName);
				pstmt.setString(2,password);
				pstmt.execute();
				
				query ="SELECT UserID FROM `Users` WHERE UserName= ? and Password = ?";
		        pstmt=conn.prepareStatement(query);
		        pstmt.clearParameters(); 
		        pstmt.setString(1,userName);
				pstmt.setString(2,password);
				ResultSet result = pstmt.executeQuery();
				userID = "0";
				while(result.next())
				{
					userID=result.getString("UserID");
				}
				
				query ="INSERT INTO `UserInfo`(`userID`, `age`, `email`, `phoneNbr`, `firstName`, `LastName`) VALUES (?,?,?,?,?,?)";
		        pstmt=conn.prepareStatement(query);
		        pstmt.clearParameters(); 
		        pstmt.setString(1,userID);
				pstmt.setString(2,age+"");
				pstmt.setString(3,email);
				pstmt.setString(4,phoneNbr);
				pstmt.setString(5,firstName);
				pstmt.setString(6,lastName);
				pstmt.execute();
				
				conn.close();
	    	}catch(Exception e)
	    	{
	    		e.printStackTrace();
	    		return "0";
	    	}
	    	return userID;
    	}
    	else
    		return "0";
    }
    public String login(String userName, String password)
    {
    	String userID = "0";
    	try
    	{
    		Class.forName(DRIVER_CLASS);  // register the driver
      		String dbURL = DRIVER+DB;
      		System.out.println("Attempting connection");
      		conn = DriverManager.getConnection(dbURL,USER,PWD);
      		System.out.println("Connection successfully made");
	    	String query ="SELECT UserID FROM `Users` WHERE UserName= ? and Password = ?";
	        PreparedStatement pstmt=conn.prepareStatement(query);
	        pstmt.clearParameters(); 
	        pstmt.setString(1,userName);
			pstmt.setString(2,password);
			ResultSet result = pstmt.executeQuery();
			while(result.next())
			{
				userID=result.getString("UserID");
			}
			conn.close();
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return userID;
    }
    
    public ResultSet getUserData(int userID)
    {
    	ResultSet result = null;
    	try
    	{
    		Class.forName(DRIVER_CLASS);  // register the driver
      		String dbURL = DRIVER+DB;
      		System.out.println("Attempting connection");
      		conn = DriverManager.getConnection(dbURL,USER,PWD);
      		System.out.println("Connection successfully made");
	    	String query ="SELECT * FROM `UserInfo` WHERE userID = ?";
	        PreparedStatement pstmt=conn.prepareStatement(query);
	        pstmt.clearParameters(); 
	        pstmt.setString(1,userID+"");
			result = pstmt.executeQuery();
	    	
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return result;
    }
    
    public boolean updateUser(int userID,int age, String email, String phoneNbr, String firstName, String lastName)
    {//UPDATE `UserInfo` SET `age`=23,`email`='jon@gmail.com',`phoneNbr`='2628257935',`firstName`='Jon',`LastName`='McKeown' WHERE userID='9'
    	try{
    		Class.forName(DRIVER_CLASS);
      		String dbURL = DRIVER+DB;
      		System.out.println("Attempting connection");
      		conn = DriverManager.getConnection(dbURL,USER,PWD);
      		System.out.println("Connection successfully made");
	    	String query ="UPDATE `UserInfo` SET `age`=?,`email`=?,`phoneNbr`=?,`firstName`=?,`LastName`=? WHERE userID=?";
	        PreparedStatement pstmt=conn.prepareStatement(query);
	        pstmt.clearParameters(); 
	        pstmt.setString(1,age+"");
			pstmt.setString(2,email);
			pstmt.setString(3,phoneNbr);
			pstmt.setString(4,firstName);
			pstmt.setString(5,lastName);
			pstmt.setString(6,userID+"");
			pstmt.execute();
    		return true;
    		
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    		return false;
    	}
    }
}
