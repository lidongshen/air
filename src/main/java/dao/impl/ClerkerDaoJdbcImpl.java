package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IClerkerDao;
import entity.Flight;
import entity.User;
@Repository("ClerkerDaoJdbcImpl")
public class ClerkerDaoJdbcImpl  implements IClerkerDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	//查询全部航班
	public List<Flight> findFlightAll() {
		return jdbcTemplate.query("select * from flight", new BeanPropertyRowMapper<Flight>(Flight.class));
	}
	
	@Override
	//航班精确查询
	public List<Flight> findFlight(String from, String to) {
		return jdbcTemplate.query(
				"SELECT * FROM flight WHERE f_fromcity =? AND f_tocity=?",
				new Object[] {from,to},
				new BeanPropertyRowMapper<Flight>(Flight.class));
	}
	
	@Override
	public List<Flight> findFlightinfo(int fid) {
		return jdbcTemplate.query(
				"SELECT * FROM flight WHERE f_id=?",
				new Object[] {fid},
				new BeanPropertyRowMapper<Flight>(Flight.class));
	}
	
	@Override
	//全部用户信息查询
	public List<User> findUserAll() {
		return jdbcTemplate.query("select * from user", new BeanPropertyRowMapper<User>(User.class));
	}
	@Override
	//单用户信息查询
	public List<User> findUser(int uid) {
		return jdbcTemplate.query("SELECT * FROM user WHERE u_id=?", new Object[] {uid},new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	//订票
	public void orderTicket(int uId, int fId) {
		jdbcTemplate.update("insert into booking (u_id,c_id,f_id) values("+uId+",0,"+fId+")");
		
		jdbcTemplate.update("insert into trip (u_id,f_id) values("+uId+","+fId+")");
		
	}

	@Override
	//出票
	public void drawerTicket(int uId, int fId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//退票
	public void refundTicket(int uId, int fId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//改签
	public void endorseTicket(int uId, int fId1, int fId2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//支付
	public void pay(int uId, int fId) {
		// TODO Auto-generated method stub
		
	}
}

