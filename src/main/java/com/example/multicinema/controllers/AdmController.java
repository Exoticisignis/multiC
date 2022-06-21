package com.example.multicinema.controllers;

import com.example.multicinema.auth.CookieUtil;
import com.example.multicinema.auth.JwtUtil;
import com.example.multicinema.entities.Administrator;
import com.example.multicinema.services.AdmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@CrossOrigin(origins={"*"})
@RestController
public class AdmController {
    @Autowired
    AdmService admService;
    private static final String jwtTokenCookieName = "JWT-TOKEN";
    private static final String signingKey = "admKey";
    @RequestMapping(value="/admins", method = RequestMethod.GET)
    public ResponseEntity<Object> getAdmins(){
        return new ResponseEntity<>(admService.getAll(), HttpStatus.OK);
    }
    @RequestMapping(value="/admins/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getAdm(@PathVariable("id") int id){
        return new ResponseEntity<>(admService.get(id), HttpStatus.OK);
    }
    @RequestMapping(value = "/admins", method = RequestMethod.POST)
    public ResponseEntity<Object> addAdm(@RequestBody Administrator administrator){
        admService.addAdm(administrator);
        return new ResponseEntity<>("Admin has been added", HttpStatus.OK);
    }
    @RequestMapping(value="/admins/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteAdm(@PathVariable("id") int id){
        admService.deleteAdm(id);
        return new ResponseEntity<>("Admin deleted", HttpStatus.OK);
    }
    @RequestMapping(value="/admins/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateAdm(@PathVariable("id") int id, @RequestBody Administrator administrator){
        admService.updateAdm(id, administrator);
        return new ResponseEntity<>("Admin updated", HttpStatus.OK);
    }
    @RequestMapping(value = "/loginA", method = RequestMethod.POST)
    public ResponseEntity<Object> login(@RequestBody Administrator administrator, HttpServletResponse httpServletResponse){
        if (admService.login(administrator.getHaslo(), administrator.getLogin())){
            String token = JwtUtil.generateToken(signingKey, administrator.getLogin());
            CookieUtil.create(httpServletResponse, jwtTokenCookieName, token, false, -1, "localhost");
            return new ResponseEntity<>("Welcome", HttpStatus.OK);}
        return new ResponseEntity<>("Wrong login or password", HttpStatus.OK);
    }
}
