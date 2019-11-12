package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import service.prototype.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {TestConfig.class})
public class TestUserService {
	@Autowired
	private IUserService userService;
	
	@Test
	public void testOrder() {
		System.out.println(userService.findOrder(1, "太原", "北京"));
	}
	@Test
	public void testLogin() {
		boolean flag = userService.isLogin("123", "zss");
		System.out.println(flag);
	}
}
