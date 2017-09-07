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
		logger.info("move_write 진입..");
		return "grade:grade/write.tiles";
	}
	
	@RequestMapping("/move_update")
	public String goUpdate(Model model) {
		logger.info("move_update 진입..");
		return "grade:grade/update.tiles";
	}
	
	@RequestMapping("/move_list")
	public String goList(Model model) {
		logger.info("move_list 진입..");
		return "grade:grade/list.tiles";
	}
	
	@RequestMapping("/move_delete")
	public String goDeletet(Model model) {
		logger.info("move_delete 진입..");
		return "grade:grade/delete.tiles";
	}
}
