package controller;

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
	
	@RequestMapping("/corder")
	@ResponseBody
	public String corder(HttpServletRequest request) {
		HttpSession session=request.getSession(true);
		String fid = request.getParameter("fId");
		int fId = Integer.parseInt(fid);
		int cId=Integer.parseInt(session.getAttribute("cId").toString());
		System.out.println(cId+"-"+fId);
		return "ok";
	}/*@RequestMapping(value = "/corderTicket/{fId}",produces = "text/plain;charset=utf-8")
	public ModelAndView seachFindOrder(HttpSession session,@PathVariable("fId") int fId) {
		int cId = (int) session.getAttribute("cId");
		System.out.println(cId);
		System.out.println(fId);
		ModelAndView mv = new ModelAndView("clerker/corderTicket");
		List<Booking> f = clerkerService.findBooking(cId, fId);
		mv.addObject("f",f);
		return mv;
	} */
	
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
	
	
}
