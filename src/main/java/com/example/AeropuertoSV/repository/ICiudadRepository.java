package com.example.AeropuertoSV.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.AeropuertoSV.entity.Ciudad;

@Repository
public interface ICiudadRepository extends JpaRepository<Ciudad, Integer> {

}
