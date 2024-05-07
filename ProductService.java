package com.klef.jfsd.sdp.service;

import java.util.List;

import com.klef.jfsd.sdp.model.Product;

public interface ProductService 
{
	public String AddProduct(Product product);
	public List<Product> viewallproducts();
	public Product ViewProductByID(int productid);
	public void DeleteProductByID(int productid);
	public List<Product> viewallproductsbycategory(String category);
}
