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
public class Auteur implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_auteur;
    @Column(name = "nom_auteur",nullable = false)
    private String nom_auteur;
    @Column(name = "filiere",nullable = false)
    private String filiere;
    @Column(name = "option_auteur",nullable = false)
    private String option_auteur;

    public Auteur(Long id_auteur, String nom_auteur, String filiere, String option_auteur, String niveau_etude, List<Memoire> memoires) {
        this.id_auteur = id_auteur;
        this.nom_auteur = nom_auteur;
        this.filiere = filiere;
        this.option_auteur = option_auteur;
        this.niveau_etude = niveau_etude;
        this.memoires = memoires;
    }

    public String getOption_auteur() {
        return option_auteur;
    }

    public void setOption_auteur(String option_auteur) {
        this.option_auteur = option_auteur;
    }
    @Column(name = "niveau_etude",nullable = false)
    private String niveau_etude;
    
    @OneToMany(mappedBy="auteur")
    private List<Memoire> memoires;

    public List<Memoire> getMemoires() {
        return memoires;
    }

    public void setMemoires(List<Memoire> memoires) {
        this.memoires = memoires;
    }

    public Long getId_auteur() {
        return id_auteur;
    }

    public void setId_auteur(Long id_auteur) {
        this.id_auteur = id_auteur;
    }

    public String getNom_auteur() {
        return nom_auteur;
    }

    public void setNom_auteur(String nom_auteur) {
        this.nom_auteur = nom_auteur;
    }

    public String getFiliere() {
        return filiere;
    }

    public void setFiliere(String filiere) {
        this.filiere = filiere;
    }

   

    public String getNiveau_etude() {
        return niveau_etude;
    }

    public void setNiveau_etude(String niveau_etude) {
        this.niveau_etude = niveau_etude;
    }


    public Auteur(){
        
    }
    
}