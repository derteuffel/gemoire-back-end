/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Gemoire.Gemoire.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Data;

/**
 *
 * @author jahaelle
 */
@Data
@Entity
public class Memoire implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @Column(nullable=false)
    private String titre;
    @Column(nullable=false, length = 65536)
    private  String resume;
    @Column(nullable=false,length = 65536)
    private String abstract_memoire;
    @Column(nullable=false,length = 65536)
    private String contenu;
    @Column(nullable=false)
    private Long nombreTelechargement;
    @Column(nullable=false)
    private Long nombreVue;
    
    @ElementCollection
    @CollectionTable(name = "motCles")
    private List<String> motCles;
    @Column(nullable=false)
    private Date dateInsertion;
    @Column(nullable=false)
    private Date dateDerniereVue;
    @Column(nullable=false)
    private Date session;
    
    @ManyToOne
    private Etudiant etudiant;
    
    @ManyToOne
    private Encadreur encadreur;
    
    @ManyToOne
    private Diplome diplome;
    
   @ManyToOne
   private Filiere filiere;
    
}
