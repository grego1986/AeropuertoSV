package com.example.AeropuertoSV.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.AeropuertoSV.entity.Ciudad;
import com.example.AeropuertoSV.entity.Vuelo;


@Repository
public interface IVueloRepository extends JpaRepository<Vuelo, String> {
	
	@Query("SELECT v FROM Vuelo v WHERE v.fecha = :fecha" +
	           " AND (:ciudadOrigen is null or v.origen = :ciudadOrigen)" +
	           " AND (:ciudadDestino is null or v.destino = :ciudadDestino)" + 
	           "ORDER BY v.hora")
	    public List<Vuelo> buscarVuelosPorFechaYFiltros(
	            @Param("fecha") LocalDate fecha,
	            @Param("ciudadOrigen") Ciudad ciudadOrigen,
	            @Param("ciudadDestino") Ciudad ciudadDestino);

}
