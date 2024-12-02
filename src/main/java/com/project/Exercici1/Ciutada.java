package com.project.Exercici1;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Ciutada")
public class Ciutada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ciutadaId")
    private Long ciutadaId;
    
    @Column(name = "ciutatId", nullable = true)
    private Long ciutatId;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "cognom", nullable = false)
    private String cognom;

    @Column(name = "edat", nullable = false)
    private Integer edat;

    public long getCiutadaId() {
        return ciutadaId;
    }
    public void setCiutadaId(long ciutadaId) {
        this.ciutadaId = ciutadaId;
    }
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
    public String getCognom() {
        return cognom;
    }
    public void setCognom(String cognom) {
        this.cognom = cognom;
    }
    public int getEdat() {
        return edat;
    }
    public void setEdat(int edat) {
        this.edat = edat;
    }
    @Override
    public String toString() {
        return "Ciutada [ciutadaId=" + ciutadaId + ", ciutatId=" + ciutatId + ", nom=" + nom + ", cognom=" + cognom
                + ", edat=" + edat + "]";
    }
    
}