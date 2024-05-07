package com.klef.jfsd.sdp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.klef.jfsd.sdp.model.Seller;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Integer>
{
	@Query("select s from Seller s where s.email=?1 and s.password=?2")
	public Seller checksellerlogin(String email,String pwd);
}
