package dao;

import config.TestConfig;
import dao.prototype.IBossDao;
import entity.BusinesspointAndNum;
import entity.Piao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = (TestConfig.class))
public class TestBossDaoImpl {
    @Autowired
    private IBossDao bossDao;

    @Test
    public void testFindAll() {
        List<BusinesspointAndNum> businesspointAndNums = bossDao.searchBuAndNum("2019");
        System.out.println(businesspointAndNums);
    }

}
