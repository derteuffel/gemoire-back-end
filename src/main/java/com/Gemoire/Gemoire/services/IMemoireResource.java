/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Gemoire.Gemoire.services;

import com.Gemoire.Gemoire.entity.Encadreur;
import com.Gemoire.Gemoire.entity.Memoire;
import java.util.List;
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

/**
 *
 * @author jahaelle
 */
@Path("/memoires")
public interface IMemoireResource {
   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Page<Memoire>findAllMemoires(@QueryParam("page") @DefaultValue("0") int page, @QueryParam("size") @DefaultValue("10")int size);
    
     @GET
      @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<Page<Memoire>> searchByEncadreur(@QueryParam("nomEncadreur")String nomEncadreur, @DefaultValue("0") @QueryParam("page")int page, @DefaultValue("10") @QueryParam("size")int size);
    
     @GET
      @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<Page<Memoire>> searchByMotCles(@QueryParam("motCles")String motCles,@DefaultValue("0") @QueryParam("page")int page, @DefaultValue("10") @QueryParam("size")int size);
     @GET
      @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<Page<Memoire>> searchByDiplome( @QueryParam("nomEncadreur")String intituleDiplome,@DefaultValue("0") @QueryParam("page")int page, @DefaultValue("10") @QueryParam("size")int size);
    
     @GET
     @Path("/search")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<Page<Memoire>> searchByTitre( @QueryParam("titre")String titre,@DefaultValue("0") @QueryParam("page")int page, @DefaultValue("10") @QueryParam("size")int size);
     
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<Memoire> addMemoire(Memoire memoire);
    
     @PUT
    @Path("{id : \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public ResponseEntity<Memoire> updateMemoire(@PathParam("id") long id, Memoire memoire);
    
    @DELETE
    @Path("{id : \\d+}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteMemoire(@PathParam("id") long id);
    
}
