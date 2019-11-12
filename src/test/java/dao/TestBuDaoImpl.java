package dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import dao.prototype.IBussinessPointDao;
import entity.BusinessPoint;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=(TestConfig.class))
public class TestBuDaoImpl {
	@Autowired
	private IBussinessPointDao bd;
	@Test
	public void testFindAll(){
		List<BusinessPoint> findBuAll = bd.findBuAll();
		for (BusinessPoint b : findBuAll) {
			System.out.println(b);
		}
	}
	
	@Test
	public void delete() {
		System.out.println(bd.deleteBu(19));
	} 
	
	
	
	@Test
	public void find() {
		System.out.println(bd.findBu(2));
	}
}
