package com.example.multicinema.services;

import com.example.multicinema.entities.Film;

public interface FilmService {
    public Iterable<Film> getAll();
}
