import java.sql.Date;
import java.util.ArrayList;

public class mixanografiko {

	private int ID;
	private Date dateRegistration;
	private ArrayList<RegisteredDepartment> registeredDepartment;
	
	public mixanografiko(int ID, Date dateRegistration) {
		this.ID = ID;
		this.dateRegistration = dateRegistration;
		this.registeredDepartment = new ArrayList<>();
	}
	
	public void registerDepartment(int position, Department department) {
		RegisteredDepartment registeredDepartment = new RegisteredDepartment(position, department);
		this.registeredDepartment.add(registeredDepartment);
	}
	
	public ArrayList<RegisteredDepartment> getRegisteredDepartment(){
		return this.registeredDepartment;
	}
}
