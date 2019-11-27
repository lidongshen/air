package dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.prototype.IUserDao;
import entity.Flight;
import entity.OutTicket;
import entity.Trip;
import entity.TripByUserAndFlight;
import entity.User;

@Repository("userDaoSpringImpl")
public class UserDaoSpringImpl implements IUserDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/*@Override
	@Transactional
	public void orderTicket(int uId, int fId) {
		
		jdbcTemplate.update("insert into booking (u_id,c_id,f_id,b_ispay) values("+uId+",0,"+fId+",0)");
		
		jdbcTemplate.update("insert into trip (u_id,f_id,u_ispay) values("+uId+","+fId+",0)");
	}
	//出票
	@Override
	public void drawerTicket(int uId, int fId) {
		jdbcTemplate.update(
				"insert into outticket (u_id,f_id,c_id,o_isout) values(?,?,0,1)",
				new Object[] {uId,fId});
	}
	//退票
	@Override
	@Transactional
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
	//改签
	@Override
	@Transactional
	public void endorseTicket(int uId, int fId1,int fId2) {
		jdbcTemplate.update(
				"update trip set f_id = ? where u_id = ? and f_id=?",
				new Object[] {fId2,uId,fId1});
		jdbcTemplate.update(
				"update booking set f_id = ? where u_id = ? and f_id=?",
				new Object[] {fId2,uId,fId1});
	}

	@Override
	public void pay(int uId, int fId) {
		jdbcTemplate.update(
				"update trip set u_ispay=1 where u_id=? and f_id=?",
				new Object[]{uId,fId});
		jdbcTemplate.update(
				"update booking set b_ispay=1 where u_id=? and f_id=?",
				new Object[]{uId,fId});
	}
*/
	
	@Override
	public List<Flight> findOrder(int uId, String from, String to) {
		return jdbcTemplate.query(
				"select * from flight where f_id in (select f_id from outticket where o_id in (select o_id from trip where u_id = ?)) and f_fromcity = ? and f_tocity = ?",
				new Object[] {uId,from,to},
				new BeanPropertyRowMapper<Flight>(Flight.class));
	}

	@Override
	public List<Flight> findTicket(String from, String to) {
		return jdbcTemplate.query(
				"select * from flight where f_fromcity=? and f_tocity=?",
				new Object[] {from,to},
				new BeanPropertyRowMapper<Flight>(Flight.class));
	}

	@Override
	public boolean isPay(int uId, int fId) {
		boolean flag = false;
		Trip list = jdbcTemplate.queryForObject(
				"select * from trip where u_id=? and f_id=?", 
				new Object[] {uId,fId},
				new BeanPropertyRowMapper<Trip>(Trip.class));
		if(list.getuIspay()==1) {
			flag=true;
		}
		return flag;
	}

	@Override
	public boolean isLogin(String username, String password) {
		boolean flag = false;
		List<User> list = jdbcTemplate.query(
				"select * from user where u_phone=? and u_password=?", 
				new Object[] {username,password},
				new BeanPropertyRowMapper<User>(User.class));
		if(list.size()>0) {
			flag=true;
		}
		return flag;
	}
	/*@Override
	public boolean isOutTicket(int uId,int fId) {
		boolean flag = false;
		OutTicket list = jdbcTemplate.queryForObject(
				"select * from outticket where u_id=? and f_id=?", 
				new Object[] {uId,fId},
				new BeanPropertyRowMapper<OutTicket>(OutTicket.class));
		if(list.getoIsout()==1) {
			flag=true;
		}
		return flag;
	}*/
	
	@Override
	public User findUser(String name) {
		return jdbcTemplate.queryForObject(
				"select * from user where u_phone = ?",
				new Object[]{name},
				new BeanPropertyRowMapper<User>(User.class));
	}
	
	@Override
	public List<User> findUPager(int offset ,int pageSize) {
		return jdbcTemplate.query("select * from user limit ?,?",new Object[] {offset ,pageSize} ,new BeanPropertyRowMapper<User>(User.class));
	}
	@Override
	public int totalNum() {
		return jdbcTemplate.queryForObject("select count(*) from user", Integer.class);
	}
	@Override
	public List<TripByUserAndFlight> findTrip(int uId) {
		return jdbcTemplate.query(
				"select f.f_id,u.u_name,f.f_fromcity,f.f_tocity,f.f_starttime,f.f_endtime,t.u_ispay,t.book_id from trip t left JOIN flight f on f.f_id=t.f_id LEFT JOIN user u on u.u_id = t.u_id where t.u_id =?", 
				new Object[] {uId},
				new BeanPropertyRowMapper<TripByUserAndFlight>(TripByUserAndFlight.class));
	}
	@Override
	public User findUser(int id) {
		return jdbcTemplate.queryForObject(
				"select * from user where u_id = ?",
				new Object[]{id},
				new BeanPropertyRowMapper<User>(User.class));
	}
	@Override
	public int updateUser(User user) {
		return jdbcTemplate.update("update user set u_phone=?,u_password=?,u_age=?,u_sex=? where u_id=?",
				new Object[] {user.getuPhone(),user.getuPassword(),user.getuAge(),user.getuSex(),user.getuId()});
	}
	@Override
	public int addBook(int uId,int fId) {
		return jdbcTemplate.update("insert into booking (u_id,c_id,f_id,b_ispay) values (?,?,?,?)"
				,new Object[] {uId,0,fId,0});
		
	}
	@Override
	public int payBook(int uId,int fId) {
		return jdbcTemplate.update("update booking set b_ispay=? where u_id=? and f_id=?"
				,new Object[] {1,uId,fId});
	}
	@Override
	public int outPayBook(int bookId) {
		return jdbcTemplate.update("update booking set b_ispay=? where book_id=?"
				,new Object[] {0,bookId});
	}
	@Override
	public int addTrip(int uId,int fId) {
		return jdbcTemplate.update("insert into trip (u_id,f_id,u_ispay) values (?,?,?)"
				,new Object[] {uId,fId,0});
	}
	@Override
	public int payTrip(int uId,int fId) {
		return jdbcTemplate.update("update trip set u_ispay = ? where u_id=? and f_id=? "
				,new Object[] {1,uId,fId});
	}
	@Override
	public int outPayTrip(int bookId) {
		return jdbcTemplate.update("update trip set u_ispay = ? where book_id=? "
				,new Object[] {0,bookId});
	}
	@Override
	public int addOutTicket(int uId,int fId) {
		return jdbcTemplate.update("insert into (f_id,u_id,c_id,o_isout,id_num) values (?,?,?,?,?)"
				,new Object[] {fId,uId,0,0,0});
	}
	@Override
	public int outTicket(int uId,int fId) {
		return jdbcTemplate.update("update outticket set o_isout=? where u_id=? and f_id=?"
				,new Object[] {1,uId,fId});
	}
	@Override
	public int outOutTicket(int bookId) {
		return jdbcTemplate.update("update outticket set o_isout=? where book_id=?"
				,new Object[] {0,bookId});
	}
	@Override
	public int deleteOneTicket(int fId) {
		return jdbcTemplate.update("update flight set f_seatnum=f_seatnum-1 where f_id=?",
				new Object[] {fId});
	}
	@Override
	public int addOneTicket(int fId) {
		return jdbcTemplate.update("update flight set f_seatnum=f_seatnum+1 where f_id=?",
				new Object[] {fId});
	}

	@Override
	public int findLastTid(int fId, int uId) {
		int bookId = jdbcTemplate.queryForObject("select MAX(book_id) bookId from booking where f_id=? and u_id=?",
				new Object[] {fId,uId},
				Integer.class);
		return bookId;
	}

	@Override
	public int findLastBookid(int fId, int uId) {
		int bookId = jdbcTemplate.queryForObject("select MAX(t_id) tId from trip where f_id=? and u_id=?",
				new Object[] {fId,uId},
				Integer.class);
		return bookId;
	}

	@Override
	public int updateTripInBookId(int uId, int fId, int bookId,int tId) {
		return jdbcTemplate.update("update trip set book_id = ? where u_id=? and f_id=? and t_id=?"
				,new Object[] {bookId,uId,fId,tId});
	}
	@Override
	public int findMaxTidInTrip() {
		int tId = jdbcTemplate.queryForObject("select MAX(t_id) from trip",
				Integer.class);
		return tId;
	}

	@Override
	public int findFidByBookId(int bookId) {
		int fId = jdbcTemplate.queryForObject("select f_id from trip where book_id=?",
				new Object[] {bookId},
				Integer.class);
		return fId;
	}

	@Override
	public void changeTripFid(int fId, int bookId) {
		jdbcTemplate.update("update trip set f_id=? where book_id=?",
				new Object[] {fId,bookId});
	}

	@Override
	public void changeBookingFid(int fId, int bookId) {
		jdbcTemplate.update("update booking set f_id=? where book_id=?",
				new Object[] {fId,bookId});
	}
	

}
