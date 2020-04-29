package com.jse2.web.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.jse2.web.util.Data;
import com.jse2.web.util.Messenger;

@Service
public class UserServiceImpl implements UserService {

	@Override
	public void signUp(User user) {
		try {
			File file = new File(Data.USER_PATH.toString()+Data.LIST.toString()+Data.CSV.toString());
			@SuppressWarnings("resource")
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
			bufferedWriter.write(user.toString());
			bufferedWriter.newLine();
			bufferedWriter.flush();
		} catch(Exception e) {
			System.out.println(Messenger.FILE_READ_ERROR);
		}
	}

	@Override
	public List<User> fineAll() {
		List<User> list = new ArrayList<>();
		List<String> stringList = new ArrayList<>();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(Data.USER_PATH.toString()+Data.LIST.toString()+Data.CSV.toString()));
			String msg = "";
			while((msg=bufferedReader.readLine())!=null) {
				stringList.add(msg);
			}
			bufferedReader.close();
		} catch (Exception e) {
			System.out.println(Messenger.FILE_READ_ERROR);
		}
		User user = null;
		for(int i = 0; i < stringList.size(); i++) {
			user = new User();
			String[] strings = stringList.get(i).split(",");
			user.setName(strings[0]);
			user.setUserid(strings[1]);
			user.setPassword(strings[2]);
			user.setSsn(strings[3]);
			user.setAddress(strings[4]);
			user.setEmail(strings[5]);
			user.setProfile(strings[6]);
			user.setRegisterDate(strings[7]);
			list.add(user);
		}
		return list;
	}

	@Override
	public User findOne(String userid) {
		return null;
	}

	@Override
	public void modify(User user) {
		
	}

	@Override
	public void remove(User user) {
		
	}

}

