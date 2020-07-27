/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Gemoire.Gemoire.services.impl;

import com.Gemoire.Gemoire.dao.EncadreurDao;
import com.Gemoire.Gemoire.entity.Encadreur;
import com.Gemoire.Gemoire.entity.Filiere;
import com.Gemoire.Gemoire.services.IEncadreurResource;
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
public class EncadreurResource implements IEncadreurResource{
@Autowired
private EncadreurDao encadreurDao;
    @Override
    public ResponseEntity<Encadreur> addEncadreur(Encadreur encadreur) {
          Encadreur e = encadreurDao.save(encadreur);
         URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(e.getId())
                .toUri();
        return ResponseEntity.created(location).body(e);
    }

    @Override
    public ResponseEntity<Encadreur> updateEncadreur(long id, Encadreur encadreur) {

 return encadreurDao.findById(id).map(
                e -> {
                   e.setNomEncadreur(encadreur.getNomEncadreur());
                   e.setTitreEncadreur(encadreur.getGradeEncadreur());
                   e.setGradeEncadreur(encadreur.getTitreEncadreur());
                    return ResponseEntity.ok(encadreurDao.save(e));
                }
        ).orElse(
                ResponseEntity.notFound().build()
        );    }

    @Override
    public void deleteEncadreur(long id) {
        encadreurDao.deleteById(id);
    }

    @Override
    public Page<Encadreur> findAllEncadreurs(int page, int size) {
          return encadreurDao.findAll(PageRequest.of(page, size));
    }
    
}
