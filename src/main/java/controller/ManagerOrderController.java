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
		List<OrderReSeatNum> o = oms.findOrderReSeatNumPage(page, limit,bId);
		int totalItems = oms.totalItems(bId);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", totalItems);
		map.put("data", o);
		return JSON.toJSONString(map);
	}
	
	
	@RequestMapping("/lookmo")
	public String lookMc() {
		return "managerorder/lookmo";
	}
	
	
}
