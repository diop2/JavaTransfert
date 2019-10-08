package com.devweb.rh.controller;

import com.devweb.rh.model.*;
import com.devweb.rh.repository.CompteRepository;
import com.devweb.rh.repository.UserRepository;
import com.devweb.rh.repository.VersementRepository;
import com.devweb.rh.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestControllerAdvice
@CrossOrigin
@RequestMapping(value ="/traitement")
public class TraitementController {

    @Autowired
    CompteRepository compteRepository;
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Autowired
    UserRepository userRepository ;
    @Autowired
    VersementRepository versementRepository;

    @PostMapping(value = "/depot",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ADMIN')")
    public String depot(@RequestBody(required = false) TraitementModel t) throws Exception{
        User userConnecte = userDetailsService.getUserConnecte();
        Versement v = new Versement();
        Compte compte =compteRepository.findByNumeroCompte(t.getNumeroCompte());
        compte.setSolde(compte.getSolde()+t.getMontant());
        compteRepository.save(compte);
        v.setMontant(t.getMontant());
        v.setCompte(compte);
        Date date = new Date();
        v.setDateDepot(date);
        v.setUser(userConnecte);
        versementRepository.save(v);

        return "depot effectuer";
    }
}
