package com.example.multicinema.services;


import com.example.multicinema.entities.Kino;

public interface KinoService {
    public Iterable<Kino> getAll();
    public Kino get(int id);
    public Kino addKino(Kino kino);
    public void deleteKino(int id);
}
