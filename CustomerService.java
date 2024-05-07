package com.klef.jfsd.sdp.service;

import com.klef.jfsd.sdp.model.Customer;

public interface CustomerService 
{
	public Customer checkcustomerlogin(String email,String pwd);
	public String insertclient(Customer customer);
}
