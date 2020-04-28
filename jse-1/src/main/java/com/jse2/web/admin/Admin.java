package com.jse2.web.admin;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Admin {
	String name, employNumber, password, position, email, phoneNumber, profile, registerDate;

	@Override
	public String toString() {
		return String.format("%s,%s,%s,%s,%s,%s,%s,%s", name, employNumber, password, position, email, phoneNumber, profile, registerDate);
	}
	
}
