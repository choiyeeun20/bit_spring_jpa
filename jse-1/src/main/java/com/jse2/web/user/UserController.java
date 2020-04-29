package com.jse2.web.user;

import java.util.List;

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
@RequestMapping("/users")
public class UserController {

	@Autowired UserService userService;
	
	@PostMapping("")
	public Messenger post(@RequestBody User user) {
		userService.signUp(user);
		return Messenger.SUCCESS;
	}
	
	@GetMapping("")
	public List<User> list(){
		return userService.fineAll();
	}
	
	@GetMapping("/{userid}")
	public User detail(@RequestBody String userid) {
		return userService.findOne(userid);
	}
	
	@PutMapping("/{userid}")
	public Messenger put(@RequestBody User user) {
		userService.modify(user);
		return Messenger.SUCCESS;
	}
	
	@DeleteMapping("/{userid}")
	public Messenger delete(@RequestBody User user) {
		userService.remove(user);
		return Messenger.SUCCESS;
	}
	
}
