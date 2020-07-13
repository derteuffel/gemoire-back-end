/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Gemoire.Gemoire.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jahaelle
 */
public class Departement  implements Serializable{ 
@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_departement;
@Column(name = "code_departement",nullable = false)
private String code_departement;
@Column(name = "intitule_departement",nullable = false)
private String intitule_departement;
    
}
