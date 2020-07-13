/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Gemoire.Gemoire.dao;

import com.Gemoire.Gemoire.entity.Filiere;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jahaelle
 */
public interface FiliereDao extends JpaRepository<Filiere, Long>{
    
}
