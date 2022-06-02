package com.example.multicinema.entities;

import javax.persistence.*;

@Entity
@Table(name = "Kina")
public class Kino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idK;
    private String nazwaK;
    private String adresK;

    public String getAdresK() {
        return adresK;
    }

    public void setAdresK(String adresK) {
        this.adresK = adresK;
    }

    public String getNazwaK() {
        return nazwaK;
    }

    public void setNazwaK(String nazwaK) {
        this.nazwaK = nazwaK;
    }

    public int getIdK() {
        return idK;
    }

    public void setIdK(int idK) {
        this.idK = idK;
    }
}
