package com.test03;

public class Engineer extends Emp {

	private String dept;

	public Engineer() {
		// TODO Auto-generated constructor stub
	}

	public Engineer(String name, int salary) {
		super(name, salary);
		// TODO Auto-generated constructor stub
	}
	
	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return super.toString() + "\t 부서 : 기술(" + dept + ")";
	}
}
