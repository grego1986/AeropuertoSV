package com.example.AeropuertoSV.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AeropuertoSV.entity.Pais;

@Repository
public interface IPaisRepository extends JpaRepository<Pais, Integer> {

}
