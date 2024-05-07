package com.klef.jfsd.sdp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.sdp.model.Admin;
import com.klef.jfsd.sdp.model.Seller;
import com.klef.jfsd.sdp.repository.AdminRepository;
import com.klef.jfsd.sdp.repository.SellerRepository;

@Service
public class AdminServiceImpl implements AdminService
{
	@Autowired
	public AdminRepository adminRepository;
	
	@Autowired
	public SellerRepository sellerrepo;
	
	
	@Override
	public Admin checkadminlogin(String uname, String pwd) 
	{
		return adminRepository.checkadminlogin(uname, pwd);
	}

	
	@Override
	public List<Seller> viewallsellers() 
	{
		
		return sellerrepo.findAll();
	}

}
