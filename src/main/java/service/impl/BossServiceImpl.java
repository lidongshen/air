package service.impl;

import com.alibaba.fastjson.JSON;
import dao.prototype.IBossDao;
import entity.BusinesspointAndNum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import service.prototype.IBossService;

import java.util.ArrayList;
import java.util.List;

@Service
@Repository("IBossServiceImpl")
public class BossServiceImpl implements IBossService {
    @Autowired
    private IBossDao boss;


//    @Override
//    public String seeTicketInfo() {
//        return JSON.toJSONString(boss.searchCount());
//    }
//
//    @Override
//    public String seeBusinesspoint() {
//
//        return JSON.toJSONString(boss.searchBusinesspoint());
//    }
//
//    @Override
//    public String seeBusinesspointSum() {
//
//
//        return JSON.toJSONString(boss.searchBusinesspointSum());
//    }

    @Override
    public String seeBusinesspoinAndSum(String year) {
        List<BusinesspointAndNum> buss = boss.searchBuAndNum(year);
        List<Object> names = new ArrayList<>();
        for (BusinesspointAndNum bus : buss) {
            String bName = bus.getbName();
            names.add(bName);
        }

        return JSON.toJSONString(names);
    }

    @Override
    public String seeBusinesspoinAndSumData(String year) {
        List<BusinesspointAndNum> buss = boss.searchBuAndNum(year);
        List<Object> names = new ArrayList<>();
        for (BusinesspointAndNum bus : buss) {
            int nums = bus.getbNum();
            names.add(nums);
        }

        return JSON.toJSONString(names);
    }


}
