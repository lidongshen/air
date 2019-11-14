package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.impl.BossServiceImpl;

import javax.servlet.http.HttpServletRequest;

@Controller
public class BossController {


    
    @Autowired
    private BossServiceImpl iBossService;

    @RequestMapping(value = "/boss", produces = "text/plain;charset=utf-8")
    public String bossindex() {
        return "boss/bossindex";
    }

////查询票数信息
//	@RequestMapping(value = "/queryticket",produces = "text/plain;charset=utf-8")
//	@ResponseBody
//	public String rindex(){
//		return iBossService.seeTicketInfo();
//	}
//
////查询营业点信息
//	@RequestMapping(value = "/businesspoint",produces = "text/plain;charset=utf-8")
//	@ResponseBody
//	public String bossbusinesspoint(){
//		//返回BossService接口
//		return iBossService.seeBusinesspoint();
//	}
//
//	//查询营业点票数信息
//	@RequestMapping(value = "businesspointsum",produces = "text/plain;charset=utf-8")
//	@ResponseBody
//	public String bossbusinesspointsum(){
//		//返回BossService接口
//		return iBossService.seeBusinesspointSum();
//	}


    //查询营业厅名字  年度
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


}

