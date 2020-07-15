/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Gemoire.Gemoire.services.impl;

import com.Gemoire.Gemoire.dao.MemoireDao;
import com.Gemoire.Gemoire.entity.Memoire;
import com.Gemoire.Gemoire.services.IMemoireResource;
import java.net.URI;
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
     public ResponseEntity<Memoire> addMemoire(Memoire memoire){
         Memoire m =memoireDao.save(memoire);
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
    }

    @Override
    public ResponseEntity<Memoire> updateMemoire(long id, Memoire memoire) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteMemoire(long id) {
         memoireDao.deleteById(id);
    }

    @Override
    public ResponseEntity<Page<Memoire>> searchByTitre(String titre, int page, int size) {
        return (ResponseEntity<Page<Memoire>>) memoireDao.findByTitre(titre, PageRequest.of(page, size));
    }

}
