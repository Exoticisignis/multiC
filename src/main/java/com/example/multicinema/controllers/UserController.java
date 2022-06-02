package com.example.multicinema.controllers;

import com.example.multicinema.entities.Uzytkownik;
import com.example.multicinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value="/users", method = RequestMethod.GET)
    public ResponseEntity<Object> getUsers(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }
    @RequestMapping(value="/users/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUser(@PathVariable("id") int id){
        return new ResponseEntity<>(userService.get(id), HttpStatus.OK);
    }
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public ResponseEntity<Object> addUser(@RequestBody Uzytkownik uzytkownik){
        userService.addUser(uzytkownik);
        return new ResponseEntity<>("User has been added", HttpStatus.OK);
    }
    @RequestMapping(value="/users/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteUser(@PathVariable("id") int id){
        userService.deleteUser(id);
        return new ResponseEntity<>("User deleted", HttpStatus.OK);
    }
    @RequestMapping(value="/users/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateUser(@PathVariable("id") int id, @RequestBody Uzytkownik user){
        userService.updateUser(id, user);
        return new ResponseEntity<>("User updated", HttpStatus.OK);
    }
}
