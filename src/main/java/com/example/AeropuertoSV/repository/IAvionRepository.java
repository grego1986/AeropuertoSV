package com.example.AeropuertoSV.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.AeropuertoSV.entity.Avion;


@Repository
public interface IAvionRepository extends JpaRepository<Avion, Long>{
	
}
