package dao;

import config.TestConfig;
import dao.prototype.IBossDao;
import entity.Boss;
import entity.BusinesspointAndNum;
import entity.Piao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = (TestConfig.class))
public class TestBossDaoImpl {
    @Autowired
    private IBossDao bossDao;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testFindAll() {
        List<BusinesspointAndNum> businesspointAndNums = bossDao.searchBuAndNum("2019");
        System.out.println(businesspointAndNums);
    }

    //    @Test
//    public void testuap() {
//        String s = bossDao.cheackUaP("boss", "boss");
//        System.out.println(s);
//    }
    @Test
    public void testuaxp() {
        String sql = "select * from airsys.boss where bo_number = 'ss' and bo_password = 'ss'";
        String query = jdbcTemplate.queryForObject(sql, String.class);
        System.out.println(query);
    }

}
