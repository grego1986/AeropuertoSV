package com.example.AeropuertoSV.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.AeropuertoSV.entity.Asiento;



@Repository
public interface IAsientoRepository extends JpaRepository<Asiento, String> {

	@Query("SELECT COUNT(a) FROM Asiento a WHERE a.avion.id = :idAvion AND a.disponible = true")
    Long contarAsientosDisponiblesPorAvion(@Param("idAvion") Long idAvion);
	
}
