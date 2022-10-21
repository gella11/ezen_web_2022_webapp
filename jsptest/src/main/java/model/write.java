package model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BoardDao;


@WebServlet("/write")
public class write extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public write() {super();    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bname = request.getParameter("bname");
		String bpassword = request.getParameter("bpassword");
		
		BoardDao dao = new BoardDao();
		boolean result = dao.write(btitle , bcontent, bname, bpassword);
		
		response.getWriter().print(result);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
