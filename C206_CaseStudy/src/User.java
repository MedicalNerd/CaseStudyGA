

/*

* I declare that this code was written by me. 

* I do not copy or allow others to copy my code. 

* I understand that copying code is considered as plagiarism.

* 

* Student Name: naoto

* Student ID: {type your id here}

* Class: {type your class here}

* Date/Time created: Wednesday 09-08-2023 21:48

*/

 

/**

* @author naoto

*

*/

 

public class User {

 

	private String username;

	private String password;

	private String email;
	
	private String contact;
	
	private String address;

	public User(String username,String password,String email,String contact,String address){

		this.username = username;

		this.password = password;

		this.email = email;
		
		this.contact = contact;
		
		this.address = address;

	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String toString() {


		// Write your codes here

		String UserInfo = String.format("%-10s %-30s %-10s %-10s", username,

				password, 

				email);


		return UserInfo;

	}

	public String getUsername() {

		return username;

	}

	public void setUsername(String username) {

		this.username = username;

	}

	public String getPassword() {

		return password;

	}

	public void setPassword(String password) {

		this.password = password;

	}

	public String getEmail() {

		return email;

	}

	public void setEmail(String email) {

		this.email = email;

	}

 

 

}
