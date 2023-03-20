package edu.kh.jsp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		
		//post 방식 요청 데이터 문자 인코딩 처리
		req.setCharacterEncoding("UTF-8");
		
		//전달받은 파라미터 (input 태그의 값)를 얻어와 변수에 저장
		//파라미터는 모두 String 타입
		String id = req.getParameter("inputId");
		String pw = req.getParameter("inputPw");
		
		//파라미터 잘 얻어왔는지 확인 
		System.out.println(id);
		System.out.println(pw);
		
		String result = null;
		
		if(id.equals("user01") && pw.equals("pass01!")	) {
			result = "로그인 성공";
			
		}else{
			result = "아이디 또는 비밀번호 불일치";
			
		}
		
		// *********************************************
		
		//**JSP로 응답하기 **
		
		// Dispatcher : 필요한 정보를 제공하는 자 == 발송자
		// 위임 : 넘겨주다 
		
		// forward : 보내다, 전달하다 , 전송하다
		
		// * 응답 화면을 만드는 Servlet의 일을
		// 좀 더 효율적으로 처리할 수 있는 JSP에게 넘겨줄 예정
		
		// RequestDisparcher : 
		//Servlet -> JSp로
		// HTTPServletRequest 객체 ,  HTTPServletResponse 객체를
		//발송(위임)하는 역할을 객체
		// -> 정확히는 요청에 대한 응답화면을 만들어
		// 클라이언트에게 출력하는 역할을 위임하는 객체
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/loginResult.jsp");
		
		//req.getRequestDispatche("JSP 경로")
		// - HTTPServletResponse 객체가 생성될때
		// 내부에 자동으로 요청을 위임하는 객체(RequestDisparcher)를 생성하는 방법을 초함하고 있음
		//*JSP경로 작성규칙*
		//--webapp폴더 기준으로 JSP파일까지의 모든 경로 작성
		
		
		// * JSP에게 전달될 예정인 req 객체에 result 변수값 담아서 같이 전달
		//req.setAttribute(String key, Object value)
		//-> value는 모든 객체(타입 상관없음)
		//Attribute : 속성 ==데이터(값)
		req.setAttribute("r",result);
							//Object로 업캐스팅 되어있는 상태
		
		// -forward는 페이지 이동이 아닌 
		//servlet의 역할 중 응답화면 출력 역할을 분업한 jsp에게
		//req.resp를 전달만 하는 것.
		//-> JSP응답을 대신 할 뿐이다.
		
		//결론 : 페이지 이동 X -> 주소창의 요청 주소도 변하지 않는다 
		
		dispatcher.forward(req, resp);
		//req - 파라미터
		//resp - 응답용 스트림
		
		
		
	}
	

}
