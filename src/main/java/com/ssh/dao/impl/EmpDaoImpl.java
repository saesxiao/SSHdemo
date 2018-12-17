package com.ssh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.ssh.dao.EmpDao;
import com.ssh.entity.Emp;

@Repository("EmpDao")
public class EmpDaoImpl implements EmpDao {
	

	private HibernateTemplate template;
	
	@SuppressWarnings("unused")
	private Session session;
		
	@Autowired
    public EmpDaoImpl(SessionFactory sessionFactory) {
        this.template = new HibernateTemplate(sessionFactory);
        session = sessionFactory.openSession();
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Emp> getEmpList() {
		List<Emp> list= new ArrayList<>();
		try {
			list = (List<Emp>) template.find("from Emp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public Emp getEmpById(int id) {
		Emp emp = new Emp();
		try {
			emp = template.get(Emp.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public void saveEmp(Emp emp) {
		try {
			template.save(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void updateEmp(Emp emp) {
		try {
			template.update(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteEmp(int id) {
		Emp emp = getEmpById(id);
		try {
			template.delete(emp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
