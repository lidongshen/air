
package dao.prototype;

import java.util.List;

import entity.Booking;
import entity.Clerker;
import entity.Flight;
import entity.User;

public interface IClerkerDao {
		//登录查询
		int findClerker(String cname,String cpwd);
	     //航班查询
		List<Flight> findFlightAll();
		List<Flight> findFlightinfo(int fid);
		List<Flight> findFlight(String from,String to);
		//用户查询
		List<User>  findUserAll();
		List<User>  findUser(int uid);
		//修改用户信息
		void Modify(int uid);
		//订票
		void orderTicket(int cid,int fid);
        List<Booking> findBooking(int cid,int fid);
		//出票
		void drawerTicket(int uId,int cid,int fId);
		
		//退款
		void refundTicket(int uId,int fId);
		
		//改签
		void endorseTicket(int uId, int fId1,int fId2);
		
		//付账update
		void pay(int uId, int fId);
		
		List<Clerker> findCPager(int offset ,int pageSize);
		List<Clerker> findCPager(int offset ,int pageSize,int bId);
		int totalNum();
		int totalNum(int bId);
		int addC(Clerker c);
		int deleteC(int id);
		int upDateC(Clerker c);
}

