package com.example.multicinema.controllers;

import com.example.multicinema.auth.CookieUtil;
import com.example.multicinema.auth.JwtUtil;
import com.example.multicinema.entities.Uzytkownik;
import com.example.multicinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
@CrossOrigin(origins={"*"})
@RestController
public class UserController {
    private static final String jwtTokenCookieName = "JWT-TOKEN";
    private static final String signingKey = "userKey";
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
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Object> login(@RequestBody Uzytkownik user, HttpServletResponse httpServletResponse){
        if (userService.login(user.getHaslo(), user.getLogin())){
            String token = JwtUtil.generateToken(signingKey, user.getLogin());
            CookieUtil.create(httpServletResponse, jwtTokenCookieName, token, false, -1, "localhost");
            return new ResponseEntity<>("Welcome", HttpStatus.OK);}
        return new ResponseEntity<>("Wrong login or password", HttpStatus.OK);
    }
}
