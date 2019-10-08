package com.devweb.rh.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Versement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private double montant;
    private Date dateDepot;

    @ManyToOne
    private Compte compte;

    @ManyToOne
    private User user;

    public Versement() {
    }

    public Versement(long montant, Date dateDepot, Compte compte, User user) {
        this.montant = montant;
        this.dateDepot = dateDepot;
        this.compte = compte;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Date getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(Date dateDepot) {
        this.dateDepot = dateDepot;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
