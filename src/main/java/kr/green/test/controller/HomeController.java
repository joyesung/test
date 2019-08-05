package kr.green.test.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.green.test.service.MemberService;
import kr.green.test.vo.MemberVO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	@Autowired
	MemberService memberservice;
	
	@RequestMapping(value= "/",method = RequestMethod.GET)
	public ModelAndView mainGet(ModelAndView mv) throws Exception{
	  
	    mv.setViewName("/main/home");
	   
	    return mv;
	}

	@RequestMapping(value= "/",method = RequestMethod.POST)
	public String mainPost(MemberVO logInfo, Model model) throws Exception{
    	MemberVO user = memberservice.signin(logInfo);
    	System.out.println(user);
    	model.addAttribute("user", user);
	    return "redirect:/";
	}
	@RequestMapping(value= "/signout",method = RequestMethod.GET)
	public String signoutGet(HttpServletRequest r) throws Exception{
	  r.getSession().removeAttribute("user");
	    return "redirect:/";
	}
}
  