package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import util.HibernateUtil;

import beans.Bank;
import beans.Dependent;
import beans.Employee;
import beans.Health_Insurance;
import beans.Login;
import beans.Policy;
import beans.Request;

public class UserDAO {
	public int addEmployee(int empId, String empName, Date dOB, String gender,
			String email, String alternate_Email, long phoneNo,
			long alternate_PhoneNo, Date startDate, int policy_Period, double sum_Insured, double premium_Amount, long accNo, String bankName, String IFSC){
		Session session=null;
		Transaction transaction=null;
		Health_Insurance hi=null;
		try{
			session = HibernateUtil.currentSession();
			transaction = session.beginTransaction();

			Employee emp= new Employee();
			emp.setEmpId(empId);
			emp.setEmpName(empName);
			emp.setDOB(dOB);
			emp.setGender(gender);
			emp.setEmail(email);
			emp.setAlternate_Email(alternate_Email);
			emp.setPhoneNo(phoneNo);
			emp.setAlternate_PhoneNo(alternate_PhoneNo);
			session.save(emp);
			System.out.println("Employee added");
			Bank bank=new Bank();
			bank.setEmpId(empId);
			bank.setBankName(bankName);
			bank.setAccNo(accNo);
			bank.setIFSC(IFSC);
			session.save(bank);
			System.out.println("Bank added");	
			Policy pol=new Policy();
			pol.setPolicy_Period(policy_Period);
			pol.setStartDate(startDate);
			pol.setPremium_Amount(premium_Amount);
			pol.setSum_Insured(sum_Insured);
			session.save(pol);
			System.out.println("premium added");
			System.out.println("policy no is "+ pol.getPolicy_No());
			hi=new Health_Insurance();
			hi.setCustomer_Id(empId);
			hi.setPolicy_No(pol.getPolicy_No());
			session.save(hi);
			System.out.println("Hiid added");
			Request r=new Request();
			r.setHID(hi.getHID());
			System.out.println("hid no is " +hi.getHID());
			r.setEmpId(empId);
			session.save(r);
			System.out.println("request added");
			System.out.println("request no is " +r.getRequest_Id());
			transaction.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
			hi=null;
		}
		finally{
			if(session!=null){
				HibernateUtil.closeSession();
			}
		}
		if(hi!=null)
			return hi.getHID();
		else
			return 0;
	}

	public int addDependent(int empId, String beneName, Date dOB, String gender, String relation,

			Date startDate, int policy_Period, double sum_Insured, double premium_Amount){
		Session session=null;
		Transaction transaction=null;
		int a=0;
		try{
			session = HibernateUtil.currentSession();
			transaction = session.beginTransaction();

			Dependent dep=new Dependent();
			dep.setEmpId(empId);
			dep.setBeneName(beneName);
			dep.setRelation(relation);
			dep.setDob(dOB);
			dep.setGender(gender);
			session.save(dep);
			System.out.println("Dependent added");

			Policy pol=new Policy();
			pol.setPolicy_Period(policy_Period);
			pol.setStartDate(startDate);
			pol.setPremium_Amount(premium_Amount);
			pol.setSum_Insured(sum_Insured);
			session.save(pol);
			System.out.println("premium added");
			System.out.println("policy no is "+ pol.getPolicy_No());
			Health_Insurance hi=new Health_Insurance();
			hi.setCustomer_Id(dep.getDepId());
			hi.setPolicy_No(pol.getPolicy_No());
			session.save(hi);
			a=hi.getHID();
			System.out.println("Hiid added");
			Request r=new Request();
			r.setHID(hi.getHID());
			System.out.println("hid no is " +hi.getHID());
			r.setEmpId(empId);
			session.save(r);
			System.out.println("request added");
			System.out.println("request no is " +r.getRequest_Id());
			transaction.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
			a=0;
		}
		finally{
			if(session!=null){
				HibernateUtil.closeSession();
			}
		}
		return a;
	}

	public Login searchLogin(int empId){
		Session session=null;
		Transaction transaction=null;
		Login login=null;
		try{
			session = HibernateUtil.currentSession();
			transaction = session.beginTransaction();
			login = (Login)session.get(Login.class, empId);
			transaction.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
			login=null;
		}
		finally{
			if(session!=null){
				HibernateUtil.closeSession();
			}
		}
		if(login!=null){
			return login;
		}
		else{
			return null;
		}
	}
	public Employee searchEmployee(int empId){
		Session session=null;
		Transaction transaction=null;
		Employee emp=null;
		try{
			session = HibernateUtil.currentSession();
			transaction = session.beginTransaction();
			emp = (Employee)session.get(Employee.class, empId);
			transaction.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
			emp=null;
		}
		finally{
			if(session!=null){
				HibernateUtil.closeSession();
			}
		}
		return emp;
	}
	public ArrayList<Dependent> searchDependent(int empId){
		Session session=null;
		Transaction transaction=null;
		Iterator<Dependent> itr=null;
		ArrayList<Dependent> dlist=new ArrayList<Dependent>();
		try{
			session = HibernateUtil.currentSession();
			transaction = session.beginTransaction();
			String sql="from Dependent d where d.EmpId=:empid";
			Query query=session.createQuery(sql);
			query.setString("empid", Integer.toString(empId));
			itr=query.list().iterator();
			while(itr.hasNext()){
				Dependent d=itr.next();
				dlist.add(d);
				}
			transaction.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally{
			if(session!=null){
				HibernateUtil.closeSession();
			}
		}
		return dlist;
	}
	
	
	public void changePassword(int empId,String pass){
		Session session=null;
		Transaction transaction=null;
		Login login=null;
		try{
			session = HibernateUtil.currentSession();
			transaction = session.beginTransaction();
			login = (Login)session.get(Login.class, empId);
			login.setPassword(pass);
			transaction.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally{
			if(session!=null){
				HibernateUtil.closeSession();
			}
		}
	}
	public Health_Insurance viewHealthInsuranceDetails(int hid){
		Session session=null;
		Transaction transaction=null;
		Health_Insurance h=null;
		try{
			session = HibernateUtil.currentSession();
			transaction = session.beginTransaction();
			h=(Health_Insurance)session.get(Health_Insurance.class, hid);
			transaction.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally{
			if(session!=null){
				HibernateUtil.closeSession();
			}
		}
		return h;
	}

	public Health_Insurance viewHealthInsuranceDetailsForEmployee(int eid){
		Session session=null;
		Transaction transaction=null;
		Health_Insurance h=null;
		Iterator<Health_Insurance> itr=null;
		try{
			session = HibernateUtil.currentSession();
			transaction = session.beginTransaction();
			String sql="from Health_Insurance h where h.Customer_Id=:empid";
			Query query=session.createQuery(sql);
			query.setString("empid", Integer.toString(eid));
			itr=query.list().iterator();
			h=itr.next();
			transaction.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally{
			if(session!=null){
				HibernateUtil.closeSession();
			}
		}
		return h;
	}
	
	public Policy viewPolicyDetails(int pid){
		Session session=null;
		Transaction transaction=null;
		Policy pol=null;
		try{
			session = HibernateUtil.currentSession();
			transaction = session.beginTransaction();
			pol=(Policy)session.get(Policy.class, pid);
			transaction.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally{
			if(session!=null){
				HibernateUtil.closeSession();
			}
		}
		return pol;
	}
	public Employee viewEmployeeDetails(int empid){
		Session session=null;
		Transaction transaction=null;
		Employee emp=null;
		try{
			session = HibernateUtil.currentSession();
			transaction = session.beginTransaction();
			emp=(Employee)session.get(Employee.class, empid);
			transaction.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
			emp=null;
		}
		finally{
			if(session!=null){
				HibernateUtil.closeSession();
			}
		}
		return emp;
	}

	public Bank viewBankDetails(int empid){
		Session session=null;
		Transaction transaction=null;
		Bank b=null;
		try{
			session = HibernateUtil.currentSession();
			transaction = session.beginTransaction();
			b=(Bank)session.get(Bank.class, empid);
			transaction.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally{
			if(session!=null){
				HibernateUtil.closeSession();
			}
		}
		return b;
	}

	public Dependent viewDependentDetails(int did){
		Session session=null;
		Transaction transaction=null;
		Dependent dep=null;
		try{
			session = HibernateUtil.currentSession();
			transaction = session.beginTransaction();
			dep=(Dependent)session.get(Dependent.class, did);
			transaction.commit();
		}catch (HibernateException e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}
		finally{
			if(session!=null){
				HibernateUtil.closeSession();
			}
		}
		return dep;
	}
	public ArrayList<Request> viewRequestLists(int empid){
		Session session=null;
		Transaction transaction=null;
		Iterator<Request> itr=null;
		ArrayList<Request> rlist=new ArrayList<Request>();
		try{
			session = HibernateUtil.currentSession();
			transaction = session.beginTransaction();
			String sql="from Request r where r.EmpId=:empid";
			Query query=session.createQuery(sql);
			query.setString("empid", Integer.toString(empid));
			itr=query.list().iterator();
			while(itr.hasNext()){
				Request r=itr.next();
					rlist.add(r);
				}
			transaction.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally{
			if(session!=null){
				HibernateUtil.closeSession();
			}
		}
		return rlist;
	}
	public String[] generateCardEmp(int empid){
		Session session=null;
		Transaction transaction=null;
		Iterator<Health_Insurance> itr1=null;
		Iterator<Employee> itr2=null;
		String[] result=new String[10];
		try{
			session = HibernateUtil.currentSession();
			transaction = session.beginTransaction();
			String sql1="from Health_Insurance h where h.Customer_Id=:empid";
			Query query1=session.createQuery(sql1);
			query1.setString("empid", Integer.toString(empid));
			itr1=query1.list().iterator();
			Health_Insurance h=itr1.next();
			Employee emp=(Employee)session.get(Employee.class, empid);
			result[0]=Integer.toString(h.getPolicy_No());
			result[1]=emp.getEmpName();
			result[2]=Integer.toString(h.getHID());
			result[3]=Integer.toString(empid);
			result[4]="Self";
			String date_s = emp.getDOB().toString(); 
			SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 
			Date date=null;
			try {
				date = dt.parse(date_s);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			SimpleDateFormat dt1 = new SimpleDateFormat("dd-MMM-yyyy");
			result[5]=dt1.format(date);
			result[6]=emp.getEmpName();
			transaction.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally{
			if(session!=null){
				HibernateUtil.closeSession();
			}
		}
		return result;
	}
	public String[] generateCardDep(int did){
		Session session=null;
		Transaction transaction=null;
		Iterator<Health_Insurance> itr1=null;
		Iterator<Dependent> itr2=null;
		String[] result=new String[10];
		try{
			session = HibernateUtil.currentSession();
			transaction = session.beginTransaction();
			String sql1="from Health_Insurance h where h.Customer_Id=:did";
			Query query1=session.createQuery(sql1);
			query1.setString("did", Integer.toString(did));
			itr1=query1.list().iterator();
			Health_Insurance h=itr1.next();
			Dependent dep=(Dependent)session.get(Dependent.class, did);
			Employee emp=(Employee)session.get(Employee.class, dep.getEmpId());
			result[0]=Integer.toString(h.getPolicy_No());
			result[1]=dep.getBeneName();
			result[2]=Integer.toString(h.getHID());
			result[3]=Integer.toString(dep.getEmpId());
			result[4]=dep.getRelation();
			String date_s = dep.getDob().toString(); 
			SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); 
			Date date=null;
			try {
				date = dt.parse(date_s);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			SimpleDateFormat dt1 = new SimpleDateFormat("dd-MMM-yyyy");
			result[5]=dt1.format(date);
			result[6]=emp.getEmpName();
			transaction.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally{
			if(session!=null){
				HibernateUtil.closeSession();
			}
		}
		return result;
	}
}
