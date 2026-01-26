package com.example.crudapi.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "client") 

public class Client {
    
    @Id
    @Column(name = "identifiant", nullable = false, length = 10)
    
    private String identifiant;
    private String nom;
    private String prenom;
    private LocalDate date_naiss;
    @Enumerated(EnumType.STRING)
    private Genre genre;
    private String adresse;
    private String num_tel;
    private String adresse_mail;
    
    //@ManyToOne
    //private User user;


    public Client(String identifiant, String nom, String prenom, LocalDate date_naiss, Genre genre, String adresse, String num_tel, String adresse_mail) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.date_naiss = date_naiss;
        this.genre = genre;
        this.adresse = adresse;
        this.num_tel = num_tel;
        this.adresse_mail = adresse_mail;
    }

    public Client() {
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public LocalDate getDate_naiss() {
        return date_naiss;
    }

    public Genre getGenre() {
        return genre;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getNum_tel() {
        return num_tel;
    }

    public String getAdresse_mail() {
        return adresse_mail;
    }

    public void setIdentifiant(String id) {
        this.identifiant= id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setDate_naiss(LocalDate date_naiss) {
        this.date_naiss = date_naiss;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setNum_tel(String numtel) {
        this.num_tel = numtel;
    }

    public void setAdresse_mail(String email) {
        this.adresse_mail = email;
    }
    
}
