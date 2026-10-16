package com.sena.practica03.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity 
public class Usuario {
    @Id 
    private Integer numDoc;
    private String nom;
    public String ape;
    public LocalDate fecNac;

    //cosntructores
    public Usuario() {
    }

//costrutor con todos los atributos

    public Usuario(Integer numDoc, String nom, String ape, LocalDate fecNac) {
        this.numDoc = numDoc;
        this.nom = nom;
        this.ape = ape;
        this.fecNac = fecNac;
    }
    

    //getters y setters
    public Integer getNumDoc() {
        return numDoc;
    }

    public void setNumDoc(Integer numDoc) {
        this.numDoc = numDoc;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getApe() {
        return ape;
    }

    public void setApe(String ape) {
        this.ape = ape;
    }

    public LocalDate getFecNac() {
        return fecNac;
    }

    public void setFecNac(LocalDate fecNac) {
        this.fecNac = fecNac;
    }
}
