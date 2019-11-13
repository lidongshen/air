package dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototype.IClerkerDao;
import entity.Flight;
import entity.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=(TestConfig.class))
public class TestClerkerDao {
	@Autowired
	private IClerkerDao clerkerdao;
	
	@Test
	public void testFindFlightAll(){
		List<Flight> f = clerkerdao.findFlightAll();
		for (Flight f1 : f) {
			System.out.println(f1);
		}
	}
	@Test
	public void testFindFlight() {
		List<Flight> f = clerkerdao.findFlight("太原", "北京");
		for (Flight f1 : f) {
			System.out.println(f1);
		}
	}
	@Test
	public void testFlightinfo() {
		List<Flight> f = clerkerdao.findFlightinfo(1);
		for (Flight f1 : f) {
			System.out.println(f1);
		}
	}
	@Test
	public void testFindAllUser() {
		List<User> u = clerkerdao.findUserAll();
		for (User u1 : u) {
			System.out.println(u1);
		}
	}
	
	@Test
	public void testFindUser() {
		List<User> u = clerkerdao.findUser(2);
		for (User u1 : u) {
			System.out.println(u1);
		}
	}
	@Test
	public void testFindClerker() {
		int findClerker = 0;
		try {
			findClerker=clerkerdao.findClerker("222", "222222");
		}catch (Exception e) {
			//throw new RuntimeException("13");
		}
		System.out.println(findClerker);
	}
	@Test
	public void testOrderTicket() {
		 clerkerdao.orderTicket(1,1,1);
	}
	@Test
	public void testDrawerTicket() {
		clerkerdao.drawerTicket(1, 1, 1);
	}
}