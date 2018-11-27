package com.ssh.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ssh.entity.Emp;
import com.ssh.service.EmpService;

@Component("EmpAction")
@Scope("prototype")
public class EmpAction extends ActionSupport implements ModelDriven<Emp>{
	/**
	 * 序列
	 */
	private static final long serialVersionUID = 7795875925039980991L;
	
	// Struts 传递参数 需手动化实例 再注入
	private Emp emp = new Emp();  //手动实例化
	@Override
	public Emp getModel() {
		return emp;  //返回实例   
	}
	
	
	@Autowired
	private EmpService service;
	
	public String getEmpList(){
		ActionContext text = ActionContext.getContext();
		Map<String, Object> session = text.getSession();
		List<Emp> list=service.getEmpList();
		session.put("empList", list);
		return "EmpList";
	}
	
	
	public String toAddPage(){
		return "addPage";
	}
	
	public String saveEmp(){
		try {
			service.saveEmp(emp);
			return "addEmp";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String toUptPage(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		Emp emp = service.getEmpById(id);
		ActionContext text = ActionContext.getContext();
		Map<String, Object> session = text.getSession();
		session.put("uemp", emp);
		return "uptPage";
	}
	
	public String updateEmp(){
		try {
			service.updateEmp(emp);
			return "uptEmp";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String deleteEmp(){
		HttpServletRequest request = ServletActionContext.getRequest();
		int id = Integer.parseInt(request.getParameter("id"));
		try {
			service.deleteEmp(id);
			return "delEmp";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
