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
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;
import lombok.Data;

/**
 *
 * @author jahaelle
 */
@Data
@Entity
public class Encadreur  implements Serializable{ 
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(nullable = false)
private String nomEncadreur;
@Column(nullable = false)
private String titreEncadreur;
@Column(nullable = false)
private String gradeEncadreur;
 @JsonIgnore
 @XmlTransient
@OneToMany(mappedBy="encadreur")
private List<Memoire> memoires;

 public Long getId() {
  return id;
 }

 public void setId(Long id) {
  this.id = id;
 }

 public String getNomEncadreur() {
  return nomEncadreur;
 }

 public void setNomEncadreur(String nomEncadreur) {
  this.nomEncadreur = nomEncadreur;
 }

 public String getTitreEncadreur() {
  return titreEncadreur;
 }

 public void setTitreEncadreur(String titreEncadreur) {
  this.titreEncadreur = titreEncadreur;
 }

 public String getGradeEncadreur() {
  return gradeEncadreur;
 }

 public void setGradeEncadreur(String gradeEncadreur) {
  this.gradeEncadreur = gradeEncadreur;
 }

 public List<Memoire> getMemoires() {
  return memoires;
 }

 public void setMemoires(List<Memoire> memoires) {
  this.memoires = memoires;
 }
}
