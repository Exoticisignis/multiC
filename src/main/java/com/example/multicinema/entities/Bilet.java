package com.example.multicinema.entities;

import javax.persistence.*;

@Entity
@Table(name = "Bilety")
public class Bilet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idB;
    private String dataZ;
    private String miejsce;
    private int seans;
    private int uzytkownik;
    private String email;
    private double cena;

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(int uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public int getSeans() {
        return seans;
    }

    public void setSeans(int seans) {
        this.seans = seans;
    }

    public String getMiejsce() {
        return miejsce;
    }

    public void setMiejsce(String miejsce) {
        this.miejsce = miejsce;
    }

    public String getDataZ() {
        return dataZ;
    }

    public void setDataZ(String dataZ) {
        this.dataZ = dataZ;
    }

    public int getIdB() {
        return idB;
    }

    public void setIdB(int idB) {
        this.idB = idB;
    }
}
