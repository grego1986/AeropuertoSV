package com.example.AeropuertoSV.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AeropuertoSV.entity.TasaNacional;

@Repository
public interface ITasaNacionalRepository extends JpaRepository <TasaNacional,Integer> {

}
