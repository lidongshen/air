package dao.prototype;

import java.util.List;
import java.util.Date;

import entity.Booking;
import entity.Flight;
import entity.OutTicket;
import entity.Trip;
import entity.TripByUserAndFlight;
import entity.User;
/**
 * IUserDao接口
 * @author Administrator
 *
 */
public interface IUserDao {
	
	User findUser(int id);
	User findUser(String name);
	/*//订票
	void orderTicket(int uId,int fId);
	
	//出票
	void drawerTicket(int uId,int fId);
	
	//退款
	void refundTicket(int uId,int fId);
	
	//改签
	void endorseTicket(int uId, int fId1,int fId2);
	
	//付账update
	void pay(int uId, int fId);
	*/
	//查询订单
	List<Flight> findOrder(int uId,String from,String to);
	//查票
	List<Flight> findTicket(String from,String to,String date);
	
	//检查是否付账
	boolean isPay(int uId,int fId);
	
	boolean isLogin(String username,String password);
	
	/*boolean isOutTicket(int bookId);*/
	
	List<User> findUPager(int offset ,int pageSize);
	
	int totalNum();
	
	List<TripByUserAndFlight> findTrip(int uId);
	
	
	int deleteOneTicket(int fId);
	int addOneTicket(int fId);
	
	int updateUser(User user);
	
	int findLastTid(int fId,int uId);
	int findLastBookid(int fId,int uId);
	
	
	int addBook(int uId,int fId);
	int payBook(int uId,int fId);
	int outPayBook(int bookId);
	
	int addTrip(int uId,int fId);
	int payTrip(int uId,int fId);
	int outPayTrip(int bookId);
	
	int addOutTicket(int uId,int fId);
	int outTicket(int uId,int fId);
	int outOutTicket(int bookId);
	int updateTripInBookId(int uId,int fId,int bookId,int tId);
	
	int findFidByBookId(int bookId);
	
	void changeTripFid(int fId,int bookId);
	void changeBookingFid(int fId,int bookId);
	int findMaxTidInTrip();
}
