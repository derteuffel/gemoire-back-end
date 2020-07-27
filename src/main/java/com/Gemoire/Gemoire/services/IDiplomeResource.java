/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Gemoire.Gemoire.services;

import com.Gemoire.Gemoire.entity.Diplome;
import com.Gemoire.Gemoire.entity.Etudiant;
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
@Path("/diplomes")
public interface IDiplomeResource {
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<Diplome> addDiplome(Diplome diplome);
    
     @POST
    @Path("{id : \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<Diplome> updateDiplome(@PathParam("id") long id, Diplome diplome);
    
      @DELETE
    @Path("{id : \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteDiplome(@PathParam("id") long id);
    
    
}
