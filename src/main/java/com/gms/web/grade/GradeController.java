package com.gms.web.grade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("grade")
public class GradeController {

	private static final Logger logger = LoggerFactory.getLogger(GradeController.class);
	
	@RequestMapping("/move_write")
	public String goWrite(Model model) {
		return "/grade/write";
	}
	
	@RequestMapping("/move_update")
	public String goUpdate(Model model) {
		return "/grade/update";
	}
	
	@RequestMapping("/move_list")
	public String goList(Model model) {
		return "/grade/list";
	}
	
	@RequestMapping("/move_delete")
	public String goDeletet(Model model) {
		return "/grade/delete";
	}
}
