
public class Department {

	private String departmentName;
	private int departmentID;
	private int departmentMaxNumber;
	private int EBE;
	
	public Department(String departmentName, int departmentID, int departmentMaxNumber) {
		this.departmentName = departmentName;
		this.departmentID = departmentID;
		this.departmentMaxNumber = departmentMaxNumber;
	}
	
	public void setEBE(int EBE) {
		this.EBE = EBE;
	}
	
	public Department getDepartment(int departmentID) {
		return null;
	}
}
