/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Gemoire.Gemoire.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author jahaelle
 */@Entity
public class Memoire implements Serializable{
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_memoire;
     @Column(name = "titre" ,nullable = false)
    private String titre;
     @Column(name = "categorie" ,nullable = false)
    private String categorie;
     @Column(name = "date_insertion" ,nullable = false)
    private Date date_insertion;
     @GeneratedValue(strategy = GenerationType.AUTO)
    private Long nombre_telechargement;

     @ManyToOne
     private Superviseur superviseur;
     
     @ManyToOne
     private Examinateur examinateur;
     
     @ManyToOne
     private Auteur auteur;
     
    public Long getId_memoire() {
        return id_memoire;
    }

    public void setId_memoire(Long id_memoire) {
        this.id_memoire = id_memoire;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Date getDate_insertion() {
        return date_insertion;
    }

    public void setDate_insertion(Date date_insertion) {
        this.date_insertion = date_insertion;
    }

    public Long getNombre_telechargement() {
        return nombre_telechargement;
    }

    public void setNombre_telechargement(Long nombre_telechargement) {
        this.nombre_telechargement = nombre_telechargement;
    }
     public Memoire(){
         
     }

    public Memoire(Long id_memoire, String titre, String categorie, Date date_insertion, Long nombre_telechargement) {
        this.id_memoire = id_memoire;
        this.titre = titre;
        this.categorie = categorie;
        this.date_insertion = date_insertion;
        this.nombre_telechargement = nombre_telechargement;
    }
    
}
