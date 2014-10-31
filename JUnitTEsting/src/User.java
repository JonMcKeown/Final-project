
public class User {
	private int userID;
	private int age;
	private String email;
	private String phoneNbr;
	private String fristName;
	private String lastName;

	public User(int userID, int age, String email, String phoneNbr,
			String firstName, String lastName) {
		this.userID = userID;
		this.age = age;
		this.email = email;
		this.phoneNbr = phoneNbr;
		this.fristName = firstName;
		this.lastName = lastName;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public String getFristName() {
		return fristName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhoneNbr() {
		return phoneNbr;
	}

	public int getUserID() {
		return userID;
	}
}
