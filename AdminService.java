package com.klef.jfsd.sdp.service;

import java.util.List;

import com.klef.jfsd.sdp.model.Admin;
import com.klef.jfsd.sdp.model.Seller;

public interface AdminService 
{
	public Admin checkadminlogin(String uname,String pwd);
	public List<Seller> viewallsellers();
}
