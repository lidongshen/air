package dao.prototype;


import entity.BusinesspointAndNum;
import entity.Piao;

import java.util.List;

/**
 * @author dqyy
 */

public interface IBossDao {

    //    List<Booking> searchCount();
//    List<Booking> searchCount();
//    List searchDate();
//    List<BusinessPoint> searchBusinesspoint();
//    List<BusinessPoint> searchBusinesspointfor(int i);
//    List<Clerker> searchClerker(int cid);
    List<Piao> searchBusinesspointSum();

    List<BusinesspointAndNum> searchBuAndNum(String year);
}
