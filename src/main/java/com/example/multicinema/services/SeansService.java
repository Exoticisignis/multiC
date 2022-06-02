package com.example.multicinema.services;


import com.example.multicinema.entities.Seans;

public interface SeansService {
    public Iterable<Seans> getAll();
    public Seans get(int id);
    public Seans addSeans(Seans seans);
    public void deleteSeans(int id);
    public void updateSeans(int id, Seans seans);
}
