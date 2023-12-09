package com.example.AeropuertoSV.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.AeropuertoSV.entity.Avion;


@Repository
public interface IAvionRepository extends JpaRepository<Avion, Long>{
	
	@Query("SELECT COUNT(v) FROM Avion a JOIN a.vuelos v WHERE a.id = :avionId AND v.fecha = :fecha")
    int contarVuelosEnFecha(@Param("avionId") Long avionId, @Param("fecha") LocalDate fecha);
}
