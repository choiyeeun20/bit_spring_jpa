package com.jse2.web.user;

import java.util.List;

public interface UserService {
	public void add(User user);
	public List<User> list();
	public User detail(String userid);
	public int count();
	public User login(User user);
	public boolean update(User user);
	public boolean delete(String userid);
}
