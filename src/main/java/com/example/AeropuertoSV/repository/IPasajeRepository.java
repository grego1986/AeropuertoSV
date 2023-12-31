package com.example.AeropuertoSV.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.AeropuertoSV.entity.Pasaje;

@Repository
public interface IPasajeRepository extends JpaRepository<Pasaje, Long> {

}
