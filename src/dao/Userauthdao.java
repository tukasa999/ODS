package dao;

import model.Userinfo;
import model.Userauth;

public class Userauthdao extends Daobase {
	public String Usercheck(String id){
		String check =null;
		try{
			super.connection();
			String sql  ="select * from user_auth_table where userid=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			rs=stmt.executeQuery();
			rs.next();
			check = rs.getString("userid");
			
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}	
		return check;
	}
	public String Usercheck(String id,String pass){
		String check = null;
		try{
			super.connection();
			String sql  ="select * from user_auth_table where userid=? && pass=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, pass);
			rs=stmt.executeQuery();
			rs.next();
			check = rs.getString("userid");
			
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}	
		return check;
	}
	public String Userauth(String id){
		String auth = null;
		try{
			super.connection();
			String sql  ="select auth from user_auth_table where userid=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			rs=stmt.executeQuery();
			rs.next();
			auth = rs.getString("auth");
			
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}	
		return auth;
	}
	
	public void Userinsert(String id,String pass){
		try{
			super.connection();
			String sql  ="insert into user_auth_table(userid,pass) values(?,?)";
			stmt = con.prepareStatement(sql);	
			stmt.setString(1, id);
			stmt.setString(2, pass);
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
			String sql  ="delete from user_auth_table where userid=?";
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
	public Userauth Userget(String id){
		Userauth uauth = new Userauth();
		try{
			super.connection();
			String sql  ="select * from user_auth_table where userid=?";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, id);
			rs=stmt.executeQuery();
			rs.next();
			uauth.setPass(rs.getString("userid"));
			uauth.setUserid(rs.getString("userid"));
			uauth.setState(rs.getString("state"));
			uauth.setAuth(rs.getString("auth"));

			
			
		}catch(Exception e){
			
		}finally {
			try{
				super.DbClose();
			}catch(Exception e){
				System.out.println("error");
			}
		}	
		return uauth;
	}
	public void owneradd(String id){
		try{
			super.connection();
			String sql  ="update uset_auth_table set auth='A' where ?";
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

}
