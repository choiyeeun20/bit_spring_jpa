package com.jse2.web.user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jse2.web.util.Data;
import com.jse2.web.util.Messenger;

@Repository
public class UserDaoImpl implements UserDao{

	@Override
	public void insert(User user) {
		try {
			@SuppressWarnings("resource")
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(Data.DATA_PATH.toString()+Data.USER_LIST+Data.CSV), true));
			bufferedWriter.write(user.toString());
			bufferedWriter.newLine();
			bufferedWriter.flush();
		} catch(Exception e) {
			System.out.println(Messenger.FILE_INSERT_ERROR);
		}
	}

	@Override
	public List<User> selectAll() {
		List<User> list = new ArrayList<>();
		List<String> stringList = new ArrayList<>();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Data.DATA_PATH.toString()+Data.USER_LIST+Data.CSV)));
			String string = "";
			while((string=bufferedReader.readLine())!=null) {
				stringList.add(string);
			}
			bufferedReader.close();
		} catch(Exception e) {
			System.out.println(Messenger.FILE_SELECT_ERROR);
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
			user.setPhoneNubmer(strings[6]);
			user.setProfile(strings[7]);
			user.setRegisterDate(strings[8]);
			list.add(user);
		}
		return list;
	}

	@Override
	public User selectOne(String userid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

}
