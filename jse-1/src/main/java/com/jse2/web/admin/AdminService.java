package com.jse2.web.admin;

import java.util.List;

public interface AdminService {
	public void register(Admin admin);
	public List<Admin> findAll();
	public Admin findOne(String employNumber);
	public void modify(Admin admin);
	public void remove(Admin admin);
}
