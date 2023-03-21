package edu.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/scope")//무조건 절대경로 방식으로 요청 주소 작성
public class ScopeServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/el/scope.jsp");
		
		//1. page -> JSP에서만 사용가능
		//PageContext  추상 클래스 이용
		
		//2. request
		req.setAttribute("message", "request scope에 저장된 메서지 입니다.");
		
		//3. session
		//1) HTTPSession 객체 얻어오기
		HttpSession session = req.getSession();
		//2) session scope로 값 세팅하기 
		//*page,request,session,application은 모두 사용법이 동일
		session.setAttribute("sessionValue", "999");
		
		
		//4.application
		//1)ServletContext 객체 얻어오기
		ServletContext application = req.getServletContext();
		//2) application 범위로 값 세팅 
		application.setAttribute("appValue", "애플리케이션");
		//내장객체 우선순위확인
		req.setAttribute("str","reqeset scope");
		session.setAttribute("str","sessio scope");
		application.setAttribute("str","application scope");
		
		
		dispatcher.forward(req, resp);
		
	}

}
