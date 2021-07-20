package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.pojo.ConversionMultiple;

@Repository
public interface ConversionMultipleRepository extends JpaRepository<ConversionMultiple, Integer>{
	
	

}
