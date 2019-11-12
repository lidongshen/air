
package dao.prototype;

import java.util.List;

import entity.Flight;
import entity.User;

public interface IClerkerDao {
	     //航班查询
		List<Flight> findFlightAll();
		List<Flight> findFlightinfo(int fid);
		List<Flight> findFlight(String from,String to);
		//用户查询
		List<User>  findUserAll();
		List<User>  findUser(int uid);
		//订票
		void orderTicket(int uId,int fId);
		
		//出票
		void drawerTicket(int uId,int fId);
		
		//退款
		void refundTicket(int uId,int fId);
		
		//改签
		void endorseTicket(int uId, int fId1,int fId2);
		
		//付账update
		void pay(int uId, int fId);
}

