import java.sql.Date;
import java.util.ArrayList;

public class Candidate extends User{
	
	private Date birthday;
	private int moria;
	private String firstName;
	private String lastName;
	private ArrayList<Department> AvailableDepartmentperUser = new ArrayList<>();
	mixanografiko Mixanografiko;

	public Candidate(String firstName, String password, int ID, String email, Date birthday, String lastName) {
		super(password, ID, email);
		this.firstName = firstName;
		this.birthday = birthday;
		this.lastName = lastName;
		setUserMode("Candidate");
	}

	public int getAccountID() {
		return this.getID();
	}
	
	public int getExamsResults() {
		return this.moria;
	}
	
	public ArrayList<Department> getAvailableDepartment() {
		return this.AvailableDepartmentperUser;
	}
	
	public Date getBirthday() {
		return this.birthday;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public void setMixanografiko() {
		this.Mixanografiko = new mixanografiko(1, birthday);
	}
	
	public ArrayList<RegisteredDepartment> getMixanografiko() {
		return this.Mixanografiko.getRegisteredDepartment();
	}
}
