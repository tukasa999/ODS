package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Itemdao;
import dao.Userauthdao;
import dao.Userinfodao;
import model.Item;
import model.Userinfo;

/**
 * Servlet implementation class Memberdelete
 */
@WebServlet("/Memberdelete")
public class Memberdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Memberdelete() {
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
		Userinfo userinfo = (Userinfo)session.getAttribute("userinfo");//セッションから変更情報を取得
		//DAOの用意
		Userinfodao uidao = new Userinfodao();
		Userauthdao uadao =new Userauthdao();
	    uidao.userdelete(userinfo.getUserid());//userinfoテーブルから削除
		uadao.userdelete(userinfo.getUserid());//userauthテーブルから削除
	    request.getRequestDispatcher("ownerpage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
