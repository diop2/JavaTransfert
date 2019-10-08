package com.devweb.rh.controller;


import com.devweb.rh.model.*;
import com.devweb.rh.repository.CompteRepository;
import com.devweb.rh.repository.PartenaireRepository;
import com.devweb.rh.repository.RoleRepository;
import com.devweb.rh.repository.UserRepository;
import com.devweb.rh.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import javax.naming.Name;
import java.lang.String;

import java.util.*;

@RestControllerAdvice
@CrossOrigin
@RequestMapping(value ="/service")
public class AjoutController {
    
    @Autowired
    CompteRepository compteRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    UserDetailsServiceImpl userDetailsService;
    @Autowired
     UserRepository userRepository ;
    @Autowired
    PartenaireRepository partenaireRepository;
    @PostMapping(value = "/add",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ADMIN')")
    public String add(@RequestBody(required = false) Ajout3 c) throws Exception{
        //return  partenaireRepository.save(c) ; // on peut utiliser aussi saveOnUpdate   return "redirect:/user";

        User userConnecte = userDetailsService.getUserConnecte();
        User u= new User();
        Partenaire p = new Partenaire();
        Compte co= new Compte();

        p.setNomEntreprise(c.getNomEntreprise());
        p.setNinea(c.getNinea());
        p.setRaisonSocial(c.getRaisonSocial());
        partenaireRepository.save(p);

        u.setUsername(c.getUsername());
        u.setPassword(encoder.encode(c.getPassword()));
        u.setName(c.getName());
        u.setEmail(c.getEmail());
        Set<Role> roles = new HashSet<>();
        Role role=new Role();
        role.setId(c.getRolee());//l id sera envoyé grace au value du select
        roles.add(role);
        u.setPartenaire(p);
        u.setUs(userConnecte);
        u.setRoles(roles);
        userRepository.save(u);



        co.setSolde(0);
        co.setNumeroCompte(c.getNumeroCompte());
        Date date = new Date();
        co.setDateCreation(date);
        co.setPartenaire(p);
        co.setUser(u);
        compteRepository.save(co);
        return "ok";
    }

    @PostMapping(value = "/addEmployer",consumes = {MediaType.APPLICATION_JSON_VALUE})
    @PreAuthorize("hasAuthority('ADMIN')")
    public String addEmployer(@RequestBody(required = false) Ajout3 c) throws Exception{
        User userConnecte = userDetailsService.getUserConnecte();
        User u= new User();
        u.setUsername(c.getUsername());
        u.setPassword(encoder.encode(c.getPassword()));
        u.setName(c.getName());
        u.setEmail(c.getEmail());
        Set<Role> roles = new HashSet<>();
        Role role=new Role();
        role.setId(c.getRolee());//l id sera envoyé grace au value du select
        roles.add(role);
        u.setUs(userConnecte);
        u.setRoles(roles);
        userRepository.save(u);
        return "Ajout Employer effectuer";
    }
}
