package com.example.multicinema.entities;

import javax.persistence.*;

@Entity
@Table(name = "Seansy")
public class Seans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idS;
    private String czasR;
    private String czasZ;
    private String glos;
    private int sala;
    private int kino;
    private int film;

    public int getFilm() {
        return film;
    }

    public void setFilm(int film) {
        this.film = film;
    }

    public int getKino() {
        return kino;
    }

    public void setKino(int kino) {
        this.kino = kino;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public String getGlos() {
        return glos;
    }

    public void setGlos(String glos) {
        this.glos = glos;
    }

    public String getCzasZ() {
        return czasZ;
    }

    public void setCzasZ(String czasZ) {
        this.czasZ = czasZ;
    }

    public String getCzasR() {
        return czasR;
    }

    public void setCzasR(String czasR) {
        this.czasR = czasR;
    }

    public int getIdS() {
        return idS;
    }

    public void setIdS(int idS) {
        this.idS = idS;
    }
}
