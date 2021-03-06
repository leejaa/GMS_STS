package com.gms.web.grade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("grade")
public class GradeController {

	private static final Logger logger = LoggerFactory.getLogger(GradeController.class);
	
	@RequestMapping("/move_{page}")
	public String goPage(Model model,@PathVariable String page) {
		logger.info("move_"+page+" 진입..");
		return "grade:grade/"+page+".tiles";
	}
}
