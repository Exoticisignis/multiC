package com.example.multicinema.entities;

import javax.persistence.*;

@Entity
@Table(name = "Filmy")
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idF;
    private String nazwaF;
    private String gatunek;
    private String opis;
    private String dyrektor;
    private String statusF;

    public int getId() {
        return idF;
    }

    public void setId(int id) {
        this.idF
                = id;
    }

    public String getName() {
        return nazwaF;
    }

    public void setName(String name) {
        this.nazwaF = name;
    }

    public String getStatus() {
        return statusF;
    }

    public void setStatus(String status) {
        this.statusF = status;
    }

    public String getDirector() {
        return dyrektor;
    }

    public void setDirector(String director) {
        this.dyrektor = director;
    }

    public String getDescription() {
        return opis;
    }

    public void setDescription(String description) {
        this.opis = description;
    }

    public String getGenre() {
        return gatunek;
    }

    public void setGenre(String genre) {
        this.gatunek = genre;
    }
}
