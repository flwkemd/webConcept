package vo;

public class EmployeeVo {
	private int emp_id;
	private String fir_name, dept_id;
	private DepartmentVo dvo;
	
	
	
	public DepartmentVo getDvo() {
		return dvo;
	}
	public void setDvo(DepartmentVo dvo) {
		this.dvo = dvo;
	}
	public int getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}
	public String getFir_name() {
		return fir_name;
	}
	public void setFir_name(String fir_name) {
		this.fir_name = fir_name;
	}
	public String getDept_id() {
		return dept_id;
	}
	public void setDept_id(String dept_id) {
		this.dept_id = dept_id;
	}

	

}