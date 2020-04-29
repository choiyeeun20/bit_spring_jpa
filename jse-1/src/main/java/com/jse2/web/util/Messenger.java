package com.jse2.web.util;

public enum Messenger {
	SUCCESS, FAIL, FILE_READ_ERROR;
	
	@Override
	public String toString() {
		String returnString = "";
		switch(this) {
		case FILE_READ_ERROR:
			returnString = "파일 읽기에서 에러 발생";
			break;
		default:
			break;
		}
		return returnString;
	}
}
