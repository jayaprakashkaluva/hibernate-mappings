package com.jp.userservice.dao;

import com.jp.userservice.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User,Long>{
	
	@Query("SELECT p FROM User p LEFT JOIN FETCH p.billingAddress LEFT JOIN FETCH p.shippingAddress") 
	public List<User> findAll();
}
