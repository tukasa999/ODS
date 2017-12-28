package dao;

import java.io.InputStream;
import java.util.ArrayList;

import model.Category;

public class Categorydao extends Daobase {
	public ArrayList<String> getcategory(){
		ArrayList<String> category = new ArrayList<String>();
		try{
			super.connection();
			String sql  ="select * from category_table";
			stmt = con.prepareStatement(sql);

			rs=stmt.executeQuery();
			
			while(rs.next()){
				category.add(rs.getString("c_name"));
			}

			
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}	
		return category;
	}
	public ArrayList<Category> getcategoryall(){
		ArrayList<Category> categorylist  = new ArrayList<Category>();
		try{
			super.connection();
			String sql  ="select * from category_table";
			stmt = con.prepareStatement(sql);
			rs=stmt.executeQuery();
			
			while(rs.next()){
				Category category = new Category();
				category.setCid(rs.getInt("c_id"));
				category.setCname(rs.getString("c_name"));
				categorylist.add(category);
			}

			
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}	
		return categorylist;
	}
	public String getname(int cid){
		String name ="";
		try{
			super.connection();
			String sql  ="select c_name from category_table where c_id=?";
			
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, cid);

			rs=stmt.executeQuery();
			rs.next();
			name = rs.getString("c_name");

			
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
	public String getid(String cname){
		String id ="";
		try{
			super.connection();
			String sql  ="select c_id from category_table where c_name=?";
			
			stmt = con.prepareStatement(sql);
			stmt.setString(1, cname);

			rs=stmt.executeQuery();
			rs.next();
			id = rs.getString("c_id");

			
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}	
		return id;
		
	}
	public void categoryinsert(String name){
		try{
			super.connection();
			String sql  ="insert into category_table(c_name) values(?)";
			stmt = con.prepareStatement(sql);	
			stmt.setString(1, name);
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
