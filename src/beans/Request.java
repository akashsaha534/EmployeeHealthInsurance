package beans;

import java.sql.Timestamp;
import java.util.Date;

public class Request {
private int Request_Id;
private int HID;
private int EmpId;
private Timestamp SubmitDate=new Timestamp(new Date().getTime());
private Timestamp ApproveDate;
private String SLA_Crossed="False";
private String Reason;
private char Is_Deleted='N';
public int getRequest_Id() {
	return Request_Id;
}
public void setRequest_Id(int request_Id) {
	Request_Id = request_Id;
}
public int getHID() {
	return HID;
}
public void setHID(int hID) {
	HID = hID;
}
public int getEmpId() {
	return EmpId;
}
public void setEmpId(int empId) {
	EmpId = empId;
}
public Timestamp getSubmitDate() {
	return SubmitDate;
}
public void setSubmitDate(Timestamp submitDate) {
	SubmitDate = submitDate;
}
public Timestamp getApproveDate() {
	return ApproveDate;
}
public void setApproveDate(Timestamp approveDate) {
	ApproveDate = approveDate;
}
public String getSLA_Crossed() {
	return SLA_Crossed;
}
public void setSLA_Crossed(String sLA_Crossed) {
	SLA_Crossed = sLA_Crossed;
}
public String getReason() {
	return Reason;
}
public void setReason(String reason) {
	Reason = reason;
}
public char getIs_Deleted() {
	return Is_Deleted;
}
public void setIs_Deleted(char is_Deleted) {
	Is_Deleted = is_Deleted;
}

}
