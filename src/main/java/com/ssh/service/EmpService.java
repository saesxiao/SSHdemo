package com.ssh.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.ssh.entity.Emp;

public interface EmpService {

	public List<Emp> getEmpList();
	
	public Emp getEmpById(int id);
	
	public void saveEmp(Emp emp);
	
	public void updateEmp(Emp emp);
	
	public void deleteEmp(int id);
}
