/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Gemoire.Gemoire.services;

import com.Gemoire.Gemoire.entity.Etudiant;
import com.Gemoire.Gemoire.entity.Memoire;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author jahaelle
 */
@Path("/etudiants")
public interface IEtudiantResource {
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<Etudiant> addEtudiant(Etudiant etudiant);
    
     @PUT
    @Path("{id : \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<Etudiant> updateEtudiant(@PathParam("id") long id, Etudiant etudiant);
    
      @DELETE
    @Path("{id : \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteEtudiant(@PathParam("id") long id);
    
}
