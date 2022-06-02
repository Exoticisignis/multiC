package com.example.multicinema.controllers;

import com.example.multicinema.services.FilmService;
import com.example.multicinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
}
