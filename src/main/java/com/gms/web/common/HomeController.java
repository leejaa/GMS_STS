package com.gms.web.common;


import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gms.web.complex.PathFactory;


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/")
	public String index(Model model,HttpSession session) {
		logger.info("welcome home....");
		session.setAttribute("path", PathFactory.create());
		
		System.out.println("path : "+session.getAttribute("path"));
		
		return "public:common/home.tiles";
	}
	
}
