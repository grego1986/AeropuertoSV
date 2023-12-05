package com.example.AeropuertoSV.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AeropuertoSV.entity.TasaInternacional;

@Repository
public interface ITasaInternacionalRepository extends JpaRepository <TasaInternacional,Integer> {

	
	
}
