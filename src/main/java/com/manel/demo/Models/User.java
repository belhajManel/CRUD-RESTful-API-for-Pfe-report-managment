package com.manel.demo.Models;

import javax.persistence.*;

@Entity
//This tells mysql that this user class will be a table
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String specialite;

    @Column
    private String classe;

    @Column
    private String encadrantFaculte;

    @Column
    private String encadrantSociete;

    @Column
    private String sujet;

    @Column
    private String domaineSujet;

    @Column
    private boolean stage_valide;

    @Column
    private boolean rapport_signe;

    @Column
    private boolean rapport_valide;



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getEncadrantFaculte() {
        return encadrantFaculte;
    }

    public void setEncadrantFaculte(String encadrantFaculte) {
        this.encadrantFaculte = encadrantFaculte;
    }

    public String getEncadrantSociete() {
        return encadrantSociete;
    }

    public void setEncadrantSociete(String encadrantSociete) {
        this.encadrantSociete = encadrantSociete;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getDomaineSujet() {
        return domaineSujet;
    }

    public void setDomaineSujet(String domaineSujet) {
        this.domaineSujet = domaineSujet;
    }
    public boolean isStage_valide() {
        return stage_valide;
    }

    public void setStage_valide(boolean stage_valide) {
        this.stage_valide = stage_valide;
    }

    public boolean isRapport_signe() {
        return rapport_signe;
    }

    public void setRapport_signe(boolean rapport_signe) {
        this.rapport_signe = rapport_signe;
    }

    public boolean isRapport_valide() {
        return rapport_valide;
    }

    public void setRapport_valide(boolean rapport_valide) {
        this.rapport_valide = rapport_valide;
    }


}


