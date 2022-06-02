package com.example.multicinema.controllers;

import com.example.multicinema.entities.Film;
import com.example.multicinema.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FilmsController {
    @Autowired
    FilmService filmService;
    @RequestMapping(value = "/films", method = RequestMethod.GET)
    public ResponseEntity<Object> getFilms() { return new ResponseEntity<>(filmService.getAll(), HttpStatus.OK);}
    @RequestMapping(value="/films/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getFilm(@PathVariable("id") int id){
        return new ResponseEntity<>(filmService.get(id), HttpStatus.OK);
    }
    @RequestMapping(value = "/films", method = RequestMethod.POST)
    public ResponseEntity<Object> addFilm(@RequestBody Film film){
        filmService.addFilm(film);
        return new ResponseEntity<>("Film has been added", HttpStatus.OK);
    }
    @RequestMapping(value="/films/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteFilm(@PathVariable("id") int id){
        filmService.deleteFilm(id);
        return new ResponseEntity<>("Film deleted", HttpStatus.OK);
    }
    @RequestMapping(value="/films/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateFilm(@PathVariable("id") int id, @RequestBody Film film){
        filmService.updateFilm(id, film);
        return new ResponseEntity<>("Film updated", HttpStatus.OK);
    }
}
