package dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototype.IManagerDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=(TestConfig.class))
public class TestMananger {
	@Autowired
	private IManagerDao ma;
	
	
	@Test
	public void Test(){
		
		int findManager = 0;
		try {
			findManager= ma.findManager("root1", "111111");
		}catch (Exception e) {
			//throw new RuntimeException("13");
		}
		 
		System.out.println(findManager);
	}
}
