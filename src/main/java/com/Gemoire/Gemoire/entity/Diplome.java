/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Gemoire.Gemoire.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Data;

/**
 *
 * @author jahaelle
 */
@Data
@Entity
public class Diplome { 
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
@Column(nullable = false)
private String codeDiplome;
@Column(nullable = false)
private String intituleDiplome;

@OneToMany(mappedBy="diplome")
private List<Memoire> memoires;

@JsonIgnore
 @XmlTransient
@ManyToMany(mappedBy="diplome")
private List<Filiere> filiere;
      
     

    
}
