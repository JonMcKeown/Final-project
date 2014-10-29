package com.mckeown.options;

import com.mckeown.jaxb.EditAcct;
import com.mckeown.utils.DBConnection;

public class UpdateUser {
	
	public boolean update(EditAcct acct)
	{
		DBConnection db = new DBConnection();
		return db.updateUser(acct.getUserID(), acct.getAge(), acct.getEmail(), acct.getPhoneNbr(), acct.getFirstName(), acct.getLastName());
		
	}

}
