package service.prototype;

import java.util.Date;
import java.util.List;

import entity.Flight;
import entity.Trip;
import entity.TripByUserAndFlight;
import entity.User;

public interface IUserService {
	User findUser(String username);
	User findUser(int uId);
	// 订票
	void orderTicket(int uId, int fId);

	// 出票
	void drawerTicket(int bookId);

	// 退款
	String refundTicket(int bookId);

/*	// 改签
	void endorseTicket(int uId, int fId1, int fId2);*/

	// 付账update
	void pay(int uId, int fId);

	// 查询订单
	List<Flight> findOrder(int uId, String from, String to);

	// 查票
	List<Flight> findTicket(String from, String to,String date);

	// 检查是否付账
	boolean isPay(int uId, int fId);

	boolean isLogin(String username, String password);

	/*boolean isOutTicket(int uId, int fId);*/
	
	List<User> seachUserPage(int pageNo ,int pageSize);
	
	int totalItems();
	
	List<TripByUserAndFlight> findTrip(int uId);
	
	int updateUser(User user);
	
	int findLastTid(int fId,int uId);
	int findLastBookid(int fId,int uId);
	
	int findFidByBookId(int bookId);
	void endorseTicket(int fId,int bookId);
	
	void addUser(User user);
}
