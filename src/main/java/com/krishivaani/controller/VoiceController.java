package com.krishivaani.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VoiceController {

    @GetMapping("/")
    public String home() {
        return "voice";
    }
}