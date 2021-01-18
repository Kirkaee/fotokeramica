package com.fotokeramica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping("/main")
    public String greeting() {
        return "main";
    }

}
