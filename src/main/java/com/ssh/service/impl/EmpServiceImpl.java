package com.ssh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssh.dao.EmpDao;
import com.ssh.entity.Emp;
import com.ssh.service.EmpService;


@Service("EmpService")
public class EmpServiceImpl implements EmpService {
	
	@Autowired
	private EmpDao empDao;

	@Override
	public List<Emp> getEmpList() {
		List<Emp> list = empDao.getEmpList();
		return list;
	}

	@Override
	public Emp getEmpById(int id) {
		Emp emp = empDao.getEmpById(id);
		return emp;
	}

	@Override
	public void saveEmp(Emp emp) {
		empDao.saveEmp(emp);
	}

	@Override
	public void updateEmp(Emp emp) {
		empDao.updateEmp(emp);
	}

	@Override
	public void deleteEmp(int id) {
		empDao.deleteEmp(id);
	}

}
