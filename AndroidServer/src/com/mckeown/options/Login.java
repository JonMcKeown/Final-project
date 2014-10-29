package com.mckeown.options;

import com.mckeown.utils.DBConnection;

public class Login {
	public String login(String userName, String password)
	{
		DBConnection db = new DBConnection();
		return db.login(userName, password);
	}
}
