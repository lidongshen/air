package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import entity.BusinessPoint;
import entity.Clerker;
import service.prototype.IBusinessPointService;
import service.prototype.IClerkerService;

@Controller
public class ManagerClerkerController {
	@Autowired
	private IBusinessPointService bps;
	@Autowired
	private IClerkerService cs;
	
	@RequestMapping("/mcindex")
	public String mcindex(){
		return "managerclerker/mcindex";
	}
	
	@RequestMapping(value="/buall",produces="text/html;charset=utf-8")
	@ResponseBody
	public String mcAll(){
		List<BusinessPoint> buAll = bps.seachBuAll();
		
		return JSON.toJSONString(buAll);
	}
	
	
	@RequestMapping(value="/mcseach",produces="text/html;charset=utf-8")
	@ResponseBody
	public String seachMc(int page, int limit) {
		List<Clerker> seachClerkerPage = cs.seachClerkerPage(page, limit);
		int totalItems = cs.totalItems();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", totalItems);
		map.put("data", seachClerkerPage);
		return JSON.toJSONString(map);
	}
	
	@RequestMapping(value="/buselect",produces="text/html;charset=utf-8")
	@ResponseBody
	public String buSelect(int page, int limit,int bId) {
		if(bId==0) {
			return seachMc(page, limit);
		}
		List<Clerker> seachClerkerPage = cs.seachClerkerPage(page, limit,bId);
		int totalItems = cs.totalItems(bId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", totalItems);
		map.put("data", seachClerkerPage);
		return JSON.toJSONString(map);
	}
	
	@RequestMapping(value="/delmc",produces="text/html;charset=utf-8")
	@ResponseBody
	public String delMc(int cId) {
		int delC= cs.delC(cId);
		if(delC>0) {
			return "ok";
		}
		return "no";
	}
	
	@RequestMapping(value="/delmcAll",produces="text/html;charset=utf-8")
	@ResponseBody
	public String delMcAll(int[] data) {
		for(int i=0;i<data.length;i++) {
			int delC = cs.delC(data[i]);
			if(delC<=0) {
				return "no";
			}
		}
		return "ok";
	}
	
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
}
