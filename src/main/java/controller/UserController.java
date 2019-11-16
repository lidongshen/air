package controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

import entity.Flight;
import entity.Trip;
import entity.User;
import service.prototype.IFlightService;
import service.prototype.IUserService;

@Controller
@RequestMapping(value = "/user",produces = "text/plain;charset=utf-8")
public class UserController {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private IFlightService flightService;
	
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
		ModelAndView mv = new ModelAndView("user/list");
		List<Flight> f = userService.findTicket(from, to);
		mv.addObject("f",f);
		mv.addObject("time", time);
		return mv;
	} 
	
	@RequestMapping(value = "/login",produces = "text/plain;charset=utf-8")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login/ulogin");
		return mv;
	}
	@RequestMapping(value = "/logins",produces = "text/plain;charset=utf-8")
	public ModelAndView loginplus(HttpServletRequest request) {
		ModelAndView mv = null;
		String uphone = request.getParameter("username");
		String upwd = request.getParameter("upwd");
		User u = userService.findUser(uphone);
		if(userService.isLogin(uphone,upwd)) {
			mv = new ModelAndView("user/index");
			mv.addObject("uId", u.getuId());
			HttpSession session = request.getSession(true);
			session.setAttribute("uId", u.getuId());
			session.setAttribute("userlogin", "yes");
			session.setAttribute("uNum", u.getuNum());
			session.setAttribute("uPhone", u.getuPhone());
			session.setAttribute("uPassword", u.getuPassword());
			session.setAttribute("uName", u.getuName());
			session.setAttribute("uAge", u.getuAge());
			session.setAttribute("uSex", u.getuSex());
		}else {
			mv = new ModelAndView("login/ulogin");
		}
		return mv;
	}
	@RequestMapping(value ="/userLookFlight/{fId}",produces = "text/plain;charset=utf-8")
	public ModelAndView userLookFlight(@PathVariable("fId") int fId) {
		ModelAndView mv = new ModelAndView("user/details");
		Flight oneFlight = flightService.seachFlight(fId);
		mv.addObject("oneFlight", oneFlight);
		return mv;
	}
	@RequestMapping(value="/payTicket/{fId}/{uId}",produces = "text/plain;charset=utf-8")
	public ModelAndView payTicket(@PathVariable("fId") int fId ,@PathVariable("uId") int uId) {
		ModelAndView mv = new ModelAndView("user/pay");
		System.out.println(fId);
		System.out.println(uId);
		userService.pay(uId, fId);
		return mv;
	}
	@RequestMapping(value="/orderTicket/{fId}/{uId}",produces = "text/plain;charset=utf-8")
	public ModelAndView orderTicket(@PathVariable("fId") int fId,@PathVariable("uId") int uId) {
		ModelAndView mv = new ModelAndView("user/orderTicket");
		Flight orderFlight = flightService.seachFlight(fId);
		mv.addObject("orderFlight", orderFlight);
		userService.orderTicket(uId, fId);
		return mv;
	}
	@RequestMapping("/index")
	public ModelAndView index(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("user/index");
		
		return mv;
	}
	@RequestMapping("/checksession")
	public ModelAndView checkSession() {
		ModelAndView mv = new ModelAndView("user/checksession");
		return mv;
	}
	@RequestMapping("/exit")
	public ModelAndView exit() {
		ModelAndView mv = new ModelAndView("user/exit");
		return mv;
	}
	@RequestMapping("/success")
	public ModelAndView success() {
		ModelAndView mv = new ModelAndView("user/success");
		return mv;
	}
	@RequestMapping(value="/triplist",produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String allTrip(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int uId = Integer.parseInt(session.getAttribute("uId").toString());
		List<Trip> trip = userService.findTrip(uId);
		return JSON.toJSONString(trip);
	}
	@RequestMapping(value="/userlist",produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String myUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int uId = Integer.parseInt(session.getAttribute("uId").toString());
		User user = userService.findUser(uId);
		return JSON.toJSONString(user);
	}
}

