package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.prototype.IManagerService;

@Controller
public class LoginController {
	@Autowired
	private IManagerService ms;
	
	@RequestMapping("/rlogin")
	public String rlogin() {
		return "login/rlogin";
	}
	
	@RequestMapping("/rl")
	@ResponseBody
	public String rl(HttpServletRequest request,HttpServletResponse response) {
		String rname = request.getParameter("rname");
		String rpwd = request.getParameter("rpwd");
		int findManagerId = ms.findManagerId(rname, rpwd);
		if(findManagerId==0) {
			return "no";
		}
		HttpSession session = request.getSession(true);
		session.setAttribute("rname", rname);
		return "ok";
	}
	
	@RequestMapping("/ulogin")
	public String ulogin() {
		return "login/ulogin";
	}
	
}
