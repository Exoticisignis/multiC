package com.example.multicinema.services;

import com.example.multicinema.entities.Seans;
import com.example.multicinema.repositories.SeansRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeansServiceImpl implements SeansService{
    @Autowired
    private SeansRep seansRep;
    @Override
    public Iterable<Seans> getAll(){
        return seansRep.findAll();
    }

    @Override
    public Seans get(int id) {
        return seansRep.findById(id).get();
    }

    @Override
    public Seans addSeans(Seans seans) {
        return seansRep.save(seans);
    }

    @Override
    public void deleteSeans(int id) {
        seansRep.deleteById(id);
    }

}
