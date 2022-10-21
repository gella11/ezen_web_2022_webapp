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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;



//@WebServlet("/chatting")
@ServerEndpoint("/chatting/{mid}") // 웹서버에 웹소켓 URL 만들기
public class chatting  {
	
	// 서버소켓 들어온 클라이언소켓 명단 ( 세션 , 아이디 저장 [dto가능])
	// arraylist vs Vector [동기화x vs 동기화o]
	// vector 에서 hashtable 변경한 이유 [ 2개씩 저장하려고 ]
	// public static Vector<Session> clients = new Vector<>();
	   public static Hashtable< Session, String > clients = new Hashtable<>();
	   						  //   키   :   값  이를 엔트리라고 함
	   
	   
	   public JSONObject jsonAlarm(String content) throws IOException {
		   // 접속 알람 메시지
		   // 전송 메시지 구성
			JSONObject object = new JSONObject();
			object.put("type", "alarm");
			object.put("content", content);
			return object;
	   }
	   
	   // 알람 실제 전송 함수
	   public void sendmsg(JSONObject object) throws IOException {
		   for(Session s : clients.keySet() ) { 
				s.getBasicRemote().sendText( object.toString() );
			}
	   }
	   
	   
	   
		// 3가지 메소드
		@OnOpen			// 1. 접속 /// 웹소켓이 들어왔을 때	
		public void OnOpen(Session session , @PathParam("mid")String mid ) throws IOException { //@PathParam : 경로상의 변수 호출
			sendmsg(jsonAlarm( mid+"님이 들어왔습니다."));			
			clients.put(session, mid); // 접속된 클라이언트 소켓을 저장
			
		}
		
		
		@OnClose		// 2. 나가기 /// 웹소켓을 나갔을 때 [ 서버소켓[서버 재부팅/시작 ] 꺼지나 클라이언트소켓이 닫기 요청 ]
		public void onClose(Session session) throws IOException {
			JSONObject object =  jsonAlarm(clients.get(session)+"님이 퇴장했습니다.");
			clients.remove(session); // map객체명.remove(key) : 해당 key의 앤트리 삭제
			sendmsg(object);
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
