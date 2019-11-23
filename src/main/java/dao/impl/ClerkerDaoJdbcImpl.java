package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IClerkerDao;
import entity.Booking;
import entity.Clerker;
import entity.Flight;
import entity.User;
@Repository("ClerkerDaoJdbcImpl")
public class ClerkerDaoJdbcImpl  implements IClerkerDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	
	@Override
	//登录验证
	public int findClerker(String cname, String cpwd) {
		return jdbcTemplate.queryForObject("select c_id from clerker where c_number=? and c_password=?", new Object[] {cname,cpwd},Integer.class);
	}
	
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
	//查询航班详细信息
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
	public void orderTicket(int cid, int fid) {
		jdbcTemplate.update("insert into booking (u_id,c_id,f_id,b_ispay) values(0,"+cid+","+fid+",0)");
	}
	//订单查询
	public List<Booking> findBooking() {
		return jdbcTemplate.query("SELECT * FROM  booking", new BeanPropertyRowMapper<Booking>(Booking.class));
	}
	
	public List<Booking> findBooking(int cid,int fid) {
		return jdbcTemplate.query("SELECT * FROM  booking WHERE f_id=? and c_id=? ", new Object[] {cid,fid},new BeanPropertyRowMapper<Booking>(Booking.class));
	}

		@Override
		//出票
		public void drawerTicket(int uId,int cId, int fId) {
			jdbcTemplate.update(
					"insert into outticket (u_id,f_id,c_id,o_isout) values(?,?,?,1)");
		} 

		//退票
		@Override
		public void refundTicket(int uId, int fId) {
			jdbcTemplate.update(
					"update trip set u_ispay=0 where u_id=? and f_id=?",
					new Object[] {uId,fId});
			jdbcTemplate.update(
					"update booking set b_ispay=0 where u_id=? and f_id=?",
					new Object[] {uId,fId});
			jdbcTemplate.update(
					"update outticket set o_isout=0 where u_id=? and f_id=?",
					new Object[] {uId,fId});
		}

		@Override
		//改签
		public void endorseTicket(int uId, int fId1,int fId2) {
			jdbcTemplate.update(
					"update trip set f_id = ? where u_id = ? and f_id=?",
					new Object[] {fId2,uId,fId1});
			jdbcTemplate.update(
					"update booking set f_id = ? where u_id = ? and f_id=?",
					new Object[] {fId2,uId,fId1});
		}


		@Override
		//支付
		public void pay(int cId, int fId) {
			jdbcTemplate.update(
					"update booking set b_ispay=1 where c_id=? and f_id=?",
					new Object[]{cId,fId});
		}

	@Override
	//修改用户信息
	public void Modify(int uid) {
		jdbcTemplate.update("update ");
	}
	
	@Override
	public List<Clerker> findCPager(int offset ,int pageSize) {
		return jdbcTemplate.query("select c.*,b.b_name from clerker c join businesspoint b on c.b_id=b.b_id limit ?,?",new Object[] {offset ,pageSize} ,new BeanPropertyRowMapper<Clerker>(Clerker.class));
	}
	
	@Override
	public List<Clerker> findCPager(int offset, int pageSize, int bId) {
		return jdbcTemplate.query("select c.*,b.b_name from clerker c join businesspoint b on c.b_id=b.b_id where c.b_id=? limit ?,?",new Object[] {bId,offset ,pageSize} ,new BeanPropertyRowMapper<Clerker>(Clerker.class));
	}
	
	@Override
	public int totalNum() {
		return jdbcTemplate.queryForObject("select count(*) from clerker", Integer.class);
	}
	
	@Override
	public int totalNum(int bId) {
		return jdbcTemplate.queryForObject("select count(*) from clerker where b_id="+bId, Integer.class);
	}
	
	@Override
	public int addC(Clerker c) {
		return jdbcTemplate.update("insert into clerker(c_name,c_number,c_password,b_id) values(?,?,?,?)",new Object[] {c.getcName(),c.getcNumber(),c.getcPassword(),c.getbId()});
	}

	@Override
	public int deleteC(int id) {
		return jdbcTemplate.update("delete from clerker where c_id="+id);
	}

	@Override
	public int upDateC(Clerker c) {
		return jdbcTemplate.update("update clerker set c_name=?,c_number=?,c_password=?,b_id=? where c_id=?",new Object[] {c.getcName(),c.getcNumber(),c.getcPassword(),c.getbId(),c.getcId()});
	}

}

