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
public class Examinateur implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_examinateur;
    @Column(name = "nom_examinateur",nullable = false)
    private String nom_examinateur;
    @Column(name = "specialite_exa",nullable = true)
    private String specialite_exa;
    
    @OneToMany(mappedBy="examinateur")
    private List<Memoire> memoires;

    public List<Memoire> getMemoires() {
        return memoires;
    }

    public void setMemoires(List<Memoire> memoires) {
        this.memoires = memoires;
    }

    public String getSpecialite_exa() {
        return specialite_exa;
    }

    public void setSpecialite_exa(String specialite_exa) {
        this.specialite_exa = specialite_exa;
    }

    public Examinateur(Long id_examinateur, String nom_examinateur, String specialite_exa) {
        this.id_examinateur = id_examinateur;
        this.nom_examinateur = nom_examinateur;
        this.specialite_exa = specialite_exa;
    }

    public Long getId_examinateur() {
        return id_examinateur;
    }

    public void setId_examinateur(Long id_examinateur) {
        this.id_examinateur = id_examinateur;
    }

    public String getNom_examinateur() {
        return nom_examinateur;
    }

    public void setNom_examinateur(String nom_examinateur) {
        this.nom_examinateur = nom_examinateur;
    }

    public Examinateur(){
    
    }

    
    
}
