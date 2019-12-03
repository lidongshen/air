package service.prototype;

import entity.Boss;
import entity.Sum;

import java.util.List;

public interface IBossService {
    //    String seeTicketInfo();
//    String seeBusinesspoint();
//    String seeBusinesspointSum();
    String seeBusinesspoinAndSum(String year);

    String seeBusinesspoinAndSumData(String year);

    List<Boss> cheackUserAndPass(String user, String pwd);

    List<Sum> cheackSum();

    List<Boss> seeBoss(String id);

    String xxmm(String un, String pd);


}
