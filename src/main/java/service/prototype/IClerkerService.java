package service.prototype;

import java.util.List;

import entity.Booking;
import entity.Clerker;
import entity.Flight;
import entity.User;

public interface IClerkerService {
	List<Flight> seachFlightAll();
	List<Flight> seachFlight(String from,String to);
	List<Flight> seachFlightinfo(int fid);
	List<User>seachUserAll();
	List<User>seachUser(int uid);
	int findClerker(String cname,String cpwd);
	void orderTicket(int uid,int cid,int fid);
	void reduceTicket(int fid);
	void refundTicket(int uId,int fId);
	void drawerTicket(int uId,int cId,int fId);
	List<Booking> findBooking(int bookId);
	List<Booking> findBooking();
	List<Clerker> seachClerkerPage(int pageNO ,int pageSize);
	List<Clerker> seachClerkerPage(int pageNO ,int pageSize,int bId);
	int totalItems();
	int totalItems(int bId);
	int insertC(Clerker c);
	int delC(int id);
	int modify(Clerker c);
	void pay(int uId,int cId, int fId);
	void endorseTicket(int uId, int fId1,int fId2);
}
