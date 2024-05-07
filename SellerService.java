package com.klef.jfsd.sdp.service;

import java.util.List;

import com.klef.jfsd.sdp.model.Seller;

public interface SellerService 
{
	public Seller checksellerlogin(String email,String pwd);
	public String insertseller(Seller seller);
	
}
