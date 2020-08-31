/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Gemoire.Gemoire.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Data;

/**
 *
 * @author jahaelle
 */
@Data
@Entity
public class Filiere implements Serializable{ 
@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
@Column(nullable = false)
private String codeFiliere;
@Column(nullable = false)
private String intituleFiliere;

@JsonIgnore
 @XmlTransient
@OneToMany(mappedBy="filiere")
private List<Memoire> memoires;

@JsonIgnore
 @XmlTransient
@ManyToMany
private List<Diplome> diplome;

@ManyToOne
private  Departement departement;

    public Filiere() {
    }

    public Filiere(Long id, String codeFiliere, String intituleFiliere) {
        this.id = id;
        this.codeFiliere = codeFiliere;
        this.intituleFiliere = intituleFiliere;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeFiliere() {
        return codeFiliere;
    }

    public void setCodeFiliere(String codeFiliere) {
        this.codeFiliere = codeFiliere;
    }

    public String getIntituleFiliere() {
        return intituleFiliere;
    }

    public void setIntituleFiliere(String intituleFiliere) {
        this.intituleFiliere = intituleFiliere;
    }

    public List<Memoire> getMemoires() {
        return memoires;
    }

    public void setMemoires(List<Memoire> memoires) {
        this.memoires = memoires;
    }

    public List<Diplome> getDiplome() {
        return diplome;
    }

    public void setDiplome(List<Diplome> diplome) {
        this.diplome = diplome;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
}
