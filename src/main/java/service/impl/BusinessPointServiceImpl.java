package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.IBussinessPointDao;
import entity.BusinessPoint;
import service.prototype.IBusinessPointService;

@Service
public class BusinessPointServiceImpl implements IBusinessPointService{
	@Autowired
	private IBussinessPointDao bpd;
	@Override
	public List<BusinessPoint> seachBuAll() {
		return bpd.findBuAll();
	}

	@Override
	public BusinessPoint seachBu(int id) {
		return bpd.findBu(id);
	}

	@Override
	public int delBu(int id) {
		return bpd.deleteBu(id);
	}

	@Override
	public int addBu(BusinessPoint bu) {
		return bpd.insertBu(bu);
	}

	@Override
	public int modify(BusinessPoint bu) {
		return bpd.upDateBu(bu);
	}

	@Override
	public List<BusinessPoint> buPage(int pageNo, int pageSize) {
		return bpd.findBuPager((pageNo-1)*pageSize, pageSize);
	}

	@Override
	public int totalItems() {
		return bpd.totalNum();
	}
	
}
