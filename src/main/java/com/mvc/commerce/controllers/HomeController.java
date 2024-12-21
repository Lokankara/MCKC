package com.mvc.commerce.controllers;

import com.mvc.commerce.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

@Controller
public class HomeController {

    Logger logger = Logger.getLogger(getClass().getName());

    @GetMapping("/home")
    public String goHome() {
        logger.info("goHome");
        return "index";
    }

    @GetMapping("/goToSearch")
    public String goToSearch() {
        logger.info("goToSearch");
        return "search";
    }

    @GetMapping("/goToLogin")
    public String goToLogin() {
        logger.info("goToLogin");
        return "login";
    }

    @GetMapping("/goToRegistration")
    public String goToRegistration() {
        logger.info("goToRegistration");
        return "register";
    }

    @ModelAttribute("newuser")
    public User getDefaultUser() {
        return new User();
    }


    @ModelAttribute("genderItems")
    public List<String> getGenderItems() {
        return Arrays.asList("Male", "Female", "Other");
    }
}
