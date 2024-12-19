package com.mvc.commence.controllers;

import com.mvc.commence.dao.UserDao;
import com.mvc.commence.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private UserDao userDao;

    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute("newuser") User user, Model model) {
        userDao.save(user);
        System.out.println("register " + user);
        model.addAttribute("dataSaved", "User register successfully");
        return "login";
    }
}
