/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Gemoire.Gemoire.services;

import com.Gemoire.Gemoire.entity.Filiere;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.DefaultValue;
import org.springframework.data.domain.Page;
import javax.ws.rs.core.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 *
 * @author jahaelle
 */
@CrossOrigin("*")
@Path("/filieres")
public interface IFiliereResource {
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<Filiere> addFiliere(Filiere filiere);
    
    @GET
    @Path("{id : \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<Filiere> findFiliere(@PathParam("id") long id);
    
    @POST
    @Path("{id : \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<Filiere> updateFiliere(@PathParam("id") long id, Filiere filiere);
    
    @DELETE
    @Path("{id : \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteFiliere(@PathParam("id") long id);
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Page<Filiere>findAllFilieres(@QueryParam("page") @DefaultValue("0") int page, @QueryParam("size") @DefaultValue("10")int size);
    
    
}
