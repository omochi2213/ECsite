package com.internousdev.ecsite.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.ecsite.dao.BuyItemDAO;
import com.internousdev.ecsite.dto.BuyItemDTO;
import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport implements SessionAware{
	public Map<String,Object>session;
	public String execute(){
		String result ="login";
		if(session.containsKey("id")){
			BuyItemDAO bidao=new BuyItemDAO();
			BuyItemDTO bidto=bidao.getBuyItemInfo();
			session.put("id",bidto.getId());
			session.put("buyitem_name", bidto.getItemName());
			session.put("buyItem_price", bidto.getItemPrice());
			result=SUCCESS;
		}
		return result;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}


}
