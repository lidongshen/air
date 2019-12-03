package controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import entity.Boss;
import entity.Sum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import service.impl.BossServiceImpl;
import service.prototype.IBossService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class BossController {

    @Autowired
    private IBossService iBossService;


    //首页
    @RequestMapping(value = "/boss", produces = "text/plain;charset=utf-8")
    public String airsysbos() {
        return "boss/airsysbos";
    }


    //登录页面
    @RequestMapping(value = "/bslogin", produces = "text/plain;charset=utf-8")
    public String bosslogin() {
        return "login/bslogin";
    }

    //登录页面
    @RequestMapping(value = "/xgmm", produces = "text/plain;charset=utf-8")
    public String xgmm() {
        return "boss/xgmm";
    }


    //登录页面
    @RequestMapping(value = "/xg", produces = "text/plain;charset=utf-8")
    public String xg() {
        return "boss/xgmm";
    }


    //boss的登录页面验证
    @RequestMapping(value = "/bosslogin")
    @ResponseBody
    public String cheackUsernameandPassword(HttpServletRequest request) {
        String bname = request.getParameter("bname");
        String bpwd = request.getParameter("bpwd");
        List<Boss> bosses = iBossService.cheackUserAndPass(bname, bpwd);
        String msg = null;

        if (bosses.size() != 0) {
            String ss = bosses.get(0).getBoNumber();
            boolean name = ss.equals(bname);
            boolean pass = bosses.get(0).getBoPassword().equals(bpwd);
            if (name == true && pass == true) {
                HttpSession session = request.getSession(true);
                session.setAttribute("bossId", bname);
//                session.setMaxInactiveInterval(3360);
                msg = "ok";
            }

        } else {
            msg = "no";

        }


        System.out.println(bname);
        System.out.println(bpwd);

        System.out.println(bosses);
        return msg;
    }


    //图表页面
    @RequestMapping(value = "/bossindex", produces = "text/plain;charset=utf-8")
    public String bossindex() {
        return "boss/bossindex";
    }


    //表格页面
    @RequestMapping(value = "/bostable", produces = "text/plain;charset=utf-8")
    public String table() {
        return "boss/table";
    }


    //查询营业厅名字
    @RequestMapping(value = "/businesspointsumname", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String seeBusinesspoinAndSum(HttpServletRequest request) {
        String year = request.getParameter("year");
        //返回BossService接口
        return iBossService.seeBusinesspoinAndSum(year);
    }


    //查询营业厅数据 年度
    @RequestMapping(value = "/businesspointsumdata")
    @ResponseBody
    public String seeBusinesspoinAndSumData(HttpServletRequest request) {
        String year = request.getParameter("year");

        return iBossService.seeBusinesspoinAndSumData(year);
    }


    //查询营业厅名字，城市，时间
    @RequestMapping(value = "/tablesum", produces = "text/plain;charset=utf-8")
    @ResponseBody
    @JSONField(jsonDirect = true)
    public String tablesum() {
        List<Sum> sums = iBossService.cheackSum();
//        Map<String, Object> sb = new HashMap<>();
//        sb.put("code",0);
//        sb.put("msg","");
//        sb.put("count",sums.size());
//        sb.put("data", sums);

        JSONObject jb = new JSONObject();
        jb.put("code", 0);
        jb.put("msg", "");
        jb.put("count", sums.size());
        jb.put("data", sums);
        return JSON.toJSONString(jb);
    }


    //查询boss用户的信息
    @RequestMapping(value = "/seeboss", produces = "text/plain;charset=utf-8")
    @ResponseBody
    @JSONField(jsonDirect = true)
    public String seeboss(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        Object bos = session.getAttribute("bossId");
        String se = (String) bos;
        List<Boss> bosses = iBossService.seeBoss(se);


        return JSON.toJSONString(bosses);
    }

    //查询boss用户的信息
    @RequestMapping(value = "/mmxx", produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String mmxx(HttpServletRequest request) {
        String un = request.getParameter("username");
        String pd = request.getParameter("password");

        String x = iBossService.xxmm(un, pd);
        System.out.println(un);
        System.out.println(pd);
        System.out.println(x);

        return x;
    }

}


