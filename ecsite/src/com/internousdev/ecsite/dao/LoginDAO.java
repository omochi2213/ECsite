package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.LoginDTO;
import com.internousdev.ecsite.util.DBConnector;

public class LoginDAO {
	private DBConnector db=new DBConnector();
	private Connection con=db.getConnection();
	private LoginDTO ldto=new LoginDTO();

	public LoginDTO getLoginUserInfo(String loginUserId,String loginPassword){
	String sql="select * from login_user_transaction where login_id=? and login_pass=?";

		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, loginUserId);
			ps.setString(2, loginPassword);
			ResultSet rs=ps.executeQuery();

			if(rs.next()){
				ldto.setLoginId(rs.getString("login_id"));
				ldto.setLoginPassword(rs.getString("login_pass"));
				ldto.setUserName(rs.getString("user_name"));

				if(!(rs.getString("login_id").equals(null))){
					ldto.setLoginFlg(true);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return ldto;
	}
	public LoginDTO getloginDTO(){
		return ldto;
	}
}
