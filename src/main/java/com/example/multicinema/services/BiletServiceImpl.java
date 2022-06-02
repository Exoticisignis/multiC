package com.example.multicinema.services;

import com.example.multicinema.entities.Bilet;
import com.example.multicinema.repositories.BiletRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BiletServiceImpl implements BiletService{
    @Autowired
    private BiletRep biletRep;
    @Override
    public Iterable<Bilet> getAll(){
        return biletRep.findAll();
    }

    @Override
    public Bilet get(int id) {
        return biletRep.findById(id).get();
    }

    @Override
    public Bilet addBilet(Bilet bilet) {
        return biletRep.save(bilet);
    }

    @Override
    public void deleteBilet(int id) {
        biletRep.deleteById(id);
    }

}
