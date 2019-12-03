package dao.impl;

import dao.prototype.IBossDao;
import entity.Boss;
import entity.BusinesspointAndNum;
import entity.Piao;
import entity.Sum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BossDaoImpl implements IBossDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Piao> searchBusinesspointSum() {
        String sql = "SELECT count(*) piao\n" +
                "FROM booking b RIGHT JOIN fb f ON b.f_id = f.f_id\n" +
                "JOIN businesspoint bu ON f.b_id = bu.b_id\n" +
                "GROUP BY f.b_id";
        List<Piao> bSum = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Piao>(Piao.class));
        return bSum;
    }

    @Override
    public List<BusinesspointAndNum> searchBuAndNum(String year) {
        String sql = "select bu.b_name,IFNULL(num,0)as b_num,IFNULL(ddd,'大型错误，年份未指定，票数未指定')as b_date\n" +
                "from businesspoint bu LEFT JOIN \n" +
                "(select fb.b_id,count(*) as num,YEAR(b.b_date) as ddd\n" +
                "FROM fb fb JOIN booking b ON b.f_id = fb.f_id  \n" +
                "WHERE YEAR(b.b_date) LIKE ?\n" +
                "GROUP BY fb.b_id,YEAR(b.b_date)) t2 \n" +
                "ON bu.b_id = t2.b_id;";
        List<BusinesspointAndNum> bans = jdbcTemplate.query(sql, new Object[]{year}, new BeanPropertyRowMapper<BusinesspointAndNum>(BusinesspointAndNum.class));

        return bans;
    }

    @Override
    public List<Boss> cheackUaP(String username, String pwd) {
        String sql = "select * from boss where bo_number = ? and bo_password = ?";
        List<Boss> query = jdbcTemplate.query(sql, new Object[]{username, pwd}, new BeanPropertyRowMapper<Boss>(Boss.class));
        return query;
    }

    @Override
    public List<Sum> cheackSum() {
        String sql = "select bu.b_id,bu.b_name,bu.b_phone,bu.b_city,date\n" +
                "from airsys.businesspoint bu JOIN\n" +
                "(select fb.b_id,b.b_date as date\n" +
                "FROM airsys.fb  join airsys.booking as b\n" +
                "where b.f_id = fb.f_id\n" +
                "GROUP BY fb.b_id,b.b_date) t2\n" +
                "ON bu.b_id = t2.b_id";
        List<Sum> query = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Sum>(Sum.class));

        return query;
    }

    @Override
    public List<Boss> seeBoss(String id) {
        String sql = "select * from airsys.boss where boss.bo_number=?";
        List<Boss> q = jdbcTemplate.query(sql, new Object[]{id}, new BeanPropertyRowMapper<Boss>(Boss.class));
        return q;
    }

    @Override
    public int xxmm(String un, String pd) {
        String sql = "update airsys.boss set bo_number=?,bo_password=? where bo_number=?";
        int up = jdbcTemplate.update(sql, new Object[]{un, pd, un});
        return up;
    }
}
