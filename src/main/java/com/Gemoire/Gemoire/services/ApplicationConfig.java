/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Gemoire.Gemoire.services;

import com.Gemoire.Gemoire.services.impl.DepartementResource;
import com.Gemoire.Gemoire.services.impl.DiplomeResource;
import com.Gemoire.Gemoire.services.impl.EncadreurResource;
import com.Gemoire.Gemoire.services.impl.EtudiantResource;
import com.Gemoire.Gemoire.services.impl.FiliereResource;
import com.Gemoire.Gemoire.services.impl.MemoireResource;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 *
 * @author jahaelle
 */
@Component
@ApplicationPath("/api")
public class ApplicationConfig extends ResourceConfig {
    public ApplicationConfig(){
        register(MemoireResource.class);
        register(DepartementResource.class);
        register(FiliereResource.class);
        register(DiplomeResource.class);
        register(EtudiantResource.class);
        register(EncadreurResource.class);
    }
}
