package com.jse2.web.admin;

import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

	private Member[] members;
	private int count;

	public MemberServiceImpl() {
		members = new Member[5];
		count = 0;
	}

	@Override
	public void add(Member member) {
		members[count] = member;
		count++;
	}

	@Override
	public Member[] list() {
		return members;
	}

	@Override
	public Member[] searchByName(String name) {
		Member[] returnMembers = null;
		int num = count(name);
		if (num != 0) {
			returnMembers = new Member[num];
			int j = 0;
			for (int i = 0; i < count; i++) {
				if (name.equals(members[i].getName())) {
					returnMembers[j] = members[i];
					j++;
				}
				if (num == j) {
					break;
				}
			}
		}
		return returnMembers;
	}

	@Override
	public Member detail(String userid) {
		Member returnMember = null;
		for (int i = 0; i < count; i++) {
			if (userid.equals(members[i].getUserid())) {
				returnMember = members[i];
				break;
			}
		}
		return returnMember;
	}

	@Override
	public int count() {
		return count;
	}

	@Override
	public int count(String name) {
		int num = 0;
		for (int i = 0; i < count; i++) {
			if (name.equals(members[i].getUserid())) {
				num++;
			}
		}
		return num;
	}

	@Override
	public boolean login(Member member) {
		boolean result = false;
		for (int i = 0; i < count; i++) {
			if (member.getUserid().equals(members[i].getUserid())
					&& member.getPassword().equals(members[i].getPassword())) {
				result = true;
				break;
			}
		}
		return result;
	}

	@Override
	public void update(Member member) {
		for (int i = 0; i < count; i++) {
			if (member.getUserid().equals(members[i].getUserid())) {
				members[i].setPassword(member.getPassword());
				break;
			}
		}
	}

	@Override
	public void delete(Member member) {
		for (int i = 0; i < count; i++) {
			if (member.getUserid().equals(members[i].getUserid())
					&& member.getPassword().equals(members[i].getPassword())) {
				members[i] = members[count-1];
				members[count-1] = null;
				count--;
				break;
			}
		}
	}

}
