/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Gemoire.Gemoire.dao;

import com.Gemoire.Gemoire.entity.Memoire;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author jahaelle
 */
@Repository
public interface MemoireDao extends JpaRepository<Memoire, Long>{
    //rechercher un memoire par nom d'un encadreur
    List<Memoire> findAllByEncadreur_Id(Long id, Sort sort);
    //rechercher un memoire par diplome
    List<Memoire> findAllByDiplome_Id(Long id, Sort sort);
  //rechercher un diplome par mot cles
  public Page<Memoire> findByMotClesLike(String motCles,Pageable p);
  //rrechercher un memoire par departement
  //public Page<Memoire> findByDepartementIntituleDepartementLike(String intituleDepartement,Pageable p);
  //rechercher un memoire par titre
   List<Memoire> findAllByTitre(String titre,Sort sort);
  
}
