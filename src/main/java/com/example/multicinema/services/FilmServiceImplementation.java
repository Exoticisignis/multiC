package com.example.multicinema.services;

import com.example.multicinema.entities.Film;
import com.example.multicinema.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("filmService")
public class FilmServiceImplementation implements FilmService{
    @Autowired
    private FilmRepository filmRepository;
    @Override
    public Iterable<Film> getAll(){
        return filmRepository.findAll();
    }

    @Override
    public Film get(int id) {
        return filmRepository.findById(id).get();
    }

    @Override
    public Film addFilm(Film film) {
        return filmRepository.save(film);
    }

    @Override
    public void deleteFilm(int id) {
        filmRepository.deleteById(id);
    }

}
