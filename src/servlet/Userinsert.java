package servlet;

import java.io.IOException;
import java.util.Calendar;

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
 * Servlet implementation class Userinsert
 */
@WebServlet("/Userinsert")
public class Userinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userinsert() {
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
		SafePassword spass = new SafePassword();//セキュリティクラスの用意
		//daoのようい
		Userauthdao uadao = new Userauthdao();
		Userinfodao uidao = new Userinfodao();
		//値の受け取り
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String shapass = spass.getStretchedPassword(pass, id);
		String mail = request.getParameter("mail");
		String address = request.getParameter("address");
		String check = uadao.Usercheck(id);
		//重複チェック
		if(check != null){
			session.setAttribute("dist", "IDが重複しています");
			request.getRequestDispatcher("userinsert.jsp").forward(request, response);
		}
		//インサート文実行
		uadao.Userinsert(id, shapass);
		uidao.Userinsert(id, address, mail);
		

		request.getRequestDispatcher("login.jsp").forward(request, response);
	}

}
