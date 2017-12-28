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
import secure.SafePassword;

/**
 * Servlet implementation class Taikai
 */
@WebServlet("/Taikai")
public class Taikai extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Taikai() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession(); //セッションの用意
		String id = (String)session.getAttribute("userid");//セッションの受け取り
		String pass  = request.getParameter("pass");//値の受け取り
		//daoの用意
		Userinfodao uidao = new Userinfodao();
		Userauthdao uadao =new Userauthdao();
		SafePassword spass = new SafePassword();
		String shapass = spass.getStretchedPassword(pass, id);
		String check = uadao.Usercheck(id, shapass);//認証
		//認証失敗処理
		if(check == null){
			session.setAttribute("msg", "パスワードを正しく入力してください");
			request.getRequestDispatcher("taikai.jsp").forward(request, response);
		}else{
		//認証成功・ユーザー削除
		uidao.userdelete(id);
		uadao.userdelete(id);
		session.invalidate();
		request.getRequestDispatcher("login.jsp").forward(request, response);
		}


	}

}


