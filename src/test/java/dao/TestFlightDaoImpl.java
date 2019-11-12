package dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototype.IFlightDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=(TestConfig.class))
public class TestFlightDaoImpl {
	@Autowired
	private IFlightDao fd;
	
	@Test
	public void testFindAll(){
		
	}
	
	@Test
	public void delete() {
		System.out.println(fd.deleteFlight(19));
	} 
	
	
	
	@Test
	public void find() {
		System.out.println(fd.findFlight(2));
	}
}
