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
		return Integer.toString((findAll().size()!=0) ? 1000+findAll().size() : 1000);
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
	public Admin login(Admin admin) {
		return (loginChecker(admin)) ? findOne(admin.employNumber) : null;
	}
	
	private boolean loginChecker(Admin admin) {
		Admin returnAdmin = findOne(admin.getName());
		return ((returnAdmin)!=null)? 
				(admin.getPassword().equals(returnAdmin.getPassword()) ? true : false) 
				: false;
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
