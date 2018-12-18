package com.ssh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
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
	
	private Session session;
		
	@Autowired
    public EmpDaoImpl(SessionFactory sessionFactory) {
        this.template = new HibernateTemplate(sessionFactory);
        session = sessionFactory.openSession();
    }

	@Override
	public List<Emp> getEmpList() {
		try {
			Query query =session.createQuery("from Emp");
			List<Emp> list = query.list();
			return list;
		} catch (Exception e) {
			return new ArrayList<Emp>();
		}
		
	}

	@Override
	public Emp getEmpById(int id) {
		Emp emp = new Emp();
		try {
			Query query =session.createQuery("from Emp where id=?");
			query.setParameter(0, id);
			List<Emp> list = query.list();
			if(list!=null){
				if(list.size()>0){
					return list.get(0);
				}
			}
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
