/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Gemoire.Gemoire.services.impl;

import com.Gemoire.Gemoire.dao.MemoireDao;
import com.Gemoire.Gemoire.entity.Memoire;
import com.Gemoire.Gemoire.helpers.MemoireHelper;
import com.Gemoire.Gemoire.services.IMemoireResource;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author jahaelle
 */
public class MemoireResource implements IMemoireResource {
    @Autowired
    private MemoireDao memoireDao;
    
    @Override
     public ResponseEntity<Memoire> addMemoire(MemoireHelper memoire){
        DateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy hh:mm");
        Date date = new Date();
         Memoire m =new Memoire();
         m.setTitre(memoire.getTitre());
         m.setResume(memoire.getResume());
         m.setAbstractMemoire(memoire.getAbstractMemoire());
         m.setNombreTelechargement(0L);
         m.setNombreVue(0L);
         m.setDateInsertion(sdf.format(date));
         m.setDateDerniereVue(sdf.format(date));
         m.setSession(sdf.format(memoire.getSession()));
         String[] strings=memoire.getMotCles().split(",");
         for (String item:strings){
             if (m.getMotCles().isEmpty()){
                 m.setMotCles(Arrays.asList(item));
             }else {
                 m.getMotCles().add(item);
             }
         }
         URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(m.getId())
                .toUri();
        return ResponseEntity.created(location).body(m);

                 }

    @Override
    public Page<Memoire> findAllMemoires(int page, int size) {
       return memoireDao.findAll(PageRequest.of(page, size));
    }

    @Override
    public ResponseEntity<Page<Memoire>> searchByEncadreur(String nomEncadreur, int page, int size) {
        return null;
    }

    @Override
    public ResponseEntity<Page<Memoire>> searchByMotCles(String motCles, int page, int size) {
        return null;
    }

    @Override
    public ResponseEntity<Page<Memoire>> searchByDiplome(String intituleDiplome, int page, int size) {
        return null;
    }

    @Override
    public ResponseEntity<Page<Memoire>> searchByTitre(String titre, int page, int size) {
        return null;
    }

   /* @Override
    public ResponseEntity<Page<Memoire>> searchByEncadreur(String nomEncadreur,int p, int size) {
      return (ResponseEntity<Page<Memoire>>) memoireDao.findByEncadreurNomEncadreurLike("%" +nomEncadreur + "%", PageRequest.of(p, size));
    }

    @Override
    public ResponseEntity<Page<Memoire>> searchByMotCles(String motCles,int p, int size) {
       return (ResponseEntity<Page<Memoire>>) memoireDao.findByMotClesLike("%" + motCles + "%", PageRequest.of(p, size));
    }

    @Override
    public ResponseEntity<Page<Memoire>> searchByDiplome(String intituleDiplome,int p, int size) {
         return (ResponseEntity<Page<Memoire>>) memoireDao.findByDiplomeIntituleDiplomeLike(intituleDiplome,PageRequest.of(p, size));
    }*/

    @Override
    public ResponseEntity<Memoire> updateMemoire(long id, Memoire memoire) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteMemoire(long id) {
         memoireDao.deleteById(id);
    }
   /* @Override
   public ResponseEntity<Page<Memoire>> searchByTitre(String titre, int page, int size) {
        return (ResponseEntity<Page<Memoire>>) memoireDao.findByTitre(titre, PageRequest.of(page, size));
   }*/

}
