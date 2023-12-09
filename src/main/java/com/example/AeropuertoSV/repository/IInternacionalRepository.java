package com.example.AeropuertoSV.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.AeropuertoSV.entity.Ciudad;
import com.example.AeropuertoSV.entity.Internacional;
import com.example.AeropuertoSV.entity.Vuelo;

@Repository
public interface IInternacionalRepository extends JpaRepository<Internacional, String> {

	@Query("SELECT i FROM Internacional i WHERE i.fecha = :fecha" +
	           " AND (:ciudadOrigen is null or i.origen = :ciudadOrigen)" +
	           " AND (:ciudadDestino is null or i.destino = :ciudadDestino)" +
	           "ORDER BY i.hora")
	    public List<Internacional> buscarVuelosPorFechaYFiltros(
	            @Param("fecha") LocalDate fecha,
	            @Param("ciudadOrigen") Ciudad ciudadOrigen,
	            @Param("ciudadDestino") Ciudad ciudadDestino);
}
