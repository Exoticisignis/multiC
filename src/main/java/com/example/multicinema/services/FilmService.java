package com.example.multicinema.services;

import com.example.multicinema.entities.Film;

public interface FilmService {
    public Iterable<Film> getAll();
    public Film get(int id);
    public Film addFilm(Film film);
    public void deleteFilm(int id);
    public void updateFilm(int id, Film film);
}
