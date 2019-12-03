package service;

import com.alibaba.fastjson.JSON;
import config.TestConfig;
import dao.prototype.IBossDao;
import entity.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import service.prototype.IBossService;
import service.prototype.IClerkerService;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = (TestConfig.class))
public class TestBossService {
    @Resource
    private IBossService bossService;
    @Resource
    private IBossDao iBossDao;


    @Test
    public void test() {
        List<Boss> bosses = bossService.cheackUserAndPass("boss", "boss");
        System.out.println(bosses);
    }

    @Test
    public void sum() {
        List<Sum> sums = bossService.cheackSum();
        String s = JSON.toJSONString(sums);
        System.out.println(s);
    }

    @Test
    public void sss() {
        int xxmm = iBossDao.xxmm("boss", "boss");

    }


}
