package com.example.multicinema.controllers;

import com.example.multicinema.services.KinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KinoController {
    @Autowired
    KinoService kinoService;
}
