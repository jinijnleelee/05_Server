package edu.kh.jsp.student.model.vo;

public class Search {
	
	private String studentNo; // 학번
	private String studentName;// 이름
	private String departmentName;// 학과명
	private String studentAddress;// 주소
	
	public Search() {}

	public Search(String studentNo, String studentName, String departmentName, String studentAddress) {
		super();
		this.studentNo = studentNo;
		this.studentName = studentName;
		this.departmentName = departmentName;
		this.studentAddress = studentAddress;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getStudentAddress() {
		return studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	@Override
	public String toString() {
		return "SearchDepart [studentNo=" + studentNo + ", studentName=" + studentName + ", departmentName="
				+ departmentName + ", studentAddress=" + studentAddress + "]";
	}
	
	
	
	
	

}
