package com.example.multicinema.services;


import com.example.multicinema.entities.Bilet;

public interface BiletService {
    public Iterable<Bilet> getAll();
    public Bilet get(int id);
    public Bilet addBilet(Bilet bilet);
    public void deleteBilet(int id);
}
