package com.example.loginsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
    @GetMapping("/replyback")
    public String replyback() {
        return "productos";
    }

    @GetMapping("/commitback")
    public String commitback() {
        return "reportes";
    }
}