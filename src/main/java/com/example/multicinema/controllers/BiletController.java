package com.example.multicinema.controllers;

import com.example.multicinema.services.BiletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BiletController {
    @Autowired
    BiletService biletService;
}
