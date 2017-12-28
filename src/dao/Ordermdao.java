package dao;

import java.sql.Date;
import java.util.ArrayList;

import model.Order;
import model.Orderm;

public class Ordermdao extends Daobase {
	public void orderinsert(int cnum,int cmnum,int sid,int price){
		try{
			super.connection();
			String sql  ="insert into order_m_table(chu_num,chu_m_num,s_id, price) values(?,?,?,?)";
			stmt = con.prepareStatement(sql);	
			stmt.setInt(1, cnum);
			stmt.setInt(2, cmnum);
			stmt.setInt(3, sid);
			stmt.setInt(4, price);
			
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
	public ArrayList<Orderm> getOrderm(int cid){
		ArrayList<Orderm> orders = new ArrayList<Orderm>();
		try{
			super.connection();
			String sql  ="select * from order_m_table where chu_num=?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, cid);
			rs=stmt.executeQuery();
			while(rs.next()){
			Orderm order = new Orderm();
			order.setChumnum(rs.getInt(2));
			order.setChunum(rs.getInt(1));
			order.setPrice(rs.getInt(4));
			order.setSid(rs.getInt(3));
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
