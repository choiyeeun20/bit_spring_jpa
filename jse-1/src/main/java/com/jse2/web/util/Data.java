package com.jse2.web.util;

import java.io.File;

public enum Data {
	DATA_PATH,CSV, ADMIN_LIST, USER_LIST;
	
	@Override
	public String toString() {
		String returnValue = "";
		switch(this) {
		case DATA_PATH:
			returnValue = "C:"+File.separator+"Users" +
					File.separator + "bit" + 
					File.separator + "git" + 
					File.separator + "repository2" + 
					File.separator + "jse-1" + 
					File.separator + "src" + 
					File.separator + "main" + 
					File.separator + "resources" + 
					File.separator + "static" + 
					File.separator + "resources" + 
					File.separator + "file" +
					File.separator;
			break;

		case CSV:
			returnValue = ".csv";
			break;
			
		case ADMIN_LIST:
			returnValue = "admin_list";
			break;
		
		case USER_LIST:
			returnValue = "user_list";
			break;
			
		default:
			break;
		}
		return returnValue;
	}
}
