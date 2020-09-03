/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Gemoire.Gemoire.entity;

import java.io.Serializable;
import java.net.URL;
import javax.persistence.*;

import lombok.Data;

/**
 *
 * @author jahaelle
 */
@Data
@Entity
public  class Pieces_jointes implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

   private String  name;
   private String  url;


   @OneToOne
   private Memoire memoire;

    public Pieces_jointes() {
    }

    public Pieces_jointes(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Memoire getMemoire() {
        return memoire;
    }

    public void setMemoire(Memoire memoire) {
        this.memoire = memoire;
    }
}
