package controller.member.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.BoardDao;


@WebServlet("/board/bdelete")
public class bdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public bdelete() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bno = Integer.parseInt( request.getParameter("bno") );
		
		boolean result = BoardDao.getInstance().delete(bno);
		
		response.getWriter().print(result);
		
		
		
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
