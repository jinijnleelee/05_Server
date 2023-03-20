package edu.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signUp")
public class signUpServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		req.setCharacterEncoding("UTF-8");
		//전달받은 파라미터 (input 태그의 값)를 얻어와 변수에 저장
		//파라미터는 모두 String 타입
		String id = req.getParameter("inputId");
		String pw = req.getParameter("inputPw");
		String Na = req.getParameter("inputName");
		String Em = req.getParameter("inputEmail");
		

		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/signUpResult.jsp");
		
		dispatcher.forward(req, resp);
	}
	
	
	
	
	
	

}
