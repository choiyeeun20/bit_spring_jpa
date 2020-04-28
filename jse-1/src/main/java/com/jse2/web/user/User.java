package com.jse2.web.user;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
	String name, userid, password, ssn, address, email, profile, registerDate;
	
	@Override
	public String toString() {
		return String.format("%s,%s,%s,%s,%s", name,userid,password,address,ssn);
	}
}
