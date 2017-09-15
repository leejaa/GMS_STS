package com.gms.web.command;



import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.gms.web.constant.Extension;
import com.gms.web.constant.Path;
import com.gms.web.member.MemberDTO;

import lombok.Data;


@Data @Component @Lazy
public class CommandDTO{
	protected String dir,startRow,endRow,page,column,search,member_id,password,action,pageNumber,view;
	protected MemberDTO member;
	public void setPageNumber(String pageNumber) {
		this.pageNumber =(pageNumber==null)?"1":pageNumber;
	}
	
	public void setAction(String action) {
		this.action =(action==null)?"move":action;
	}
	
	public void process() {
		this.view=(dir.equals("/common"))?"/WEB-INF/view/common/main.jsp":
		Path.VIEW+dir+Path.SEPARATOR+page+Extension.JSP+"?pageNumber="+this.pageNumber+"&action="+this.action;
		System.out.println("이동페이지 : "+this.view);
	}

	
}
