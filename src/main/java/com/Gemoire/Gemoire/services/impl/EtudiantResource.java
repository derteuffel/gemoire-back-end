/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Gemoire.Gemoire.services.impl;

import com.Gemoire.Gemoire.dao.EtudiantDao;
import com.Gemoire.Gemoire.entity.Etudiant;
import com.Gemoire.Gemoire.services.IEtudiantResource;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 *
 * @author jahaelle
 */
public class EtudiantResource implements IEtudiantResource{
@Autowired
private EtudiantDao etudiantDao;
    @Override
    public ResponseEntity<Etudiant> addEtudiant(Etudiant etudiant) {
                Etudiant et = etudiantDao.save(etudiant);
                URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(et.getId())
                .toUri();
        return ResponseEntity.created(location).body(et);
    }

    @Override
    public ResponseEntity<Etudiant> updateEtudiant(long id, Etudiant etudiant) {
 return etudiantDao.findById(id).map(
                et -> {
                   et.setMatriculeEtudiant(etudiant.getMatriculeEtudiant());
                   et.setNomEtudiant(etudiant.getNomEtudiant());
                    return ResponseEntity.ok(etudiantDao.save(et));
                }
        ).orElse(
                ResponseEntity.notFound().build()
        );    }

    @Override
    public void deleteEtudiant(long id) {
               etudiantDao.deleteById(id);
        
        }
    
}
