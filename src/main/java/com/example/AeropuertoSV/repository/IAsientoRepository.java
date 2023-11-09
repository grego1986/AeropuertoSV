package com.example.AeropuertoSV.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AeropuertoSV.entity.Asiento;
import com.example.AeropuertoSV.entity.AsientoAvionId;



@Repository
public interface IAsientoRepository extends JpaRepository<Asiento, AsientoAvionId> {

}
