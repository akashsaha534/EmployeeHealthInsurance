package beans;

import java.util.Date;

public class Dependent {
private int DepId;
private int EmpId;
private String BeneName;
private String Relation;
private Date dob;
private String Gender;
private char Is_Deleted='N';
public int getDepId() {
	return DepId;
}
public void setDepId(int depId) {
	DepId = depId;
}
public int getEmpId() {
	return EmpId;
}
public void setEmpId(int empId) {
	EmpId = empId;
}
public String getBeneName() {
	return BeneName;
}
public void setBeneName(String beneName) {
	BeneName = beneName;
}
public String getRelation() {
	return Relation;
}
public void setRelation(String relation) {
	Relation = relation;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public String getGender() {
	return Gender;
}
public void setGender(String gender) {
	Gender = gender;
}
public char getIs_Deleted() {
	return Is_Deleted;
}
public void setIs_Deleted(char is_Deleted) {
	Is_Deleted = is_Deleted;
}

}
