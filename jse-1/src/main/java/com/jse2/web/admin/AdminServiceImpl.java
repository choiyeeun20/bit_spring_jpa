package com.jse2.web.admin;

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
public class AdminServiceImpl implements AdminService {
	
	
	@Override
	public void register(Admin admin) {
		try {
			File file = new File(Data.ADMIN_PATH.toString()+Data.LIST.toString()+Data.CSV.toString());
			@SuppressWarnings("resource")
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true));
			bufferedWriter.write(admin.toString());
			bufferedWriter.newLine();
			bufferedWriter.flush();
		} catch(Exception e) {
			System.out.println(Messenger.FILE_READ_ERROR);
		}
	}

	@Override
	public List<Admin> findAll() {
		List<Admin> list = new ArrayList<>();
		List<String> stringList = new ArrayList<>();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(Data.ADMIN_PATH.toString()+Data.LIST+Data.CSV));
			String message = "";
			while((message=bufferedReader.readLine())!=null) {
				stringList.add(message);
			}
			bufferedReader.close();
		} catch(Exception e) {
			System.out.println(Messenger.FILE_READ_ERROR);
		}
		Admin admin = null;
		for(int i = 0; i < stringList.size(); i++) {
			String[] strings = stringList.get(i).split(",");
			admin = new Admin();
			admin.setName(strings[0]);
			admin.setEmployNumber(strings[1]);
			admin.setPassword(strings[2]);
			admin.setPosition(strings[3]);
			admin.setEmail(strings[4]);
			admin.setPhoneNumber(strings[5]);
			admin.setProfile(strings[6]);
			admin.setRegisterDate(strings[7]);
			list.add(admin);
		}
		return list;
	}

	@Override
	public Admin findOne(String employNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modify(Admin admin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Admin admin) {
		// TODO Auto-generated method stub
		
	}
	
	

}
