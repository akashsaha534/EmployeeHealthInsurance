package dao;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Health_Insurance;
import beans.Login;
import beans.Request;
import beans.TPALogin;
import util.HibernateUtil;

public class TPADao {
	public String searchTPA(int id){
		Session session=null;
		Transaction transaction=null;
		TPALogin login=null;
		try{
			session = HibernateUtil.currentSession();
			transaction = session.beginTransaction();
			login = (TPALogin)session.get(TPALogin.class, id);
			transaction.commit();
		}catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		}
		finally{
			HibernateUtil.closeSession();
		}
		if(login!=null){
			return login.getPass();
		}
		else{
			return null;
		}
	}

	public ArrayList<Request> viewRequestList(String action){
		Session session=null;
		Transaction transaction=null;
		Iterator<Request> itr1=null;
		Iterator<Health_Insurance> itr2=null;
		ArrayList<Request> rlist=new ArrayList<Request>();;
		try{
			session = HibernateUtil.currentSession();
			transaction = session.beginTransaction();
			String sql1="from Request r";
			Query query1=session.createQuery(sql1);
			itr1=query1.list().iterator();
			while(itr1.hasNext()){
				Request r=itr1.next();
				String sql2="from Health_Insurance h where h.Status=:status and h.HID=:hid";
				Query query2=session.createQuery(sql2);
				query2.setString("status", action);
				query2.setString("hid",Integer.toString(r.getHID()));
				itr2=query2.list().iterator();
				if(itr2.hasNext()){
					rlist.add(r);
				}
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
	public void approveRequest(int hid,int reqid){
		Session session=null;
		Transaction transaction=null;
		Health_Insurance h=null;
		Request r=null;
		try{
			session = HibernateUtil.currentSession();
			transaction = session.beginTransaction();
			h = (Health_Insurance)session.get(Health_Insurance.class, hid);
			h.setStatus("Approved");
			session.save(h);
			r=(Request)session.get(Request.class, reqid);
			Timestamp approveDate=new Timestamp(new Date().getTime());
			r.setApproveDate(approveDate);
			session.save(r);
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
	public void rejectRequest(int hid,int reqid){
		Session session=null;
		Transaction transaction=null;
		Health_Insurance h=null;
		Request r=null;
		try{
			session = HibernateUtil.currentSession();
			transaction = session.beginTransaction();
			h = (Health_Insurance)session.get(Health_Insurance.class, hid);
			h.setStatus("Rejected");
			session.save(h);
			r=(Request)session.get(Request.class, reqid);
			Timestamp approveDate=new Timestamp(new Date().getTime());
			r.setApproveDate(approveDate);
			session.save(r);
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
	public int addLoginDetails(int empId){
		Session session=null;
		Transaction transaction=null;
		Login login=null;
		int a=0;
		try{
			session = HibernateUtil.currentSession();
			transaction = session.beginTransaction();
			login=new Login();
			login.setEmpId(empId);
			a = (Integer)session.save(login);
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
	public void updateSLA(Request r){
		Session session=null;
		Transaction transaction=null;
		Request re=null;
		try{
			session = HibernateUtil.currentSession();
			transaction = session.beginTransaction();
			re = (Request)session.get(Request.class,r.getRequest_Id());
			re.setSLA_Crossed("true");
			session.save(re);
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
}
