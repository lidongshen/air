package service.prototype;

import java.util.List;

import entity.OrderReSeatNum;

public interface IOrderReSeatNumMapperService {
	int totalItems(int bId);
	List<OrderReSeatNum> findOrderReSeatNumPage(int page,int pageSize,int bId);
}
