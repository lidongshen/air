package service.prototype;

import java.util.List;

import entity.OrderReSeatNum;

public interface IOrderReSeatNumMapperService {
	
	List<OrderReSeatNum> findOrderReSeatNumPage(int page,int pageSize,int bId);
}
