package com.jse2.web.user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	public final static String FILE_PATH = "C:\\Users\\bit\\spring_workspace\\jse\\src\\main\\resources\\static\\user\\";
	private Map<String, Object> map;
	
	public UserServiceImpl() {
		map = new HashMap<>();
	}
	
	@Override
	public void add(User user) {
		map.put(user.getUserid(), user);
	}


	@Override
	public List<User> list() {
		List<User> list = new ArrayList<>();
		@SuppressWarnings("rawtypes")
		Set set = map.entrySet();
		@SuppressWarnings("rawtypes")
		Iterator iterator = set.iterator();
		while(iterator.hasNext()) {
			@SuppressWarnings("unchecked")
			Map.Entry<String, User> entry = (Entry<String, User>) iterator.next();
			list.add(entry.getValue());
		}
		
		return list;
	}
	
	@Override
	public User detail(String userid) {
		return (User) map.get(userid);
	}

	@Override
	public int count() {
		return map.size();
	}

	@Override
	public User login(User user) {
		User returnUser = null;
		if(map.containsKey(user.getUserid())) {
			User detailUser = detail(user.getUserid());
			if(detailUser.getPassword().equals(user.getPassword())) {
				returnUser = detailUser;
			}
		}
		return returnUser;
	}

	@Override
	public boolean update(User user) {
		map.replace(user.getUserid(), user);
		return true;
	}

	@Override
	public boolean delete(String userid) {
		map.remove(userid);
		return true;
	}
}

