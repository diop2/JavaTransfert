package com.devweb.rh.repository;

import com.devweb.rh.model.Versement;
import org.springframework.data.jpa.repository.JpaRepository;


public interface VersementRepository extends JpaRepository<Versement, Long> {
}
