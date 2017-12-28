package dao;

import java.util.ArrayList;

import model.Cart;

public class Cartdao extends Daobase {
	public ArrayList<Cart> getCart(String userid){
		ArrayList<Cart> carts = new ArrayList<Cart>();
		try{
			super.connection();
			String sql  ="select * from cart where userid=?";

			stmt = con.prepareStatement(sql);
			stmt.setString(1, userid);

			rs=stmt.executeQuery();
			while(rs.next()){
				Cart cart = new Cart();
				cart.setCartid(rs.getInt("cartid"));
				cart.setS_id(rs.getInt("s_id"));
				cart.setUserid(rs.getString("userid"));
				carts.add(cart);

			}


		}catch(Exception e){

		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}	
		return carts;

	}
	public void cartinsert(String userid,int s_id){
		try{
			super.connection();
			String sql  ="insert into cart(userid,s_id) values(?,?)";
			stmt = con.prepareStatement(sql);	
			stmt.setString(1, userid);
			stmt.setInt(2, s_id);
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
	public void cartitemdelete(int cid){
		try{
			super.connection();
			String sql  ="delete from cart where cartid= ?";
			stmt = con.prepareStatement(sql);	
			stmt.setInt(1, cid);
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
	public void kessai(String uid){
		try{
			super.connection();
			String sql  ="delete from cart where userid= ?";
			stmt = con.prepareStatement(sql);	
			stmt.setString(1, uid);
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
	public void soldout(int sid){
		try{
			super.connection();
			String sql  ="delete from cart where s_id= ?";
			stmt = con.prepareStatement(sql);	
			stmt.setInt(1, sid);
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
	public boolean settled(int sid,String uid){
		boolean hantei = false;
		try{
			super.connection();
			String sql  ="select count(*) from cart where s_id=? && userid =?";

			stmt = con.prepareStatement(sql);
			stmt.setInt(1, sid);
			stmt.setString(2, uid);

			rs=stmt.executeQuery();
			rs.next();
			int count = rs.getInt(1);
			if(count >=1 ){
				hantei = true;
			}


		}catch(Exception e){

		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}	
		return hantei;
		
	}
}