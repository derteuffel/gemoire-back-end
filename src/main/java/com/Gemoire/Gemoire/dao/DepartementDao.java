/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Gemoire.Gemoire.dao;

import com.Gemoire.Gemoire.entity.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author jahaelle
 */
@Repository
public interface DepartementDao extends JpaRepository<Departement, Long>{
    
}
