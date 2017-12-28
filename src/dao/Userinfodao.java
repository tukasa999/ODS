package dao;

import java.util.ArrayList;

import model.Userinfo;

public class Userinfodao extends Daobase {
	
	public void Userinsert(String id,String address,String mail){
		try{
			super.connection();
			String sql  ="insert into user_info_table values(?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, address);
			stmt.setString(3, mail);
			rsno = stmt.executeUpdate();			
			
		}catch(Exception e){
//			member=null;
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}	
	}
	public void Userupdate(String id,String mail,String address){
		System.out.println("");
		try{
			super.connection();
			String sql  ="Update user_info_table set mail=?,address=? where userid=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, mail);
			stmt.setString(2, address);
			stmt.setString(3, id);
			rsno = stmt.executeUpdate();			
			
		}catch(Exception e){
//			member=null;
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}
		
	}
	public void userdelete(String id){
		try{
			super.connection();
			String sql  ="delete from user_info_table where userid=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			rsno = stmt.executeUpdate();			
			
		}catch(Exception e){
//			member=null;
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}	
	}
	public Userinfo Userget(String id){
		Userinfo uinfo = new Userinfo();
		try{
			super.connection();
			String sql  ="select * from user_info_table where userid=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			rs=stmt.executeQuery();
			rs.next();
			uinfo.setUserid(rs.getString("userid"));
			uinfo.setMail(rs.getString("mail"));
			uinfo.setAddress(rs.getString("address"));
			
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}	
		return uinfo;
	}
	public ArrayList<Userinfo> Userall(){
		ArrayList<Userinfo> users = new ArrayList<Userinfo>();
		try{
			super.connection();
			String sql  ="select * from user_info_table";
			stmt = con.prepareStatement(sql);
			rs=stmt.executeQuery();
			while(rs.next()){
			Userinfo uinfo = new Userinfo();
			uinfo.setUserid(rs.getString("userid"));
			uinfo.setMail(rs.getString("mail"));
			uinfo.setAddress(rs.getString("address"));
			users.add(uinfo);
			}
			
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}	
		return users;
	}

}
