
public class Examiner extends User {
	
	private String firstName;
	private String lastName;
	private String academicRole;

	public Examiner(String password, int ID, String email, String firstName, String lastName, String role) {
		super(password, ID, email);
		this.firstName = firstName;
		this.lastName = lastName;
		this.academicRole = role;
		setUserMode("Examiner");
	}
	
	public Candidate findCandidate(int ID, String firstName, String lastName) {
		return null;
	}
	
	public void saveMarks(int ID, String firstName, String lastName) {
		Candidate candidate = findCandidate(ID, firstName, lastName);
	}

	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public String getRole() {
		return this.academicRole;
	}
}
