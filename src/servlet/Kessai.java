package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Cartdao;
import dao.Itemdao;
import dao.Orderdao;
import dao.Ordermdao;
import model.Cart;
import model.Item;
import model.Order;

/**
 * Servlet implementation class Kessai
 */
@WebServlet("/Kessai")
public class Kessai extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kessai() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String uid = request.getParameter("uid");//リクエストパラメータからログインユーザーのID取得
		ArrayList<Cart> carts = new ArrayList<Cart>();//カートのリスト用意
		ArrayList<Order> orders = new ArrayList<Order>();//購入履歴のリスト用意
		HttpSession session = request.getSession(); //セッションの用意
		Cartdao cdao = new Cartdao();//カートdaoの用意
		Itemdao idao = new Itemdao();//商品daoの用意
		Orderdao odao = new Orderdao();//購入履歴daoの用意
		Ordermdao omdao = new Ordermdao();//購入履歴明細daoの用意
		carts = (ArrayList<Cart>)session.getAttribute("carts");//カートリストの取得
		//購入履歴IDの最後の件数の取得
		int lastid = 0;
		orders = odao.getOrder();
		for(Order order:orders){
			lastid = order.getChunum();
		}
		lastid ++;
		int cmnum =0;//商品明細番号
		int gok = 0;//合計金額
		for(Cart cart:carts){
			Item item = new Item();//商品ビーンズの用意
			item = idao.getitem(cart.getS_id());//商品IDを元に商品情報を取得
			cmnum++;//商品明細番号加算
			gok += item.getPrice();//合計金額加算
			cdao.soldout(cart.getS_id());//他の人が購入商品をカートに入れてた場合削除
			idao.soldout(cart.getS_id());//商品情報を購入済みに更新する
			omdao.orderinsert(lastid, cmnum, cart.getS_id(), item.getPrice());//購入履歴明細追加
		}
		odao.orderinsert(gok, uid);//購入履歴追加
		cdao.kessai(uid);//カート情報削除
		 request.getRequestDispatcher("kessaiend.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
