package com.jse2.web.user;

import java.util.List;

public interface UserService {

	public void signUp(User user);

	public List<User> fineAll();

	public User findOne(String name);

	public void modify(User user);

	public void remove(User user);
}
