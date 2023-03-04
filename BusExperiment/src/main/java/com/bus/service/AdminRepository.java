package com.bus.service;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bus.beans.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer>{

	public Admin findByUsernameAndPassword(String username,String Password);
} 
