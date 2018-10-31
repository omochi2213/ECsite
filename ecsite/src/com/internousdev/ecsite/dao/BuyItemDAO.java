package com.internousdev.ecsite.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.ecsite.dto.BuyItemDTO;
import com.internousdev.ecsite.util.DBConnector;

public class BuyItemDAO {
	private DBConnector db=new DBConnector();
	private Connection con=db.getConnection();
	private BuyItemDTO bidto=new BuyItemDTO();

	public BuyItemDTO getBuyItemInfo(){
		String sql="select id,item_name,item_price from item_info_transaction";
		try{
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();

			if(rs.next()){
				bidto.setId(rs.getInt("id"));
				bidto.setItemName(rs.getString("item_name"));
				bidto.setItemPrice(rs.getString("item_price"));
			}
			}catch(Exception e){
				e.printStackTrace();
			}
			return bidto;
		}
	public BuyItemDTO getBuyItemDTO(){
		return bidto;
	}
}
