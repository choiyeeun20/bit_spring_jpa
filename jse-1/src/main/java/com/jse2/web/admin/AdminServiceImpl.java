package com.jse2.web.admin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

	public final static String FILE_PATH = "C:\\Users\\bit\\git\\repository2\\jse-1\\src\\main\\resources\\static\\admin\\";
	
	@Override
	public void add(Admin admin) {
		try {
			File file = new File(FILE_PATH+"adminlist.txt");
			@SuppressWarnings("resource")
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true));
			bufferedWriter.write(admin.toString());
			bufferedWriter.newLine();
			bufferedWriter.flush();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Admin> list() {
		List<Admin> list = new ArrayList<>();
		List<String> stringList = new ArrayList<>();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH+"adminlist.txt"));
			String string = "";
			while((string=bufferedReader.readLine())!=null) {
				stringList.add(string);
			}
			bufferedReader.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		Admin admin = null;
		for(int i =0; i < stringList.size(); i++) {
			admin = new Admin();
			String[] strings = stringList.get(i).split(",");
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
		return null;
	}

}
