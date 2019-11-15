package dao;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.TestConfig;
import entity.OrderReSeatNum;
import mapper.IOrderReSeatNumMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=(TestConfig.class))
public class TestOrderReSeatNum {
	@Autowired
	private IOrderReSeatNumMapper om;
	
	@Test
	public void test() {
		List<OrderReSeatNum> findPage = om.findPage(1, 1, 1);
		for (OrderReSeatNum orderReSeatNum : findPage) {
			orderReSeatNum.setReseatnum(orderReSeatNum.getfSeatnum()-orderReSeatNum.getSeatnum());
		}
		if(findPage.size()==0) {
			findPage=null;
		}
		System.out.println(findPage);
	}

}
