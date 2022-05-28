package com.example.multicinema.controllers;

import com.example.multicinema.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilmsController {
    @Autowired
    FilmService filmService;
    @RequestMapping(value = "/get/films", method = RequestMethod.GET)
    public ResponseEntity<Object> getFilms() { return new ResponseEntity<>(filmService.getAll(), HttpStatus.OK);}
}
