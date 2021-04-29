package beans;

import java.util.Date;

public class Policy {
private int Policy_No;
private Date StartDate;
private int Policy_Period;
private double Sum_Insured;
private double Premium_Amount;
private char Is_Deleted='N';
public int getPolicy_No() {
	return Policy_No;
}
public void setPolicy_No(int policy_No) {
	Policy_No = policy_No;
}
public Date getStartDate() {
	return StartDate;
}
public void setStartDate(Date startDate) {
	StartDate = startDate;
}
public int getPolicy_Period() {
	return Policy_Period;
}
public void setPolicy_Period(int policy_Period) {
	Policy_Period = policy_Period;
}
public double getSum_Insured() {
	return Sum_Insured;
}
public void setSum_Insured(double sum_Insured) {
	Sum_Insured = sum_Insured;
}
public double getPremium_Amount() {
	return Premium_Amount;
}
public void setPremium_Amount(double premium_Amount) {
	Premium_Amount = premium_Amount;
}
public char getIs_Deleted() {
	return Is_Deleted;
}
public void setIs_Deleted(char is_Deleted) {
	Is_Deleted = is_Deleted;
}
}
