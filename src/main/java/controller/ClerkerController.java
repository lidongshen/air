package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Flight;
import entity.User;
import service.prototype.IClerkerService;

@Controller

public class ClerkerController {
	@Autowired
	private IClerkerService clerkerService;
	
	@RequestMapping("/clerker")
	public String clerker(){
		return "clerker/clerker";
	}
	
	@RequestMapping("/huanying")
	public String huanying(){
		return "clerker/huanying";
	}
	
	@RequestMapping(value = "/cflightlist",produces = "text/plain;charset=utf-8")
	public ModelAndView seachFlightAll() {
		ModelAndView mv = new ModelAndView("clerker/cflightlist");
		List<Flight> f = clerkerService.seachFlightAll();
		mv.addObject("f",f);
		return mv;
	} 
	 
	
	@RequestMapping(value = "/cuserlist",produces = "text/plain;charset=utf-8")
	public ModelAndView seachuserAll() {
		ModelAndView mv = new ModelAndView("clerker/cuserlist");
		List<User> u = clerkerService.seachUserAll();
		mv.addObject("u",u);
		return mv;
	} 
	
	
}
