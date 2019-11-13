package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.prototype.IBusinessPointService;

@Controller
public class ManagerClerkerController {
	@Autowired
	private IBusinessPointService bps;
	
	@RequestMapping("/mcindex")
	public String mcindex(){
		return "managerclerker/mcindex";
	}
	/*
	@RequestMapping(value="/buseach",produces="text/html;charset=utf-8")
	@ResponseBody
	public String seachBu(int page, int limit) {
		List<BusinessPoint> buPage = bps.buPage(page, limit);
		int totalItems = bps.totalItems();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", totalItems);
		map.put("data", buPage);
		return JSON.toJSONString(map);
	}
	
	@RequestMapping(value="/delbu",produces="text/html;charset=utf-8")
	@ResponseBody
	public String delBu(int bId) {
		int delBu= bps.delBu(bId);
		if(delBu>0) {
			return "ok";
		}
		return "no";
	}
	@RequestMapping(value="/delbuAll",produces="text/html;charset=utf-8")
	@ResponseBody
	public String delBuAll(int[] data) {
		for(int i=0;i<data.length;i++) {
			int delBu = bps.delBu(data[i]);
			if(delBu<=0) {
				return "no";
			}
		}
		return "ok";
	}
	
	@RequestMapping("/lookbu")
	public String lookBu() {
		return "businesspoint/lookbu";
	}
	
	@RequestMapping("/addbu")
	public String addBu() {
		return "businesspoint/addbu";
	}
	
	@RequestMapping(value="/addbusinesspoint",produces="text/html;charset=utf-8")
	@ResponseBody
	public String addBu(String bName,String bProvince,String bCity,String bPhone) {
		BusinessPoint bu = new BusinessPoint(bName,bProvince,bCity,bPhone);
		int addBu = bps.addBu(bu);
		if(addBu>0) {
			return "ok";
		}
		return "no";
	}
	
	@RequestMapping("/editbu")
	public String editBu() {
		return "businesspoint/editbu";
	}
	
	@RequestMapping(value="/editbusinesspoint",produces="text/html;charset=utf-8")
	@ResponseBody
	public String editF(int bId,String bName,String bProvince,String bCity,String bPhone) {
		BusinessPoint bu = new BusinessPoint(bId,bName,bProvince,bCity,bPhone);
		int addBu = bps.modify(bu);
		if(addBu>0) {
			return "ok";
		}
		return "no";
	}*/
}
