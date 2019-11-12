package service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import service.prototype.IManagerService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=(TestConfig.class))
public class TestManager {
	@Autowired
	private IManagerService ms;
	
	@Test
	public void test() {
		int findManagerId = ms.findManagerId("root", "123");
		System.out.println(findManagerId);
	}
}
