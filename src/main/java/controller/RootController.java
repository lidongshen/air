
package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RootController {

	@RequestMapping("/rindex")
	public String rindex(){
		return "manager/rindex";
	}
	
	@RequestMapping("/checksession")
	@ResponseBody
	public String checkSession(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession(false);
		if(session.getAttribute("rname")==null) {
			return "no";
		}
		return "ok";
	}
	
	@RequestMapping("/exitsession")
	@ResponseBody
	public String exitSession(HttpServletRequest request,HttpServletResponse response){
		HttpSession session = request.getSession(false);
		session.invalidate();
		return "ok";
	}
	
	
	@RequestMapping("/getrname")
	@ResponseBody
	public String getName(HttpServletRequest request,HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		String rname = (String)session.getAttribute("rname");
		return rname;
	}
	
	
	@RequestMapping("/welcome")
	public String welcome(){
		return "manager/welcome";
	}
	
	
}

