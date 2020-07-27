/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Gemoire.Gemoire.services;

import com.Gemoire.Gemoire.entity.Departement;
import com.Gemoire.Gemoire.entity.Diplome;
import com.Gemoire.Gemoire.entity.Etudiant;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author jahaelle
 */
@Path("/departements")
public interface IDepartementResource {
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<Departement> addDepartement(Departement departement);
    
     @POST
    @Path("{id : \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<Departement> updateDepartement(@PathParam("id") long id, Departement departement);
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Page<Departement>findAllDepartements(@QueryParam("page") @DefaultValue("0") int page, @QueryParam("size") @DefaultValue("10")int size);
    
    
    @DELETE
    @Path("{id : \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteDepartement(@PathParam("id") long id);
}
