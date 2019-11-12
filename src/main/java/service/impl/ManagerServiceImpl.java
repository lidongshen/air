package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.prototype.IManagerDao;
import service.prototype.IManagerService;

@Service
public class ManagerServiceImpl implements IManagerService{
	@Autowired
	private IManagerDao md;
	
	@Override
	public int findManagerId(String name, String pwd) {
		int findManager= 0;
		try {
			findManager = md.findManager(name, pwd);
		}catch (Exception e) {
		}
		return findManager;
	}
	
}
