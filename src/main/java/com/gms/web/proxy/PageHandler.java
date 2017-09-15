package com.gms.web.proxy;

import org.springframework.stereotype.Component;


@Component
public class PageHandler{

	public PageProxy attr(PageProxy pxy){
		
		if(pxy.getPageNumber()<=pxy.getTheNumberOfRows()/pxy.getPageSize()+1){
			if(pxy.getPageNumber() ==1){
				pxy.setStartRow("1");
				pxy.setEndRow(String.valueOf(pxy.getPageSize()));
			}else{
				pxy.setStartRow(String.valueOf((pxy.getPageNumber()-1)*pxy.getPageSize()+1));
				pxy.setEndRow(String.valueOf(pxy.getPageNumber()*pxy.getPageSize()));
			}
			
		}
		
		return pxy;
	}

}
