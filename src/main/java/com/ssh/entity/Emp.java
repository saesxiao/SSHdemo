package com.ssh.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="emp")
public class Emp {
	@Id
    @GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "native") //自定义主键生成策略 generator = name
    private int id;			// 职员ID
	
    @Column(name = "ename",length = 15)
    private String ename;	// 职员姓名
    
    @Column(name = "salary",length = 100)
    private double salary;	// 职员工资
    
    @Column(name = "age",length = 100)
    private int age;		// 职员工资

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", ename=" + ename + ", price=" + salary
				+ ", age=" + age + "]";
	}
    
    


}
