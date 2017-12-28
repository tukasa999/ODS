package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Userauthdao;
import dao.Userinfodao;
import model.Userauth;
import model.Userinfo;

/**
 * Servlet implementation class Memberupdate
 */
@WebServlet("/Memberupdate")
public class Memberupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Memberupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(); //セッションの用意
		String id = request.getParameter("id");
		Userinfodao uidao = new Userinfodao();//DAO用意
		Userauthdao uadao = new Userauthdao();
		Userinfo userinfo = new Userinfo();//ビーンズの用意
		Userauth userauth = new Userauth();
		userinfo = uidao.Userget(id);//idを元にユーザーの情報を受け取る
		userauth = uadao.Userget(id);
		session.setAttribute("userinfo",userinfo);//セッションにユーザー情報を格納する
		session.setAttribute("userauth",userauth);//セッションにユーザー情報を格納する
		request.getRequestDispatcher("memberupdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession(); //セッションの用意
		Userinfo userinfo = (Userinfo)session.getAttribute("userinfo");
		String mail =request.getParameter("mail");
		String address =request.getParameter("address");
		Userinfodao dao = new Userinfodao();
		dao.Userupdate(userinfo.getUserid(), mail, address);//ユーザー情報を更新する
		request.getRequestDispatcher("ownerpage.jsp").forward(request, response);
	}

}
