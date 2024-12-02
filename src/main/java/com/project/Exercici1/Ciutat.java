package com.project.Exercici1;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ciutat")
public class Ciutat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ciutatId")
    private Long ciutatId;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "pais", nullable = false)
    private String pais;

    @Column(name = "codiPostal", nullable = false)
    private Integer codiPostal;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Ciutada> ciutadans;

    public long getCiutatId() {
        return ciutatId;
    }

    public void setCiutatId(long ciutatId) {
        this.ciutatId = ciutatId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getCodiPostal() {
        return codiPostal;
    }

    public void setCodiPostal(int codiPostal) {
        this.codiPostal = codiPostal;
    }

    public Set<Ciutada> getCiutadans() {
        return ciutadans;
    }

    public void setCiutadans(Set<Ciutada> ciutadans) {
        this.ciutadans = ciutadans;
    }

    @Override
    public String toString() {
        if (ciutadans == null) {
            return "Ciutat [ciutatId=" + ciutatId + ", nom=" + nom + ", pais=" + pais + ", codiPostal=" + codiPostal
                + ", ciutadans=lazy Initialized]";
        } else {
            return "Ciutat [ciutatId=" + ciutatId + ", nom=" + nom + ", pais=" + pais + ", codiPostal=" + codiPostal
                + ", ciutadans="+ciutadans+"]";
        }
        
    }


}