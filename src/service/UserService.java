package service;

import java.util.ArrayList;
import java.util.Date;

import beans.Bank;
import beans.Dependent;
import beans.Employee;
import beans.Health_Insurance;
import beans.Login;
import beans.Policy;
import beans.Request;

import dao.UserDAO;

public class UserService {
	private UserDAO ud=new UserDAO();
	public int addDependent(int empId, String beneName, Date dOB, String gender, String relation,
			Date startDate, int policy_Period, double sum_Insured, double premium_Amount){
		int a=ud.addDependent(empId, beneName, dOB, gender, relation, startDate, policy_Period, sum_Insured, premium_Amount);
		return a;
	}
	
	public int addEmployee(int empId, String empName, Date dOB, String gender,
			String email, String alternate_Email, long phoneNo,
			long alternate_PhoneNo, Date startDate, int policy_Period, double sum_Insured, double premium_Amount, long accNo, String bankName, String IFSC){
		int a=ud.addEmployee(empId, empName, dOB, gender, email, alternate_Email, phoneNo, alternate_PhoneNo, startDate, policy_Period, sum_Insured, premium_Amount, accNo, bankName, IFSC);
		return a;
	}
	public Health_Insurance viewHealthInsuranceDetails(int hid){
		Health_Insurance h=ud.viewHealthInsuranceDetails(hid);
		return h;
	}
	public Health_Insurance viewHealthInsuranceDetailsForEmployee(int eid){
		Health_Insurance h=ud.viewHealthInsuranceDetailsForEmployee(eid);
		return h;
	}
	public Employee searchEmployee(int empId){
		Employee emp=ud.searchEmployee(empId);
		return emp;
	}
	public ArrayList<Dependent> searchDependent(int empId){
		ArrayList<Dependent> dlist=ud.searchDependent(empId);
		return dlist;
	}
	public ArrayList<Request> viewRequestLists(int empid){
		ArrayList<Request> rlist=ud.viewRequestLists(empid);
		return rlist;
	}
	public String[] generateCardEmp(int empid){
		String[] result=ud.generateCardEmp(empid);
		return result;
	}
	public String[] generateCardDep(int did){
		String[] result=ud.generateCardDep(did);
		return result;
	}
	public Login searchLogin(int empid){
		return ud.searchLogin(empid);
	}
	public Employee viewEmployeeDetails(int empId){
		return ud.viewEmployeeDetails(empId);
	}
	public Bank viewBankDetails(int empId){
		return ud.viewBankDetails(empId);
	}
	public Policy viewPolicyDetails(int pid){
		return ud.viewPolicyDetails(pid);
	}
	public void changePassword(int empid,String pass){
		ud.changePassword(empid,pass);
	}
}
