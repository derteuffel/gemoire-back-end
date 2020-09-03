package com.Gemoire.Gemoire.controllers;

import com.Gemoire.Gemoire.config.FileServices;
import com.Gemoire.Gemoire.dao.*;
import com.Gemoire.Gemoire.entity.*;
import com.Gemoire.Gemoire.helpers.MemoireHelper;
import com.Gemoire.Gemoire.helpers.MessageResponse;
import com.Gemoire.Gemoire.helpers.UpdateMemoireHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

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

    @Autowired
    private FileServices fileServices;

    @Autowired
    private Pieces_jointesDao pieces_jointesDao;


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


        Optional<Memoire> memoire = memoireDao.findById(id);
        if (memoire.isPresent()){
            return new ResponseEntity<>(memoire.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/titre/{titre}")
    public ResponseEntity<Memoire> getOneTitre(@PathVariable String titre){


        Memoire memoire = memoireDao.findByTitre(titre);
        if (memoire!= null){

            return new ResponseEntity<>(memoire, HttpStatus.OK);
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

    @GetMapping("/download/{titre}")
    public ResponseEntity<Pieces_jointes> getOnePieces(@PathVariable String titre){


        Optional<Pieces_jointes> pieces_jointes = pieces_jointesDao.findByName(titre);
        if (pieces_jointes.isPresent()){
            Memoire memoire = pieces_jointes.get().getMemoire();
            memoire.setNombreTelechargement(memoire.getNombreTelechargement()+1);
            memoireDao.save(memoire);
            return new ResponseEntity<>(pieces_jointes.get(), HttpStatus.OK);
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
            return new ResponseEntity<>(memoire,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>((Memoire) null,HttpStatus.EXPECTATION_FAILED);
        }

    }
    // compress the image bytes before storing it in the database
    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);

        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }

        // uncompress the image bytes before returning it to the angular application
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }


    @PostMapping("/upload/{id}")
    public ResponseEntity<MessageResponse> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable Long id) {
        String message = "";
        Memoire memoire = memoireDao.getOne(id);
        Pieces_jointes pieces_jointes = new Pieces_jointes();
        pieces_jointes.setName(memoire.getTitre());
        pieces_jointes.setMemoire(memoire);

        try {
            fileServices.save(file);

            message = "Uploaded the file successfully: " + file.getOriginalFilename();
            pieces_jointes.setUrl(file.getOriginalFilename());
            pieces_jointesDao.save(pieces_jointes);
            return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + "!";
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
        }
    }

    @GetMapping("/files")
    public ResponseEntity<List<Pieces_jointes>> getListFiles() {
        List<Pieces_jointes> fileInfos = fileServices.loadAll().map(path -> {
            String filename = path.getFileName().toString();
            String url = MvcUriComponentsBuilder
                    .fromMethodName(MemoireController.class, "getFile", path.getFileName().toString()).build().toString();

            return new Pieces_jointes(filename, url);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        System.out.println(filename);
        Resource file = fileServices.load(filename);
        System.out.println(file.getFilename());
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
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
