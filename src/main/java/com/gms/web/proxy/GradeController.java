package com.gms.web.proxy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/grade.do")
public class GradeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("grade Controller 진입");
		/*Separator.init(request);
		switch (request.getParameter("action")) {
		case Action.MOVE:
			DispatcherServlet.send(request, response);
			break;

		default:
			break;*/
		}
	}


