package com.example.multicinema.services;

import com.example.multicinema.entities.Administrator;

public interface AdmService {
    public Iterable<Administrator> getAll();
    public Administrator get(int id);
    public Administrator addAdm(Administrator ad);
    public void deleteAdm(int id);
    public void updateAdm(int id, Administrator ad);
}
