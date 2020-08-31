package com.Gemoire.Gemoire.controllers;

import com.Gemoire.Gemoire.dao.EncadreurDao;
import com.Gemoire.Gemoire.dao.EtudiantDao;
import com.Gemoire.Gemoire.dao.FiliereDao;
import com.Gemoire.Gemoire.dao.MemoireDao;
import com.Gemoire.Gemoire.entity.Encadreur;
import com.Gemoire.Gemoire.entity.Etudiant;
import com.Gemoire.Gemoire.entity.Filiere;
import com.Gemoire.Gemoire.entity.Memoire;
import com.Gemoire.Gemoire.helpers.MemoireHelper;
import com.Gemoire.Gemoire.helpers.UpdateMemoireHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/rest/memoire")
public class MemoireController {

    @Autowired
    private MemoireDao memoireDao;
    @Autowired
    private EncadreurDao encadreurDao;
    @Autowired
    private EtudiantDao etudiantDao;
    @Autowired
    private FiliereDao filiereDao;


    @GetMapping("/lists")
    public ResponseEntity<List<Memoire>> getAllMemoires(){
        List<Memoire> memoires = new ArrayList<>();

        try {
            memoireDao.findAll().forEach(memoires :: add);
            if (memoires.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(memoires,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<Memoire>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Memoire>> getAllMemoires1(){
        List<Memoire> memoires = new ArrayList<>();

        try {
            memoireDao.findAll().forEach(memoires :: add);
            if (memoires.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(memoires,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>((List<Memoire>) null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Memoire> getOne(@PathVariable Long id){

        SimpleDateFormat sdd = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdh = new SimpleDateFormat("hh:mm");
        Optional<Memoire> memoire = memoireDao.findById(id);
        if (memoire.isPresent()){
            memoire.get().setDateDerniereVue("Le : "+sdd.format(new Date())+" a : "+sdh.format(new Date()));
            memoire.get().setNombreVue(memoire.get().getNombreVue()+1);
            memoireDao.save(memoire.get());
            return new ResponseEntity<>(memoire.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/guest/{id}")
    public ResponseEntity<Memoire> getOneguest(@PathVariable Long id){

        SimpleDateFormat sdd = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdh = new SimpleDateFormat("hh:mm");
        Optional<Memoire> memoire = memoireDao.findById(id);
        if (memoire.isPresent()){
            memoire.get().setDateDerniereVue("Le : "+sdd.format(new Date())+" a : "+sdh.format(new Date()));
            memoire.get().setNombreVue(memoire.get().getNombreVue()+1);
            memoireDao.save(memoire.get());
            return new ResponseEntity<>(memoire.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping(value = "/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<Memoire> postMemoire(@RequestBody MemoireHelper memoireHelper) throws IOException {
        DateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy hh:mm");
        Date date = new Date();
        Encadreur encadreur = encadreurDao.findByNomEncadreurAndTitreEncadreurAndGradeEncadreur(memoireHelper.getNomEncadreur().toLowerCase(),
                memoireHelper.getTitreEncadreur().toLowerCase(),memoireHelper.getGradeEncadreur().toLowerCase());
        Etudiant etudiant = etudiantDao.findByMatriculeEtudiant(memoireHelper.getMatriculeEtudiant().toLowerCase());
        System.out.println(memoireHelper.getCodeFiliere()+" "+memoireHelper.getIntituleFiliere());
        Filiere filiere = filiereDao.findByCodeFiliereOrIntituleFiliere(memoireHelper.getCodeFiliere().toLowerCase(),memoireHelper.getIntituleFiliere().toLowerCase());
        Memoire memoire = new Memoire();


        try {
            System.out.println("inside the controller");
            if (etudiant != null) {
                System.out.println("inside the controller 1");
                memoire.setEtudiant(etudiant);
                memoire.setNomEtudiant(etudiant.getNomEtudiant());
            } else {
                System.out.println("inside the controller 2");
                Etudiant etudiant1 = new Etudiant();
                etudiant1.setNomEtudiant(memoireHelper.getNomEtudiant().toLowerCase());
                etudiant1.setMatriculeEtudiant(memoireHelper.getMatriculeEtudiant().toLowerCase());
                etudiantDao.save(etudiant1);
                memoire.setNomEtudiant(memoireHelper.getNomEtudiant().toLowerCase());
                memoire.setEtudiant(etudiant1);
            }

            if (encadreur != null) {
                System.out.println("inside the controller 3");
                memoire.setEncadreur(encadreur);
                memoire.setNomEncadreur(encadreur.getNomEncadreur());
            } else {
                System.out.println("inside the controller 4");
                Encadreur encadreur1 = new Encadreur();
                encadreur1.setNomEncadreur(memoireHelper.getNomEncadreur().toLowerCase());
                encadreur1.setTitreEncadreur(memoireHelper.getTitreEncadreur().toLowerCase());
                encadreur1.setGradeEncadreur(memoireHelper.getGradeEncadreur().toLowerCase());
                encadreurDao.save(encadreur1);
                memoire.setNomEncadreur(memoireHelper.getNomEncadreur());
                memoire.setEncadreur(encadreur1);
            }

            if (filiere != null) {
                System.out.println("inside the controller 5");
                memoire.setFiliere(filiere);
                memoire.setTitreFiliere(filiere.getCodeFiliere());
            } else {
                System.out.println("inside the controller 6");
                Filiere filiere1 = new Filiere();
                filiere1.setCodeFiliere(memoireHelper.getCodeFiliere().toLowerCase());
                filiere1.setIntituleFiliere(memoireHelper.getIntituleFiliere().toLowerCase());
                filiereDao.save(filiere1);
                memoire.setTitreFiliere(memoireHelper.getCodeFiliere());
                memoire.setFiliere(filiere1);
            }
            //memoire.setTitreFiliere(memoireHelper.getCodeFiliere());
            System.out.println("inside the controller 7");
            memoire.setTitre(memoireHelper.getTitre().toUpperCase());
            memoire.setResume(memoireHelper.getResume());
            memoire.setAbstractMemoire(memoireHelper.getAbstractMemoire());
            memoire.setNombreTelechargement(0L);
            memoire.setNombreVue(0L);
            memoire.setOptions(memoireHelper.getOptions());
            memoire.setTitreDiplome(memoireHelper.getTitreDiplome());
            String[] strings = memoireHelper.getMotCles().split(",");
            ArrayList<String> lists = new ArrayList<>();
            for (String item : strings) {
                lists.add(item);
            }
            System.out.println(lists);
            memoire.setMotCles(lists);
            memoire.setDateInsertion(sdf.format(date));
            memoire.setDateDerniereVue(sdf.format(date));
            memoire.setSession(memoireHelper.getSession());

            memoireDao.save(memoire);
            System.out.println("saved");
            return new ResponseEntity<>(memoire, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>((Memoire) null, HttpStatus.EXPECTATION_FAILED);
        }

    }

    @PostMapping(value = "/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<Memoire> postMemoire(@RequestBody UpdateMemoireHelper memoire, @PathVariable Long id) throws IOException {
        DateFormat sdf =  new SimpleDateFormat("dd/MM/yyyy hh:mm");
        Date date = new Date();
        Memoire memoire1 = memoireDao.getOne(id);
        try {
            memoire1.setNomEtudiant(memoire.getNomEtudiant());
            memoire1.setNomEncadreur(memoire.getNomEncadreur());
            memoire1.setTitre(memoire.getTitre().toUpperCase());
            memoire1.setResume(memoire.getResume());
            memoire1.setAbstractMemoire(memoire.getAbstractMemoire());
            memoire1.setNombreTelechargement(0L);
            memoire1.setNombreVue(0L);
            memoire1.setOptions(memoire.getOptions());
            memoire1.setTitreDiplome(memoire.getTitreDiplome());
            String[] strings = memoire.getMotCles().split(",");
            ArrayList<String> lists = new ArrayList<>();
            for (String item : strings) {
                lists.add(item);
            }
            System.out.println(lists);
            memoire1.setMotCles(lists);
            memoire1.setDateInsertion(sdf.format(date));
            memoire1.setDateDerniereVue(sdf.format(date));
            memoire1.setSession(memoire.getSession());

            memoireDao.save(memoire1);
            System.out.println("saved");
            return new ResponseEntity<>(memoire1, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>((Memoire) null, HttpStatus.EXPECTATION_FAILED);
        }

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteMemoire(@PathVariable Long id){
        try {
            memoireDao.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
