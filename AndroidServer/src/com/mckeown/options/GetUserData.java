package com.mckeown.options;

import java.sql.ResultSet;

import com.mckeown.jaxb.EditAcct;
import com.mckeown.jaxb.ObjectFactory;
import com.mckeown.utils.DBConnection;
import com.mckeown.utils.User;

public class GetUserData {

	public EditAcct getData(int userID) throws Exception {
		DBConnection db = new DBConnection();
		String phoneNbr = "0";
		String email = "-";
		int age = 0;
		String firstName = "0";
		String lastName = "0";
		ResultSet result;
		try {
			result = db.getUserData(userID);

			String ID = "0";
			while (result.next()) {
				userID = Integer.parseInt(result.getString("UserID"));
				phoneNbr = result.getString("phoneNbr");
				email = result.getString("email");
				age = Integer.parseInt(result.getString("age"));
				firstName = result.getString("firstName");
				lastName = result.getString("LastName");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		ObjectFactory o = new ObjectFactory();
		EditAcct e = o.createEditAcct();
		e.setAge(age);
		e.setEmail(email);
		e.setFirstName(firstName);
		e.setLastName(lastName);
		e.setPhoneNbr(phoneNbr);
		e.setUserID(userID);
		return e;

	}

}
