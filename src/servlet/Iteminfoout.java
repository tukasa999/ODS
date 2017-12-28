package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Categorydao;
import dao.Itemdao;
import model.Item;

/**
 * Servlet implementation class Iteminfoout
 */
@WebServlet("/Iteminfoout")
public class Iteminfoout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Iteminfoout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		int sid = Integer.parseInt(request.getParameter("id"));
		Itemdao idao = new Itemdao();
		Categorydao cdao = new Categorydao();
		Item item = new Item();
		//商品詳細情報取得
		item = idao.getitem(sid);
		HttpSession session = request.getSession();
		//商品名取得
		String cname = cdao.getname(item.getCid());
		session.setAttribute("item", item);
		session.setAttribute("cname", cname);
		request.getRequestDispatcher("iteminfoout.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
