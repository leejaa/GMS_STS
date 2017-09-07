package com.gms.web.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("common")
public class CommonController {
	private static final Logger logger = LoggerFactory.getLogger(CommonController.class);
	
	@RequestMapping("/move_home")
	public String goHome(Model model) {
		logger.info("goHome...");
		return "public:common/home.tiles";
	}
}
