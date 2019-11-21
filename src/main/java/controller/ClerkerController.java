package controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import entity.Booking;
import entity.Flight;
import entity.User;
import service.prototype.IClerkerService;
import service.prototype.IFlightService;

@Controller
public class ClerkerController {
	@Autowired
	private IClerkerService clerkerService;
	@Autowired
	private IFlightService flightService;
	
	@RequestMapping("/clerker")
	public String clerker(){
		return "clerker/clerker";
	}
	
	@RequestMapping("/huanying")
	public String huanying(){
		return "clerker/huanying";
	}
	@RequestMapping("/clogin")
	public String clogin(){
		return "login/clogin";
	}
	@RequestMapping("/cl")
	@ResponseBody
	public String cl(HttpServletRequest request,HttpServletResponse response) {
		String cname = request.getParameter("cname");
		String cpwd = request.getParameter("cpwd");
		int findClerker = clerkerService.findClerker(cname, cpwd);

		if(findClerker==0) {
			return "no";
		}
		HttpSession session = request.getSession(true);
		session.setAttribute("cId",findClerker);
		return "ok";
	}
	
	@RequestMapping(value = "/corderTicket/{fId}",produces = "text/plain;charset=utf-8")
	public ModelAndView corder(@PathVariable("fId" ) int fId,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("clerker/corderTicket");
		HttpSession session=request.getSession(true);
		int cId=Integer.parseInt(session.getAttribute("cId").toString());
		clerkerService.orderTicket(cId, fId);
		Flight oneFlight = flightService.seachFlight(fId);
		mv.addObject("oneFlight",oneFlight);
		return mv;
	}
	@RequestMapping(value="/payTicket/{fId}/{cId}",produces = "text/plain;charset=utf-8")
	public ModelAndView payTicket(@PathVariable("fId") int fId ,@PathVariable("cId") int cId) {
		ModelAndView mv = new ModelAndView("clerker/pay");
		System.out.println(fId);
		System.out.println(cId);
		clerkerService.pay(cId, fId);
		return mv;
	}
	
	@RequestMapping(value = "/cflightlist",produces = "text/plain;charset=utf-8")
	public ModelAndView seachFlightAll() {
		ModelAndView mv = new ModelAndView("clerker/cflightlist");
		List<Flight> f = clerkerService.seachFlightAll();
		mv.addObject("f",f);
		return mv;
	} 
	
	@RequestMapping(value = "/flightinfo/{fId}",produces = "text/plain;charset=utf-8")
	public ModelAndView seachflightinfo(@PathVariable("fId") int fId) {
		ModelAndView mv = new ModelAndView("clerker/flightinfo");
		List<Flight> f = clerkerService.seachFlightinfo(fId);
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
	
	@RequestMapping(value = "/search",produces = "text/plain;charset=utf-8")
	public ModelAndView getUsers(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String from = request.getParameter("from");
		String to = request.getParameter("to");		
		String time = request.getParameter("time");
		System.out.println(time);
		ModelAndView mv = new ModelAndView("clerker/list");
		List<Flight> f = clerkerService.seachFlight(from, to);
		mv.addObject("f",f);
		mv.addObject("time", time);
		return mv;
	} 
	
}
