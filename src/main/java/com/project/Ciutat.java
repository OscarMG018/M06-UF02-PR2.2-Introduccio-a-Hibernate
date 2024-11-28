package com.project;

import java.util.Set;

public class Ciutat {
    
    private long ciutatId;
    private String nom;
    private String pais;
    private int codiPostal;
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