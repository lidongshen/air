package service.prototype;

import java.util.List;

import entity.BusinessPoint;

/**
 * 站点班业务接口
 * @author s
 *
 */
public interface IBusinessPointService {
	List<BusinessPoint> seachBuAll();
	BusinessPoint seachBu(int id);
	int delBu(int id);
	int addBu(BusinessPoint bu);
	int modify(BusinessPoint bu);
	List<BusinessPoint> buPage(int pageNo,int pageSize);
	int totalItems();
}
