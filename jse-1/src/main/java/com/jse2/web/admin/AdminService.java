package com.jse2.web.admin;

public interface AdminService {
	public void add(Admin member);
	public Admin[] list();
	public Admin[] searchByName(String name);
	public Admin detail(String userid);
	public int count();
	public int count(String name);
	public boolean login(Admin member);
	public void update(Admin member);
	public void delete(Admin member);

}
