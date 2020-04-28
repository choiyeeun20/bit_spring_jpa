package com.jse2.web.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;



import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	
	public final static String FILE_PATH = "C:\\Users\\bit\\spring_workspace\\jse\\src\\main\\resources\\static\\user\\";
	
	@Override
	public void add(User user) {
		try {
			File file = new File(FILE_PATH+"list.txt");
			@SuppressWarnings("resource")
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
			bufferedWriter.write(user.toString());
			bufferedWriter.newLine();
			bufferedWriter.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public List<User> list() {
		List<User> list = new ArrayList<>();
		List<String> userList = new ArrayList<>();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH+"list.txt"));
			String message = "";
			while((message = bufferedReader.readLine())!=null) {
				userList.add(message);
			}
			bufferedReader.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		User user = null;
		for(int i = 0; i < userList.size() ; i++) {
			user = new User();
			String[] arr = userList.get(i).split(",");
			user.setName(arr[0]);
			user.setUserid(arr[1]);
			user.setPassword(arr[2]);
			user.setAddress(arr[3]);
			user.setSsn(arr[4]);
			list.add(user);
		}
		return list;
	}
	
	@Override
	public User detail(String userid) {
		return null;
	}

	@Override
	public int count() {
		return 0;
	}

	@Override
	public User login(User user) {
		return null;
	}

	@Override
	public boolean update(User user) {
		return true;
	}

	@Override
	public boolean delete(String userid) {
		return true;
	}

	@Override
	public boolean searchID(String userid) {
		List<User> list = list();
		boolean result = false;
		for(int i = 0; i < list.size(); i++) {
			if(userid.equals(list.get(i).getUserid())) {
				result = true;
			}
		}
		return !result;
	}

}

