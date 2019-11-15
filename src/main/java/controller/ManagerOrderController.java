package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import entity.OrderReSeatNum;
import service.prototype.IOrderReSeatNumMapperService;

@Controller
public class ManagerOrderController {
	@Autowired
	private IOrderReSeatNumMapperService oms;
	
	@RequestMapping("/moindex")
	public String mcindex(){
		return "managerorder/moindex";
	}
	
	
	
	
	@RequestMapping(value="/moseach",produces="text/html;charset=utf-8")
	@ResponseBody
	public String buSelect(int page, int limit,int bId) {
		System.out.println(page+"-"+limit+"-"+bId);
		List<OrderReSeatNum> o = oms.findOrderReSeatNumPage(page, limit,bId);
		//int totalItems = cs.totalItems(bId);
		Map<String, Object> map = new HashMap<String, Object>();
		if(o.size()==0) {
			o=null;
		}
		map.put("total", 100);
		map.put("data", o);
		return JSON.toJSONString(map);
	}
	
	/*
	@RequestMapping("/lookmc")
	public String lookMc() {
		return "managerclerker/lookmc";
	}
	
	@RequestMapping("/addmc")
	public String addBu() {
		return "managerclerker/addmc";
	}
	
	@RequestMapping(value="/addmclerker",produces="text/html;charset=utf-8")
	@ResponseBody
	public String addC(String cName,String cNumber,String cPassword,int bId) {
		Clerker clerker = new Clerker(cName,cNumber,cPassword,bId);
		int addC = cs.insertC(clerker);
		if(addC>0) {
			return "ok";
		}
		return "no";
	}
	
	@RequestMapping("/editmc")
	public String editMc() {
		return "managerclerker/editmc";
	}
	
	@RequestMapping(value="/editclerker",produces="text/html;charset=utf-8")
	@ResponseBody
	public String editF(int cId,String cName,String cNumber,String cPassword,int bId) {
		 Clerker clerker = new Clerker(cId,cName,cNumber,cPassword,bId);
		int addMc = cs.modify(clerker);
		if(addMc>0) {
			return "ok";
		}
		return "no";
	}
	*/
}
