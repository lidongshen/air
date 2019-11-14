package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import entity.User;
import service.prototype.IUserService;

@Controller
public class ManagerUserController {
	@Autowired
	private IUserService us;
	
	@RequestMapping("/muindex")
	public String muindex(){
		return "manageruser/muindex";
	}
	
	
	@RequestMapping(value="/museach",produces="text/html;charset=utf-8")
	@ResponseBody
	public String seachMu(int page, int limit) {
		List<User> seachUserPage = us.seachUserPage(page, limit);
		int totalItems = us.totalItems();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", totalItems);
		map.put("data", seachUserPage);
		return JSON.toJSONString(map);
	}
	
	
	@RequestMapping("/lookmu")
	public String lookMc() {
		return "manageruser/lookmu";
	}
	
}
