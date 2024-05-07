package com.klef.jfsd.sdp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.sdp.model.Seller;
import com.klef.jfsd.sdp.repository.SellerRepository;

@Service
public class SellerServiceImpl implements SellerService
{
	@Autowired
	private SellerRepository sellerRepository;
	
	@Override
	public Seller checksellerlogin(String email, String pwd) 
	{
		return sellerRepository.checksellerlogin(email, pwd);
	}

	@Override
	public String insertseller(Seller seller) {
		sellerRepository.save(seller);
		return "Seller Added Successfully";
	}


}
