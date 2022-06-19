package com.example.multicinema.controllers;

import com.example.multicinema.entities.Seans;
import com.example.multicinema.services.SeansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins={"*"})
@RestController
public class SeansController {
    @Autowired
    SeansService seansService;
    @RequestMapping(value="/seansy", method = RequestMethod.GET)
    public ResponseEntity<Object> getUsers(){
        return new ResponseEntity<>(seansService.getAll(), HttpStatus.OK);
    }
    @RequestMapping(value="/seansy/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUser(@PathVariable("id") int id){
        return new ResponseEntity<>(seansService.get(id), HttpStatus.OK);
    }
    @RequestMapping(value = "/seansy", method = RequestMethod.POST)
    public ResponseEntity<Object> addUser(@RequestBody Seans seans){
        seansService.addSeans(seans);
        return new ResponseEntity<>("Seans has been added", HttpStatus.OK);
    }
    @RequestMapping(value="/seansy/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUser(@PathVariable("id") int id){
        seansService.deleteSeans(id);
        return new ResponseEntity<>("Seans deleted", HttpStatus.OK);
    }
    @RequestMapping(value="/seansy/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateSeans(@PathVariable("id") int id, @RequestBody Seans seans){
        seansService.updateSeans(id, seans);
        return new ResponseEntity<>("Seans updated", HttpStatus.OK);
    }
}
