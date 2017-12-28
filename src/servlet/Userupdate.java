package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Userinfodao;
import model.Userinfo;

/**
 * Servlet implementation class Userupdate
 */
@WebServlet("/Userupdate")
public class Userupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(); //セッションの用意
		String id = (String)session.getAttribute("userid");
		Userinfodao uidao = new Userinfodao();//DAO用意
		Userinfo userinfo = new Userinfo();//ビーンズの用意
		userinfo = uidao.Userget(id);//idを元にユーザーの情報を受け取る
		session.setAttribute("userinfo",userinfo);//セッションにユーザー情報を格納する
		request.getRequestDispatcher("userupdate.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession(); //セッションの用意
    	String id  = (String)session.getAttribute("userid");//セッションの受け取り
    	//値のうけとり
		String mail =request.getParameter("mail");
		String address =request.getParameter("address");
		Userinfodao dao = new Userinfodao();//daoの用意
		dao.Userupdate(id, address, mail);;//ユーザー情報を更新する
		request.getRequestDispatcher("mypage.jsp").forward(request, response);
	}

}
