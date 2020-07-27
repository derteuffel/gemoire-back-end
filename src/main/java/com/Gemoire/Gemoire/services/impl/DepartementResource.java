/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Gemoire.Gemoire.services.impl;

import com.Gemoire.Gemoire.dao.DepartementDao;
import com.Gemoire.Gemoire.entity.Departement;
import com.Gemoire.Gemoire.services.IDepartementResource;
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
public class DepartementResource implements IDepartementResource{
@Autowired
private DepartementDao departementDao;
    @Override
    public ResponseEntity<Departement> addDepartement(Departement departement) {
        Departement de = departementDao.save(departement);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(de.getId())
                .toUri();
        return ResponseEntity.created(location).body(de);
    }

    @Override
    public ResponseEntity<Departement> updateDepartement(long id, Departement departement) {
 return departementDao.findById(id).map(
                de -> {
                    de.setCodeDepartement(departement.getCodeDepartement());
                   de.setIntituleDepartement(departement.getIntituleDepartement());
                    return ResponseEntity.ok(departementDao.save(de));
                }
        ).orElse(
                ResponseEntity.notFound().build()
        );    }
    

    @Override
    public void deleteDepartement(long id) {
        departementDao.deleteById(id);
    }

    @Override
    public Page<Departement> findAllDepartements(int page, int size) {
           return departementDao.findAll(PageRequest.of(page, size));
    }
    
}
