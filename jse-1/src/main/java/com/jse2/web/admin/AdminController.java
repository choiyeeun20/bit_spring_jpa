package com.jse2.web.admin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jse2.web.util.Messenger;

@RestController
@RequestMapping("/admins")
public class AdminController {
	
	@Autowired AdminService adminService;
	
	@PostMapping("")
	public Messenger post(@RequestBody Admin admin) {
		adminService.register(admin);
		return Messenger.SUCCESS;
	}
	
	@PostMapping("/{employNumber}")
	public Map<String,Object> login(@RequestBody Admin admin){
		Map<String, Object> returnMap = new HashMap<>();
		Admin returnAdmin = adminService.login(admin);
		if(returnAdmin!=null) {
			returnMap.put("admin", returnAdmin);
			returnMap.put("messenger", Messenger.SUCCESS);
		} else {
			returnMap.put("messenger", Messenger.FAIL);
		}
		return returnMap;
	}
	
	@GetMapping("")
	public List<Admin> list(){
		return adminService.findAll();
	}
	
	@GetMapping("/{employNumber}")
	public Admin detail(@PathVariable String employNumber) {
		return adminService.findOne(employNumber);
	}
	
	@PutMapping("/{employNumber}")
	public Messenger put(@RequestBody Admin admin) {
		adminService.modify(admin);
		return Messenger.SUCCESS;
	}
	
	@DeleteMapping("/{employNumber}")
	public Messenger delete(@RequestBody Admin admin) {
		adminService.remove(admin);
		return Messenger.SUCCESS;
	}
}
