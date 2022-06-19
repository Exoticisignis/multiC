package com.example.multicinema.controllers;

import com.example.multicinema.entities.Bilet;
import com.example.multicinema.services.BiletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins={"*"})
@RestController
public class BiletController {
    @Autowired
    BiletService biletService;
    @RequestMapping(value="/bilety", method = RequestMethod.GET)
    public ResponseEntity<Object> getTickets(){
        return new ResponseEntity<>(biletService.getAll(), HttpStatus.OK);
    }
    @RequestMapping(value="/bilety/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getTicket(@PathVariable("id") int id){
        return new ResponseEntity<>(biletService.get(id), HttpStatus.OK);
    }
    @RequestMapping(value = "/bilety", method = RequestMethod.POST)
    public ResponseEntity<Object> addTicket(@RequestBody Bilet bilet){
        biletService.addBilet(bilet);
        return new ResponseEntity<>("Ticket has been added", HttpStatus.OK);
    }
    @RequestMapping(value="/bilety/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteTicket(@PathVariable("id") int id){
        biletService.deleteBilet(id);
        return new ResponseEntity<>("Ticket deleted", HttpStatus.OK);
    }
    @RequestMapping(value="/bilety/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateBilet(@PathVariable("id") int id, @RequestBody Bilet bilet){
        biletService.updateBilet(id, bilet);
        return new ResponseEntity<>("Bilet updated", HttpStatus.OK);
    }
}
