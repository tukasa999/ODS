package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.Categorydao;
import dao.Itemdao;

/**
 * Servlet implementation class Iteminsert
 */
@WebServlet("/Iteminsert")
@MultipartConfig(maxFileSize = 2147483647)
public class Iteminsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Iteminsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Categorydao cdao = new Categorydao();
		ArrayList<String> category = new ArrayList<String>();
		category = cdao.getcategory();//カテゴリー取得
		HttpSession session = request.getSession(); 
		session.setAttribute("category", category);
		request.getRequestDispatcher("iteminsert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		Categorydao cdao = new Categorydao();
		Itemdao idao = new Itemdao();
		//値格納
		String name = request.getParameter("name");
		String price = request.getParameter("price");
		String category = request.getParameter("category");
		int cid = Integer.parseInt(cdao.getid(category));
		//画像挿入処理
		InputStream is= null;
		Part filePart = request.getPart("image");
		if (filePart != null) {
            is = filePart.getInputStream();
        }
		//商品登録
		idao.iteminsert(name, price, is, cid);
		request.getRequestDispatcher("ownerpage.jsp").forward(request, response);
		
		
		
		
	}

}
