package controller.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import model.dao.FriendDao;
import model.dto.BoardDto;


@WebServlet("/F_list")
public class F_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public F_list() {super(); }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 
		// 세션에 저장된 이메일로 --> 회원번호 호출
		String my_email = (String)request.getSession().getAttribute("user_email");

		// DAO
		// 나의 회원번호로 --> 내 친구들의 회원번호 호출,
		// 각 친구번호의   --> ( 회원번호 / 이름 / 프로필 ) 호출
		int my_num = FriendDao.getInstacnDao().user_num(my_email);
		ArrayList<   > friend_num  = FriendDao.getInstacnDao().getinfolist(my_num);
		ArrayList<   > friend_info = FriendDao.getInstacnDao().f_list_info(friend_num);
		
		// JSON
		JSONArray array = new JSONArray();
		for( int i = 0  ; i<list.size() ; i++ ) {
			JSONObject object = new JSONObject();
			object.put("user_num", 		list.get(i).getUser_num() );
			object.put("user_name", 	list.get(i).getUser_name() );
			object.put("user_profile",  list.get(i).getUser_profile() );
			array.add(object);
		}
		
		// 나의 회원번호 세션에 등록
		HttpSession 세션 = request.getSession();
		세션.setAttribute("user_num",user_num);	
		
		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(object);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
