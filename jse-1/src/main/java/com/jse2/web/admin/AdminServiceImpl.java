package com.jse2.web.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired AdminDao adminDao;
	
	@Override
	public void register(Admin admin) {
		admin.setEmployNumber(createEmployNumber());
		admin.setPassword(createPassword());
		admin.setRegisterDate(currentDate());
		adminDao.insert(admin);
	}

	private String createEmployNumber() {
		List<Admin> list = findAll();
		int EmployNumber = 1000;
		if(list.size()!=0) {
			EmployNumber += list.size();
		}
		return Integer.toString(EmployNumber);
	}
	
	private String createPassword() {
		return Integer.toString((int)(Math.random()*10000)+1000);
	}
	
	private String currentDate() {
		return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
	}

	@Override
	public List<Admin> findAll() {
		return adminDao.selectAll();
	}

	@Override
	public Admin findOne(String employNumber) {
		return adminDao.selectOne(employNumber);
	}

	@Override
	public void modify(Admin admin) {
		adminDao.update(admin);
	}

	@Override
	public void remove(Admin admin) {
		adminDao.delete(admin);
	}
	
	

}
