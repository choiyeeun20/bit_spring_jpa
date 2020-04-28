package com.jse2.web.admin;

public interface MemberService {
	public void add(Member member);
	public Member[] list();
	public Member[] searchByName(String name);
	public Member detail(String userid);
	public int count();
	public int count(String name);
	public boolean login(Member member);
	public void update(Member member);
	public void delete(Member member);
}
