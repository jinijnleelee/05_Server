package edu.kh.jsp.student.model.dao;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jsp.student.model.vo.Search;
import edu.kh.jsp.student.model.vo.Student;

public class SearchDepartDAO {
	
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	
	public SearchDepartDAO() {
		
	
	
	
	try {
		String filePath =
				SearchDepartDAO.class.getResource("\"/edu/kh/jsp/sql/student-sql.xml\"").getPath();
	
	prop =new Properties();
	
	prop.loadFromXML(new FileInputStream(filePath));
	

	
	
	
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}

	public List<Search> schdepa(Connection conn) throws Exception{
		
		List<Search> schList = new ArrayList<>();
		
		try {
			//sql 작성하기 
			String sql = prop.getProperty("selectAll");
			//Statement 객체 생성 
			stmt = conn.createStatement();
			//sql 수행 수 결과 (ResultSet )qksghks qkerl 
			rs =stmt.executeQuery(sql);
			
			while(rs.next()) {
			String studentNo = rs.getString("STUDENT_NO");
			String studentName = rs.getString("STUDENT_NAME");
			String departmentName = rs.getString("DEPARTMENT_NAME");
			String studentAddress = rs.getString("STUDENT_ADDRESS");
			schList.add(
				new Search(studentNo,studentName,departmentName,studentAddress)
			);
				
			}
			
		}finally {
			
		}
		return schList;
	}


	
	
	
	

}
