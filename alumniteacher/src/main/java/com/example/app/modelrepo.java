package com.example.app;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;



public interface modelrepo extends JpaRepository<modelalumni,Long> {
	public modelalumni findByNameAndYear(String name,String year);

	
}



