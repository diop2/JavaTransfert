package com.devweb.rh.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Partenaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nomEntreprise;
    private String ninea;
    private String raisonSocial;




    public String getNomEntreprise() {
        return nomEntreprise;
    }

    public Partenaire() {
    }

    public Partenaire(String nomEntreprise, String ninea, String raisonSocial) {
        this.nomEntreprise = nomEntreprise;
        this.ninea = ninea;
        this.raisonSocial = raisonSocial;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomEntreprise(String nomEntreprise) {
        return this.nomEntreprise;
    }

    public void setNomEntreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
    }

    public String getNinea() {
        return ninea;
    }

    public void setNinea(String ninea) {
        this.ninea = ninea;
    }

    public String getRaisonSocial() {
        return raisonSocial;
    }

    public void setRaisonSocial(String raisonSocial) {
        this.raisonSocial = raisonSocial;
    }


}
