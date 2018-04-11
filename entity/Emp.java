package com.hexa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "hexa_employee")
public class Emp {

	@Id
	@NotNull(message="Employee Id is mandatory")
	@Column(name = "emp_id")
	@Min(value=1000,message="minimum value must be 1001 for employee id")
	private Integer empId;
    
	@Column(name = "emp_name")
	@NotEmpty(message="name is mandatory")
	@Size(min=3,max=20,message="name can contain 3 to 20 alphabets")
	@Pattern(regexp="[a-zA-Z]+",message="name must contain only alphabets")
	private String empName;
    
	@Column(name = "emp_pwd")
	@NotEmpty(message="name is mandatory")
	@Size(min=3,max=20,message="name can contain 3 to 20 alphabets")
	private String pwd;

	
	@Column(name = "emp_img")
	private String img;

	@Column(name = "emp_sal")
	@NotNull(message="salary is mandatory")
	@Min(value=5000,message="minimum value must be 5000 for salary")
	private Double sal;

	@ManyToOne
	@JoinColumn(name = "dept_id", referencedColumnName = "did")
	private Dept dept;

	public Dept getDept() {
		return dept;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Double getSal() {
		return sal;
	}

	public void setSal(Double sal) {
		this.sal = sal;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return empId+" "+empName+" "+sal;
	}


}
