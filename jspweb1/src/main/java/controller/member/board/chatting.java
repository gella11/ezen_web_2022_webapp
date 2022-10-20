package controller.member.board;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;



//@WebServlet("/chatting")
@ServerEndpoint("/chatting/{mid}") // 웹서버에 웹소켓 URL 만들기
public class chatting  {
	
	// 서버소켓 들어온 클라이언소켓 명단 ( 세션 , 아이디 저장 [dto가능])
	// arraylist vs Vector [동기화x vs 동기화o]
	// vector 에서 hashtable 변경한 이유 [ 2개씩 저장하려고 ]
	// public static Vector<Session> clients = new Vector<>();
	   public static Hashtable< Session, String > clients = new Hashtable<>();
	   						  //   키   :   값  이를 엔트리라고 함
		// 3가지 메소드
		@OnOpen			// 웹소켓이 들어왔을 때	
		public void OnOpen(Session session , @PathParam("mid")String mid ) throws IOException { //@PathParam : 경로상의 변수 호출
			clients.put(session, mid); // 접속된 클라이언트 소켓을 저장
			System.out.println( session ); // session 자동식별번호. 한 번 나갔다 들어오면 다른 사람이 되어있어서 세션으로 식별 불가
			System.out.println(mid+"님이 접속했습니다.");
			
			// 접속했다고 다른 사람에게 알리기
			for(Session s : clients.keySet() ) { // keySet() 맵에 저장된 모든 key 호출
				s.getBasicRemote().sendText(clients.get(s)+"님이 접속했습니다.");
			}
		}
		
		
		
		@OnClose		// 웹소켓을 나갔을 때 [ 서버소켓[서버 재부팅/시작 ] 꺼지나 클라이언트소켓이 닫기 요청 ]
		public void onClose(Session session) {
			// 1.종료된 세션을 접속명단에서 제거
			clients.remove(session); // map객체명.remove(key) : 해당 key의 앤트리 삭제
			
		}
			
		
		
		
		
		@OnMessage		// 웹소켓에 메시지 왔을 때
		public void onMessage(Session session, String msg) throws IOException {
			System.out.println(msg);
			for(Session s : clients.keySet() ) {
				// 접속된 클라이언트 소켓을  하나씩 호출
				// 클라이언트 소켓들에게 메시지를 다 보내기
				s.getBasicRemote().sendText(msg);
			}
		}
	
	// 클라이언트 소켓 만들기 [ 웹기준 --- JS ] 
	
	

}
