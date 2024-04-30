package com.invio.shopping.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/privacy")
public class PrivacyController {

    @GetMapping("/")
    public String privacyText(){
        return "Lorem İpsum";
    }
}
