package service.impl;

import java.util.ArrayList;
import java.util.List;

import entity.Boss;
import entity.Sum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

import dao.prototype.IBossDao;
import entity.BusinesspointAndNum;
import service.prototype.IBossService;

@Service
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

    @Override
    public List<Boss> cheackUserAndPass(String user, String pwd) {
        List<Boss> bosses = boss.cheackUaP(user, pwd);
        return bosses;
    }

    @Override
    public List<Sum> cheackSum() {
        List<Sum> sums = boss.cheackSum();
        return sums;
    }

    @Override
    public List<Boss> seeBoss(String id) {
        List<Boss> bosses = boss.seeBoss(id);
        return bosses;
    }

    @Override
    public String xxmm(String un, String pd) {
        int xxmm = boss.xxmm(un, pd);
        String b = null;
        if (xxmm != 1) {
            b = "no";
        } else {
            b = "ok";
        }
        return b;
    }


}
