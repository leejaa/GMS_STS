package com.gms.web.member;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


import lombok.Data;

@Data @Lazy @Component
public class SubjectDTO {
	private String subjId,title,majorId;

}
