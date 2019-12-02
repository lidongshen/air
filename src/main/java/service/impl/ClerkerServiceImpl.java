package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.IClerkerDao;
import entity.Booking;
import entity.Clerker;
import entity.Flight;
import entity.User;
import service.prototype.IClerkerService;

@Service("ClerkerServiceImpl")
public class ClerkerServiceImpl implements IClerkerService {

	@Autowired
	private  IClerkerDao clerkerdao;	
	
	@Override
	public List<Flight> seachFlightAll() {
		return clerkerdao.findFlightAll();
	}

	@Override
	public List<Flight> seachFlight(String from, String to) {	
		return clerkerdao.findFlight(from, to);
	}
	
	@Override
	public List<Flight> seachFlightinfo(int fid) {
		return clerkerdao.findFlightinfo(fid);
	}
	
	@Override
	public List<User> seachUserAll() {
		return clerkerdao.findUserAll();
	}	

	@Override
	public List<User> seachUser(int uid) {
		return clerkerdao.findUser(uid);
	}

	@Override
	public int findClerker(String cname, String cpwd) {
		int findClerker= 0;
		try {
			findClerker = clerkerdao.findClerker(cname, cpwd);
		}catch (Exception e) {
		}
		return findClerker;
	}

	@Override
	public void orderTicket(int uid,int cid, int fid) {
		clerkerdao.orderTicket(uid,cid, fid);
		
	}
	@Override
	public void reduceTicket(int fid) {
		clerkerdao.reduceTicket(fid);
	}
	@Override
	public List<Booking> findBooking(int bookId) {
		return clerkerdao.findBooking(bookId);
	}
	
	@Override
	public List<Clerker> seachClerkerPage(int pageNO ,int pageSize) {
		return clerkerdao.findCPager((pageNO-1)*pageSize, pageSize);
	}
	
	@Override
	public List<Clerker> seachClerkerPage(int pageNO, int pageSize, int bId) {
		return clerkerdao.findCPager((pageNO-1)*pageSize, pageSize,bId);
	}
	
	@Override
	public int totalItems() {
		return clerkerdao.totalNum();
	}

	@Override
	public int totalItems(int bId) {
		return clerkerdao.totalNum(bId);
	}
	
	@Override
	public int insertC(Clerker c) {
		return clerkerdao.addC(c);
	}

	@Override
	public int delC(int id) {
		return clerkerdao.deleteC(id);
	}

	@Override
	public int modify(Clerker c) {
		return clerkerdao.upDateC(c);
	}
	@Override
	public void pay(int uid,int cid, int fid) {
		clerkerdao.pay(uid,cid, fid);
	}

	@Override
	public List<Booking> findBooking() {
		return clerkerdao.findBooking();
	}
	@Override
	public void drawerTicket(int uId,int cId, int fId) {
		clerkerdao.drawerTicket(uId,cId, fId);
	}

	@Override
	public void endorseTicket(int uId, int fId1, int fId2) {
		clerkerdao.endorseTicket(uId,fId1, fId2);
	}

	@Override
	public void refundTicket(int uId, int fId) {
		clerkerdao.refundTicket(uId, fId);		
	}



}
