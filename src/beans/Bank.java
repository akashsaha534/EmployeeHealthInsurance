package beans;

public class Bank {
private int EmpId;
private long AccNo;
private String BankName;
private String IFSC;
private char Is_Deleted='N';
public int getEmpId() {
	return EmpId;
}
public void setEmpId(int empId) {
	EmpId = empId;
}
public long getAccNo() {
	return AccNo;
}
public void setAccNo(long accNo) {
	AccNo = accNo;
}
public String getBankName() {
	return BankName;
}
public void setBankName(String bankName) {
	BankName = bankName;
}
public String getIFSC() {
	return IFSC;
}
public void setIFSC(String iFSC) {
	IFSC = iFSC;
}
public char getIs_Deleted() {
	return Is_Deleted;
}
public void setIs_Deleted(char is_Deleted) {
	Is_Deleted = is_Deleted;
}

}
