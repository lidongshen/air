package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import entity.Flight;
import service.prototype.IFlightService;
import util.DateUtil;

@Controller
public class FlightController {
	@Autowired
	private IFlightService fs;
	
	@RequestMapping("/findex")
	public String findex(){
		return "flight/findex";
	}
	
	@RequestMapping(value="/fseach",produces="text/html;charset=utf-8")
	@ResponseBody
	public String seachFlight(int page, int limit) {
		List<Flight> seachFlightAll = fs.flightPage(page, limit);
		int totalItems = fs.totalItems();
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", totalItems);
		map.put("data", seachFlightAll);
		return JSON.toJSONString(map);
	}
	
	@RequestMapping(value="/delf",produces="text/html;charset=utf-8")
	@ResponseBody
	public String delF(int fId) {
		int delFlight = fs.delFlight(fId);
		if(delFlight>0) {
			return "ok";
		}
		return "no";
	}
	@RequestMapping(value="/delfAll",produces="text/html;charset=utf-8")
	@ResponseBody
	public String delFAll(int[] data) {
		for(int i=0;i<data.length;i++) {
			int delFlight = fs.delFlight(data[i]);
			if(delFlight<=0) {
				return "no";
			}
		}
		return "ok";
	}
	
	@RequestMapping("/lookflight")
	public String lookFlight() {
		return "flight/lookflight";
	}
	
	@RequestMapping("/addflight")
	public String addFlight() {
		return "flight/addflight";
	}
	
	@RequestMapping(value="/addf",produces="text/html;charset=utf-8")
	@ResponseBody
	public String addF(String fName,int fMoney,int fSeatnum,String fFromcity,String fTocity,String fStarttime,String fEndtime) {
		Flight flight = new Flight(fName,fFromcity,fTocity,fMoney,fSeatnum,DateUtil.toDate("yyyy-MM-dd HH:mm:ss", fStarttime),DateUtil.toDate("yyyy-MM-dd HH:mm:ss", fEndtime));
		int addFlight = fs.addFlight(flight);
		if(addFlight>0) {
			return "ok";
		}
		return "no";
	}
	
	@RequestMapping("/editflight")
	public String editFlight() {
		return "flight/editflight";
	}
	
	@RequestMapping(value="/editf",produces="text/html;charset=utf-8")
	@ResponseBody
	public String editF(int fId,String fName,int fMoney,int fSeatnum,String fFromcity,String fTocity,String fStarttime,String fEndtime) {
		Flight flight = new Flight(fId,fName,fFromcity,fTocity,fMoney,fSeatnum,DateUtil.toDate("yyyy-MM-dd HH:mm:ss", fStarttime),DateUtil.toDate("yyyy-MM-dd HH:mm:ss", fEndtime));
		int addFlight = fs.modify(flight);
		if(addFlight>0) {
			return "ok";
		}
		return "no";
	}
}
