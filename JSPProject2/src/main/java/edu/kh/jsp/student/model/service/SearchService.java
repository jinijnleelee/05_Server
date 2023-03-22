package edu.kh.jsp.student.model.service;
import java.sql.Connection;
import java.util.List;
import static edu.kh.jsp.common.JDBCTemplate.*;
import edu.kh.jsp.student.model.dao.SearchDepartDAO;
import edu.kh.jsp.student.model.vo.Search;

public class SearchService {

	private SearchDepartDAO dao = new SearchDepartDAO();
	
	public List<Search> schdepa() throws  Exception{
		
		Connection conn = getConnection();
		
		List<Search> schList = dao.schdepa(conn);
		
		close(conn);
		
		return schList;
	}
}
