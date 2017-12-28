package dao;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import model.Item;

public class Itemdao extends Daobase {
	public void iteminsert(String name,String price,InputStream image, int cid){
		try{
			super.connection();
			String sql  ="insert into item_table(name,price,image,c_id) values(?,?,?,?)";
			stmt = con.prepareStatement(sql);	
			stmt.setString(1, name);
			stmt.setString(2, price);
			stmt.setBlob(3, image);
			stmt.setInt(4, cid);
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
	public ArrayList<String> getname(){
		ArrayList<String> name = new ArrayList<String>();
		try{
			super.connection();
			String sql  ="select * from item_table";
			stmt = con.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()){
			 name.add(rs.getString("name"));
			}
			
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}	
		return name;
	}
	public ArrayList<Item> searchItem(String name){
		ArrayList<Item> sitems = new ArrayList<Item>();
		try{
			super.connection();
			String sql  ="select * from item_table where status = '未購入' && name like ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, "%"+name+"%");
			rs = stmt.executeQuery();
			while(rs.next()){
				Item item = new Item();
				item.setCid(rs.getInt("c_id"));
				item.setSid(rs.getInt("s_id"));
				item.setName(rs.getString("name"));
				item.setImage(rs.getBlob("image"));
				item.setPrice(rs.getInt("price"));
				item.setStatus(rs.getString("status"));
				sitems.add(item);
			}
		}catch(Exception e){

		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}	
		return sitems;
	}
	public Item getitem(String name){
		Item item = new Item();
		try{
			super.connection();
			String sql  ="select * from item_table where name = ?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, name);
			rs=stmt.executeQuery();
			rs.next();
			item.setCid(rs.getInt("c_id"));
			item.setSid(rs.getInt("s_id"));
			item.setName(rs.getString("name"));
			item.setImage(rs.getBlob("image"));
			item.setPrice(rs.getInt("price"));
			item.setStatus(rs.getString("status"));
			
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}	
		return item;
		
	}
	public Item getitem(int sid){
		Item item = new Item();
		try{
			super.connection();
			String sql  ="select * from item_table where s_id = ?";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, sid);
			rs=stmt.executeQuery();
			rs.next();
			item.setCid(rs.getInt("c_id"));
			item.setSid(rs.getInt("s_id"));
			item.setName(rs.getString("name"));
			item.setImage(rs.getBlob("image"));
			item.setPrice(rs.getInt("price"));
			item.setStatus(rs.getString("status"));
			
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}	
		return item;
		
	}
	public void Itemdelete(int id){
		try{
			super.connection();
			String sql  ="Delete from item_table where s_id=?";
			stmt = con.prepareStatement(sql);	
			stmt.setInt(1, id);
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
	public void Itemupdate(String name,int price,InputStream image, int cid,int sid){

		try{
			super.connection();
			String sql  ="update item_table set name=?,price=?,image=?,c_id=? where s_id = ?";
			stmt = con.prepareStatement(sql);	
			stmt.setString(1, name);
			stmt.setInt(2, price);
			stmt.setBlob(3, image);
			stmt.setInt(4, cid);
			stmt.setInt(5, sid);
			rsno = stmt.executeUpdate();
		}catch(Exception e){
			System.out.println("エラー");
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}	
	}
	public ArrayList<Item> Allitemget(){
		ArrayList<Item> items = new ArrayList<Item>();
		try{
			super.connection();
			String sql  ="select * from item_table where status = '未購入'";
			stmt = con.prepareStatement(sql);	
			rs = stmt.executeQuery();
			while(rs.next()){
				Item item = new Item();
				item.setCid(rs.getInt("c_id"));
				item.setSid(rs.getInt("s_id"));
				item.setName(rs.getString("name"));
				item.setImage(rs.getBlob("image"));
				item.setPrice(rs.getInt("price"));
				item.setStatus(rs.getString("status"));
				items.add(item);
			}
		}catch(Exception e){

		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}	
		return items;
	}
	public BufferedImage getImage(int id){
		try{
			super.connection();
			String sql  ="select * from item_table where s_id = ?";
			stmt = con.prepareStatement(sql);	
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			rs.next();
			InputStream is = rs.getBinaryStream("image");
			BufferedInputStream bis = new BufferedInputStream(is);
			return ImageIO.read(bis);

		}catch(Exception e){

		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}	
		return null;
	}
	public ArrayList<Item> Allitemget(String cid){
		ArrayList<Item> items = new ArrayList<Item>();
		try{
			super.connection();
			String sql  ="select * from item_table where status = '未購入' && c_id=?";
			stmt = con.prepareStatement(sql);	
			stmt.setString(1, cid);
			rs = stmt.executeQuery();
			while(rs.next()){
				Item item = new Item();
				item.setCid(rs.getInt("c_id"));
				item.setSid(rs.getInt("s_id"));
				item.setName(rs.getString("name"));
				item.setImage(rs.getBlob("image"));
				item.setPrice(rs.getInt("price"));
				item.setStatus(rs.getString("status"));
				items.add(item);
			}
		}catch(Exception e){

		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}	
		return items;
	}
	public void soldout(int sid){
		try{
			super.connection();
			String sql  ="update item_table set status = '購入済' where s_id = ?";
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


}


