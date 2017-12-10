package Entity;

import java.io.Serializable;

public class Emp implements Serializable {
	private Integer empno;
	private String name;
	private String job;
	private float sal;
	
	public Integer getEmpno(){
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public float getSal() {
		return sal;
	}

	public void setSal(float sal) {
		this.sal = sal;
	}

	


}
