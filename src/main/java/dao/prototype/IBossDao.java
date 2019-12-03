package dao.prototype;


import entity.Boss;
import entity.BusinesspointAndNum;
import entity.Piao;
import entity.Sum;

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

    List<Boss> cheackUaP(String username, String pwd);

    List<Sum> cheackSum();

    List<Boss> seeBoss(String id);

    int xxmm(String un, String pd);

}
