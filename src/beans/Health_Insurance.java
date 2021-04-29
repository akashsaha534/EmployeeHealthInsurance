package beans;

public class Health_Insurance {
private int HID;
private int Customer_Id;
private int Policy_No;
private String Status="Pending";
private char Is_Deleted='N';
public int getHID() {
	return HID;
}
public void setHID(int hID) {
	HID = hID;
}
public int getCustomer_Id() {
	return Customer_Id;
}
public void setCustomer_Id(int customer_Id) {
	Customer_Id = customer_Id;
}
public int getPolicy_No() {
	return Policy_No;
}
public void setPolicy_No(int policy_No) {
	Policy_No = policy_No;
}
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}
public char getIs_Deleted() {
	return Is_Deleted;
}
public void setIs_Deleted(char is_Deleted) {
	Is_Deleted = is_Deleted;
}

}
