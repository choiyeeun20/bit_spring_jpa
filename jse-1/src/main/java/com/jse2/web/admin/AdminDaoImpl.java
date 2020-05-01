package com.jse2.web.admin;

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
public class AdminDaoImpl implements AdminDao {
	
	
	@Override
	public void insert(Admin admin) {
		try {
			@SuppressWarnings("resource")
			BufferedWriter bufferedWriter = new BufferedWriter(
											new FileWriter(
											new File(Data.ADMIN_PATH.toString()+Data.LIST+Data.CSV), true));
			bufferedWriter.write(admin.toString());
			bufferedWriter.newLine();
			bufferedWriter.flush();
			System.out.println(admin);
		} catch(Exception e) {
			System.out.println(Messenger.FILE_INSERT_ERROR);
		}
	}

	@Override
	public List<Admin> selectAll() {
		List<Admin> list = new ArrayList<>();
		List<String> stringList = new ArrayList<>();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(Data.ADMIN_PATH.toString()+Data.LIST+Data.CSV));
			String msg = "";
			while((msg=bufferedReader.readLine())!=null) {
				stringList.add(msg);
			}
			bufferedReader.close();
		} catch(Exception e) {
			System.out.println(Messenger.FILE_SELECT_ERROR);
		} finally {
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
		}
		return list;
	}

	@Override
	public Admin selectOne(String employNumber) {
		Admin admin = null;
		try {
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(new FileReader(Data.ADMIN_PATH.toString()+Data.LIST+Data.CSV));
			String msg = "";
			while((msg = bufferedReader.readLine())!=null) {
				String[] strings = msg.split(",");
				if(strings[1].equals(employNumber)) {
					admin = new Admin();
					admin.setName(strings[0]);
					admin.setEmployNumber(strings[1]);
					admin.setPassword(strings[2]);
					admin.setPosition(strings[3]);
					admin.setEmail(strings[4]);
					admin.setPhoneNumber(strings[5]);
					admin.setProfile(strings[6]);
					admin.setRegisterDate(strings[7]);
				}
			}
		} catch(Exception e) {
			System.out.println(Messenger.FILE_SELECT_ERROR);
		}
		return admin;
	}

	@Override
	public void update(Admin admin) {
		try {
			
		} catch(Exception e) {
			
		}
	}

	@Override
	public void delete(Admin admin) {
		try {
			
		} catch(Exception e) {
			
		}
	}

}
