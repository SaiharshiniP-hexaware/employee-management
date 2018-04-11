package com.hexa.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "hexa_dept")
public class Dept {

	@Id
	@Column(name = "did")
	private int deptId;


	@Column(name = "dname", length = 20)
	private String deptName;
	// @OneToMany(mappedBy="dept")
	@OneToMany(mappedBy = "dept", fetch = FetchType.LAZY) // ---TO FETCH DATA FAST NOT LAZILY
	private Set<Emp> elist;

	public Set<Emp> getElist() {
		return elist;
	}

	public void setElist(Set<Emp> elist) {
		this.elist = elist;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return deptId +" " + deptName;


}
}
