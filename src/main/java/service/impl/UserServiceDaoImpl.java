package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public void orderTicket(int uId, int fId) {
		userDao.orderTicket(uId, fId);
	}

	@Override
	public void drawerTicket(int uId, int fId) {
		userDao.drawerTicket(uId, fId);
	}

	@Override
	public void refundTicket(int uId, int fId) {
		userDao.refundTicket(uId, fId);
	}

	@Override
	public void endorseTicket(int uId, int fId1, int fId2) {
		userDao.endorseTicket(uId, fId1, fId2);
	}

	@Override
	public void pay(int uId, int fId) {
		userDao.pay(uId, fId);
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
	
}
