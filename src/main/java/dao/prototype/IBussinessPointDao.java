package dao.prototype;

import java.util.List;

import entity.BusinessPoint;

public interface IBussinessPointDao {
	List<BusinessPoint> findBuAll();
	List<BusinessPoint> findBuPager(int offset ,int pageSize);
	BusinessPoint findBu(int id);
	int deleteBu(int id);
	int insertBu(BusinessPoint bu);
	int upDateBu(BusinessPoint bu);
	int totalNum();
}
