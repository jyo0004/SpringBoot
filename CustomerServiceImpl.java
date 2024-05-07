package com.klef.jfsd.sdp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.sdp.model.Customer;
import com.klef.jfsd.sdp.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService
{
	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Customer checkcustomerlogin(String email, String pwd) 
	{
		return customerRepository.checkcustomerlogin(email, pwd);
	}

	@Override
	public String insertclient(Customer customer) 
	{
		customerRepository.save(customer);
		return "Client Added Successfully";
	}

}
