package com.example.AeropuertoSV.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.AeropuertoSV.entity.Internacional;

@Repository
public interface IInternacionalRepository extends JpaRepository<Internacional, Long> {

}
