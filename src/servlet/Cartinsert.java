package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Cartdao;




/**
 * Servlet implementation class Cartinsert
 */
@WebServlet("/Cartinsert")
public class Cartinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cartinsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(); 
		String userid = (String)session.getAttribute("userid");
		int s_id = Integer.parseInt(request.getParameter("sid"));
		Cartdao dao = new Cartdao();
//		商品の売り切れ確認
		boolean hantei = dao.settled(s_id, userid);
		//すでに売り切れの処理
		if(hantei){
			request.getRequestDispatcher("Cartout").forward(request, response);
		}else{
		dao.cartinsert(userid, s_id);
		request.getRequestDispatcher("Cartout").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
