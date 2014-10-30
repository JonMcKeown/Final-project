package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Mysql {
	
    
	public static void main(String[]args) throws Exception
	{
		DBConnection db = new DBConnection();
		db.addUser("Joe", "password", 23, "email","1234568", "Joe", "McKeown");
		
	}
	        


}
