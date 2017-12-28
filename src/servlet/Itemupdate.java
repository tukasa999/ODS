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
import model.Item;

/**
 * Servlet implementation class Itemupdate
 */
@WebServlet("/Itemupdate")
@MultipartConfig(maxFileSize = 2147483647)
public class Itemupdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Itemupdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		Itemdao idao = new Itemdao();
		ArrayList<String> iname = new ArrayList<String>();//リスト用意
		iname = idao.getname();//商品名検索
		HttpSession session = request.getSession();
		session.setAttribute("iname", iname);//商品名を格納
		request.getRequestDispatcher("itemupdate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		HttpSession session = request.getSession();
		Item item = new Item();
		//セッションから商品情報取得
	    item = (Item)session.getAttribute("item");
	    Itemdao idao = new Itemdao();
	    Categorydao cdao = new Categorydao();
	    //値受け取り
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		String cate = request.getParameter("category");
		int cid = Integer.parseInt(cdao.getid(cate));
		//画像挿入処理
		InputStream is= null;
		Part filePart = request.getPart("image");
		if (filePart != null) {
            is = filePart.getInputStream();
        }
		idao.Itemupdate(name, price, is, cid,item.getSid());
		request.getRequestDispatcher("ownerpage.jsp").forward(request, response);
		
	}

}
