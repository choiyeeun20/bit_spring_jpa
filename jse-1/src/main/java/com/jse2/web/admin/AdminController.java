package com.jse2.web.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jse2.web.util.Messenger;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired AdminService adminService;
	
	@PostMapping("/join")
	public Messenger add(@RequestBody Admin admin) {
		int current = adminService.count();
		adminService.add(admin);
		return (adminService.count()==(current+1)) ? Messenger.SUCCESS : Messenger.FAIL;
	}
	
	@PostMapping("/login")
	public Messenger login(@RequestBody Admin admin) {
		return (adminService.login(admin)) ? Messenger.SUCCESS : Messenger.FAIL;
	}
	
	@GetMapping("/list")
	public Admin[] list() {
		return adminService.list();
	}
	
	@GetMapping("/detail")
	public Admin detail(@RequestBody String userid) {
		adminService = new AdminServiceImpl();
		return adminService.detail(userid);
	}
	
	@GetMapping("/count")
	public int count() {
		adminService = new AdminServiceImpl();
		return adminService.count();
	}
	
	@PutMapping("/update")
	public Admin update(@RequestBody Admin admin) {
		adminService = new AdminServiceImpl();
		adminService.update(admin);
		return admin;
	}
	
	@DeleteMapping("/delete")
	public Admin delete(@RequestBody Admin admin) {
		adminService = new AdminServiceImpl();
		adminService.delete(admin);
		return admin;
	}
}
