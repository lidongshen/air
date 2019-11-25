package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.prototype.IUserDao;
import entity.Flight;
import entity.TripByUserAndFlight;
import entity.User;
import service.prototype.IUserService;

@Service
public class UserServiceDaoImpl implements IUserService{

	@Autowired
	private IUserDao userDao;

	@Override
	@Transactional
	public void orderTicket(int uId, int fId) {
		userDao.addBook(uId, fId);
		userDao.addTrip(uId, fId);
		userDao.deleteOneTicket(fId);
	}

	@Override
	public void drawerTicket(int uId, int fId) {
		userDao.outOutTicket(uId, fId);
	}

	@Override
	@Transactional
	public String refundTicket(int uId, int fId) {
		if(userDao.isOutTicket(uId, fId)) {
			return "nook";
		}else {
			userDao.outOutTicket(uId, fId);
			userDao.outPayBook(uId, fId);
			userDao.outPayTrip(uId, fId);
			return "ok";
		}
	}

	/*//改签？？
	@Override
	public void endorseTicket(int uId, int fId1, int fId2) {
		userDao.endorseTicket(uId, fId1, fId2);
	}*/

	@Override
	@Transactional
	public void pay(int uId, int fId) {
		userDao.payBook(uId, fId);
		userDao.payTrip(uId, fId);
	}

	@Override
	public List<Flight> findOrder(int uId, String from, String to) {
		return userDao.findOrder(uId, from, to);
	}

	@Override
	public List<Flight> findTicket(String from, String to) {
		return userDao.findTicket(from, to);
	}

	@Override
	public boolean isPay(int uId, int fId) {
		return userDao.isPay(uId, fId);
	}

	@Override
	public boolean isLogin(String username, String password) {
		return userDao.isLogin(username, password);
	}

	@Override
	public boolean isOutTicket(int uId, int fId) {
		return userDao.isOutTicket(uId, fId);
	}

	@Override
	public User findUser(String username) {
		return userDao.findUser(username);
	}
	
	@Override
	public User findUser(int uId) {
		return userDao.findUser(uId);
	}
	
	@Override
	public List<User> seachUserPage(int pageNo ,int pageSize) {
		return userDao.findUPager((pageNo-1)*pageSize, pageSize);
	}
	
	@Override
	public int totalItems() {
		return userDao.totalNum();
	}

	@Override
	public List<TripByUserAndFlight> findTrip(int uId) {
		return userDao.findTrip(uId);
	}

	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public int findLastTid(int fId, int uId) {
		return userDao.findLastTid(fId, uId);
	}

	@Override
	public int findLastBookid(int fId, int uId) {
		return userDao.findLastBookid(fId, uId);
	}
	
}
