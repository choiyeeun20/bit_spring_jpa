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
@RequestMapping("/member")
public class MemberController {
	@Autowired MemberService memberService;
	
	@PostMapping("/join")
	public Messenger add(@RequestBody Member member) {
		int current = memberService.count();
		memberService.add(member);
		return (memberService.count()==(current+1)) ? Messenger.SUCCESS : Messenger.FAIL;
	}
	
	@PostMapping("/login")
	public Messenger login(@RequestBody Member member) {
		return (memberService.login(member)) ? Messenger.SUCCESS : Messenger.FAIL;
	}
	
	@GetMapping("/list")
	public Member[] list() {
		return memberService.list();
	}
	
	@GetMapping("/detail")
	public Member detail(@RequestBody String userid) {
		memberService = new MemberServiceImpl();
		return memberService.detail(userid);
	}
	
	@GetMapping("/count")
	public int count() {
		memberService = new MemberServiceImpl();
		return memberService.count();
	}
	
	@PutMapping("/update")
	public Member update(@RequestBody Member member) {
		memberService = new MemberServiceImpl();
		memberService.update(member);
		return member;
	}
	
	@DeleteMapping("/delete")
	public Member delete(@RequestBody Member member) {
		memberService = new MemberServiceImpl();
		memberService.delete(member);
		return member;
	}
}
