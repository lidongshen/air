package dao.impl;

import dao.prototype.IBossDao;
import entity.BusinesspointAndNum;
import entity.Piao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("BossImpl")
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
                "(select fb.f_id,count(*) as num,YEAR(b.b_date) as ddd\n" +
                "FROM fb JOIN booking b ON b.f_id = fb.f_id  \n" +
                "WHERE YEAR(b.b_date) LIKE ?\n" +
                "GROUP BY fb.f_id,YEAR(b.b_date)) t2 \n" +
                "ON bu.b_id = t2.f_id;";
        List<BusinesspointAndNum> bans = jdbcTemplate.query(sql, new Object[]{year}, new BeanPropertyRowMapper<BusinesspointAndNum>(BusinesspointAndNum.class));

        return bans;
    }
}
