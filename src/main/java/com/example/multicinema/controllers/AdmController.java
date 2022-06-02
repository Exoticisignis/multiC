package com.example.multicinema.controllers;

import com.example.multicinema.services.AdmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdmController {
    @Autowired
    AdmService admService;
}
