package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IBussinessPointDao;
import entity.BusinessPoint;

@Repository
public class BussinessPointDaoImpl implements IBussinessPointDao{
	
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public List<BusinessPoint> findBuAll() {
		return jt.query("select * from businesspoint", new BeanPropertyRowMapper<BusinessPoint>(BusinessPoint.class));
	}

	@Override
	public List<BusinessPoint> findBuPager(int offset, int pageSize) {
		return jt.query("select * from businesspoint limit ?,?",new Object[] {offset,pageSize}, new BeanPropertyRowMapper<BusinessPoint>(BusinessPoint.class));
	}

	@Override
	public BusinessPoint findBu(int id) {
		return jt.queryForObject("select * from businesspoint where b_id="+id,new BeanPropertyRowMapper<BusinessPoint>(BusinessPoint.class));
	}

	@Override
	public int deleteBu(int id) {
		return jt.update("delete from businesspoint where b_id="+id);
	}

	@Override
	public int insertBu(BusinessPoint bu) {
		return jt.update("insert into businesspoint(b_name,b_province,b_city,b_phone) values(?,?,?,?)",new Object[] {bu.getbName(),bu.getbProvince(),bu.getbCity(),bu.getbPhone()});
	}

	@Override
	public int upDateBu(BusinessPoint bu) {
		return jt.update("update businesspoint set b_name=?,b_province=?,b_city=?,b_phone=? where b_id=?",new Object[] {bu.getbName(),bu.getbProvince(),bu.getbCity(),bu.getbPhone(),bu.getbId()});
	}

	@Override
	public int totalNum() {
		return jt.queryForObject("select count(*) from businesspoint", Integer.class);
	}

}
