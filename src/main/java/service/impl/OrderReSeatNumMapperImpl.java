package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import entity.OrderReSeatNum;
import mapper.IOrderReSeatNumMapper;
import service.prototype.IOrderReSeatNumMapperService;
@Service
public class OrderReSeatNumMapperImpl implements IOrderReSeatNumMapperService{
	@Autowired
	private IOrderReSeatNumMapper om;

	@Override
	public List<OrderReSeatNum> findOrderReSeatNumPage(int page, int pageSize, int bId) {
		List<OrderReSeatNum> findPage = om.findPage((page-1)*pageSize,pageSize, bId);
		for (OrderReSeatNum orderReSeatNum : findPage) {
			orderReSeatNum.setReseatnum(orderReSeatNum.getfSeatnum()-orderReSeatNum.getSeatnum());
		}
		return findPage;
	}

}
