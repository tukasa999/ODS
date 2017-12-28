package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Userauthdao;
import secure.SafePassword;

/**
 * Servlet implementation class Loginuser
 */
@WebServlet("/Loginuser")
public class Loginuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Loginuser() {
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
		session.invalidate();//ログアウト処理
		request.getRequestDispatcher("login.jsp").forward(request, response);//ログイン画面に遷移する
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(); 
		SafePassword spass = new SafePassword();
		//ユーザーが入力した値を受け取る
		String memberid = request.getParameter("memberid");
		String password = request.getParameter("password");
		String shapass = spass.getStretchedPassword(password, memberid);
		Userauthdao uadao = new Userauthdao();
		//ユーザーが入力した値をdaoに渡してユーザー情報を取得する
		String check = uadao.Usercheck(memberid, shapass);
		//ログイン判定
		if(check != null){
			session.setAttribute("userid", memberid);
			String auth = uadao.Userauth(memberid);
			if(auth.equals("U")){
			request.getRequestDispatcher("mypage.jsp").forward(request, response);
			}else{
				session.setAttribute("manager", "Manager");
				request.getRequestDispatcher("ownerpage.jsp").forward(request, response);
			}
		}else{

			session.setAttribute("login", "IDとパスワードを正しく入力してください");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}

	}

}
