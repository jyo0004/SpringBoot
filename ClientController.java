package com.klef.jfsd.sdp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.klef.jfsd.sdp.model.Admin;
import com.klef.jfsd.sdp.model.Customer;
import com.klef.jfsd.sdp.model.Seller;
import com.klef.jfsd.sdp.service.AdminService;
import com.klef.jfsd.sdp.service.CustomerService;
import com.klef.jfsd.sdp.service.SellerService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ClientController 
{
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private SellerService sellerService;
	
	@GetMapping("/")
	public String main()
	{
		return "index";
	}
	
	@GetMapping("adminlogin")
	   public ModelAndView adminlogin()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("adminlogin");
	     return mv;
	   }
	
	   @PostMapping("checkadminlogin")
	   public ModelAndView checkadminlogin(HttpServletRequest request)
	   {
		   ModelAndView mv=new ModelAndView();
		   
		   String uname=request.getParameter("uname");
		   String pwd=request.getParameter("pwd");
		   
		   Admin a = adminService.checkadminlogin(uname, pwd);
		   
		   if(a!=null)
		   {
			   mv.setViewName("adminhome");

		   }
		   else 
		   {
			   mv.setViewName("login");
			   mv.addObject("message", "Login Failed");
		   }
		   return mv;
	   }
	   
	   
	   //customer
	   
	   @GetMapping("signup")
	   public ModelAndView empreg()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("signup");
	     return mv;
	   }

	   
	   
	   @PostMapping("insertclient")
		  public ModelAndView insert(HttpServletRequest request)
		  {
			  ModelAndView mv=new ModelAndView();
			  
			  String msg=null;
			  
			  try
			  {
				  String name = request.getParameter("username");
				  String email = request.getParameter("email");
				  String pwd = request.getParameter("password");
				  String contact = request.getParameter("contact");
				  
				  Customer customer=new Customer();
				  
				  customer.setName(name);
				  customer.setEmail(email);
				  customer.setPassword(pwd);
				  customer.setContactno(contact);
				  
				  msg=customerService.insertclient(customer);
				  
				  mv.setViewName("clientlogin");
				  mv.addObject("message", msg);
				  
			  }
			  catch(Exception e)
			  {
				  msg = e.getMessage();
		
			      mv.setViewName("displayerror");
				  mv.addObject("message", msg);
			  }
			  return mv;
		  }
	   
	   @GetMapping("clientlogin") 
	   public ModelAndView clientlogin()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("clientlogin");
	     return mv;
	   }

	   
	   @PostMapping("checkcustomerlogin")
	   public ModelAndView checkcustomerlogin(HttpServletRequest request)
	   {
	     ModelAndView mv = new ModelAndView();
	     
	     String email = request.getParameter("email");
	     String pwd = request.getParameter("pwd");
	     
	      Customer customer = customerService.checkcustomerlogin(email, pwd);
	       
	       if(customer!=null)
	       {
	    	   
	    	   HttpSession session=request.getSession();
	    	   session.setAttribute("cid", customer.getId());
	    	   session.setAttribute("cname", customer.getName());
	         
	           mv.setViewName("clienthome");
	       }
	       else
	       {
	         mv.setViewName("clientlogin");
	         mv.addObject("message", "Login Failed");
	       }
	       
	       return mv;
	   }
	   
	   //seller
	   
	   @GetMapping("sellersignup")
	   public ModelAndView sellersignup()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("sellersignup");
	     return mv;
	   }

	   
	   
	   @PostMapping("insertseller")
		  public ModelAndView insertseller(HttpServletRequest request)
		  {
			  ModelAndView mv=new ModelAndView();
			  
			  String msg=null;
			  
			  try
			  {
				  String name = request.getParameter("username");
				  String email = request.getParameter("email");
				  String pwd = request.getParameter("password");
				  String contact = request.getParameter("contact");
				  
				  Seller s=new Seller();
				  s.setName(name);
				  s.setEmail(email);
				  s.setPassword(pwd);
				  s.setContactno(contact);
				  
				  msg=sellerService.insertseller(s);
				  mv.setViewName("sellerlogin");
				  mv.addObject("message", msg);
				  
			  }
			  catch(Exception e)
			  {
				  msg = e.getMessage();
		
			      mv.setViewName("displayerror");
				  mv.addObject("message", msg);
			  }
			  return mv;
		  }
	   
	   @GetMapping("sellerlogin") 
	   public ModelAndView sellerlogin()
	   {
	     ModelAndView mv = new ModelAndView();
	     mv.setViewName("sellerlogin");
	     return mv;
	   }

	   
	   @PostMapping("checksellerlogin")
	   public ModelAndView checksellerlogin(HttpServletRequest request)
	   {
	     ModelAndView mv = new ModelAndView();
	     
	     String email = request.getParameter("email");
	     String pwd = request.getParameter("password");
	     
	     Seller seller = sellerService.checksellerlogin(email, pwd);
	       
	       if(seller!=null)
	       {
	    	   //session
	    	   
	    	   HttpSession session=request.getSession();
	    	   session.setAttribute("sid", seller.getId()); 
	    	   session.setAttribute("sname", seller.getName()); 
	         
	           mv.setViewName("sellerhome");
	       }
	       else
	       {
	         mv.setViewName("sellerlogin");
	         mv.addObject("message", "Login Failed");
	       }
	       
	       return mv;
	   }
	   
	   @GetMapping("viewallsellers")
	   public ModelAndView viewallsellers()
	   {
		   ModelAndView mv = new ModelAndView();
		   
		   List<Seller> seller = adminService.viewallsellers();
		   
		   mv.addObject("sdata", seller);
		   mv.setViewName("viewallsellers");
		   
		   return mv;
	   }
	   
	   
	   

	
}
