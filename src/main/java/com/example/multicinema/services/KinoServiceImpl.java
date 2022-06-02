package com.example.multicinema.services;

import com.example.multicinema.entities.Kino;
import com.example.multicinema.repositories.KinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KinoServiceImpl implements KinoService{
    @Autowired
    private KinoRepository kinoRepository;
    @Override
    public Iterable<Kino> getAll(){
        return kinoRepository.findAll();
    }

    @Override
    public Kino get(int id) {
        return kinoRepository.findById(id).get();
    }

    @Override
    public Kino addKino(Kino kino) {
        return kinoRepository.save(kino);
    }

    @Override
    public void deleteKino(int id) {
        kinoRepository.deleteById(id);
    }

    @Override
    public void updateKino(int id, Kino kino) {
        kinoRepository.deleteById(id);
        kino.setIdK(id);
        kinoRepository.save(kino);
    }

}
