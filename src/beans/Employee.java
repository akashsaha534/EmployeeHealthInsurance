package beans;

import java.util.Date;

public class Employee {
	private int EmpId;
	private String EmpName;
	private Date DOB;
	private String Gender;
	private String Email;
	private String Alternate_Email;
	private long PhoneNo;
	private long Alternate_PhoneNo;
	private char Is_Deleted='N';
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAlternate_Email() {
		return Alternate_Email;
	}
	public void setAlternate_Email(String alternate_Email) {
		Alternate_Email = alternate_Email;
	}
	public long getPhoneNo() {
		return PhoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		PhoneNo = phoneNo;
	}
	public long getAlternate_PhoneNo() {
		return Alternate_PhoneNo;
	}
	public void setAlternate_PhoneNo(long alternate_PhoneNo) {
		Alternate_PhoneNo = alternate_PhoneNo;
	}
	public char getIs_Deleted() {
		return Is_Deleted;
	}
	public void setIs_Deleted(char iS_Deleted) {
		Is_Deleted = iS_Deleted;
	}
	
}
