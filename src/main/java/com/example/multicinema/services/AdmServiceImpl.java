package com.example.multicinema.services;

import com.example.multicinema.entities.Administrator;
import com.example.multicinema.repositories.AdmRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdmServiceImpl implements AdmService{
    @Autowired
    private AdmRep admRep;
    @Override
    public Iterable<Administrator> getAll(){
        return admRep.findAll();
    }

    @Override
    public Administrator get(int id) {
        return admRep.findById(id).get();
    }

    @Override
    public Administrator addAdm(Administrator adm) {
        return admRep.save(adm);
    }

    @Override
    public void deleteAdm(int id) {
        admRep.deleteById(id);
    }

}
