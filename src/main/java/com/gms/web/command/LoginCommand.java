package com.gms.web.command;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;
@Component
public class LoginCommand extends CommandDTO{
	@Getter @Setter
	protected String member_id,password;
}
