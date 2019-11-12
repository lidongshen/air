package dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IManagerDao;

@Repository
public class ManagerDaoImpl implements IManagerDao{
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public int findManager(String name, String pwd) {
		return jt.queryForObject("select m_id from manager where m_number=? and m_password=?", new Object[] {name,pwd},Integer.class);
		
	}
	
}
