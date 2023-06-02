package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import domain.MemberVO;
import service.MemberService;
import service.MemberServiceImpl;

@WebServlet("/mem/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//log설정
	//private static final Logger log = LoggerFactory.getLogger(클래스명);
	private static final Logger log = LoggerFactory.getLogger(MemberController.class);
	private RequestDispatcher rdp;
	private MemberService msv;
	private int isOk;
	private String destPage;
       
    public MemberController() {
        msv = new MemberServiceImpl();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// characterEncoding 설정 / contentType / uri
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String uri = request.getRequestURI();
		log.info(">>> uri : "+uri);
//		/mem/join : 요청에 대한 path만 남기기
		String path = uri.substring(uri.lastIndexOf("/") + 1);
		log.info(">>> path : "+path);
		
		switch(path) {
		case "join":
			destPage="/member/join.jsp";
			break;
		case "register":
			//jsp 에서 가져온 파라미터 저장
			String id = request.getParameter("id");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			int age = Integer.parseInt(request.getParameter("age"));
			
			// 파라미터로 mvo 객체 생성
			MemberVO mvo = new MemberVO(id, password, email, age);
			isOk = msv.register(mvo);
			log.info(">>> JOIN > "+ (isOk>0 ? "success" : "fail"));
			destPage = "/";
			break;
		case "login":	//로그인 페이지로 이동
			log.info(">>> login page 이동");
			destPage="/member/login.jsp";
			break;
		case "login.auth":	//실제 로그인이 일어나는 케이스
			try {
				String id2 = request.getParameter("id");
				String password2 = request.getParameter("password");
				MemberVO mvo2 = new MemberVO(id2, password2);
				//해당 id, password가 db상에 있는지 체크
				//해당 객체(사용자)를 가져와서
				//해당 객체(사용자)를 세션에 담기
				log.info(">>> login 요청"+mvo2);
				MemberVO loginMvo = msv.login(mvo2);
				//같은정보가 있으면 객체를 리턴, 없다면 null이 리턴
				//객체가 있다면 세션에 저장
				if(loginMvo != null) {
					//세션을 가져오기. 연결된 세션이 없다면 새로 생성
					HttpSession ses = request.getSession();
					ses.setAttribute("ses", loginMvo);
					//로그인 유지시간(초단위)
					ses.setMaxInactiveInterval(10*60);
				}else {
					request.setAttribute("msg_login", 0);
				}
				destPage="/";
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "logout":
			try {
				//세션 가져오기 (연결된 세션)
				HttpSession ses = request.getSession();
				//마지막 로그인 시간 기록
				MemberVO mvo2 = (MemberVO)ses.getAttribute("ses");
				String id2 = mvo2.getId();
				log.info(">>> login id : "+id2);
				//로그인정보(id)를 주고 마지막 로그인 시간 기록(update)
				isOk = msv.lastLogin(id2);
				log.info(">>> logout > "+ (isOk>0 ? "success" : "fail"));
				ses.invalidate();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			destPage = "/";
			break;
		case "modify":
			destPage="/member/modify.jsp";
			break;
		case "edit":
			try {
				String id3 = request.getParameter("id");
				String password3 = request.getParameter("password");
				String email3 = request.getParameter("email");
				int age3 = Integer.parseInt(request.getParameter("age"));
				String regdate = request.getParameter("reg_date");
				String lastlogin = request.getParameter("last_login");
				MemberVO mvo3 = new MemberVO(id3, password3, email3, age3, regdate, lastlogin);
				isOk = msv.modify(mvo3);
				log.info(">>> Modify > "+ (isOk>0 ? "success" : "fail"));
				log.info(">>> Modify 완료, session 변경시작");
				if(isOk > 0) {
					//case 1 session 객체에 값을 담기
					//mvo = msv.login(mvo3); //modify에서 모든정보를 가져오지 않았을경우
//					HttpSession ses = request.getSession();
//					ses.setAttribute("ses", mvo3);
					
					//case 2 login_auth case로 mvo3 객체 보내기
					request.setAttribute("mvo", mvo3);
					log.info(">>> session 변경 완료");
				}
				destPage="login.auth";
//				destPage="/";
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "delete":
			try {
				//기존에 연결된 세션을 가져옴. (로그인 한 객체를 가져옴)
				HttpSession ses = request.getSession();
				MemberVO mvo4 = (MemberVO)ses.getAttribute("ses");
				String id4 = mvo4.getId();
				isOk = msv.remove(id4);
				log.info(">>> 회원탈퇴 > "+ (isOk>0 ? "success" : "fail"));
				ses.invalidate(); //세션 로그아웃
				log.info(">>> logout(세션 삭제)완료");
			} catch (Exception e) {
				// TODO: handle exception
			}
			destPage="/";
			break;
		case "list":
			try {
				List<MemberVO> list = new ArrayList<MemberVO>();
				list = msv.list();
				request.setAttribute("list", list);
				log.info(">>> 회원리스트 성공~!!");
				log.info(">>> "+list.size());
			} catch (Exception e) {
				e.printStackTrace();
			}
			destPage="/member/list.jsp";
			break;
		}
		
		rdp = request.getRequestDispatcher(destPage);
		rdp.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		service(request, response);
	}

}
