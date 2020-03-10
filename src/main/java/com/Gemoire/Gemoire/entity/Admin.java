/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Gemoire.Gemoire.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author jahaelle
 */
@Entity
public class Admin implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_admin;
   @Column(name = "nom_admin",nullable = false)
    private String nom_admin;
   @Column(name = "password",nullable = false)
    private String password;

    public Integer getId_admin() {
        return id_admin;
    }

    public void setId_admin(Integer id_admin) {
        this.id_admin = id_admin;
    }

    public String getNom_admin() {
        return nom_admin;
    }

    public void setNom_admin(String nom_admin) {
        this.nom_admin = nom_admin;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Admin(Integer id_admin, String nom_admin, String password) {
        this.id_admin = id_admin;
        this.nom_admin = nom_admin;
        this.password = password;
    }
   public Admin(){
       
   }
    
}
