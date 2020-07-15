/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Gemoire.Gemoire.services.impl;

import com.Gemoire.Gemoire.dao.FiliereDao;
import com.Gemoire.Gemoire.entity.Filiere;
import com.Gemoire.Gemoire.services.IFiliereResource;
import java.net.URI;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author jahaelle
 */
public class FiliereResource implements IFiliereResource{
    @Autowired
    private FiliereDao filiereDao;

    @Override
    public ResponseEntity<Filiere> addFiliere(Filiere filiere) {
         Filiere f = filiereDao.save(filiere);
         URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(f.getId())
                .toUri();
        return ResponseEntity.created(location).body(f);
    } 

    @Override
    public ResponseEntity<Filiere> findFiliere(long id) {
         Optional<Filiere> filiere = filiereDao.findById(id);
        if (filiere.isPresent()) {
            return ResponseEntity.ok(filiere.get());
        }
        return ResponseEntity.notFound().build();
    
    }

    @Override
    public ResponseEntity<Filiere> updateFiliere(long id, Filiere filiere) {
 return filiereDao.findById(id).map(
                 f-> {
                    f.setCodeFiliere(filiere.getCodeFiliere());
                   f.setIntituleFiliere(filiere.getIntituleFiliere());
                    return ResponseEntity.ok(filiereDao.save(f));
                }
        ).orElse(
                ResponseEntity.notFound().build()
        );    }

    @Override
    public void deleteFiliere(long id) {
        filiereDao.deleteById(id);
    }
    
}
