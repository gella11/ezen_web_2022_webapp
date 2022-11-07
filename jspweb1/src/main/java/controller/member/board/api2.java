package controller.member.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import model.dao.BoardDao;
import model.dao.BoardDao2;


@WebServlet("/api2")
public class api2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public api2() {super();   }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		JSONArray array = BoardDao2.getInstance().getapi();
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(array);
		System.out.println( array +"dasdasddddddd" );
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
