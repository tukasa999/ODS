package dao;

import java.io.InputStream;
import java.sql.Date;
import java.util.ArrayList;

import model.Order;

public class Orderdao extends Daobase {
	public void orderinsert(int price,String uid){
		try{
			super.connection();
			String sql  ="insert into order_table(g_price, u_id) values(?,?)";
			stmt = con.prepareStatement(sql);	
			stmt.setInt(1, price);
			stmt.setString(2, uid);
			rsno = stmt.executeUpdate();
		}catch(Exception e){

		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}	
	}
	public ArrayList<Order> getOrder(){
		ArrayList<Order> orders = new ArrayList<Order>();
		try{
			super.connection();
			String sql  ="select * from order_table";
			stmt = con.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()){
			Order order = new Order();
			order.setBuydate(rs.getDate("buy_date"));
			order.setChunum(rs.getInt("chu_num"));
			order.setGprice(rs.getInt("g_price"));
			order.setUid(rs.getString("u_id"));
			orders.add(order);
			}
			
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}	
		return orders;
	}
	public ArrayList<Order> getOrder(String userid){
		ArrayList<Order> orders = new ArrayList<Order>();
		try{
			super.connection();
			String sql  ="select * from order_table where u_id=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, userid);
			rs=stmt.executeQuery();
			while(rs.next()){
			Order order = new Order();
			System.out.println(rs.getInt("chu_num"));
			order.setBuydate(rs.getDate("buy_date"));
			order.setChunum(rs.getInt("chu_num"));
			order.setGprice(rs.getInt("g_price"));
			order.setUid(rs.getString("u_id"));
			orders.add(order);
			}
			
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}	
		return orders;
	}
}
