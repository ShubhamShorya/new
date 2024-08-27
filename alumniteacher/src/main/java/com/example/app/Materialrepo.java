package com.example.app;


import java.math.BigInteger;
import java.sql.Blob;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;





@Repository
public interface Materialrepo extends JpaRepository<Materialmodel, Long> {

	public Materialmodel findByPdf(Blob pdf);
	
}
