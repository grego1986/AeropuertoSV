package com.example.AeropuertoSV.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.AeropuertoSV.entity.Ciudad;
import com.example.AeropuertoSV.entity.Nacional;
import com.example.AeropuertoSV.entity.Vuelo;

@Repository
public interface INacionalRepository extends JpaRepository<Nacional, String>{
	
	@Query("SELECT n FROM Nacional n WHERE n.fecha = :fecha" +
	           " AND (:ciudadOrigen is null or n.origen = :ciudadOrigen)" +
	           " AND (:ciudadDestino is null or n.destino = :ciudadDestino)" + 
	           "ORDER BY n.hora")
	    public List<Nacional> buscarVuelosPorFechaYFiltros(
	            @Param("fecha") LocalDate fecha,
	            @Param("ciudadOrigen") Ciudad ciudadOrigen,
	            @Param("ciudadDestino") Ciudad ciudadDestino);

}
