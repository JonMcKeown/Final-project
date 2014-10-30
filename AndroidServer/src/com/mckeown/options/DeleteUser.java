package com.mckeown.options;

import com.mckeown.utils.DBConnection;

public class DeleteUser {

		public Boolean deleteUser(int userID)
		{
			DBConnection db = new DBConnection();
			return db.deleteUser(userID);
		}
}
