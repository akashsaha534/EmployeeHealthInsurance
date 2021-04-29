package service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import beans.Request;
import util.BusinessDayCalculator;
import dao.TPADao;

public class TPAService {
	private TPADao td=new TPADao();
	BusinessDayCalculator calc = new BusinessDayCalculator();
	public ArrayList<Request> viewRequestList(String action){
		return td.viewRequestList(action);
	}
	public void approveRequest(int hid,int reqid){
		td.approveRequest(hid, reqid);
	}
	public void rejectRequest(int hid,int reqid){
		td.rejectRequest(hid, reqid);
	}
	public String searchTPA(int id){
		return td.searchTPA(id);
	}
	public int addLoginDetails(int empid){
		return td.addLoginDetails(empid);
	}
	public double getDifference(Timestamp t){
		String startDate = t.toString();
	    String endDate = new Timestamp(new Date().getTime()).toString();
	    return calc.dateDifference(startDate, endDate);
	}
	public void updateSLA(Request r){
		td.updateSLA(r);
	}
}
