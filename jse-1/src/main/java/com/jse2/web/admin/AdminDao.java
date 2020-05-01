package com.jse2.web.admin;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface AdminDao {

	public void insert(Admin admin);

	public List<Admin> selectAll();

	public Admin selectOne(String employNumber);

	public void update(Admin admin);

	public void delete(Admin admin);

}
