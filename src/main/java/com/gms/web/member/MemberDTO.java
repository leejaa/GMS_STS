package com.gms.web.member;

import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


import lombok.Data;


@Data @Lazy @Component
public class MemberDTO{
	private String num,member_id,password,name,ssn,gender,regdate,subj_id,email,phone,profile,title;
	private List<?> subjects;
}
