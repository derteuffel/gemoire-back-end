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
import lombok.Data;

/**
 *
 * @author jahaelle
 */
@Data
@Entity
public class Encadreur  implements Serializable{ 
@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
@Column(nullable = false)
private String nomEncadreur;
@Column(nullable = false)
private String titreEncadreur;
@Column(nullable = false)
private String gradeEncadreur;
    
@OneToMany(mappedBy="encadreur")
private List<Memoire> memoires;
}
