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
	
	@RequestMapping(value = "/corderTicket/{fId}/{uId}",produces = "text/plain;charset=utf-8")
	public ModelAndView corder(@PathVariable("fId" ) int fId,@PathVariable("uId" ) int uId,HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("clerker/corderTicket");
		HttpSession session=request.getSession(true);
		int cId=Integer.parseInt(session.getAttribute("cId").toString());
		clerkerService.orderTicket(uId,cId, fId);
		Flight oneFlight = flightService.seachFlight(fId);
		mv.addObject("oneFlight",oneFlight);
		mv.addObject("uId",uId);
		return mv;
	}
	@RequestMapping(value="payTicket/{fId}/{cId}/{uId}",produces = "text/plain;charset=utf-8")
	public ModelAndView payTicket(@PathVariable("fId") int fId ,@PathVariable("cId") int cId,@PathVariable("uId") int uId) {
		ModelAndView mv = new ModelAndView("/clerker/pay");
		mv.addObject("fId",fId);
		mv.addObject("cId",cId);
		mv.addObject("uId",uId);
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
	@RequestMapping(value = "/cbookinglist",produces = "text/plain;charset=utf-8")
	public ModelAndView findbooking() {
		ModelAndView mv = new ModelAndView("clerker/cbookinglist");
		List<Booking> b = clerkerService.findBooking();
		mv.addObject("b",b);
		return mv;
	}
	@RequestMapping(value = "/search",produces = "text/plain;charset=utf-8")
	public ModelAndView getFlight(HttpServletRequest request) {
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
		return mv;
	}
	@RequestMapping(value="/gaiqian/{bookId}",produces = "text/plain;charset=utf-8")
	public ModelAndView gaiqian(@PathVariable("bookId") int bookId) {
		ModelAndView mv = new ModelAndView("clerker/gaiqian");
		List<Booking> b = clerkerService.findBooking(bookId);
		mv.addObject("b",b);
		return mv;
	}
	@RequestMapping(value = "/gaiqianlist/{bookId}" ,produces = "text/plain;charset=utf-8")
	public ModelAndView getFlight1(HttpServletRequest request,@PathVariable("bookId") int bookId) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String from = request.getParameter("from");
		String to = request.getParameter("to");		
		String time = request.getParameter("time");
		System.out.println(time);
		ModelAndView mv = new ModelAndView("clerker/gaiqianlist");
		List<Flight> f = clerkerService.seachFlight(from, to);
		List<Booking> b = clerkerService.findBooking(bookId);
		mv.addObject("f",f);
		mv.addObject("b",b);
		mv.addObject("time", time);
		return mv;
	}
	@RequestMapping(value="/cbookinglist1",produces = "text/plain;charset=utf-8")
	public ModelAndView alter(HttpServletRequest request) {
		int fId1 =Integer.parseInt(request.getParameter("fId1"));
		int uId =Integer.parseInt(request.getParameter("uId"));
		int fId2 =Integer.parseInt(request.getParameter("fId2"));
		System.out.println(fId1);
		System.out.println(uId);
		System.out.println(fId2);
		clerkerService.endorseTicket(uId, fId1, fId2);
		ModelAndView mv = new ModelAndView("clerker/cbookinglist");
		List<Booking> b = clerkerService.findBooking();
		mv.addObject("b",b);
		return mv;
	}
	@RequestMapping(value="/success/{fId}/{cId}/{uId}",produces = "text/plain;charset=utf-8")
	public ModelAndView pay(@PathVariable("fId") int fId ,@PathVariable("cId") int cId,@PathVariable("uId") int uId) {
		ModelAndView mv = new ModelAndView("clerker/success");
		clerkerService.pay(uId,cId, fId);
		clerkerService.reduceTicket(fId);
		clerkerService.drawerTicket(uId,cId, fId);
		return mv;
	}
	@RequestMapping(value="/success/{uId}/{fId}",produces = "text/plain;charset=utf-8")
	public ModelAndView refundTicket(@PathVariable("uId") int uId,@PathVariable("fId") int fId) {
		ModelAndView mv = new ModelAndView("clerker/refundsuccess");
		clerkerService.refundTicket(uId, fId);
		return mv;
	}
}
