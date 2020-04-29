package com.jse2.web.user;

import java.util.List;

public interface UserDao {

	public void insert(User user);

	public List<User> selectAll();

	public User selectOne(String userid);

	public void update(User user);

	public void delete(User user);

}
