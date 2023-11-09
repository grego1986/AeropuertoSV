package com.example.AeropuertoSV.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.AeropuertoSV.entity.Pasaporte;

@Repository
public interface IPasaporteRepository extends JpaRepository<Pasaporte, Long> {

}
