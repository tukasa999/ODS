package servlet;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class Iteminfo
 */
@WebServlet("/Iteminfo")
public class Iteminfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Iteminfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = request.getParameter("name");
		Itemdao dao = new Itemdao();
		Categorydao cdao = new Categorydao();
		Item item = new Item();
		ArrayList<String> category = new ArrayList<String>();
		//カテゴリー取得
		category = cdao.getcategory();
		//アイテム情報取得
		item = dao.getitem(name);
		HttpSession session = request.getSession();
		session.setAttribute("item", item);
		session.setAttribute("category", category);
		request.getRequestDispatcher("iteminfoupdate.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
