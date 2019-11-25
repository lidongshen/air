package service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import entity.Booking;
import entity.Flight;
import entity.User;
import service.prototype.IClerkerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=(TestConfig.class))
public class TestClerkerService {
	@Autowired
	private IClerkerService clerkerservice;
	
	@Test
	public void testFindFlightAll() {
		List<Flight> f = clerkerservice.seachFlightAll();
		for (Flight f1 : f) {
			System.out.println(f1);
		}
	}
	@Test
	public void testFindFlight() {
		List<Flight> f = clerkerservice.seachFlight("太原", "云南");
		for (Flight f1 : f) {
			System.out.println(f1);
		}
	}
	@Test
	public void testFlightinfo() {
		List<Flight> f = clerkerservice.seachFlightinfo(2);
		for (Flight f1 : f) {
			System.out.println(f1);
		}
	}
	@Test
	public void testFindUserAll() {
		List<User> u = clerkerservice.seachUserAll();
		for (User u1 : u) {
			System.out.println(u1);
		}
	}
	@Test
	public void testFindUser() {
		List<User> u = clerkerservice.seachUser(2);
		for (User u1 : u) {
			System.out.println(u1);
		}
	}
	@Test
	public void testFindClerker() {
		int findClerker = clerkerservice.findClerker("222","222222");
		System.out.println(findClerker);
	}
	@Test
	public void testOrderTicket() {
		 clerkerservice.orderTicket(1,1);
		 List<Booking> b = clerkerservice.findBooking(1, 1);
		 for (Booking b1 : b) {
				System.out.println(b1);
			}
	}
	@Test
	public void testFindOrder() {
		 List<Booking> b = clerkerservice.findBooking();
		 for (Booking b1 : b) {
				System.out.println(b1);
			}
	}
	@Test
	public void testPay() {
		clerkerservice.pay(1, 1);
	}
	
}
