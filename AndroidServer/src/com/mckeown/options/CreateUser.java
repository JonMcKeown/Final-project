package com.mckeown.options;

import java.sql.*;

import com.mckeown.utils.DBConnection;

public class CreateUser {
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public String createUser(String userName,String password, int age, String email, String phoneNbr, String firstName, String lastName) throws Exception
	{
		DBConnection db = new DBConnection();
		return db.addUser(userName, password, age, email, phoneNbr, firstName, lastName);
	}

}
