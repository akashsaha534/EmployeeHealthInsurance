package beans;

public class Login {
private int EmpId;
private String Password="ChangePwd@123";
private String Role="Employee";
private char Is_Deleted='N';
public char getIs_Deleted() {
	return Is_Deleted;
}
public void setIs_Deleted(char is_Deleted) {
	Is_Deleted = is_Deleted;
}
public int getEmpId() {
	return EmpId;
}
public void setEmpId(int empId) {
	EmpId = empId;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getRole() {
	return Role;
}
public void setRole(String role) {
	Role = role;
}

}
