package com.example.AeropuertoSV.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AeropuertoSV.entity.Cliente;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Long> {

}
