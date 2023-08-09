
public class Account {

	private String username;
	
	private String password;
	
	private String email;
	
	private String address;
	
	public Account(String username, String password, String email, String address) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.address = address;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getAddress() {
		return address;
	}
	
	@Override
	public String toString() {
		String output = super.toString();
		output = String.format("Username: " + getUsername() + "\n Password: " + getPassword() + "\n Email: " + getEmail() + "\n Address: " + getAddress());
		
		return output;
	}
}