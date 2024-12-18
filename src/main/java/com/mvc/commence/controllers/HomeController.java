package com.mvc.commence.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String goHome(){
        System.out.println("goHome");
        return "index";
    }

    @GetMapping("/goToSearch")
    public String goToSearch(){
        System.out.println("goToSearch");
        return "search";
    }
}
