package dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototype.IUserDao;
import entity.Flight;
import entity.Trip;
import entity.TripByUserAndFlight;
import entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestUserDao {
	@Autowired
	private IUserDao userDao;
	@Test
	public void testOrder() {
		List<Flight> order = userDao.findOrder(1, "太原", "北京");
		System.out.println(order);
	}
	@Test
	public void testFindTicket() {
		List<Flight> findTicket = userDao.findTicket("太原", "北京");
		System.out.println(findTicket);
	}
	@Test
	public void testLogin() {
		boolean flag = userDao.isLogin("123", "zss");
		System.out.println(flag);
	}
	@Test
	public void testIsPay() {
		boolean flag = userDao.isPay(1, 1);
		System.out.println(flag);
	}
	@Test
	public void testIsOutTicket() {
		boolean flag = userDao.isOutTicket(1, 1);
		System.out.println(flag);
	}
	
	
	/*@Test
	public void orderTicket() {
		userDao.orderTicket(1, 5);
	}
	@Test
	public void payTicket() {
		userDao.pay(1,5);
	}
	@Test
	public void endorseTicket() {
		userDao.endorseTicket(1, 5, 4);
	}
	@Test
	public void testDrawer() {
		userDao.drawerTicket(1, 4);
	} 
	@Test
	public void refundTicket() {
		userDao.refundTicket(1, 5);
	}*/
	
	@Test
	public void testFindU() {
		User findUser = userDao.findUser("10001");
		System.out.println(findUser);
	}
	
	@Test
	public void testfindTrip() {
		List<TripByUserAndFlight> findTrip = userDao.findTrip(1);
		for (TripByUserAndFlight trip : findTrip) {
			System.out.println(trip);
		}
	}
}
