package com.example.AeropuertoSV.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.AeropuertoSV.entity.Ciudad;
import com.example.AeropuertoSV.entity.Pais;

@Repository
public interface ICiudadRepository extends JpaRepository<Ciudad, Integer> {
	
	List<Ciudad> findByPais(Pais pais);

}
