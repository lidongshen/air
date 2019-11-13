package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.IClerkerDao;
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
	public void orderTicket(int uid, int cid, int fid) {
		clerkerdao.orderTicket(uid, cid, fid);
		
	}
}
