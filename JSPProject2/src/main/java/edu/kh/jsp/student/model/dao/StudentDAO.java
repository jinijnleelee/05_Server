package edu.kh.jsp.student.model.dao;

import java.io.FileInputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.kh.jsp.student.model.vo.Student;

public class StudentDAO {
	//필드
	//jdbC 객체를 참조하기 위한 참조 변수 선언 
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private Properties prop;
	//생성자 
	
	public StudentDAO() {
		//StudentDAO 객체 생성시
		//student-sql.xml 파일을 읽어와야하는데 
		//우리는 /edu/kh/jsp/sql 에 넣어있어서 그냥 student-sql.xml이라고 하면 못알아들음.
		//그래서 filePath라는곳에 변수로 넣어서 getResource라는 객체에 넣어서 getPath 해줌
		
		try {
			String filePath =  
					StudentDAO.class.getResource("/edu/kh/jsp/sql/student-sql.xml").getPath();
		//그래서 
			prop = new Properties();
			
			prop.loadFromXML(new FileInputStream(filePath));
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Student> selectAll(Connection conn)throws Exception{
		//결과 저장용 변수 선언 
		List<Student> stdList = new ArrayList<>();
		
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
			String studentAddress = rs.getString("STUDENT_ADDRESS");
			String departmentName = rs.getString("DEPARTMENT_NAME");
					
			stdList.add(
				new Student(studentNo,studentName,studentAddress,departmentName)
			);
				
			}
			
		}finally {
			
		}
		return stdList;
	}

}
