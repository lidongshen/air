package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.prototype.IBusinessPointService;

@Controller
public class ManagerUserController {
	@Autowired
	private IBusinessPointService bps;
	
	@RequestMapping("/muindex")
	public String muindex(){
		return "manageruser/muindex";
	}
	
	/*
	@RequestMapping(value="/museach",produces="text/html;charset=utf-8")
	@ResponseBody
	public String seachMc(int page, int limit) {
		List<Clerker> seachClerkerPage = cs.seachClerkerPage(page, limit);
		int totalItems = cs.totalItems();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", totalItems);
		map.put("data", seachClerkerPage);
		return JSON.toJSONString(map);
	}
	*/
}
