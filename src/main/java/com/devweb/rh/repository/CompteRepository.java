package com.devweb.rh.repository;

import com.devweb.rh.model.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository <Compte, Long> {
    Compte findByNumeroCompte(String numerocompte);
}
