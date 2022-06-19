package com.example.multicinema.controllers;

import com.example.multicinema.entities.Kino;
import com.example.multicinema.services.KinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins={"*"})
@RestController
public class KinoController {
    @Autowired
    KinoService kinoService;
    @RequestMapping(value="/kina", method = RequestMethod.GET)
    public ResponseEntity<Object> getKina(){
        return new ResponseEntity<>(kinoService.getAll(), HttpStatus.OK);
    }
    @RequestMapping(value="/kina/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getKino(@PathVariable("id") int id){
        return new ResponseEntity<>(kinoService.get(id), HttpStatus.OK);
    }
    @RequestMapping(value = "/kina", method = RequestMethod.POST)
    public ResponseEntity<Object> addKino(@RequestBody Kino kino){
        kinoService.addKino(kino);
        return new ResponseEntity<>("Kino has been added", HttpStatus.OK);
    }
    @RequestMapping(value="/kina/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteKino(@PathVariable("id") int id){
        kinoService.deleteKino(id);
        return new ResponseEntity<>("Kino deleted", HttpStatus.OK);
    }
    @RequestMapping(value="/kina/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateKino(@PathVariable("id") int id, @RequestBody Kino kino){
        kinoService.updateKino(id, kino);
        return new ResponseEntity<>("Kino updated", HttpStatus.OK);
    }
}
