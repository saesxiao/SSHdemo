package com.ssh.dao;

import java.util.List;

import com.ssh.entity.Emp;

public interface EmpDao {
	
	public List<Emp> getEmpList();
	
	public Emp getEmpById(int id);
	
	public void saveEmp(Emp emp);
	
	public void updateEmp(Emp emp);
	
	public void deleteEmp(int id);

}
