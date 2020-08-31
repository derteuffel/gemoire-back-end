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
import lombok.Getter;
import lombok.Setter;

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
    private String abstractMemoire;
    @Column(nullable=false)
    private Long nombreTelechargement;
    @Column(nullable=false)
    private Long nombreVue;

    private String options;
    
    @ElementCollection
    @CollectionTable(name = "motCles")
    private List<String> motCles;
    @Column(nullable=false)
    private String dateInsertion;
    @Column(nullable=false)
    private String dateDerniereVue;
    @Column(nullable=false)
    private String session;

    private String nomEtudiant;
    private String nomEncadreur;
    private String titreDiplome;
    private String titreFiliere;

    @ManyToOne
    private Etudiant etudiant;
    
    @ManyToOne
    private Encadreur encadreur;
    
    @ManyToOne
    private Diplome diplome;
    
   @ManyToOne
   private Filiere filiere;

    public Memoire() {
    }

    public Memoire(Long id, String titre, String resume, String abstractMemoire, Long nombreTelechargement, Long nombreVue, String options, List<String> motCles, String dateInsertion, String dateDerniereVue, String session,
                   String nomEtudiant, String nomEncadreur, String titreDiplome, String titreFiliere) {
        this.id = id;
        this.titre = titre;
        this.resume = resume;
        this.abstractMemoire = abstractMemoire;
        this.nombreTelechargement = nombreTelechargement;
        this.nombreVue = nombreVue;
        this.options = options;
        this.motCles = motCles;
        this.dateInsertion = dateInsertion;
        this.dateDerniereVue = dateDerniereVue;
        this.session = session;
        this.nomEtudiant = nomEtudiant;
        this.nomEncadreur = nomEncadreur;
        this.titreDiplome = titreDiplome;
        this.titreFiliere = titreFiliere;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getAbstractMemoire() {
        return abstractMemoire;
    }

    public void setAbstractMemoire(String abstractMemoire) {
        this.abstractMemoire = abstractMemoire;
    }

    public Long getNombreTelechargement() {
        return nombreTelechargement;
    }

    public void setNombreTelechargement(Long nombreTelechargement) {
        this.nombreTelechargement = nombreTelechargement;
    }

    public Long getNombreVue() {
        return nombreVue;
    }

    public void setNombreVue(Long nombreVue) {
        this.nombreVue = nombreVue;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public List<String> getMotCles() {
        return motCles;
    }

    public void setMotCles(List<String> motCles) {
        this.motCles = motCles;
    }

    public String getDateInsertion() {
        return dateInsertion;
    }

    public void setDateInsertion(String dateInsertion) {
        this.dateInsertion = dateInsertion;
    }

    public String getDateDerniereVue() {
        return dateDerniereVue;
    }

    public void setDateDerniereVue(String dateDerniereVue) {
        this.dateDerniereVue = dateDerniereVue;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public String getNomEncadreur() {
        return nomEncadreur;
    }

    public void setNomEncadreur(String nomEncadreur) {
        this.nomEncadreur = nomEncadreur;
    }

    public String getTitreDiplome() {
        return titreDiplome;
    }

    public void setTitreDiplome(String titreDiplome) {
        this.titreDiplome = titreDiplome;
    }

    public String getTitreFiliere() {
        return titreFiliere;
    }

    public void setTitreFiliere(String titreFiliere) {
        this.titreFiliere = titreFiliere;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Encadreur getEncadreur() {
        return encadreur;
    }

    public void setEncadreur(Encadreur encadreur) {
        this.encadreur = encadreur;
    }

    public Diplome getDiplome() {
        return diplome;
    }

    public void setDiplome(Diplome diplome) {
        this.diplome = diplome;
    }

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }
}
