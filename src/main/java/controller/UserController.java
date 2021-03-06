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
import entity.TripByUserAndFlight;
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
		List<Flight> f = userService.findTicket(from, to,time);
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
	/*@RequestMapping(value="/payTicket/{fId}/{uId}",produces = "text/plain;charset=utf-8")
	public ModelAndView payTicket(@PathVariable("fId") int fId ,@PathVariable("uId") int uId) {
		ModelAndView mv = new ModelAndView("user/pay");
		System.out.println(fId);
		System.out.println(uId);
		userService.pay(uId, fId);
		return mv;
	}*/
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
		ModelAndView mv = new ModelAndView("user/nologin");
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
		List<TripByUserAndFlight> trip = userService.findTrip(uId);
		/*userService.findLastBookid(uId);*/
		if(trip!=null) {
			return JSON.toJSONString(trip);
		}else {
			return "nook";
		}
	}
	@RequestMapping(value="/userlist",produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String myUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		int uId = Integer.parseInt(session.getAttribute("uId").toString());
		User user = userService.findUser(uId);
		if(user !=null ) {
			return JSON.toJSONString(user);
		}else {
			return "nook";
		}
	}
	@RequestMapping("/changeMessage")
	@ResponseBody
	public String changeMessage(HttpServletRequest request) {
		int age = Integer.parseInt(request.getParameter("age"));
		String sex = request.getParameter("sex");
		String telephone = request.getParameter("telephone");
		String password = request.getParameter("password");
		User user = new User();
		user.setuAge(age);
		user.setuPhone(telephone);
		user.setuSex(sex);
		user.setuPassword(password);
		HttpSession session = request.getSession();
		int uId = Integer.parseInt(session.getAttribute("uId").toString());
		user.setuId(uId);
		if(userService.updateUser(user)>0) 
			return "ok";
		else 
			return "nook";
		
	}
	@RequestMapping("/refundTicket/{bookId}")
	public ModelAndView retundTicket(@PathVariable("bookId") int bookId) {
		ModelAndView mv = null;
		String result = userService.refundTicket(bookId);
		if("ok".equals(result)) {
			mv = new ModelAndView("/user/index");
		}
		return mv;
	}
	@RequestMapping("/endorsePage/{bookId}")
	public ModelAndView endoesePage(@PathVariable("bookId") int bookId) {
		ModelAndView mv = new ModelAndView("/user/endorseTicket");
		int fId = userService.findFidByBookId(bookId);
		Flight f = flightService.seachFlight(fId);
		mv.addObject("bookId",bookId);
		mv.addObject("f",f);
		return mv;
	}
	@RequestMapping("/endorseTicket/{bookId}")
	public ModelAndView endoeseTicket(@PathVariable("bookId") int bookId,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("/user/endorseoneTicket");
		String from = request.getParameter("from");
		String to = request.getParameter("to");
		String time=request.getParameter("time");
		List<Flight> findTicket = userService.findTicket(from, to,time);
		mv.addObject("endorseTickets",findTicket);
		mv.addObject("bookId",bookId);
		return mv;
	}
	@RequestMapping("/endorseOneTicket/{fId}/{bookId}")
	public ModelAndView endoeseOneTicket(@PathVariable("fId") int fId,@PathVariable("bookId") int bookId) {
		ModelAndView mv = new ModelAndView("/user/index");
		userService.endorseTicket(fId,bookId);
		return mv;
	}
	@RequestMapping("/paypaypay/{fId}/{uId}")
	public ModelAndView paypaypay(@PathVariable("fId") int fId) {
		ModelAndView mv=  new ModelAndView("/user/alipay/index");
		mv.addObject("fId",fId);
		double price = flightService.seachFlight(fId).getfMoney();
		mv.addObject("price",price);
		return mv;
	}
	@RequestMapping("/regi")
	public  ModelAndView regi() {
		ModelAndView mv=  new ModelAndView("/user/register");
		return mv;
	}
	@RequestMapping("/register")
	public  ModelAndView register(HttpServletRequest request) {
		ModelAndView mv =  null;
		String uPhone = request.getParameter("username");
		String password = request.getParameter("upwd");
		String repassword = request.getParameter("urepwd");
		int idnum = Integer.parseInt(request.getParameter("idnum"));
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		int sexs = Integer.parseInt(request.getParameter("sex"));
		String sex = null;
		if(sexs==1) {
			sex="男";
		}else if(sexs==0) {
			sex="女";
		}
		if(password.equals(repassword)) {
			User user = new User();
			user.setuPhone(uPhone);
			user.setuPassword(password);
			user.setuNum(idnum);
			user.setuName(name);
			user.setuAge(age);
			user.setuSex(sex);
			userService.addUser(user);
			mv =  new ModelAndView("/user/nologin");
		}else {
			mv = new ModelAndView("/user/register");
		}
		return mv;
	}
}

