package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import service.prototype.IUserService;

@Controller
@RequestMapping(value = "/user/alipay",produces = "text/plain;charset=utf-8")
public class UserAliPayController {
	
	@Autowired
	private IUserService userService;
	
	/*@RequestMapping(value="/payTicket/{fId}/{uId}",produces = "text/plain;charset=utf-8")
	public ModelAndView payTicket(@PathVariable("fId") int fId ,@PathVariable("uId") int uId) {
		ModelAndView mv = new ModelAndView("user/pay");
		System.out.println(fId);
		System.out.println(uId);
		userService.pay(uId, fId);
		return mv;
	}*/
	@RequestMapping(value="/payTicket/{fId}/{uId}",produces = "text/plain;charset=utf-8")
	public ModelAndView payTicket(@PathVariable("fId") int fId ,@PathVariable("uId") int uId) {
		ModelAndView mv = new ModelAndView("/user/alipay/alipay.trade.page.pay");
		System.out.println(fId);
		System.out.println(uId);
		userService.pay(uId, fId);
		return mv;
	}
	@RequestMapping(value = "/notify",produces = "text/plain;charset=utf-8")
	public ModelAndView notify_url() {
		ModelAndView mv = new ModelAndView("/user/index");
		return mv;
	}
	@RequestMapping(value = "/return",produces = "text/plain;charset=utf-8")
	public ModelAndView result_url() {
		ModelAndView mv = new ModelAndView("/user/airsys/user/index");
		return mv;
	}
}
