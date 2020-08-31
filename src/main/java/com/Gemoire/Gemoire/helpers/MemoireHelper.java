package com.Gemoire.Gemoire.helpers;

import lombok.Data;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import java.util.Date;
import java.util.List;

@Data
public class MemoireHelper {
    @Column(nullable=false)
    private String titre;
    @Column(nullable=false, length = 65536)
    private  String resume;
    @Column(nullable=false,length = 65536)
    private String abstractMemoire;
    private String nomEncadreur;
    private String titreEncadreur;
    private String gradeEncadreur;
    private String nomEtudiant;
    private String matriculeEtudiant;
    private String codeFiliere;
    private String intituleFiliere;
    private String titreDiplome;

    private String motCles;

    private String session;
    private String options;

    public String getTitreDiplome() {
        return titreDiplome;
    }

    public void setTitreDiplome(String titreDiplome) {
        this.titreDiplome = titreDiplome;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getAbstractMemoire() {
        return abstractMemoire;
    }

    public void setAbstractMemoire(String abstractMemoire) {
        this.abstractMemoire = abstractMemoire;
    }

    public String getMotCles() {
        return motCles;
    }

    public void setMotCles(String motCles) {
        this.motCles = motCles;
    }


    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getNomEncadreur() {
        return nomEncadreur;
    }

    public void setNomEncadreur(String nomEncadreur) {
        this.nomEncadreur = nomEncadreur;
    }

    public String getTitreEncadreur() {
        return titreEncadreur;
    }

    public void setTitreEncadreur(String titreEncadreur) {
        this.titreEncadreur = titreEncadreur;
    }

    public String getGradeEncadreur() {
        return gradeEncadreur;
    }

    public void setGradeEncadreur(String gradeEncadreur) {
        this.gradeEncadreur = gradeEncadreur;
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public String getMatriculeEtudiant() {
        return matriculeEtudiant;
    }

    public void setMatriculeEtudiant(String matriculeEtudiant) {
        this.matriculeEtudiant = matriculeEtudiant;
    }

    public String getCodeFiliere() {
        return codeFiliere;
    }

    public void setCodeFiliere(String codeFiliere) {
        this.codeFiliere = codeFiliere;
    }

    public String getIntituleFiliere() {
        return intituleFiliere;
    }

    public void setIntituleFiliere(String intituleFiliere) {
        this.intituleFiliere = intituleFiliere;
    }
}
