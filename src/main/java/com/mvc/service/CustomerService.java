package com.mvc.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mvc.vo.Customer;

//client(CustomerApp.java)
public interface CustomerService {
	public List<Customer> selectAll();
	public Customer selectOne(String num);
	public int insert(Customer c);
	
	@Transactional
	public void insert2(Customer c)  throws Exception;
	
	public int delete(String num);
	public List<Customer> findByAddress(String address);
	public int update(Customer c);
	
}





