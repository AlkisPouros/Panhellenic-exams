
abstract class User {

	private String password;
	private int ID;
	private String email;
	private String userMode;
	
	public User(String password, int ID, String email) {
		this.password = password;
		this.ID = ID;
		this.email = email;
		signUp(password, ID, email);
	}
	
	
	private void signUp(String password, int ID, String email) {
		
	}
	
	void loginUser(String email, String password) {
		
	}

	public void setUserMode(String mode) {
		this.userMode = mode;
	}
	
	public String getUserMode() {
		return this.userMode;
	}
	
	public User getAccount(int ID) {
		return this;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public int getID() {
		return this.ID;
	}
	
	public String getEmail() {
		return this.email;
	}
}
