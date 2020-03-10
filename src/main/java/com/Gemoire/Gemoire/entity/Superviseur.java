/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Gemoire.Gemoire.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author jahaelle
 */
@Entity
public class Superviseur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_superviseur;
    @Column(name = "nom_superviseur",nullable = false)
    private String nom_superviseur;
    @Column(name = "specialite_sup",nullable = true)
    private String specialite_sup;
    
    @OneToMany(mappedBy="superviseur")
private List<Memoire> memoires;

    public List<Memoire> getMemoires() {
        return memoires;
    }

    public void setMemoires(List<Memoire> memoires) {
        this.memoires = memoires;
    }
    
    public String getSpecialite_sup() {
        return specialite_sup;
    }

    public void setSpecialite_sup(String specialite_sup) {
        this.specialite_sup = specialite_sup;
    }

    public Superviseur(Long id_superviseur, String nom_superviseur, String specialite_sup) {
        this.id_superviseur = id_superviseur;
        this.nom_superviseur = nom_superviseur;
        this.specialite_sup = specialite_sup;
    }

    

    public Long getId_superviseur() {
        return id_superviseur;
    }

    public void setId_superviseur(Long id_superviseur) {
        this.id_superviseur = id_superviseur;
    }

    public String getNom_superviseur() {
        return nom_superviseur;
    }

    public void setNom_superviseur(String nom_superviseur) {
        this.nom_superviseur = nom_superviseur;
    }
public Superviseur(){

}

    
}
