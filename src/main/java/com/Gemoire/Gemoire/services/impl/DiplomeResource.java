/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Gemoire.Gemoire.services.impl;

import com.Gemoire.Gemoire.dao.DiplomeDao;
import com.Gemoire.Gemoire.entity.Diplome;
import com.Gemoire.Gemoire.services.IDiplomeResource;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author jahaelle
 */
public class DiplomeResource implements IDiplomeResource{
@Autowired
private DiplomeDao diplomeDao;
    @Override
    public ResponseEntity<Diplome> addDiplome(Diplome diplome) {
        Diplome d = diplomeDao.save(diplome);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(d.getId())
                .toUri();
        return ResponseEntity.created(location).body(d);
    }

    @Override
    public ResponseEntity<Diplome> updateDiplome(long id, Diplome diplome) {
         return diplomeDao.findById(id).map(
                d -> {
                    d.setCodeDiplome(diplome.getCodeDiplome());
                    d.setIntituleDiplome(diplome.getIntituleDiplome());
                    return ResponseEntity.ok(diplomeDao.save(d));
                }
        ).orElse(
                ResponseEntity.notFound().build()
        );
    }

    @Override
    public void deleteDiplome(long id) {
        diplomeDao.deleteById(id);
    }
    
    
}
